package poly.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import poly.edu.interceptor.AdminAuthenticationlnterceptor;
import poly.edu.interceptor.SideAuthenticationlnterceptor;

@Configuration
public class AuthenticatiolnterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private AdminAuthenticationlnterceptor adminAuthenticationlnterceptor;
	
	@Autowired
	private SideAuthenticationlnterceptor siteAuthenticationlnterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthenticationlnterceptor)
		        .addPathPatterns("/admin/**");
//		registry.addInterceptor(siteAuthenticationlnterceptor)
//		         .addPathPatterns("/user/**");
	}
    
}
