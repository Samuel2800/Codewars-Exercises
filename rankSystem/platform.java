public class platform {
    public static void main(String[] args){
        User Male = new User();
        Male.incProgress(1);
        System.out.println(Male.rank());
        System.out.println(Male.progress());
        Male.incProgress(5);
        System.out.println(Male.rank());
        System.out.println(Male.progress());
    }
}
