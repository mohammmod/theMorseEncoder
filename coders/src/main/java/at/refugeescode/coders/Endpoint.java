package at.refugeescode.coders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping
public class Endpoint {
    @Value("${coder.url}")
    private String coderurl;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/encoder")
    String enCodeSentence(@RequestBody String message){
        String[] split = message.split("");
        String collect = Arrays.stream(split)
                .map(letter -> restTemplate.postForEntity(coderurl, letter, String.class).getBody())
                .collect(Collectors.joining(""));
        return collect;

    }
}
