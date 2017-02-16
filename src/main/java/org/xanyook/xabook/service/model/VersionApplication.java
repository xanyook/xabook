package org.xanyook.xabook.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "application.informations")
@JsonIgnoreProperties({"CGLIB$BOUND", "CGLIB$CALLBACK_0", "CGLIB$CALLBACK_1", "CGLIB$CALLBACK_2", "$$beanFactory"})
public class VersionApplication {

    private String version;
    private String name;
    private String released;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }
}
