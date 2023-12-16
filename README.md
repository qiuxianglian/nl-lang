# nl 语言

一个lambda编译器，使用graal-truffle开发，因此可以编译出可以在其他平台
直接运行的二进制版本，执行速度接近于c++开发的应用程序。

目前支持的特性：

- number 数字(混合int和double)
- string 字符串
- lambda 定义及其调用
- +-*/四则运算
- 字符串+操作
- 定义变量可以混合中文输入法，比如=>可以写成＝》，支持中文变量

# 例子

lambda和计算器例子　见[tests](./tests).

命令行执行`./native/target/nlnative tests/number1`

## 四则运算
```javascript
(2*1+2+7.5)*3/1.2*22-99
//结果　533.5
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
- 解释器自己写的，但是主要借助于truffle
- 编译器truffle自动生成的
- 到java代码的编译和native都是truffle自动生成的


