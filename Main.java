package bullscows;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OutPut output = new OutPut();
        String result;
        int lengthOfCode = 0;
        int symbolsInCode = 0;


        System.out.println("Please, enter the secret code's length:");
        String input1 = scanner.nextLine();
        try {
            lengthOfCode = Integer.parseInt(input1);
        } catch (NumberFormatException e) {
            System.out.printf("Error: %s isn't a valid number.\n", input1);
            System.exit(0);
        }
        if (lengthOfCode > 36 || lengthOfCode == 0) {
            System.out.println("Error: maximum number of the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        String input2 = scanner.nextLine();
        try {
            symbolsInCode = Integer.parseInt(input2);
        } catch (NumberFormatException e) {
            System.out.printf("Error: %s isn't a valid number.\n", input2);
            System.exit(0);
        }

        if (lengthOfCode > symbolsInCode) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", lengthOfCode, symbolsInCode);
            System.exit(0);

        }
        else if (symbolsInCode > 36 || symbolsInCode == 0) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);

        }else {
            String secretCode = OutPut.SecretCode(lengthOfCode, symbolsInCode);
            System.out.println("Okay, let's start a game!");
            int i = 0;


            do {
                System.out.printf("Turn: %d", ++i);
                System.out.println(" ");
                String inputUser = scanner.next();
                result = output.Grade(secretCode, inputUser);
                System.out.println(result);
            } while (!result.equals(String.format("Grade: %s bull(s) \nCongratulations! You guessed the secret code.", lengthOfCode)));
        }
    }

}

