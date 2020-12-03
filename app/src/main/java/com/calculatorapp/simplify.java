package com.calculatorapp;

/**
 * simplify is a class meant to take a math expression and reduse it to a simpler but equal form.
 *
 * In order to be simplified and equal expression, the simplify method must follow PEMDAS rules
 * P - Parenthesis
 * E - Exponent
 * M - Multiply
 * D - Divide
 * A - Add
 * S - Subtract
 *
 *
 *
 * NOTE: the return expression might not be the simplest expression due to not foiling parenthesis in expression
 * NOTE: Inteaded to be used along side validInput class to ensure all  input is valid
 *
 * @author JACOB LOCKWOOD
 * @version 12/01/2020
 */
public class simplify{
    String simple;
    //testing purposes
    public simplify(){}

    // simplify constructor sets simplify expression to String simple
    public simplify(String input){
        String output = input;
        String temp = "";
        for(int i = 0; i<input.length(); i++){
            if( output.equals(temp) ){
                simple = output;
            }
            temp = simplify(output);
            output = simplify(temp);
        }
        simple = output;
    }

    // For Andriod studio app only
    public static String simple(String input){
        String output = input;
        String temp = "";
        for(int i =0; i<input.length(); i++){
            if(output.equals(temp)){
                return output;
            }
            temp = simplify(output);
            output = simplify(temp);
        }
        return output;
    }

    // simplify is the main function of the simplify class
    // given a math expression
    public  static String simplify(String input){
        String output = input;
        output = parenthesis(output);
        output = exponent(output);
        output = multiply(output);
        output = divide(output);
        output = add(output);
        output = subtract(output);
        return output;
    }

    public static String parenthesis(String input){
        String output = input;
        //String[] order = new String[input.length()];
        int x = 0;
        // findEndParenthesis(input.substring(i)) == input.length()-1
        for(int i=0;i<input.length();i++){
            if( input.charAt(i) == '(' ){
                if(i == 0 && findEndParenthesis(input.substring(i)) == input.length()-1){
                    output = simplify( input.substring(1,input.length()-1) ) ;
                }else if(i==0){
                    if( singleTerm( simplify(input.substring(i+1, findEndParenthesis(input.substring(i))  )) ) ){
                        output = simplify( simplify(input.substring(i+1, findEndParenthesis(input.substring(i))  )) + input.substring(findEndParenthesis(input.substring(i)) + 1) ) ;
                    }else{
                        output = '(' + simplify(input.substring(1, findEndParenthesis(input.substring(i)) -1 ) ) + ')' + simplify(input.substring(findEndParenthesis(input.substring(i)) + 1)) ;
                    }
                }else if( i!=0 && findEndParenthesis(input.substring(i)) == input.length()-1 ){
                    if( singleTerm( simplify(input.substring(i+1, findEndParenthesis(input.substring(i)) -1 )) )  ){
                        output = simplify( input.substring(0,i) +  simplify(input.substring(i+1, findEndParenthesis(input.substring(i)) -1 ) ) );
                    }else{
                        output = simplify( input.substring(0,i) ) + '(' + simplify(input.substring(i+1, findEndParenthesis(input.substring(i)) -1 )) + ')' ;
                    }
                }else{
                    if( singleTerm( simplify(input.substring(i+1, findEndParenthesis(input.substring(i)) -1 )) ) ){
                        output = simplify(input.substring(0,i) + simplify(input.substring(i+1,findEndParenthesis(input.substring(i))-1)) + input.substring(findEndParenthesis(input.substring(i))+1) );
                    }else{
                        output = simplify(input.substring(0,i)) + '(' + simplify(input.substring(i+1,findEndParenthesis(input.substring(i))-1)) + ')' + simplify( input.substring(findEndParenthesis(input.substring(i))+1) );
                    }
                }
            }
        }
        return output;
    }

