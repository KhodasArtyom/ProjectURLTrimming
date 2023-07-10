package by.tms.url.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.List;

@ConfigurationProperties(prefix = "black")
@Getter
@AllArgsConstructor
@ConfigurationPropertiesScan
public class BlackListConfig {
     List<String> blackList;
}

