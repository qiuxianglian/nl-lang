 fn = ()=>{
  i = 0;
  while (i <= 100) {
    if(i>30){
        return i;
    }
    i = i + 1;
  }
  return i;
 };

 println(fn());