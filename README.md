# nl 语言

一个支持**部分求值**的编程语言，语法基本兼容JavaScript，可以编译出可以在其他平台
直接运行的二进制版本。

目前只写了解释器，纯java写的，只做了对象缓存优化，其他内联优化还没做，所以执行速度比较慢。

不过要优化速度最简单的办法就是写一个编译器（当然解释器优化空间还是大大的有）

经过我测试，执行[fib(30)](nl/tests/fib.nl)在我电脑上需要25s左右,作为对比：

代码见见[tests](nl/tests). fib开头.

- [nodejs](nl/tests/fib.js) : 19ms
- [c++(不优化)](nl/tests/fib.c): 17ms
- [c++(-O3优化选项)](nl/tests/fib.c): 5ms
- [java](nl/tests/fib.java): 5ms
- [python](nl/tests/fib.py): 274ms
- [sampleLanguage native(java基于graal-truffle写的)](nl/tests/fib.sl)：90ms
- [sampleLanguage jar版本(java基于graal-truffle写的)](nl/tests/fib.sl)：1s

这样看，参考【sampleLanguage jar版本】，解释器优化空间还有20倍。

如果做编译器，可以编译到nodejs，毕竟nodejs的速度已经和不优化的c++相当了。同时对nodejs的编译也是最简单的，
基本toString即可。

当然也可以编译到java，不过恐怕最后速度也和nodejs相差不多。

用graal-truffle重写也是一个好的选择，轻松超越了python。

最后，python真的是差劲呀，现在java，c，c++，JavaScript执行速度都差不多了，只有python落后一个梯队。

代码如下

```javascript
fib = (n) => {
    if(n <= 1) {
         return 1;
    }else{
        return  fib(n-1) + fib(n-2);
    }
};
// java预热
fib(20);
// 正式开始
start = now();
println(fib(30));
println('cost',now()-start);
```



目前支持的特性：

- 部分求值（待完善，接下来重点开发）
- 类型：null/bool/number/string/array/object/未定义类型
- 函数：匿名函数lambda和命名函数
- 语句和表达式：赋值，while循环，if，作用域， +-*/四则运算，字符串+操作
- 内置函数只支持了print和now当前时间
- 定义变量可以混合中文输入法，比如=>可以写成＝》，支持中文变量

# 例子

lambda和计算器例子　见[tests](nl/tests).

命令行执行`./native/target/nlnative tests/number1`

## while循环和if

```javascript
i = 0;
start = now();
while(true){
    if(i>1000000){
        println("cost ",(now()-start));
        break;
    }

    i=i+1;
}
```

## array和object
```javascript
p=122;

a={
   a:12,b:13,c:{
      o:p,key:"haha"
   }
};

println(a);

a.c.key="hehe";
println(a);
```


## Lambda 

```javascript
(id1=>(id2=>(id3=>id3)(2))(3))(4)
// 结果　2
((f=>f()))(a=>1)
// 结果　1
((f=>f()))(a=>p)
// 结果　未定义变量：p
(f=>f(f))(f=>f)
// 结果　f=>f
(f=>f(f))(f=>f(f))
// 结果　Resource exhausted: Stack overflow
(你好=>你好)(1)
// 结果 1

// y组合算子
(fn => (u => u(u))(x => fn((args) => x(x)(args))))(a=>a)
// 结果 args=>((x)(x))(args) 
```

## 语句和赋值

```javascript
g=21;// 赋值
a= f=>f+g;
a(100);
```

## 部分求值

```javascript
g=x;
k=f=>g+1;
k(1)
// 输出x+1
```



## 四则运算
```javascript
(2*1+2+7.5)*3/1.2*22-99
//结果　533.5
```
# 编译

依赖`graal-jdk-21+`,**mvn**命令。

## 编译java版本

java版本启动较慢，但是可以作为其他java应用依赖。

```shell
mvn package
```

使用

```shell
./native/target/nl [file]
```

## 编译native版本

native版本启动速度快，占用内存非常小。


```shell
mvn package　-Pnative
```

使用

```shell
./native/target/nlnative [file]
```

# 技术

- parser使用antlr4
- 解释器自己写的
- 编译器还没写
- 到java代码的编译和native，graal自动生成的


