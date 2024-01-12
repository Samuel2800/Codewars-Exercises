public class doubleCola {
//remmover siempre del indice 1

    public static void main(String[] args){
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Raj", "Howard"};
        System.out.println(WhoIsNext(names, 723070295));
    }

    public static String WhoIsNext(String[] names, int n){
        n--;
        while( n >= names.length){
            n = (int)Math.floor((n - names.length) / 2);
        }
        return names[n];
    }
}
