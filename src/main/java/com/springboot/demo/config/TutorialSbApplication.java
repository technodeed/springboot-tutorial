package com.springboot.demo.config;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//@ComponentScan("com.springboot.demo")
@SpringBootApplication(scanBasePackages = "com.springboot.demo")
public class TutorialSbApplication { //extends SpringBootServletInitializer {

	//@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TutorialSbApplication.class);
    }
	
	public static void main(String[] args) {
		
		System.out.println("In TutorialSbApplication main method *** ");
		ApplicationContext ctx = SpringApplication.run(TutorialSbApplication.class, args);
		
        String[] beanNames = ctx.getBeanDefinitionNames();
         
        Arrays.sort(beanNames);
        int count = 0;
        for (String beanName : beanNames)
        {
            System.out.println("BeanName***: " + beanName);
            count++;
        }
        System.out.println("Total Beans Count: " + count);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		// If we user AcceptHeaderLocaleResolver we don't need to configure the RequestHeader parameter in every controller methods. 
		//We can directly use LocaleContextHolder.getLocale() to pick the language from HTTP request header
		
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}
	
	/**
	 * This method is used to read message of different languages stored in Resources folder.
	 * 1. All we need to give the name of properties file which in this case it is "messages"
	 * 2. If we add spring.messages.basename=messages  in application.properties file then we don't have to add this method at all
	 * 
	 */
	/*@Bean
	public ResourceBundleMessageSource messageResource() {
		ResourceBundleMessageSource messageResource = new ResourceBundleMessageSource();
		messageResource.setBasename("messages");
		return messageResource;
	}*/

}

