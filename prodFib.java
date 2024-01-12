public class prodFib {
    public static void main(String[] argrs){

    }

    public static long[] productFib(long prod){
        long n = 0;
        long m = 1;
        while(n*m < prod){
            m = n + m;
            n = m - n;
        }
        return new long[]{n, m, ((n*m == prod) ? 1 : 0)};
    }
}
