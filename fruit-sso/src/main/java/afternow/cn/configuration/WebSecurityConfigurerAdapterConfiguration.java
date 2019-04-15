package afternow.cn.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;


@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfigurerAdapterConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		// 指定登录页面链接
		http.formLogin().loginPage("/login").permitAll()
				// 指定登录成功的处理程序
				.successHandler(null).and().authorizeRequests()
				// 忽略对图片等资源的验证
				.antMatchers("/images/**", "/checkcode", "/scripts/**", "/styles/**").permitAll().anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
				// 指定拒绝访问的错误提示链接
				.exceptionHandling().accessDeniedPage("/deny").and()
				// 设定记住用户的电脑登录状态 记住24小时
				.rememberMe().tokenValiditySeconds(86400).tokenRepository(null);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
		// remember me
		auth.eraseCredentials(false);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JdbcTokenRepositoryImpl tokenRepository() {
		JdbcTokenRepositoryImpl jtr = new JdbcTokenRepositoryImpl();
//		jtr.setDataSource(dataSource);
		return jtr;
	}

//	@Bean
//	public LoginSuccessHandler loginSuccessHandler() {
//		return new LoginSuccessHandler();
//	}

}
