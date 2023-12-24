fib = (n) => {
    if(n <= 1) {
         return 1;
    }else{
        return  fib(n-1) + fib(n-2);
    }
};
start = now();
println(fib(20));
println('cost',now()-start);