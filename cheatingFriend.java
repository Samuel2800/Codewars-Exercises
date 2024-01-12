import java.util.*;

public class cheatingFriend {
    
    public static void main(String[] args){
        for(long[] list : removNb(26)){
            System.out.println("[");
            for(long numb : list){
                System.out.println(numb);
            }
            System.out.println("]");
        }
    }

    public static List<long[]> removNb(long n){
        List<long[]> list = new ArrayList<long[]>();
        long sumatory = n * (n + 1) / 2;
        for(long a = 1; a <= n; a++){
            long b = (sumatory - a) / (a + 1);
            if(b < n && a*b == sumatory - a - b){
                list.add(new long[]{a,b});
            }
        }
        return list;
    }
}
