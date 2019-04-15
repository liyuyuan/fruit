package afternow.cn.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 客户端安全管理和认证
 * 
 * @author liyuyuan_vendor
 *
 */
//@Configuration
//@EnableOAuth2Sso
//@EnableConfigurationProperties
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private AuthenticationManager authenticationManager;

}
