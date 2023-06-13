/*
this is a program that prompts users to enter a roman number and it returns the
roman numeral enteresd in the normal arabic numerals

this program makes use of the mapping concepts in java specifically the Hash map features

*/
package Question1;// Package name

// java utilities to be utilized in the program
import java.util.Scanner;// allows for the use of the Scanner Input Utilities
import java.util.HashMap;// allows for the use of Hash map java utilities
import java.util.Map;// allows for the use of map utilities 



public class RomanToNumerals { // class name
    
    // Below is the function to handle the conversion of the roman symbols entered to arabic 
    // the function below returns the roman number already converted to arabic numerals
     public static int romanToInt(String romanNumber) {
              
         // below is a creation of a hashmap that links each roman number to an arabic numeral
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        /*
        the loop that appears below deals with the correct conversion of the roman numbers to arabic numerals 
        the loop does not go beyond the length of the characters entered by the user 
        the loop checks to ensure that the if it happens that the current character it checks is greater than the previous one,
        it will then double the value of the previous number then  subtract it from the result
        
        an example of this can be the number 4:
            4 in roman numerals is IV
            if a user enters the letters IV the result of this will be 1+5=6 since I=1 and v=5 
            when the loop iterates through the characters and it reaches V(its current character at that point) the value of V is greater than I(the previous character in this case)
            the value of V is the doubled and then it is subtracted from the result
                5*2=10   result=6   10-6=4
        
        thus the value to be output will be 4 which is correct
             
        */
        for (int i = 0; i < romanNumber.length(); i++) {
            if (i > 0 && map.get(romanNumber.charAt(i)) > map.get(romanNumber.charAt(i - 1))) {
                result += map.get(romanNumber.charAt(i)) - 2 * map.get(romanNumber.charAt(i - 1));
            } else {
                result += map.get(romanNumber.charAt(i));
            }
        }
        return result;
        
    }

     // below is the main function 
    public static void main(String [] args){
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any roman number");
        String RomanNumber;
        RomanNumber=sc.next();
        
        // in the line of code below the value returned by the romanToInt function is stored in the ConveretedNumber variable 
        int ConvertedNumber=romanToInt(RomanNumber);
        
        System.out.println("The Number "+RomanNumber+" you entered is "+ConvertedNumber);
        
    }

    }
    
    

