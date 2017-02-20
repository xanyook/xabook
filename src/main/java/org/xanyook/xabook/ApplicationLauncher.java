package org.xanyook.xabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.xanyook.xabook.repository.XabookRepositoryImpl;
import org.xanyook.xabook.service.model.ErrorBean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(repositoryBaseClass = XabookRepositoryImpl.class)
public class ApplicationLauncher extends SpringBootServletInitializer {

	public static void main(String[] args) {

		// new Application().configure(new
		// SpringApplicationBuilder(Application.class)).run(args);ErrorAttributes
		SpringApplication.run(ApplicationLauncher.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationLauncher.class);
	}


	@Bean
    public ErrorBean errorBean(){
	    return new ErrorBean();
    }
}
