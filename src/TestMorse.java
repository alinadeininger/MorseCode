
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMorse {

    MorseCode m = new MorseCode();

    @Test
    void singleLetterToMorse(){
        assertEquals("...", m.getMorse("S"));
    }

    @Test
    void singleMorseToLetter(){
        assertEquals("P", m.getLetter(".--."));
    }

    @Test
    void wordToMorse(){
       assertEquals(".... . .-.. .-.. ---", m.textToMorse("hello"));
    }

    @Test
    void longerMorseToText(){
        assertEquals("HELLOWORLD", m.morseToText(".... . .-.. .-.. --- .-- --- .-. .-.. -..") );
    }

    @Test
    void longerTextToMorse(){
        String myText = "The weather is cold and sunny today";
        assertEquals("- .... . .-- . .- - .... . .-. .. ... -.-. --- .-.. -.. " +
                ".- -. -.. ... ..- -. -. -.-- - --- -.. .- -.--", m.textToMorse(myText));
    }
    
}
