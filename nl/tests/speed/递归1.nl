fib = (n) => {
    if(n <= 1) {
        return 0.1;
    }else{
        return fib(n-1)+fib(n-1);
    }
};

fib(3);