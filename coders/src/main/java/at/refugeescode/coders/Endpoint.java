package at.refugeescode.coders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@RestController
@RequestMapping
public class Endpoint {
    @Value("${coder.url}")
    private String coderurl;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/encoder")
    String enCodeSentence(@RequestBody String message){
        return message.chars()
                .mapToObj(ascii -> (char) ascii)
                .map(ascii -> String.valueOf(ascii))
                .map(letter -> restTemplate.postForObject(coderurl, letter, String.class))
                .collect(Collectors.joining());
    }
}
