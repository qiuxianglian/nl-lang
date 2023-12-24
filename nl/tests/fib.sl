function fib(n){
    if(n <= 1) {
         return 1;
    }else{
        return  fib(n-1) + fib(n-2);
    }
}

function main(){

    fib(30);
    start = now();
    println(fib(30));
    println("cost "+ (now()-start));
}
