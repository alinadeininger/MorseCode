
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMorse {

    MorseCode m = new MorseCode();

    @Test
    void singleLetterToMorse() {
        assertEquals("...", m.getMorse("S"));
        assertEquals("--.", m.getMorse("G"));
        assertEquals("-.--", m.getMorse("Y"));
    }

    @Test
    void singleMorseToLetter() {
        assertEquals("P", m.getLetter(".--."));
        assertEquals("J", m.getLetter(".---"));
        assertEquals("A", m.getLetter(".-"));
    }

    @Test
    void wordToMorse() {
        assertEquals(".... . .-.. .-.. ---", m.textToMorse("HELLO"));
        assertEquals(".--. .-. --- --. .-. .- -- -- .. -. --.", m.textToMorse("PROGRAMMING"));
    }

    @Test
    void testLowerCaseInput() {
        assertEquals(".... . .-.. .-.. ---", m.textToMorse("hello"));
        assertEquals("-... .. .-. -.. ...", m.textToMorse("birds"));
    }

    @Test
    void morseToWord() {
        assertEquals("SOS", m.morseToText("... --- ..."));
        assertEquals("HELP", m.morseToText(".... . .-.. .--."));
    }

    @Test
    void roundTrip(){
        String original = "ROUNDTRIP";
        String morse = m.textToMorse(original);
        String result = m.morseToText(morse);

        assertEquals(original, result);
    }




    @Test
    void longerMorseToText() {
        assertEquals("HELLOWORLD", m.morseToText(".... . .-.. .-.. --- .-- --- .-. .-.. -.."));
    }

    @Test
    void longerTextWithSpacesToMorse() {
        String myText = "The weather is cold and sunny today";
        assertEquals("- .... . .-- . .- - .... . .-. .. ... -.-. --- .-.. -.. " +
                ".- -. -.. ... ..- -. -. -.-- - --- -.. .- -.--", m.textToMorse(myText));
    }


    @Test
    void invalidLetterInput(){
        assertNull(m.getMorse("3"));
        assertNull(m.getMorse("Å"));

        assertThrows(IllegalArgumentException.class, () -> m.textToMorse("good&"));
    }

    @Test
    void invalidMorseInput(){
        assertNull(m.getLetter("%"));
        assertNull(m.getLetter("999999"));

        assertThrows(IllegalArgumentException.class, () -> m.morseToText("... ="));
    }

}
