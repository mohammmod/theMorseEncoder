package at.refugeescode.morseencoderui.service;

import jdk.jfr.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configration {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
