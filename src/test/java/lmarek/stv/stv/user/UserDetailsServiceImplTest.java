package lmarek.stv.stv.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

public class UserDetailsServiceImplTest {
    final UserRepository userRepository = Mockito.mock(UserRepository.class);
    final UserDetailsServiceImpl service = new UserDetailsServiceImpl(userRepository);

    @AfterEach
    protected void afterEach() {
        Mockito.reset(userRepository);
    }

    @Test
    public void testUserIsMissing() {
        final String username = "test@example.com";
        Mockito.when(userRepository.findUserByEmail(username)).thenReturn(Optional.empty());

        final Executable task = () -> service.loadUserByUsername(username);

        Assertions.assertThrows(UsernameNotFoundException.class, task);
    }

    @Test
    public void testUserIsFound() {
        final String username = "test@example.com";
        final String password = "password";
        final UserEntity returnedEntity = new UserEntity();
        returnedEntity.setEmail(username);
        returnedEntity.setId(0);
        returnedEntity.setPassword(password);
        returnedEntity.setRoles(Collections.emptyList());
        Mockito.when(userRepository.findUserByEmail(username)).thenReturn(Optional.of(returnedEntity));

        final UserDetails result = service.loadUserByUsername(username);

        Assertions.assertEquals(username, result.getUsername());
        Assertions.assertEquals(password, result.getPassword());
        Assertions.assertTrue(result.getAuthorities().isEmpty());
    }
}
