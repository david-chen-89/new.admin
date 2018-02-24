package news.admin;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import news.admin.intcp.LoginInterceptor;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public HandlerInterceptor getLoginInterceptor() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLoginInterceptor());
		super.addInterceptors(registry);
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	 
	   return (container -> {
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/page_401.html");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/page_404.html");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/page_500.html");
	 
	        container.addErrorPages(error401Page, error404Page, error500Page);
	   });
	}
}
