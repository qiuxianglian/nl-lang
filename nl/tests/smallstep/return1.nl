 fn = ()=>{
  i = 0;
  res = 0;
  while (i <= 100) {
    res = res + i;
    if(res>1000){
       return res;
    }
    i = i + 1;
  }
  return res;
 };

 fn();