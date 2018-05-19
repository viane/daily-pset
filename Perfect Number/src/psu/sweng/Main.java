/**
 * Coding Challenge 2
 * Author: Xiaoyu Zhou
 * PSUID: xpz5043
 * Date: May 19, 2018
 *
 **/
package psu.sweng;

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Perfect Number Tester\n");
        BigInteger input;
        Scanner sc = new Scanner(System.in);
	    do{
	        try{
                System.out.print("Enter a number (0 to quit): ");
	            if(sc.hasNextBigInteger()){
                    input = sc.nextBigInteger();

                    if(input.equals(BigInteger.ZERO)){
                        System.out.printf("\nEnd\n\n-----------------");
                        return;
                    }else if(input.compareTo(BigInteger.ZERO) == -1){
                        System.out.printf("\nInvalid input, retry with a positive integer.\n\n");
                    }else {
                        // input > 0

                        calculateAndValidPerfectNumber(input);
                    }
                }else{
                    System.out.println("\nUnaccepted input, retry.\n");
                    sc.next();
                }
            }catch(Exception x){
	            System.out.println(x.getMessage());
            }
        }while(true);
    }

    private static void calculateAndValidPerfectNumber(BigInteger in){
        List<BigInteger> factors = findFactor(in);
        StringJoiner joiner = new StringJoiner(", ");
        int lineCount = 0;
        for (BigInteger item : factors) {
            joiner.add(item.toString());
            if(++lineCount % 15 == 0)
                joiner.add("\n");
        }
        System.out.println("\nThe factors are " + joiner.toString() + "\n");

        int isPerfectRC = validPerfect(in, factors);
        if (isPerfectRC==0){
            System.out.println(in.toString() + " is perfect\n");
        }else if(isPerfectRC == 1){
            System.out.println(in.toString() + " is imperfect deficient\n");
        }else{
            System.out.println(in.toString() + " is imperfect abundant\n");
        }
    }

    private static List<BigInteger> findFactor(BigInteger in){
        List<BigInteger> factorList = new ArrayList<>();
        factorList.add(BigInteger.valueOf(1));

        for(BigInteger counter = BigInteger.valueOf(2);counter.compareTo(in)==-1;counter= counter.add(BigInteger.ONE)){
            if (counter.compareTo(in.divide(BigInteger.valueOf(2))) == 1){
                // counter > in/2
                // prune half of the calculation, since a factor can't be greater than half of the original number
                break;
            }

            if(in.mod(counter).compareTo(BigInteger.ZERO) == 0){
                // in % counter == 0
                factorList.add(counter);
            }
        }

        return factorList;
    }

    private static int validPerfect(BigInteger in, List<BigInteger> factors){
        BigInteger sum = BigInteger.ZERO;
        for(BigInteger item: factors){
            sum = sum.add(item);
            if(sum.compareTo(in) == 1){
                // sum > in
                return -1;
            }
        }
        return in.compareTo(sum);
    }
}

/*

Welcome to the Perfect Number Tester

Enter a number (0 to quit): 6

The factors are 1, 2, 3

6 is perfect

Enter a number (0 to quit): 10

The factors are 1, 2, 5

10 is imperfect deficient

Enter a number (0 to quit): 40

The factors are 1, 2, 4, 5, 8, 10, 20

40 is imperfect abundant

Enter a number (0 to quit): 0

End

-----------------
Process finished with exit code 0

 */