import java.util.HashMap;

public class MorseCode {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXZY";
    private String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private final HashMap<String, String> letterToMorse = new HashMap<>();
    private final HashMap<String, String> morseToLetter = new HashMap<>();

    public MorseCode() {

        for (int i = 0; i < morseCode.length; i++) {
            letterToMorse.put(String.valueOf(alphabet.charAt(i)), morseCode[i]);
            morseToLetter.put(morseCode[i], String.valueOf(alphabet.charAt(i)));
        }
    }

    public String getLetter(String morse) {
        return morseToLetter.get(morse);
    }

    public String getMorse(String letter) {
        return letterToMorse.get(letter);
    }


    public String textToMorse(String textInput) {
        textInput = textInput.toUpperCase();
        String result = "";
        for (int i = 0; i < textInput.length(); i++) {
            String letter = String.valueOf(textInput.charAt(i));
            if (letter.equals(" ")) {
                continue;
            }
            String morse = getMorse(letter);

            if (morse == null) {
                System.out.println("Invalid input: " + letter);
                System.out.println("Only letters A to Z");
                continue;
            }
            result += morse + " ";
        }
        return result.trim();
    }

    public String morseToText(String morseInput) {
        String result = "";
        String[] morseParts = morseInput.split(" ");

        for (String morse : morseParts) {
            String letter = getLetter(morse);
            if (letter == null) {
                System.out.println("Invalid symbol: " + morse);
                continue;
            }
            result += letter;

        }
        return result;
    }

}
