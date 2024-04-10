package afternow.cn.configuration;

import afternow.cn.nums.RoleEnums;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for simplicity
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole(RoleEnums.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}

