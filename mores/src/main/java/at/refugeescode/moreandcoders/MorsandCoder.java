package at.refugeescode.moreandcoders;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping
public class MorsandCoder {
    HashMap<String, String> hashMap;

    public MorsandCoder() {
        hashMap = new HashMap<>();

        String[] letters = "abcdefghijklmnopqrstuvwxyz".split("");

        String[] morse =(".-/-.../-.-./-.././..-./--./..../../.---/-.-/.-.." +
                "/--/-./---/.--./--.-/.-./.../-/..-/...-/.--/-..-/-.--" +
                "/--..").split("/");
        IntStream.range(0, 26)
                .forEach(index -> hashMap.put(letters[index], morse[index]));
        hashMap.put(" ", " / ");
    }

    @PostMapping("/morse")
    public String getTheCode(@RequestBody String letters){
        System.out.println(hashMap.get(letters));
        return hashMap.get(letters);
    }
}
