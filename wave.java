public class wave {
    public static void main(String[] args){
        for(String s : waves("two Words")){
            System.out.println(s);
        }
    }

    public static String[] waves(String str){
        str = str.toLowerCase();
        String[] result = new String[str.replaceAll(" ", "").length()];
        int j = 0;
        for(int i = 0; i < str.length(); i++){
            StringBuilder word = new StringBuilder(str);
            while(!Character.isLetter(str.charAt(i))){
                if ((i + 1) >= str.length())
                    return result;
                i++;
            }
            word.setCharAt(i, Character.toUpperCase(str.charAt(i)));
            result[j] = word.toString();
            j++;
        }
        return result;
    }
}
