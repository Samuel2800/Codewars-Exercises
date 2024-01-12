import java.util.*;

public class pickPeack {
    public static void main(String[] args){

    }

    public static Map<String, List<Integer>> getPeaks(int[] arr){
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>(){{
            put("pos", new ArrayList<Integer>());
            put("peaks", new ArrayList<Integer>());
        }};
        int peakIndex = 0;
        boolean temp = false;
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] < arr[i]){
                temp = true;
                peakIndex = i;
            }
            if(temp && arr[i-1] > arr[i]){
                temp = false;
                result.get("pos").add(peakIndex);
                result.get("peaks").add(arr[peakIndex]);
            }
        }
        return result;
    }
}
