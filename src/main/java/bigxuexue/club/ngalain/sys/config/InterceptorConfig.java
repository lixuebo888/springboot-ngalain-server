package bigxuexue.club.ngalain.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bigxuexue.club.ngalain.sys.interceptor.AuthenticationInterceptor;

/**
 * @author jinbin
 * @date 2018-07-08 22:33
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截所有请求，通过判断是否有 @LoginRequired 注解
		// 决定是否需要登录
		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
	}

	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}
}