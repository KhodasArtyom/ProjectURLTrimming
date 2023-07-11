package by.tms.url.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


import java.util.Set;


@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "block")
@Getter
@Setter
public class BlackListConfig {

     private Set<String> blackList;
}

