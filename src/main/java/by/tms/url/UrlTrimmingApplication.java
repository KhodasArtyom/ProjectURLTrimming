package by.tms.url;



import by.tms.url.model.URLModel;
import by.tms.url.repository.UrlRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URI;
import java.util.Optional;

@ConfigurationPropertiesScan
@SpringBootApplication
public class UrlTrimmingApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlTrimmingApplication.class, args);


    }

}
