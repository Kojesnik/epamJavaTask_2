import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int orel = 0, reshka = 0;                   // Task 1 variables
        int maxNumeral, num;                        // Task 2 variables
        int palindromNumber; boolean isPalindrom;   // Task 3 variables
        int simpleNumber; boolean isSimple;         // Task 4 variables
        int num2;                                   // Task 5 variables
        int a, b, nod, nok;                         // Task 6 variables
        int num3;                                   // Task 7 variables
        int num4; boolean isPerfect;                // Task 8 variables


        /* Task 1
         * "Heads or Tails"
         * 0 - orel
         * 1 - reshka
         */

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

        simpleNumber = 21;
        isSimple = simpleNumCheck(simpleNumber);
        System.out.println("\nNumber - " + simpleNumber);
        if (isSimple) {
            System.out.println("Simple number");
        } else {
            System.out.println("Not simple number");
        }

        /* Task 5
         * All simple denominators
         */

        num2 = 598;
        System.out.println("\nNumber - " + num2);
        System.out.println("All simple denominators: ");
        simpleDenom(num2);

        /* Task 6
         * NOD and NOK
         */

        a = 56;
        b = 132;
        System.out.println("\n\nNumbers - " + a + " and " + b);
        nod = nod(a, b);
        System.out.println("NOD - " + nod);
        nok = nok(a, b);
        System.out.println("NOK - " + nok);

        /* Task 7
         * Amount of different numerals
         */

        num3 = 1234445;
        System.out.println("\nNumber - " + num3);
        System.out.println("Amount of different numerals - " + differntNums(num3));

        /* Task 8
         * Perfect number or not
         */

        num4 = 8128;
        System.out.println("\nNumber - " + num4);
        isPerfect = isPerfect(num4);
        if (isPerfect) {
            System.out.println("Number is perfect");
        } else {
            System.out.println("Number is not perfect");
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

    // Task 5 method

    public static void simpleDenom(int num) {

        boolean isSimple;
        for (int i = 1; i <= num; ++i) {
            if ((num % i) == 0) {
                isSimple = simpleNumCheck(i);
                if (isSimple) {
                    System.out.print(i + " ");
                }
            }
        }

    }

    // Task 6 method (NOD)

    public static int nod(int a, int b) {

        int maxDenom = 1;
        for (int i = 1; (i * i) <=a; ++i) {
            if (((a % i) == 0) && ((b % i) == 0)) {
                if (i > maxDenom) {
                    maxDenom = i;
                }
            }
        }

        return maxDenom;

    }

    // Task 6 method (NOK)

    public static int nok(int a, int b) {

        int NOK = 0, i;
        if (a > b) {
            i = a;
        } else {
            i = b;
        }
        while (NOK == 0) {
            if (((i % a) == 0) && ((i % b) == 0)) {
                NOK = i;
            }
            ++i;
        }

        return NOK;

    }

    // Task 7 ADDITIONAL method

    public static boolean isDifferent(int numeralToCheck, String otherNumerals) {

        int numerals = Integer.valueOf(otherNumerals);
        while (numerals != 0) {
            if ((numerals % 10) == numeralToCheck) {
                return false;
            }
            numerals /= 10;
        }

        return true;

    }

    // Task 7 method

    public static int differntNums(int numToCheck) {

        int amount = 1, numeral;
        boolean isDiff;
        String allNumerals = "";
        while (numToCheck != 0) {
            numeral = numToCheck % 10;
            if (allNumerals.equals("")) {
                allNumerals += numeral;
            } else {
                isDiff = isDifferent(numeral, allNumerals);
                if (isDiff) {
                    ++amount;
                    allNumerals += numeral;
                }
            }
            numToCheck /= 10;
        }

        return amount;

    }

    public static boolean isPerfect(int numToCheck) {

        int denomSum = 0;
        for (int i = 1; i < numToCheck; ++i) {
            if ((numToCheck % i) == 0) {
                denomSum += i;
            }
        }
        if (denomSum == numToCheck) {
            return true;
        } else {
            return false;
        }

    }

}
