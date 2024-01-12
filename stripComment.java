public class stripComment {
    public static void main(String[] args){
        System.out.println(stripComments("apples, pears  # and bananas\ngrapes\nbananas !apples", new String[] { "#", "$" }));
    }

    public static String stripComments(String text, String[] commentSymbols){
        String[] parts = text.split("\n");
        for(String s : commentSymbols){
            for(int i = 0; i < parts.length; i++){
                int index = parts[i].indexOf(s.charAt(0));
                if(index != -1){
                    parts[i] = parts[i].substring(0, index).strip();
                }
                if(!parts[i].contains("[")){
                    parts[i] = parts[i].stripTrailing();
                }
            }
        }
        return String.join("\n", parts).strip();
    }
}
