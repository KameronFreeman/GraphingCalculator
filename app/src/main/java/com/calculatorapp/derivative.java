package com.calculatorapp;

/**
 * Derivative class is meant to take a math expression as a string and return the derivative of that expression
 *
 * @author JACOB LOCKWOOD
 * @version 12/02/2020
 */
public class derivative
{

    static String output;
    static simplify Simple = new simplify();
    public derivative(){

    }

    public static String takeDerivative(String input){
        System.out.println("Input " + input);
        for(int i= 0;i<input.length();i++){
            int count = 0;
            if(input.charAt(i)=='('){
                count+=1;
            }else if(input.charAt(i)==')'){
                count+=1;
            }else if(count==0){
                if(input.charAt(i)=='+'){
                    return output = takeDerivative(input.substring(0,i)) + "+" + takeDerivative(input.substring(i+1));
                }else if(input.charAt(i)=='-'){
                    return output = takeDerivative(input.substring(0,i)) + "-" + takeDerivative(input.substring(i+1));
                }else if(input.charAt(i)=='/'){
                    return output = quotientRule(input);
                }else if(input.charAt(i)=='*'){
                    return output = productRule(input);
                }else if(input.charAt(i)=='^' && input.charAt(i-1)==')'){
                    return output = chainRule(input);
                }
            }
        }
        output = powerRule(input);
        return output;
    }

