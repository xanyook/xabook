package org.xanyook.xabook;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.xanyook.xabook.processor.ErrorCodepouette;
import org.xanyook.xabook.processor.serializer.InstantSerializer;
import org.xanyook.xabook.repository.XabookRepositoryImpl;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Set;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(repositoryBaseClass = XabookRepositoryImpl.class)
public class ApplicationLauncher extends SpringBootServletInitializer {

    @Autowired
    ObjectMapper objectMapper;
    private final static String ERROR_CODE_FILE_NAME = "/error-codes.json";

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
    public Set<ErrorCodepouette> errorCodes() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ERROR_CODE_FILE_NAME);
        Set<ErrorCodepouette> codes = objectMapper.readValue(inputStream, TypeFactory.defaultInstance()
                .constructCollectionType(Set.class, ErrorCodepouette.class));
        return codes;
    }

    @Bean
    public Module simpleModule(){
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Instant.class, new InstantSerializer());

        return simpleModule;
    }




}
