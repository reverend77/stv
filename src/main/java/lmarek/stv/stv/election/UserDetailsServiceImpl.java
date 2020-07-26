package lmarek.stv.stv.election;

import lmarek.stv.stv.user.PrivilegeEntity;
import lmarek.stv.stv.user.UserEntity;
import lmarek.stv.stv.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final static String ERROR_MSG_TEMPLATE = "Username %s not found in users database!";

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> userEntity = userRepository.findUserByEmail(username);
        final Optional<UserDetails> userDetails = userEntity.map(this::convertToUserDetails);

        if(userDetails.isEmpty()){
            throw new UsernameNotFoundException(String.format(ERROR_MSG_TEMPLATE, username));
        }

        return userDetails.get();
    }

    private UserDetails convertToUserDetails(UserEntity userEntity){
        final List<GrantedAuthority> privileges = userEntity.getPrivileges()
                .stream()
                .map(PrivilegeEntity::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new User(userEntity.getEmail(), userEntity.getPassword(), privileges);
    }
}
