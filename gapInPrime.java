public class gapInPrime {
    public static void main(String[] args){
        long[] result = gap(8, 300, 400);
        try{
            for(int i = 0; i < result.length; i++){
                System.out.println(result[i]);
            }
        }
        catch(Exception e){
            System.out.println(result);
        }
        System.out.println(isPrime(361));
    }

    public static boolean isPrime(long n){
        if(n <= 1){
            return false;
        }
        for(long i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static long[] gap(int g, long m, long n){
        long primeA = 0;
        long primeB = 0;
        for(long i = m; i <= n; i++){
            boolean temp = false;
            if(isPrime(i)){
                for(long j = i + 1; j < i + g; j++){
                    if(isPrime(j)){
                        temp = true;
                    }
                }
            }
            if(temp){
                continue;
            }
            if(isPrime(i) && i + g <= n && isPrime(i + g)){
                primeA = i;
                primeB = i + g;
                break;
            }
        }
        if(!isPrime(primeA) || !isPrime(primeB)){
            return null;
        }
        return new long[]{primeA, primeB};
    }
}