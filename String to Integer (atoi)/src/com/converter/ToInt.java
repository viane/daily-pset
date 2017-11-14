package com.converter;

public class ToInt {
    private String input;
    private String sign = "+-";
    private String allowableInt = "1234567890";
    private int returnInt = 0;
    public ToInt(String input){
        // remove head/tail white space
        this.input = input.trim();
    }

    public int strToInt(){
        if(this.input.length()==0){
            return 0;
        }
        // first char check, return 0 if is neither '-','+','1-0'
        // System.out.println(this.input);
        char firstChar = input.charAt(0);
        if (firstChar != sign.charAt(0) && firstChar != sign.charAt(1) &&  !allowableInt.contains(Character.toString(firstChar)))         {
            return 0;
        }else{
            if((firstChar == sign.charAt(0) || firstChar == sign.charAt(1)) && input.length()==1){
                return 0;
            }else if (firstChar == sign.charAt(0) || firstChar == sign.charAt(1)){// if 1st char is sign
                if (!allowableInt.contains(Character.toString(input.charAt(1)))){ //if 2nd char is not a number
                    return 0;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Character.toString(firstChar)); // init return with the sign
                for (int i = 1; i<input.length();i++){ // form 2nd char to end
                    if(allowableInt.contains(Character.toString(input.charAt(i)))){ // current char is numerical
                        stringBuilder.append(Character.toString(input.charAt(i)));
                    }else{
                        break;
                    }
                }
                try{
                    returnInt = Integer.parseInt(stringBuilder.toString());
                    return returnInt;
                }catch(NumberFormatException ex){
                    // ex.printStackTrace();
                    if(firstChar=='-'){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }

            }else{
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i<input.length();i++){ // form 2nd char to end
                    if(allowableInt.contains(Character.toString(input.charAt(i)))){ // current char is numerical
                        stringBuilder.append(Character.toString(input.charAt(i)));
                    }else{
                        break;
                    }
                }
                try{
                    returnInt = Integer.parseInt(stringBuilder.toString());
                    return returnInt;
                }catch(NumberFormatException ex){
                    // ex.printStackTrace();
                    if(firstChar=='-'){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
    }
}
