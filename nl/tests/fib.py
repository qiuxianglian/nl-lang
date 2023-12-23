def fib(n):
    if n <= 1 :
         return 1
    else:
        return  fib(n-1) + fib(n-2)
import time

start = time.time() * 1000
print(fib(25))
print('cost',time.time() * 1000-start)