    // exponent takes any expression and determines wether an exponent needs to be evaluated
    // If there is an exponent symbol in the expression it will simplify the terms and format the output according to where the subtraction symbol is located in the expression
    public static String exponent(String input){
        String output = input;
        for(int i = 0;i<input.length();i++){
            if( input.charAt(i) == '^'){
                if( isConstant( previousTerm(input.substring(0,i) ) ) && isConstant(nextTerm(input.substring(i+1) )) ){
                    String prevTerm = previousTerm(input.substring(0,i));
                    String nextTerm = nextTerm(input.substring(i+1));
                    int expresionLength = prevTerm.length() + nextTerm.length() + 1;
                    if( singleTerm(input) ){
                        output = exponent(prevTerm,nextTerm);
                    }else if( input.substring(0,expresionLength).equals(prevTerm+'^'+nextTerm) ){
                        output = exponent(prevTerm,nextTerm) + input.substring(expresionLength) ;
                    }else if( input.substring(input.length() - nextTerm.length()).equals(nextTerm) ){
                        output = input.substring(0,input.length()-expresionLength) + exponent(prevTerm,nextTerm) ;
                    }else{
                        output = input.substring (0, i -prevTerm.length()) + exponent(prevTerm,nextTerm) + input.substring(i+nextTerm.length()+1)  ;
                    }
                }
            }
        }
        return output;
    }

    // returns the string value of string x raised to string y power
    // x^y
    public static String exponent(String x, String y){
        return String.valueOf( (int)Math.pow(Integer.parseInt(x),Integer.parseInt(y) ) );
    }

