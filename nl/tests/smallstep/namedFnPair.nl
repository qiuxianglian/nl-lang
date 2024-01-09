p = (x)=>x;
fib=(n)=>{
    if(n<=1){
        return 1;
    }else{
        return fib(n-1) + p(n);
    }
};



fib(2);