package at.refugeescode.morseencoderui.service;

import at.refugeescode.morseencoderui.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SenderAndRicever {
    private RestTemplate restTemplate;

    SenderAndRicever(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Value("${encoder.url}")
    private String encodersurl;

    public String getSentences(Message message){
        String morse = restTemplate.postForObject(encodersurl, message, String.class);
        return morse;
    }

}
