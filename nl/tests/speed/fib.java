public class fib{
    public static long fib(long n){
        if(n <= 1) {
            return 1;
        }else{
            return  fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args) {
        fib(30);
        long start = System.currentTimeMillis();
        System.out.println(fib(30));
        System.out.println("cost "+ (System.currentTimeMillis()-start));
    }


}
