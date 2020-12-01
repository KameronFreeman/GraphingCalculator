package com.calculatorapp;

public class Simplify {

    String output;
    public Simplify(){

    }


    public static int endBrace(String input){
        int count = 0;
        //System.out.println(input);
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i)== '('){
                count +=1;
            }else if(input.charAt(i) == ')'){
                count -=1;
                if(count == 0){
                    return i;
                }
            }
        }
        return -1;
    }

    public static String add(String x, String y){
        String output="";
        // System.out.println("The value of x: " + x);
        // System.out.println("The value of y: " + y);
        if( isConstant(x) && isConstant(y) ){
            output = String.valueOf( Integer.parseInt(x) + Integer.parseInt(y) );
        }else if(samexExponent(x,y)){
            output = combineLikeTerms(x,y,'+');
        }else{
            output = x + "+" + y;
        }
        return output;
    }

    public static String subtract(String x, String y){
        String output="";
        if( isConstant(x) && isConstant(y) ){
            output = String.valueOf( Integer.parseInt(x) - Integer.parseInt(y) );
        }else if(samexExponent(x,y)){
            output = combineLikeTerms(x,y,'-');
        }else{
            output = x + "-" + y;
        }
        return output;
    }

    public static String divide(String x, String y){
        String output="";
        if( isConstant(x) && isConstant(y) ){
            output = String.valueOf( Integer.parseInt(x) / Integer.parseInt(y) );
        }else if(samexExponent(x,y)){
            output = combineLikeTerms(x,y,'/');
        }else{
            output = x + "/" + y;
        }
        return output;
    }
    //previousTerm(input.substring(0,endBrace(input.substring(i))+1))
    public static String multiply(String x, String y){
        String output="";
        // System.out.println(x);
        // System.out.println(y);
        if( isConstant(x) && isConstant(y) ){
            output = String.valueOf( Integer.parseInt(x) * Integer.parseInt(y) );
        }else if(samexExponent(x,y)){
            output = combineLikeTerms(x,y,'*');
        }else if(x.charAt(0) == '(' || y.charAt(0) == '(' ){
            //output = factor(x,y);
        }else{
            output = x + "*" + y;
        }
        return output;
    }

    public static String exponent(String x, String y){
        String output= x + "^" +  y;
        // System.out.println(x);
        // System.out.println(isConstant(x));
        if(isConstant(y) && isConstant(x)){
            output = String.valueOf( (int)Math.pow(Integer.parseInt(x),Integer.parseInt(y) ) );
        }else if(x.charAt(x.length()-1) == ')' && isConstant(y)){
            // for(int i = 1;i< Integer.parseInt(y);i++){
            // output = factor(output,x);
            // }
        }

        return output;
    }



    public static boolean isConstant(String input){
        for(int i=0;i<input.length();i++){
            if(Character.getNumericValue(input.charAt(i)) >= 9){
                return false;
            }
        }
        return true;
    }

    public static boolean isConstant(char input){
        if( Character.getNumericValue(input) >= 9 ){
            return false;
        }

        return true;
    }

    public static boolean samexExponent(String x, String y){
        if(getExponent(x).equals(getExponent(y)) && (!getExponent(y).equals("NO EXPONENT") || !getExponent(x).equals("NO EXPONENT")) ){
            return true;
        }
        return false;
    }

    public static String combineLikeTerms(String x, String y, char operator){
        String output = "";
        if(samexExponent(x,y)){
            output = simplify( x.substring(0,findX(x)) + operator + y.substring(0,findX(y)) ) + "x^" + getExponent(x) ;
        }

        return output;
    }

    public static int findPower(String input){
        for(int i =0;i<input.length();i++){
            if(input.charAt(i)=='^'){
                return i;
            }
            if(input.charAt(i) == 'x' && i+1 == input.length() ){
                return -1;
            }
        }
        return -2;
    }

    public static String getExponent(String input){
        String power =  "";
        if(findPower(input) == -2){
            return "NO EXPONENT";
        }else if(findPower(input) == -1){
            return "1";
        }
        for(int i=findPower(input);i<input.length();i++){
            if(isConstant(input.charAt(i))){
                power = power + input.charAt(i);
            }
        }
        return power;
    }

    public static int findX(String input){
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='x'){
                return i;
            }
        }
        return -1;
    }

    public static boolean isOperator(char c){
        if( c=='-' || c=='+' || c=='/' || c=='*' || c=='(' || c== '^'  ){
            return true;
        }
        return false;
    }

    public static String simp(String input){
        //System.out.println("INPUT: " + input);

        String output = input;
        String expression = "";
        char highestOperation = '0';
        int point = 0;
        int start = 0;
        for(int i =0; i<input.length();i++){
            if(isOperator(input.charAt(i))){
                if(priorityLevel(input.charAt(i)) > priorityLevel(highestOperation) ){
                    if(input.charAt(i)=='('){
                        // if(endBrace(input.substring(i)) == input.length()-1 && i==0){
                        // return output = simp(input.substring(1,input.length()-1));
                        // }else if( !isOperator(input.charAt(i-1)) ){
                        // return output = simp(input.substring(0,i) + "*(" + simp(input.substring(i+1,endBrace(input.substring(i))+1)) + input.substring(endBrace(input.substring(i))+1));
                        // }
                        // else if( input.charAt(i-1) == '*'){
                        // System.out.println(previousTerm(input.substring(0,i)));
                        // System.out.println(input.substring(i,endBrace(input.substring(i))));
                        // return output = simp( input.substring(0, i-previousTerm(input.substring(0,i)).length() ) + distribute(previousTerm(input.substring(0,i)), input.substring(i,endBrace(input.substring(i)))) + input.substring(endBrace(input.substring(i))+1));
                        // }
                    }

                    // System.out.println("Next Term: " + nextTerm(input.substring(i+1) ) );
                    // System.out.println("Prev Term: " + previousTerm(input.substring(0,i)) );
                    expression = previousTerm(input.substring(0,i)) + input.charAt(i) + nextTerm(input.substring(i+1)) ;
                    highestOperation = input.charAt(i);

                    if(expression.length() == input.length()){
                        output = simplify(expression);
                    }else if(expression.equals(input.substring(0,expression.length())) ){
                        output = simplify(expression) + input.substring(expression.length());
                    }else{
                        output = input.substring(0, input.indexOf(highestOperation) - previousTerm(input.substring(0,input.indexOf(highestOperation))).length() ) + simplify(expression) + input.substring(input.indexOf(highestOperation) - previousTerm(input.substring(0,input.indexOf(highestOperation))).length() + expression.length());
                    }
                }
            }

        }
        if(output.equals(input)){
            return output;
        }

        return simp(output);
    }

    public static int priorityLevel(char operation){
        int level;
        if(operation == '('){
            level = 6;
        }else if(operation == '^'){
            level = 5;
        }else if(operation == '*'){
            level = 4;
        }else if(operation == '/'){
            level = 3;
        }else if(operation == '+'){
            level = 2;
        }else if(operation == '-'){
            level = 1;
        }else{
            level = 0;
        }
        return level;
    }

    public static String nextTerm(String input){
        //System.out.println("input at next term: " + input);
        if(input.length() == 1){
            return input;
        }
        int i;
        for(i = 0; i<input.length();i++){
            if( isOperator(input.charAt(i))){
                return input.substring(0,i) ;
            }
        }
        //for(i=0;  i< input.length() && (!isOperator(input.charAt(i)) || input.charAt(i) != '(' );i++){}
        //System.out.println( "Output at next term: " + input.substring(0,i) );
        return input.substring(0,i);
    }

    public static String previousTerm(String input){
        String temp = input;
        if(input.length() == 1){
            return input;
        }
        int i;
        for(i=input.length()-1; i>=0 && !isOperator(input.charAt(i));i--){}
        return input.substring(i+1);
    }



    public static String simplify(String input){
        //System.out.println("Input at Simplify: " + input);
        String output = "";
        int count = 0;
        for(int i=0;i<input.length();i++){
            if( input.charAt(i) == '(' ){
                count+=1;
            }else if(input.charAt(i) == ')'){
                count-=1;
            }else if(count==0){
                if( input.charAt(i) == '*' ){
                    return output = multiply(input.substring(0,i),input.substring(i+1));
                }else if( input.charAt(i) == '/' ){
                    return output = divide(input.substring(0,i),input.substring(i+1));
                }else if( input.charAt(i) == '+' ){
                    return output = add(input.substring(0,i),input.substring(i+1));
                }else if( input.charAt(i) == '-' ){
                    return output = subtract(input.substring(0,i),input.substring(i+1));
                }
            }
            //System.out.println("count equals: " + count);
        }
        return output;
    }

}
