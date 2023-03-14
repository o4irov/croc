package com.firstTask;

/**
 * Javadoc
 * @autor o41rov
 * @version 17.0.2
 */

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if(isMultipleThree(i) && isMultipleFive(i)){
                System.out.println("FizzBuzz");
            }
            else if(isMultipleThree(i)){
                System.out.println("Fizz");
            }
            else if(isMultipleFive(i)){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
        }
    }

    //Делимость числа на 3
    public static boolean isMultipleThree(int num){
        return num % 3 == 0;
    }

    //Делимость числа на 5
    public static boolean isMultipleFive(int num){
        return num % 5 == 0;
    }
}
