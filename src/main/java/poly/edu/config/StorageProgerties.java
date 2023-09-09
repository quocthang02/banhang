package poly.edu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("storage")
@Data

public class StorageProgerties {
     private String location;
}
