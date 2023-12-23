println = console.log;
fib = (n) => {
    if(n <= 1) {
         return 1;
    }else{
        return  fib(n-1) + fib(n-2);
    }
};

start = new Date().getTime();
console.log(fib(25));
console.log((new Date().getTime())-start);