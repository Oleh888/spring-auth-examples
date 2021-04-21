package study.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import study.spring.security.security.Authority;
import study.spring.security.security.Role;

@Configuration
public class BeanConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        userDetailsService.createUser(User.withUsername("oleh")
        .password("1")
//        .authorities(Authority.READ.name(), Authority.WRITE.name())
        .roles(Role.ADMIN.name())
        .build());

        userDetailsService.createUser(User.withUsername("loh")
                .password("1")
                .authorities(Authority.READ.name())
//                .roles(Role.ADMIN.name())
//                .authorities("ROLE_" + Role.ADMIN)
                .roles(Role.MANAGER.name())
                .build());

        return userDetailsService;
    }
}
