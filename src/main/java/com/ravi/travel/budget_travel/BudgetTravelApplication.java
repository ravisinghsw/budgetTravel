package com.ravi.travel.budget_travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories
public class BudgetTravelApplication  implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BudgetTravelApplication.class, args);
	}

	/*@Bean
	public FilterRegistrationBean deRegisterHiddenHttpMethodFilter(HiddenHttpMethodFilter filer){
		FilterRegistrationBean bean = new FilterRegistrationBean(filer);
		bean.setEnabled(false);
		return bean;
	}

	@Bean
	public FilterRegistrationBean deRegisterHttpPutFormContentFilter(HttpPutFormContentFilter filer){
		FilterRegistrationBean bean = new FilterRegistrationBean(filer);
		bean.setEnabled(false);
		return bean;
	}

	@Bean
	public FilterRegistrationBean deRegisterRequestContextFilter(RequestContextFilter filer){
		FilterRegistrationBean bean = new FilterRegistrationBean(filer);
		bean.setEnabled(false);
		return bean;
	}*/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("**/**")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("**/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
