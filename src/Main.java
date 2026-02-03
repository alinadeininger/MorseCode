import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MorseCode m = new MorseCode();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Do you want to convert letters to morse code (1) OR morse code to letters (2)?: ");
            int choice = Integer.parseInt(scanner.nextLine());

            System.out.println("*********************************************************************************");

            if (choice == 1) {
                System.out.println("Insert text that you want to convert to morse code: ");
                System.out.println();
                String textInput = scanner.nextLine().toUpperCase();


                for (int i = 0; i < textInput.length(); i++) {
                    String letter = m.getMorse(String.valueOf(textInput.charAt(i)));
                    if (letter.equals(" ")) {
                        continue;
                    }
                    System.out.print(letter + " ");
                }


            } else if (choice == 2) {
                System.out.println("Insert morse code that you want to convert to text: ");
                System.out.println();
                String morseInput = scanner.nextLine();

                String[] morseParts = morseInput.split(" ");

                for (int i = 0; i < morseParts.length; i++) {
                    String morse = m.getLetter(morseParts[i]);
                    if (morse == null) {
                        System.out.println("Invalid symbol!");
                        continue;
                    }
                    System.out.print(morse);
                }

            } else {
                System.out.println("Not a valid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("You have to put a number (1 or 2).");
        } catch (NullPointerException e) {
            System.out.println("Invalid symbol!");
        }
    }
}


