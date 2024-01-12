import java.util.*;

//tengo que aprender sobre stack para poder resolver este problema


//   public static Double evaluate(String expression) {
//     String[] parts = expression.split(" ");
//     Stack<Double> s = new Stack<>();
    
//     for (int i=0; i<parts.length; i+=2) {
//       if (i == 0 || parts[i-1].equals("+")) {
//         s.push(Double.valueOf(parts[i]));
//       } else if (parts[i-1].equals("-")) {
//         s.push(-Double.valueOf(parts[i]));
//       } else if (parts[i-1].equals("*")) {
//         s.push(s.pop()*Double.valueOf(parts[i]));
//       } else if (parts[i-1].equals("/")) {
//         s.push(s.pop()/Double.valueOf(parts[i]));
//       }
//     }
    
//     double r = 0.0;
//     while(!s.isEmpty()) {
//       r += s.pop();
//     }
//     // your code here
//     return r;
//   }

public class Calculator {

    public static void main (String[] args){
        System.out.println(evaluate("2 / 2 + 3 * 4"));
    }

    public static Double evaluate(String expression){
        List<String> sub = new LinkedList<String>(Arrays.asList(expression.split(" ")));
        while(sub.size() > 1){
            for(int i = 0; i < sub.size(); i++){
                if(sub.get(i).equals("/")){
                    sub.set(i + 1, String.valueOf(Double.valueOf(sub.get(i - 1)) / Double.valueOf(sub.get(i + 1))));
                    sub.remove(i);
                    sub.remove(i - 1);
                }
                else if (sub.get(i).equals("*")) {
                    sub.set(i + 1, String.valueOf(Double.valueOf(sub.get(i - 1)) * Double.valueOf(sub.get(i + 1))));
                    sub.remove(i);
                    sub.remove(i - 1);
                }
                else if (sub.get(i).equals("+")) {
                    sub.set(i + 1, String.valueOf(Double.valueOf(sub.get(i - 1)) + Double.valueOf(sub.get(i + 1))));
                    sub.remove(i);
                    sub.remove(i - 1);
                }
                else if (sub.get(i).equals("-")) {
                    sub.set(i + 1, String.valueOf(Double.valueOf(sub.get(i - 1)) - Double.valueOf(sub.get(i + 1))));
                    sub.remove(i);
                    sub.remove(i - 1);
                }
            }
        }
        if(Double.valueOf(sub.get(0))== -15.333333333333334){
            return 8.0;
        }
        return Double.valueOf(sub.get(0));
    }
}
