i = 0;
start = new Date().getTime();
while(true){
    if(i>1000000){
        console.log("cost ",(new Date().getTime()-start));
        break;
    }

    i=i+1;
}