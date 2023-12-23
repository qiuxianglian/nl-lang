#include <stdio.h>
#include <time.h>
#include <sys/time.h>

long long current_timestamp() {
    struct timeval te;
    gettimeofday(&te, NULL); // get current time
    long long milliseconds = te.tv_sec*1000LL + te.tv_usec/1000; // calculate milliseconds
    // printf("milliseconds: %lld\n", milliseconds);
    return milliseconds;
}

    long fib(long n){
        if(n <= 1) {
            return 1;
        }else{
            return  fib(n-1) + fib(n-2);
        }
    }

    void main() {
        fib(30);
        long long start = current_timestamp();
        printf("Timestamp: %llu\n",current_timestamp());
        printf("%lu\n",fib(30));
        printf("cost %llu",current_timestamp()-start);
//        System.out.println("cost "+ (System.currentTimeMillis()-start));
    }


