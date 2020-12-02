package com.calculatorapp;

/**
 * ValidInput is a class to check strings for valid math expressions
 *
 *
 *
 * When isValidInput is called it determines wether an expression is valid based on,
 * 1.) Valid characters
 *      - Valid characters are 0-9, -, +, /, *, ^, (, ), x
 * 2.) matching parenthesis
 *      - each parenthesis has a closing pair and close in order
 * 3.) exception free
 *      - excpetion free if the leading or ending character in the expression is not an operator other than ( or - and if an expression has more than one operator next to each other, it will determine if it's allowed
 *
 *
 *
 * @author JACOB LOCKWOOD
 * @version 12/01/2020
 */
public class ValidInput
{
    private static String errorMessage;

    // Checks if the input string is valid by checking if it has valid characters, matching parenthesis, and is free from other formating errors
    public static boolean isValidInput(String input){
        if( validCharacters(input) && matchingParenthesis(input) && exceptionFree(input) ){
            return true;
        }
        return false;
    }

    // Checks if the input string is valid by checking wether each character is valid
    public static boolean validCharacters(String input){
        for(int i = 0; i<input.length(); i++){
            if( !validCharacter( input.charAt(i) ) ){
                return false;
            }
        }
        return true;
    }

    // Checks if the input character is a valid character
    public static boolean validCharacter(char c){
        String temp = c+"";
        if(temp.matches( "/|0|1|2|3|4|5|6|7|8|9|x|/" ) || isOperator(c) ){
            return true;
        }
        errorMessage = "Invalid Character: " + c  ;
        return false;
    }

    // Checks if the input character is an operator
    public static boolean isOperator(char c){
        if( c=='-' || c=='+' || c=='/' || c=='*' || c=='(' || c== '^' || c == ')'  ){
            return true;
        }
        return false;
    }

    // Checks if the input string has matching parenthesis
    public static boolean matchingParenthesis(String input){
        char[] stack = new char[input.length()];
        int top = -1;
        for(int i=0; i<input.length(); i++){
            if( input.charAt(i) == '(' ){
                top++;
                stack[top]=input.charAt(i);
            }else if( input.charAt(i) == ')' ){
                if( top != -1 && stack[top] == '(' ){
                    top--;
                }else{
                    errorMessage = "Invalid Parenthesis" ;
                    return false;
                }
            }
        }
        if( top == -1){
            return true;
        }
        errorMessage = "Invalid Parenthesis" ;
        return false;
    }

    // Checks if input string has formating errors
    // formating errors: leading and ending characters are checked for proper character. If two operators are next to each other, it must be the right ones
    private static boolean exceptionFree(String input){
        if( isOperator(input.charAt(0)) && (input.charAt(0) != '-' && input.charAt(0) != '(' ) ){
            errorMessage = "Started expression with operator: " + input.charAt(0);
            return false;
        }else if( isOperator(input.charAt(input.length()-1)) && input.charAt(input.length()-1) != ')'  ){
            errorMessage = "Ended expression with operator: " + input.charAt(input.length()-1);
            return false;
        }

        for(int i =1; i<input.length(); i++){
            if(   isOperator( input.charAt(i) ) && isOperator( input.charAt(i-1) ) ){
                if( ( input.charAt(i-1) == '+' || input.charAt(i-1) == '-'|| input.charAt(i-1) == '*' || input.charAt(i-1) == '/') && (input.charAt(i) != '-' || input.charAt(i) != '(' ) ){
                    errorMessage = "Two operators side by side: " + input.charAt(input.charAt(i-1)) + " and " + input.charAt(i);
                    return false;
                }
            }
        }
        return true;
    }

    public static String getErrorMessage(){
        return errorMessage;
    }
}
