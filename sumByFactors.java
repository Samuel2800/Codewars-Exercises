
import java.util.*;
//este codigo me funciona en el editor pero al momento de subirlo, me muestra resultados diferentes
public class sumByFactors {
    public static void main(String[] args){
        int[] asdf = new int[]{ 17, -17, 51, -51};
        sumOfDivided(asdf);
    }

    private static ArrayList<Integer> list = new ArrayList<Integer>();
    
    public static String sumOfDivided(int[] l){
        String result = "";
        for(int num : l){
            while(num % 2 == 0){
                if(!list.contains(2)){
                    list.add(2);
                }
                num /= 2;
            }
            for(int i = 3; i <= Math.abs(num); i += 2){
                while(num % i == 0){
                    if(!list.contains(i)){
                        list.add(i);
                    }
                    num /= i;
                }
            }
        }
        Collections.sort(list);
        for(int number : list){
            int sum = 0;
            for(int numero : l){
                if(numero % number == 0){
                    sum += numero;
                }
            }
            result += ("(" + number + " " + sum + ")");

        }
        return result;
    }
}
