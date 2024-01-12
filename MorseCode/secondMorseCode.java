package MorseCode;

import java.util.*;

public class secondMorseCode {

    public static void main(String[] args){
        String message = decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011");
        System.out.println(firstMorseCode.decode(message));
    }
    public static String decodeBits(String bits){
        ArrayList<String> list = new ArrayList<String>();
        String result = "";
        int bit = -1;
        int count = 0;
        for(int j = 0; j < bits.length(); j++){
            if(Character.getNumericValue(bits.charAt(j)) == 1){
                bits = bits.substring(j) + "0";
                break;
            }
        }
        for(int i  = 0; i < bits.length(); i++){
            if(bit == -1){
                bit = Character.getNumericValue(bits.charAt(i));
            }
            if(bit != Character.getNumericValue(bits.charAt(i))){
                list.add(bits.substring(count, i));
                bit = Character.getNumericValue(bits.charAt(i));
                count = i;
            }
        }
        double rate = Double.POSITIVE_INFINITY;
        for(String s : list){
            if(s.length() < rate){
                rate = s.length();
            }
        }
        for(String s : list){
            if(s.charAt(0) == '1'){
                if(s.length() >= rate && s.length() < (3 * rate)){
                    result += ".";
                }
                else if(s.length() >= (3 * rate)){
                    result += "-";
                }
            }
            else{
                if (s.length() >= (3 * rate) && s.length() < (7 * rate)) {
                    result += " ";
                } else if (s.length() >= (7 * rate)) {
                    result += "   ";
                }
            }
        }
        System.out.println(list);
        return result;
    }
}
