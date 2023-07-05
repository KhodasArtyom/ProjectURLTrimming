package by.tms.url;



import by.tms.url.repository.UrlRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URI;


@SpringBootApplication
public class UrlTrimmingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UrlTrimmingApplication.class, args);
        UrlRepository repository = context.getBean(UrlRepository.class);
        repository.createUrl(URI.create("https://google.com"));







    }

}