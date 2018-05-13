package com.ravi.travel.budget_travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
public class BudgetTravelApplication {

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
}
