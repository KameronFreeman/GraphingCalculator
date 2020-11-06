package com.calculatorapp;

public class calcOperation {


    public calcOperation(){
    }

    public static String derv(String input){
        int coefficent;
        int power;
        String output = "";

        if(input.charAt(0) == '-'){
            int i=1;
            while(constant(input.charAt(i))){
                i+=1;
            }
            if(constant(input.charAt(1))){
                String c = input.substring(1,i);
                coefficent = Integer.parseInt(c);
                power = Integer.parseInt(input.substring(i+2));
                int z = coefficent*power;
                if((power-1)==0){
                    output = input.charAt(0) + String.valueOf(z);
                }else{
                    output = input.charAt(0) + String.valueOf(z) + input.charAt(i) +input.charAt(i+1)+ String.valueOf(power-1);
                }
            }else{
                coefficent = 1;
                power = Integer.parseInt(input.substring(i+2));
                int z = coefficent*power;
                if((power-1)==0){
                    output = input.charAt(0) + String.valueOf(z);
                }else{
                    output = input.charAt(0) + String.valueOf(z) + input.charAt(i) + input.charAt(i+1)+String.valueOf(power-1);
                }
            }
        }else{
            int i=0;
            while(constant(input.charAt(i))){
                i+=1;
            }
            if(constant(input.charAt(0))){
                String c = input.substring(0,i);
                coefficent = Integer.parseInt(c);
                power = Integer.parseInt(input.substring(i+2));
                int z = coefficent*power;
                if((power-1)==0){
                    output = String.valueOf(z);
                }else{
                    output = String.valueOf(z) + input.charAt(i) +input.charAt(i+1)+ String.valueOf(power-1);
                }
            }else{
                coefficent = 1;
                power = Integer.parseInt(input.substring(i+2));
                int z = coefficent*power;
                if((power-1) == 0){
                    output = String.valueOf(z);
                }else{
                    output = String.valueOf(z) + input.charAt(i) + input.charAt(i+1)+String.valueOf(power-1);
                }
            }
        }
        return output;
    }


    // constant checks if char c is a numeric value between 0-9
    public static boolean constant(char c){
        if(Character.getNumericValue(c) <= 9 ){
            return true;
        }
        return false;
    }

}
