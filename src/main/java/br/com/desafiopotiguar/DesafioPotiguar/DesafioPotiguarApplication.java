package br.com.desafiopotiguar.DesafioPotiguar;

import br.com.desafiopotiguar.DesafioPotiguar.config.KeyAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesafioPotiguarApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioPotiguarApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<KeyAuthFilter>keyFilter(KeyAuthFilter filter){
		FilterRegistrationBean<KeyAuthFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}
}
