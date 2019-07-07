import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int orel = 0, reshka = 0;                   // Task 1 variables
        int maxNumeral, num;                        // Task 2 variables
        int palindromNumber; boolean isPalindrom;   // Task 3 variables
        int simpleNumber; boolean isSimple;         // Task 4 variables


        /* Task 1
         * "Heads or Tails"
         * 0 - orel
         * 1 - reshka */

        Random random = new Random();
        for (int i = 0; i < 100; ++i) {
            if (random.nextInt(2) == 0) {
                ++orel;
            } else {
                ++reshka;
            }
        }
        System.out.println("Orel - " + orel);
        System.out.println("Reshka - " + reshka);

        /* Task 2
         * Max numeral of number
         */

        num = random.nextInt();
        if (num < 0) {
            num = Math.abs(num);
        }
        System.out.println("\nRandom number - " + num);
        maxNumeral = maxNumeral(num);
        System.out.println("Max numeral of " + num + " is " + maxNumeral);

        /* Task 3
         * Palindrom check 2 METHODS
         */

        palindromNumber = 404;
        isPalindrom = palindromCheck(palindromNumber);
        System.out.println("\nNumber - " + palindromNumber);
        if (isPalindrom) {
            System.out.println("Number - PALINDROM");
        } else {
            System.out.println("Number - NOT PALINDROM");
        }

        /* Task 4
         * Simple or not
         */

        simpleNumber = 3;
        isSimple = simpleNumCheck(simpleNumber);
        System.out.println("\nNumber - " + simpleNumber);
        if (isSimple) {
            System.out.println("Simple number");
        } else {
            System.out.println("Not simple number");
        }

    }

    // Task 2 method

    public static int maxNumeral(int num) {

        int maxNumeral, lastNumeral;
        maxNumeral = num % 10;
        while (num != 0) {
            lastNumeral = num % 10;
            num = num / 10;
            if (lastNumeral > maxNumeral) {
                maxNumeral = lastNumeral;
            }
        }

        return maxNumeral;

    }

    // Task 3 method

    public static boolean palindromCheck(int palindromNumber) {

        String palindromString, reverseString = "";
        palindromString = Integer.toString(palindromNumber);
        while (palindromNumber != 0) {
            reverseString += palindromNumber % 10;
            palindromNumber /= 10;
        }
        if (palindromString.equals(reverseString)) {
            return true;
        } else {
            return false;
        }

    }

    // Task 3 method (STRING BUFFER METHOD)

    public static boolean palindromCheckSB(int palindromNumber) {

        String palindromString, reverseString;
        palindromString = Integer.toString(palindromNumber);
        reverseString = new StringBuffer(palindromString).reverse().toString();
        if (palindromString.equals(reverseString)) {
            return true;
        } else {
            return false;
        }

    }

    // Task 4 method

    public static boolean simpleNumCheck(int simpleNumber) {

        if (simpleNumber == 1) {
            return false;
        }
        for (int i = 2; (i * i) <= simpleNumber; ++i) {
            if ((simpleNumber % i) == 0) {
                return false;
            }
        }

        return true;

    }


}