    // combineTerms determines how to combine the left term with the right term by the operator
    // If the values are both constants then they get evaluted as just ints and then returned
    // If one of the values has an x then they get passed to their respective function to be evaluted and formated
    public static String combineTerms(String left, String right, char operator){
        String output ="";
        if( containX(left) || containX(right) ){
            if( operator == '-' ){
                output = subtract(left,right);
            }else if( operator == '+' ){
                output = add(left,right);
            }else if( operator == '/' ){
                output = divide(left,right);
            }else if( operator == '*' ){
                output = multiply(left,right);
            }
        }else{
            if( operator == '-' ){
                output = output = String.valueOf(Integer.parseInt(left) - Integer.parseInt(right) );
                //output = output = String.valueOf( Integer.parseInt(previousTerm(left)) - Integer.parseInt(nextTerm(right)) );
            }else if( operator == '+' ){
                output = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right) );
            }else if( operator == '/' ){
                output = String.valueOf(Integer.parseInt(left) / Integer.parseInt(right) );
            }else if( operator == '*' ){
                output = String.valueOf(Integer.parseInt(left) * Integer.parseInt(right) );
            }
        }
        return output;
    }

    // subtract takes any expression and determines wether subtraction needs to be evaluated
    // If there is an subtraction symbol in the expression it will simplify the terms and format the output according to where the subtraction symbol is located in the expression
    public static String subtract(String input){
        String output = input;
        for(int i=1;i<input.length();i++){
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i-1);
            if( currentChar == '-' ){
                // Checks if previous character isn't an operator because then '-' means subtract and not negative
                if( !isOperator(prevChar)  ){
                    String prevTerm =  previousTerm(input.substring(0,i));
                    String nextTerm = nextTerm(input.substring(i+1));
                    int expressionLength = prevTerm.length() + nextTerm.length() + 1;
                    if( prevTerm.length() + nextTerm.length() + 1 == input.length()){
                        output = combineTerms(prevTerm,nextTerm,'-');
                        break;
                    }else if( input.substring(0,prevTerm.length()).equals(prevTerm) ){
                        output = combineTerms(prevTerm,nextTerm,'-') + input.substring(expressionLength);
                        //output = simplify(combineTerms(prevTerm,nextTerm,'-') + input.substring(expressionLength));
                        break;
                    }else if ( input.substring(input.length() - nextTerm.length()).equals(nextTerm) ){
                        output = input.substring(0,input.length()-expressionLength) + combineTerms(prevTerm,nextTerm,'-') ;
                        break;
                    }else{
                        output = input.substring (0, i -prevTerm.length()) + combineTerms(prevTerm,nextTerm,'-') + input.substring(i+nextTerm.length()+1)  ;
                    }
                }
            }
        }

        return output;
    }

    // subtract takes the term on the left and right of the subtraction symbol and simplifies them depending on wether both terms or one term has an x value
    public static String subtract(String left, String right){
        String output = "";
        int constantLeft = getConstant(left);
        int constantRight = getConstant(right);
        int powerLeft = getPower(left);
        int powerRight = getPower(right);
        if( containX(left) && containX(right) && powerLeft == powerRight ){
            if(constantLeft - constantRight == 0){
                output = "0";
            }else if(constantLeft - constantRight == 1){
                if(powerLeft == 1){
                    output = "x";
                }else{
                    output = "x^" + powerLeft;
                }
            }else{
                if(powerLeft == 1){
                    output = String.valueOf(constantLeft-constantRight) + "x";
                }else{
                    output = String.valueOf(constantLeft-constantRight) + "x^" + powerLeft;
                }
            }
        }else{
            output = left + '-' + right;
        }
        return output;
    }

    // add takes any expression and determines wether addition needs to be evaluated
    // If there is an addition symbol in the expression it will simplify the terms and format the output according to where the addition symbol is located in the expression
    public static String add(String input){
        String output = input;
        for(int i=1;i<input.length();i++){
            char currentChar = input.charAt(i);
            // Checks if previous character isn't an operator because then '-' means subtract and not negative
            if( currentChar == '+'  ){
                String prevTerm =  previousTerm(input.substring(0,i));
                String nextTerm = nextTerm(input.substring(i+1));
                int expressionLength = prevTerm.length() + nextTerm.length() + 1;
                if( prevTerm.length() + nextTerm.length() + 1 == input.length()){
                    output = combineTerms(prevTerm,nextTerm,'+');
                }else if( input.substring(0,prevTerm.length()).equals(prevTerm) ){
                    output = combineTerms(prevTerm,nextTerm,'+') + input.substring(expressionLength) ;
                    //output = simplify(combineTerms(prevTerm,nextTerm,'+') + input.substring(expressionLength)) ;
                }else if ( input.substring(input.length() - nextTerm.length()).equals(nextTerm) ){
                    output = input.substring(0,input.length()-expressionLength) + combineTerms(prevTerm,nextTerm,'+') ;
                }else{
                    output = input.substring (0, i -prevTerm.length()) + combineTerms(prevTerm,nextTerm,'+') + input.substring(i+nextTerm.length()+1)  ;
                }
            }
        }
        return output;
    }

    // add takes the term on the left and right of the addition symbol and simplifies them depending on wether both terms or one term has an x value
    public static String add(String left, String right){
        String output = "";
        int constantLeft = getConstant(left);
        int constantRight = getConstant(right);
        int powerLeft = getPower(left);
        int powerRight = getPower(right);
        if( containX(left) && containX(right) && powerLeft == powerRight ){
            if(constantLeft + constantRight == 0){
                output = "0";
            }else if(constantLeft + constantRight == 1){
                if(powerLeft == 1){
                    output = "x";
                }else{
                    output = "x^" + powerLeft;
                }
            }else{
                if(powerLeft == 1){
                    output = String.valueOf(constantLeft+constantRight) + "x";
                }else{
                    output = String.valueOf(constantLeft+constantRight) + "x^" + powerLeft;
                }
            }
        }else{
            output = left + '+' + right;
        }
        return output;
    }

    // divide takes any expression and determines wether division needs to be evaluated
    // If there is an division symbol in the expression it will simplify the terms and format the output according to where the division symbol is located in the expression
    public static String divide(String input){
        String output = input;

        for(int i=1;i<input.length();i++){
            char currentChar = input.charAt(i);
            // Checks if previous character isn't an operator because then '-' means subtract and not negative
            if( currentChar == '/'  ){
                String prevTerm =  previousTerm(input.substring(0,i));
                String nextTerm = nextTerm(input.substring(i+1));
                int expressionLength = prevTerm.length() + nextTerm.length() + 1;
                if( prevTerm.length() + nextTerm.length() + 1 == input.length()){
                    output = combineTerms(prevTerm,nextTerm,'/');
                }else if( input.substring(0,prevTerm.length()).equals(prevTerm) ){
                    output = combineTerms(prevTerm,nextTerm,'/') + input.substring(expressionLength) ;
                    //output = simplify(combineTerms(prevTerm,nextTerm,'+') + input.substring(expressionLength)) ;
                }else if ( input.substring(input.length() - nextTerm.length()).equals(nextTerm) ){
                    output = input.substring(0,input.length()-expressionLength) + combineTerms(prevTerm,nextTerm,'/') ;
                }else{
                    output = input.substring (0, i -prevTerm.length()) + combineTerms(prevTerm,nextTerm,'/') + input.substring(i+nextTerm.length()+1)  ;
                }
            }
        }

        return output;
    }

    // divide takes the term on the left and right of the division symbol and simplifies them depending on wether both terms or one term has an x value
    public static String divide(String left, String right){
        String output = "";
        int constantLeft = getConstant(left);
        int constantRight = getConstant(right);
        int powerLeft = getPower(left);
        int powerRight = getPower(right);
        if( containX(left) && containX(right) && powerLeft == powerRight ){
            if( powerLeft-powerRight == 0){
                output = String.valueOf(constantLeft/constantRight) ;
            }else if (powerLeft-powerRight == 1){
                output = String.valueOf(constantLeft/constantRight) + "x";
            }else{
                output = String.valueOf(constantLeft/constantRight) + "x^" + String.valueOf(powerLeft - powerRight) ;
            }
        }else if( containX(left) ){
            if( powerLeft == 1 ){
                output = String.valueOf(constantLeft/constantRight) + "x" ;
            }else{
                output = String.valueOf(constantLeft/constantRight) + "x^" + String.valueOf(powerLeft) ;
            }
        }else{
            if( powerRight == 1 ){
                output = String.valueOf(constantLeft/constantRight) + "x" ;
            }else{
                output = String.valueOf(constantLeft/constantRight) + "x^" + String.valueOf(powerRight) ;
            }
        }
        return output;
    }

    // multiply takes any expression and determines wether multiplication needs to be evaluated
    // If there is an multiplication symbol in the expression it will simplify the terms and format the output according to where the multiplication symbol is located in the expression
    public static String multiply(String input){
        String output = input;

        for(int i=1;i<input.length();i++){
            char currentChar = input.charAt(i);
            // Checks if previous character isn't an operator because then '-' means subtract and not negative
            if( currentChar == '*'  ){
                String prevTerm =  previousTerm(input.substring(0,i));
                String nextTerm = nextTerm(input.substring(i+1));
                int expressionLength = prevTerm.length() + nextTerm.length() + 1;
                if( prevTerm.length() + nextTerm.length() + 1 == input.length()){
                    output = combineTerms(prevTerm,nextTerm,'*');
                }else if( input.substring(0,prevTerm.length()).equals(prevTerm) ){
                    output = combineTerms(prevTerm,nextTerm,'*') + input.substring(expressionLength) ;
                    //output = simplify(combineTerms(prevTerm,nextTerm,'+') + input.substring(expressionLength)) ;
                }else if ( input.substring(input.length() - nextTerm.length()).equals(nextTerm) ){
                    output = input.substring(0,input.length()-expressionLength) + combineTerms(prevTerm,nextTerm,'*') ;
                }else{
                    output = input.substring (0, i -prevTerm.length()) + combineTerms(prevTerm,nextTerm,'*') + input.substring(i+nextTerm.length()+1)  ;
                }
            }
        }

        return output;
    }

    // multiply takes the term on the left and right of the multiplication symbol and simplifies them depending on wether both terms or one term has an x value;
    public static String multiply(String left, String right){
        String output = "";
        int constantLeft = getConstant(left);
        int constantRight = getConstant(right);
        int powerLeft = getPower(left);
        int powerRight = getPower(right);
        if( containX(left) && containX(right) && powerLeft == powerRight ){
            if( powerLeft+powerRight == 0){
                output = String.valueOf(constantLeft*constantRight);
            }else if(powerLeft+powerRight == 1){
                output = String.valueOf(constantLeft*constantRight) + "x" ;
            }else{
                output = String.valueOf(constantLeft*constantRight) + "x^" + String.valueOf(powerLeft+powerRight) ;
            }
        }else if( containX(left) ){
            if( powerLeft == 1){
                output = String.valueOf(constantLeft*constantRight) + "x";
            }else{
                output = String.valueOf(constantLeft*constantRight) + "x^" + String.valueOf(powerLeft) ;
            }
        }else{
            if( powerRight == 1){
                output = String.valueOf(constantLeft*constantRight) + "x";
            }else{
                output = String.valueOf(constantLeft*constantRight) + "x^" + String.valueOf(powerRight) ;
            }
        }
        return output;
    }

    // checks wether a term contains 'x'
    // EXAMPLE:
    // input: 2x^3
    // output: true
    // input: 2
    // output: false
    public static boolean containX(String input){
        for(int i = 0 ; i<input.length(); i++){
            if( input.charAt(i) == 'x'){
                return true;
            }
        }
        return false;
    }

    //returns the value in front of the 'x' character
    // EXAMPLE:
    // input: 23x^4
    // output: 23
    public static int getConstant(String input){
        for(int i =0; i<input.length(); i++){
            if( !isConstant(input.charAt(i)) ){
                if( input.charAt(0) == 'x' ){
                    return 1;
                }else{
                    return Integer.parseInt( input.substring(0,i) );
                }
            }
        }
        return Integer.parseInt( input );
    }

    // if c is a value [0-9] returns true
    public static boolean isConstant(char c){
        String temp = c+"";
        if( temp.matches("/|0|1|2|3|4|5|6|7|8|9|/") ){
            return true;
        }
        return false;
    }

    public static boolean isConstant(String input){
        for(int i =0;i<input.length();i++){
            if( !isConstant(input.charAt(i)) ){
                return false;
            }
        }
        return true;
    }

    //returns the value after the '^' character
    // EXAMPLE:
    // input: 23x^4
    // output: 4
    public static int getPower(String input){
        for(int i=exponentIndex(input)+1; i<input.length(); i++){
            if( exponentIndex(input) == -1){
                return 1;
            }
            else if( !isConstant(input.charAt(i)) ){
                return Integer.parseInt( input.substring(exponentIndex(input)+1,i) );
            }
        }
        return Integer.parseInt( input.substring(exponentIndex(input)+1) );
    }

    //returns the index value of '^' character
    public static int exponentIndex(String input){
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '^'){
                return i;
            }
        }
        return -1;
    }

    // returns the index value of the matching ending parenthesis
    public static int findEndParenthesis(String input){
        int count = 0;
        int dex = 0;
        for(int i=0; i<input.length(); i++){
            if( input.charAt(i) == '(' ){
                count+=1;
            }else if( input .charAt(i) == ')' ){
                count -=1;
                if(count == 0){
                    return i;
                }
            }
        }
        return dex;
    }

    // returns true if an expression only has one term in it
    // Example:
    // input: 3x^6
    // output: true
    // input: 2x+1
    // output: false
    public static boolean singleTerm(String input){
        int count = 0;
        for(int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            if( c == '('){
                count+=1;
            }else if(c == ')'){
                count-=1;
                if(count == 0 && i+1==input.length()){
                    return true;
                }
            }else if(count == 0){
                if( !isConstant(c) ){
                    if( c == '+' || c == '*' || c == '/' || (i!=0 && c=='-') ){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Checks if the input character is an operator
    public static boolean isOperator(char c){
        if( c=='-' || c=='+' || c=='/' || c=='*' || c=='(' || c== '^' || c == ')'  ){
            return true;
        }
        return false;
    }

    // returns the next term in an expression
    public static String nextTerm(String input){
        if(input.length() == 1){
            return input;
        }
        int i;
        for(i=0; i<input.length();i++){
            if(isOperator(input.charAt(i)) && input.charAt(i) != '^'){
                return input.substring(0,i);
            }
        }
        return input.substring(0,i);
    }

    // return previous term in an expression
    public static String previousTerm(String input){
        String temp = input;
        if(input.length() == 1){
            return input;
        }
        int i;
        for(i=input.length()-1;i>=0;i--){
            if( isOperator(input.charAt(i)) && input.charAt(i) != '^' ){
                temp = input.substring(i+1);
            }
        }
        if(temp.equals(input)){
            return input.substring(i+1);
        }
        return temp;
    }

//    public static String getSimple(){
//        return simple;
//    }
}
