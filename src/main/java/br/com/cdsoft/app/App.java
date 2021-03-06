package br.com.cdsoft.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan("br.com.cdsoft")
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableConfigurationProperties
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
