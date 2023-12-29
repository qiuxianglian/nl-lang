println = console.log;
fib = (n) => {
    if(n <= 1) {
         return 1;
    }else{
        return  fib(n-1) + fib(n-2);
    }
};
fib(30);
start = new Date().getTime();
console.log(fib(30));
console.log((new Date().getTime())-start);