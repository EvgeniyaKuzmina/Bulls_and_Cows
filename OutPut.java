package bullscows;

import java.util.Random;

public class OutPut {

        static int countBulls = 0;
        static int countCows = 0;
        static String formatString;

        int[] Number (String input) {
        char[] inputToChar = input.toCharArray();
        int[] number = new int[inputToChar.length];
        for (int i = 0; i < inputToChar.length; i++) {
            number[i] = Character.getNumericValue(inputToChar[i]);
        }
        return number;
    }

        String Grade(String secretCode, String input){

        for(int i = 0; i < Number(secretCode).length; i++){
            for (int j = 0; j < Number(input).length; j++) {
                if(Number(secretCode)[i] == Number(input)[j] && i == j) {
                    countBulls++;
                }
                if(Number(secretCode)[i] == Number(input)[j] && i != j) {
                    countCows++;
                }
            }
        }
        if(countBulls > 0 && countCows > 0) {
            formatString = String.format("Grade: %d bull(s) and %d cow(s).", countBulls, countCows);
            countBulls = 0;
            countCows = 0;
        } else if (countBulls == secretCode.length()){
            formatString = String.format("Grade: %d bull(s) \nCongratulations! You guessed the secret code.", countBulls);
        } else if (countBulls > 0 && countCows ==0){
            formatString = String.format("Grade: %d bull(s).", countBulls);
            countBulls = 0;
            countCows = 0;
        } else if (countBulls == 0 && countCows > 0){
            formatString = String.format("Grade: %d cow(s).", countCows);
            countBulls = 0;
            countCows = 0;
        } else {
            formatString = "Grade: 0 bull(s) and 0 cow(s).";
            countBulls = 0;
            countCows = 0;
        }
        return formatString;
    }

        static String SecretCode (int secretCodeSizeMax, int numberSymbolsInTheCode) {

        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        char[] array = new char[secretCodeSizeMax];
        String string = "0123456789abcdefghijklmnopqrstuvwxyz";
        char[] symbols = new char[numberSymbolsInTheCode];

        for (int i = 0; i < numberSymbolsInTheCode; i++) {
            symbols[i] = string.charAt(i);
        }

        String repeatStar = "*".repeat(secretCodeSizeMax);
        System.out.printf("The secret is prepared: %s (0-9, a-%c).",repeatStar, symbols[symbols.length - 1]);

        boolean result;
        do {
            result = false;
            for (int i = 0; i < secretCodeSizeMax; i++) {
                int nextNumber = random.nextInt(numberSymbolsInTheCode);
                nextNumber = nextNumber < 10 ? nextNumber + 48 : nextNumber + 87;
                array[i] = (char)nextNumber;

            }
            for (int i = 0; i < secretCodeSizeMax; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j] && j != i) {
                        result = true;
                        break;
                    }
                }
            }

        } while(result);
        for (char i : array) {
            secretCode.append(i);
        }

        return secretCode.toString();
    }


}
