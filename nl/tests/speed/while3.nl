add=(a, b)=> a + b;

loop=(n)=>{
  i = 0;
  while (i < n) {  
    i = add(i, 1);
  }
  i
};
i = 0;
while (i < 20) {
    loop(1000);
    i = i + 1;
}
println(loop(1000));

