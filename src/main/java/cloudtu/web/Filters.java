package cloudtu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Filters{
    private static final Logger logger = LoggerFactory.getLogger(Filters.class);       
    
    // spring boot 預設的 url mapping 是  "/*"，所以任何 request 都會經過 firstFilter bean 
    @Component    
    private static class FirstFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {           
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                FilterChain chain) throws IOException, ServletException {
            logger.debug(FirstFilter.class.getSimpleName() + " is working");
            chain.doFilter(request, response);          
        }

        @Override
        public void destroy() {         
        }       
    }    
    
    private static class SecondFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {           
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                FilterChain chain) throws IOException, ServletException {
            logger.debug(SecondFilter.class.getSimpleName() + " is working");
            chain.doFilter(request, response);          
        }

        @Override
        public void destroy() {         
        }       
    }    
    
	@Bean
	public FilterRegistrationBean secondFilter(){
		FilterRegistrationBean registration = new FilterRegistrationBean(new SecondFilter());
		// 改寫掉預設的 url mapping，只有 "/hello" 的 request 會經過 secondFilter bean
		registration.addUrlPatterns("/hello");
		return registration;
	}			
}
