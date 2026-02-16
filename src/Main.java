import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MorseCode m = new MorseCode();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Do you want to convert letters --> morse code (1) OR morse code --> letters (2)?: ");
            int choice = Integer.parseInt(scanner.nextLine());

            System.out.println("*********************************************************************************");

            if (choice == 1) {
                System.out.println("Insert text that you want to convert to morse code: ");
                System.out.println();
                String textInput = scanner.nextLine();
                System.out.println(m.textToMorse(textInput));
            } else if (choice == 2) {
                System.out.println("Insert morse code that you want to convert to text: ");
                System.out.println();
                String morseInput = scanner.nextLine();
                System.out.println(m.morseToText(morseInput));
            } else {
                System.out.println("Not a valid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("You have to put a number (1 or 2).");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


