package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import app.Interceptor.CertificationInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CertificationInterceptor())
			.addPathPatterns("/**/*")
			.excludePathPatterns("/css/**/")
			.excludePathPatterns("/js/**/")
			.excludePathPatterns("/images/**/")
			.excludePathPatterns("/register/**/")
			.excludePathPatterns("/login")
			.excludePathPatterns("/test/**/")
			.excludePathPatterns("/admin/**/")
			.excludePathPatterns("/partner/**/")
			.excludePathPatterns("/course/**/")
			.excludePathPatterns("/mall/**/")
			.excludePathPatterns("/matching/**/");
	}
	
}
