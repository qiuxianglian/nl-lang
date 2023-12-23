i = 0;
start = now();
while(true){
    if(i>1000000){
        println("cost ",(now()-start));
        break;
    }

    i=i+1;
}