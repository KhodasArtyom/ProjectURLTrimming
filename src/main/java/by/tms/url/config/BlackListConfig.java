package by.tms.url.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;
import java.util.List;



@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "banned")
@Getter
@AllArgsConstructor
public class BlackListConfig {

      List<String> bannedList;
}

