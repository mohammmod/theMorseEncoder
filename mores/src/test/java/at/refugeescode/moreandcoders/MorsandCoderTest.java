package at.refugeescode.moreandcoders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MorsandCoderTest {

    @Test
    void getTheCode() {
        String[] letters = "abcdefghijklmnopqrstuvwxyz".split("");
        String[] code = ".- / -... / -.-. / -.. / . / ..-. / --. / .... / .. / .--- / -.- / .-.. / -- / -. / --- / .--. / --.- / .-. / ... / - / ..- / ...- / .-- / -..- / -.-- / --..".split(" / ");
        MorsandCoder morsandCoder = new MorsandCoder();
        List<String> expaxtedCode = Arrays.stream(letters)
                .map(letter -> morsandCoder.getTheCode(letter))
                .collect(Collectors.toList());
        IntStream.range(0,26)
                .forEach(index -> assertEquals(code[index],expaxtedCode.get(index)));
    }
}