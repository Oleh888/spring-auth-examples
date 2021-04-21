package study.spring.security.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    private final AuthenticationProvider authenticationProvider;

    public CustomWebSecurityConfigurerAdapter(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests()
//            .antMatchers("/HW/insecure")
//                .permitAll()
//                .anyRequest()
//                .hasAnyAuthority(Authority.WRITE.name(), Authority.READ.name())
//                .hasRole(Role.ADMIN.name())
//                antMatchers
//                mvcMatchers
//                regexMatchers
                .mvcMatchers(HttpMethod.GET, "/HW/hello").hasRole(Role.MANAGER.name())
                .mvcMatchers(HttpMethod.POST, "/HW/hello").permitAll()
                .and().formLogin();

        http.csrf().disable();
    }
}
