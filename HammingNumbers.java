public class HammingNumbers {

    //utiliza programación dinámica
    public static void main(String[] args){
        System.out.println(hamming(3));
    }

    public static long hamming(int n){
        int[] exps = {0, 0, 0};

        exps[0] = (int)Math.floor(n/2);
        exps[1] = (int)Math.floor(n/3);
        exps[2] = (int)Math.floor(n/5);
        
        return (long)(Math.pow(2, exps[0]) * Math.pow(3, exps[1]) * Math.pow(5, exps[2]));
    }
}
