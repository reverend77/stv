package lmarek.stv.stv.election;

import lmarek.stv.stv.user.UserEntity;
import lmarek.stv.stv.user.UserRepository;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final static String ERROR_MSG_TEMPLATE = "Username %s not found in users database!";

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> userEntity = userRepository.findUserByEmail(username);
        final Optional<UserDetails> userDetails = userEntity
                .map(entity -> new User(username, entity.getPassword(), Collections.emptyList()));

        if(userDetails.isEmpty()){
            throw new UsernameNotFoundException(String.format(ERROR_MSG_TEMPLATE, username));
        }

        return userDetails.get();
    }
}
