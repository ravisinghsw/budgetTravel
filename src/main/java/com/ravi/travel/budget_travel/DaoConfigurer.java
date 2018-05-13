package com.ravi.travel.budget_travel;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingClass(value = {"com.ravi.travel.budget_travel.JPAConfigurere"})
public class DaoConfigurer {

    @Bean
   public Integer globalNum(){
        System.out.println("It work.. global number ");
        return new Integer(100);
    }
}
