import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMorse {
    MorseCode m = new MorseCode();

    @Test
    void singleLetterToMorse() {
        assertEquals("...", m.textToMorse("S"));
        assertEquals("--.", m.textToMorse("G"));
        assertEquals("-.--", m.textToMorse("Y"));
    }

    @Test
    void singleMorseToLetter() {
        assertEquals("P", m.morseToText(".--."));
        assertEquals("J", m.morseToText(".---"));
        assertEquals("A", m.morseToText(".-"));
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
    void roundTrip() {
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
    void invalidTextInput() {
        assertThrows(IllegalArgumentException.class, () -> m.textToMorse("good&"));
        assertThrows(IllegalArgumentException.class, () -> m.textToMorse("345Å"));
    }

    @Test
    void invalidMorseInput() {
        assertThrows(IllegalArgumentException.class, () -> m.morseToText("... ="));
        assertThrows(IllegalArgumentException.class, () -> m.morseToText("#"));
    }

}
