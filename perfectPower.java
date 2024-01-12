public class perfectPower {
    public static void main(String[] args){
        int[] n = isPerfectPower(26);
        try{
            for(int num : n){
                System.out.println(num);
            }
        }
        catch(Exception e){
            System.out.println(n);
        }
    }

    public static int[] isPerfectPower(int n) {
        for(int i = 2; i <= ((n < 30) ? n : 30) && i < 30; i++) {
            double result = (double)Math.round(Math.pow(n, (double)1/i) * Math.pow(10, 10)) /  Math.pow(10, 10);
            if((result == Math.floor(result))) return new int[] {(int)result, i};
        }
        return null;
      }
}
