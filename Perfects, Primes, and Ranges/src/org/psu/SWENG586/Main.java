/**
 * Coding Challenge 3
 * Author: Xiaoyu Zhou
 * PSUID: xpz5043
 * Date: May 27, 2018
 **/
package org.psu.SWENG586;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------\n\n\nWelcome to the Prime and Perfect Number Tester");

        try {
            List<BigInteger> inputs = Main.readInput();

            Main.processWithInput(inputs.get(0), inputs.get(1));
        } catch (EndProgramException x) {
            System.out.println("\nEnd program\n\n\n----------------");
        }
    }

    private static List<BigInteger> readInput() throws EndProgramException {
        BigInteger input;
        Scanner sc = new Scanner(System.in);
        BigInteger start = BigInteger.ZERO, end = BigInteger.ZERO;
        do {
            try {

                System.out.print("\nEnter a start number: ");
                if (sc.hasNextBigInteger()) {
                    input = sc.nextBigInteger();
                    if (input.equals(BigInteger.ZERO)) {
                        throw new EndProgramException();
                    } else if (input.compareTo(BigInteger.ZERO) == -1) {
                        System.out.printf("\nInvalid input, retry with a positive integer.\n\n");
                    } else {
                        // input > 0

                        start = input;
                    }
                } else {
                    System.out.println("\nUnaccepted input, retry.\n");
                    sc.next();
                }
            } catch (EndProgramException x) {
                throw x;
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        } while (start.compareTo(BigInteger.valueOf(1)) == -1);

        do {
            try {

                System.out.print("\nEnter a stop number: ");
                if (sc.hasNextBigInteger()) {
                    input = sc.nextBigInteger();
                    if (input.equals(BigInteger.ZERO)) {
                        throw new EndProgramException();
                    } else if (input.compareTo(BigInteger.ZERO) == -1) {
                        System.out.printf("\nInvalid input, retry with a positive integer.\n\n");
                    } else {
                        // input > 0

                        end = input;
                    }
                } else {
                    System.out.println("\nUnaccepted input, retry.\n");
                    sc.next();
                }
            } catch (EndProgramException x) {
                throw x;
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        } while (start.compareTo(BigInteger.valueOf(1)) == -1);

        return Arrays.asList(start, end);
    }

    private static void processWithInput(BigInteger start, BigInteger end) {
        try {

            if (start.compareTo(end) == 1) {
                BigInteger temp = end;
                end = start;
                start = temp;
            }

            for (BigInteger count = start; count.compareTo(end.add(BigInteger.valueOf(1))) == -1; count = count.add(BigInteger.valueOf(1))) {
                Main.calculateAndValidPerfectNumber(count);
            }

            System.out.println("\n\n----------------");

        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    private static void calculateAndValidPerfectNumber(BigInteger in) {
        List<BigInteger> factors = Main.findFactor(in);
//        StringJoiner joiner = new StringJoiner(", ");
//        int lineCount = 0;
//        for (BigInteger item : factors) {
//            joiner.add(item.toString());
//            if(++lineCount % 15 == 0)
//                joiner.add("\n");
//        }
//         System.out.println("\nThe factors are " + joiner.toString() + "\n");

        int isPerfectRC = Main.validPerfect(in, factors);
        String prependStr = "\nThe number ";
        if (isPerfectRC == 0) {
            System.out.println(prependStr + in.toString() + " is Perfect");
        } else if (isPerfectRC == 1) {
            System.out.println(prependStr + in.toString() + " is Imperfect Deficient");
        } else if (isPerfectRC == 2) {
            System.out.println(prependStr + in.toString() + " is Prime");
        } else {
            System.out.println(prependStr + in.toString() + " is Imperfect Abundant");
        }
    }

    private static List<BigInteger> findFactor(BigInteger in) {
        List<BigInteger> factorList = new ArrayList<>();
        factorList.add(BigInteger.valueOf(1));

        for (BigInteger counter = BigInteger.valueOf(2); counter.compareTo(in) == -1; counter = counter.add(BigInteger.ONE)) {
            if (counter.compareTo(in.divide(BigInteger.valueOf(2))) == 1) {
                // counter > in/2
                // prune half of the calculation, since a factor can't be greater than half of the original number
                break;
            }

            if (in.mod(counter).compareTo(BigInteger.ZERO) == 0) {
                // in % counter == 0
                factorList.add(counter);
            }
        }

        return factorList;
    }

    private static int validPerfect(BigInteger in, List<BigInteger> factors) {
        if (factors.size() == 1) {
            return 2;
        }

        BigInteger sum = BigInteger.ZERO;
        for (BigInteger item : factors) {
            sum = sum.add(item);
            if (sum.compareTo(in) == 1) {
                // sum > in
                return -1;
            }
        }
        return in.compareTo(sum);
    }
}

class EndProgramException extends Exception {
    public EndProgramException() {
        super();
    }
}

/*
Test Result

----------------


Welcome to the Prime and Perfect Number Tester

Enter a start number: 1

Enter a stop number: 17

The number 1 is Prime

The number 2 is Prime

The number 3 is Prime

The number 4 is Imperfect Deficient

The number 5 is Prime

The number 6 is Perfect

The number 7 is Prime

The number 8 is Imperfect Deficient

The number 9 is Imperfect Deficient

The number 10 is Imperfect Deficient

The number 11 is Prime

The number 12 is Imperfect Abundant

The number 13 is Prime

The number 14 is Imperfect Deficient

The number 15 is Imperfect Deficient

The number 16 is Imperfect Deficient

The number 17 is Prime


----------------

 */