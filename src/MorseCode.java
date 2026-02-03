import java.util.HashMap;

public class MorseCode {

    HashMap<String, String> letterToMorse = new HashMap<>();
    HashMap<String, String> morseToLetter = new HashMap<>();

    public MorseCode(){
        addPair("A", ".-");
        addPair("B", "-...");
        addPair("C", "-.-.");
        addPair("D", "-..");
        addPair("E", ".");
        addPair("F", "..-.");
        addPair("G", "--.");
        addPair("H", "....");
        addPair("I", "..");
        addPair("J", ".---");
        addPair("K", "-.-");
        addPair("L", ".-..");
        addPair("M", "--");
        addPair("N", "-.");
        addPair("O", "---");
        addPair("P", ".--.");
        addPair("Q", "--.-");
        addPair("R", ".-.");
        addPair("S", "...");
        addPair("T", "-");
        addPair("U", "..-");
        addPair("V", "...-");
        addPair("W", ".--");
        addPair("X", "-..-");
        addPair("Y", "-.--");
        addPair("Z", "--..");
    }

    private void addPair(String letter, String morse) {
        letterToMorse.put(letter, morse);
        morseToLetter.put(morse, letter);
    }

    public String getLetter(String morse) {
        return morseToLetter.get(morse);
    }

    public String getMorse(String letter) {
        return letterToMorse.get(letter);
    }


}
