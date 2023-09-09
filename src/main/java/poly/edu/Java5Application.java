package poly.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import poly.edu.config.StorageProgerties;
import poly.edu.sevice.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProgerties.class)
public class Java5Application {

	public static void main(String[] args) {
		SpringApplication.run(Java5Application.class, args);
	}
	
	@Bean
    CommandLineRunner init(StorageService storageService) {
    	return (args->{
    		storageService.init();
    	});
    }
}