    // Expected input is passsed as g(f(x))
    // Output is g'(f(x))*f'(x)
    public static String chainRule(String input){
        String temp = "x^";
        int i;
        int count =0;
        String f_OF_x;
        String g_OF_x;
        for(i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                count+=1;
            }else if(input.charAt(i)==')'){
                count-=1;
            }else if(count==0){
                try{
                    if(input.charAt(i)=='^'){
                        f_OF_x = input.substring(1,i-1);
                        g_OF_x = input.substring(i+1);
                        int z = Integer.parseInt(g_OF_x);
                        return output = g_OF_x + "(" + f_OF_x + ")^" + String.valueOf(z-1) + "*" + takeDerivative(f_OF_x);
                    }
                }catch(Exception e){
                    break;
                }
            }
        }
        return output = "Invalid input";
    }

    // Expected input is passed as f(x)/g(x)
    // Output is (f'(x)*g(x)-f(x)*g'(x))/(g(x))^2
    public static String quotientRule(String input){
        int i;
        for(i=0;input.charAt(i)!='/';i++){}
        String f_OF_x = input.substring(0,i);
        String g_OF_x = input.substring(i+1);
        output = "("+takeDerivative(f_OF_x)+"*"+g_OF_x+"-"+f_OF_x+"*"+takeDerivative(g_OF_x)+")/("+g_OF_x+")^2";
        return output;
    }

    // Expected input is passed as f(x)*g(x)
    // Output is f'(x)*g(x)+f(x)*g'(x)
    public static String productRule(String input){
        int i;
        for(i=0;input.charAt(i)!='*';i++){}
        String f_OF_x = input.substring(0,i);
        String g_OF_x = input.substring(i+1);
        output = takeDerivative(f_OF_x)+"*"+g_OF_x+"+"+f_OF_x+"*"+takeDerivative(g_OF_x) ;
        return output;
    }

    // derv will return the derivative of a function of the form f(x)=cx^z => f'(x) =(c*z)x^(z-1)
    // c is the leading coeffient and z is the power
    public static String powerRule(String input){
        output = "";
        int c = 1;
        int z = 1;
        Exception funnyBusiness = new Exception();

        // Checks the first Char in input String.
        // Valid input for input.charAt(0) is "x,-,(,[0-9]".
        // All other characters will be considered invalid input (Will add an option for sqrt)
        if(input.charAt(0) == 'x'){
            // Checks the second char in input String.
            // If there is no character in input.charAt(1), a nullpointer will be throw and therefore we return the derivative of x
            // Valid input for input.charAt(1) is "^,null"
            try{
                if(input.charAt(1) == '^'){
                    // Checks wether the exponent value is negative or positive
                    if(input.charAt(2) == '-'){
                        z = Integer.parseInt(input.substring(3));
                        // If z==1 is a special case since x == 1x
                        if(z==1){
                            output = "-x^-"+String.valueOf(z+1);
                        }else{
                            output = "-"+String.valueOf(z)+"x^-"+String.valueOf(z+1);
                        }
                    }else{
                        z = Integer.parseInt(input.substring(2));
                        if(z==0){
                            output = "0";
                        }else if(z==1){
                            throw  funnyBusiness ;
                        }else if(z==2){
                            output = String.valueOf(z)+"x";
                        }else{
                            output = String.valueOf(z)+"x^"+String.valueOf(z-1);
                        }
                    }
                }
            }catch(Exception e){
                output = "1";
            }
        }else if(input.charAt(0) == '-'){
            if(input.charAt(1) == 'x'){
                try{
                    if(input.charAt(2) == '^'){
                        if(input.charAt(3) == '-'){
                            z = Integer.parseInt(input.substring(4));
                            if(z==0){
                                output="Invalid input";
                            }else if(z==1){
                                output= "x^-"+ String.valueOf(z+1);
                            }else{
                                output = String.valueOf(z) + "x^-" + String.valueOf(z+1);
                            }
                        }else if(constant(input.charAt(3)) || input.charAt(3)=='('){ // Needs to be fixed. '(' is not an int so we can't -1. needs its own if clause
                            z = Integer.parseInt(input.substring(3));
                            if(z==0){
                                output="0";
                            }else if(z==1){
                                throw funnyBusiness;
                            }else if(z==2){
                                output="-"+String.valueOf(z)+"x";
                            }else{
                                output = "-"+String.valueOf(z)+"x^"+String.valueOf(z-1);
                            }
                        }else{
                            output="Invalid input";
                        }
                    }
                }catch(Exception e){
                    output = "-1";
                }
            }else if(constant(input.charAt(1))){
                int i=1;
                try{
                    for(i=1;constant(input.charAt(i)); i++){}
                    String coefficent = input.substring(1,i);
                    c = Integer.parseInt(coefficent);
                    if(input.charAt(i)=='x'){
                        if(input.charAt(i+1)=='^'){
                            if(input.charAt(i+2)=='-'){
                                if(constant(input.charAt(i+3))){
                                    z = Integer.parseInt(input.substring(i+3));
                                    output=String.valueOf(c*z)+"x^-"+String.valueOf(z+1);
                                }else{
                                    output="Invalid input";
                                }
                            }else if(constant(input.charAt(i+2))){
                                z = Integer.parseInt(input.substring(i+2));
                                if(z==0){
                                    output="0";
                                }else if(z==1){
                                    output="-"+String.valueOf(c);
                                }else if(z==2){
                                    output="-"+String.valueOf(c*z)+"x";
                                }else{
                                    output="-"+String.valueOf(c*z)+"x^"+String.valueOf(z-1);
                                }
                            }else{
                                output="Invalid input";
                            }
                        }else{
                            output="Invalid input";
                        }
                    }
                }catch(Exception e){
                    String coefficent = input.substring(1,i);
                    c = Integer.parseInt(coefficent);
                    output = "-"+String.valueOf(c);
                }
            }else{
                output ="Invalid input";
            }

        }else if(constant(input.charAt(0))){
            int i =0;
            try{

                for(i=0;constant(input.charAt(i)); i++){}
                String coefficent = input.substring(0,i);
                c = Integer.parseInt(coefficent);
                if(input.charAt(i)=='x'){
                    if(input.charAt(i+1)=='^'){
                        if(input.charAt(i+2)=='-'){
                            if(constant(input.charAt(i+3))){
                                z = Integer.parseInt(input.substring(i+3));
                                output="-"+String.valueOf(c*z)+"x^-"+String.valueOf(z+1);
                            }else{
                                output="Invalid input";
                            }
                        }else if(constant(input.charAt(i+2))){
                            z = Integer.parseInt(input.substring(i+2));
                            if(z==0){
                                output="0";
                            }else if(z==1){
                                output=String.valueOf(c);
                            }else if(z==2){
                                output=String.valueOf(c*z)+"x";
                            }else{
                                output=String.valueOf(c*z)+"x^"+String.valueOf(z-1);
                            }
                        }else{
                            output="Invalid input";
                        }
                    }else{
                        output="Invalid input";
                    }
                }else{
                    //output = "0";
                }
            }catch(Exception e){
                String coefficent = input.substring(0,i);
                c = Integer.parseInt(coefficent);
                output = String.valueOf(c);
            }
        }else{
            output ="Invalid input";
        }
        if(Simple.isConstant(output) && input.equals(output)){
            return "0";
        }
        return output ;
    }

    // constant checks if char c is a numeric value between 0-9
    public static boolean constant(char c){
        String temp = c+"";
        if( temp.matches("/|0|1|2|3|4|5|6|7|8|9|/") ){
            return true;
        }
        return false;
    }

    public static boolean isOperator(char c){
        if( c=='-' || c=='+' || c=='/' || c=='*' || c=='(' || c=='^'){
            return true;
        }
        return false;
    }

}
