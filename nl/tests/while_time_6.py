import time


i = 0
start = time.time()*1000
while True:
    if i>1000000:
        print("cost",time.time()*1000 -start)
        break
    i=i+1
