import java.util.*;

public class josephus {
    
    public static void main(String[] args){

    }

    public static <T>List<T> josephusPermutation(final List<T> items, final int k){
        List<T> result = new ArrayList<T>();
        List<Integer> count = new ArrayList<Integer>(items.size());
        for(int i = 0; i < items.size(); i++){
            count.add(i);
        }
        int index  = 0;
        while(items.size() > 0){
            index = (index + k - 1) % count.size();
            result.add(items.get(count.get(index)));
            count.remove(index);
        }
        return result;
    }
}
