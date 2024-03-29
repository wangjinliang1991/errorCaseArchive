# errorCaseArchive
日常错误用例

## numbers

### 问题1
org.example.double01.DoubleTest.testDouble01 为何 `0.1+0.2 != 0.3`

计算机是以二进制存储数值的，参考 https://www.zhihu.com/question/21711083

实际 0.1 的二进制表示为 0.0 0011 0011 0011… （0011 无限循环)

因此，0.1 无法精确表达

那如何处理？BigDecimal类型

### 问题2

org.example.double01.DoubleTest.testBigDecimal01 使用了BigDecimal还不行？

BigDecimal 表示和计算浮点数，且务必使用字符串的构造方法来初始化 BigDecimal

参见 org.example.double01.DoubleTest.testBigDecimal02

### 问题3

假设是Double类型，能否用toString然后做BigDecimal处理？

`new BigDecimal(Double.toString(4.015)).multiply(new BigDecimal(Double.toString(100)))`得到结果是`401.5000`

跟我们预期的 `401.5` 不一致，为什么呢？

debug发现 BigDecimal 有 两个属性
- scale: 小数点右边的位数 如 4.015是3
- precision: 表示精度 也就是有效数字的长度，是4

而 100的分别是1,4
对于乘法操作，返回值的 scale 是两个数的 scale 相加，最后结果小数点右边为4，`401.5000`

除了scale的不准确，那精度有没有问题？

### 问题4
四舍五入的问题如何处理？
org.example.double01.DoubleTest.testPrecision 结果double的合适，float的 `3.35f` 变成 `3.3`

为啥？
double 和 float 的 3.35 其实相当于 3.350xxx 和 3.349xxx

那如何控制呢？设置 DecimalFormat 格式
### 问题5 
DecimalFormat是否有坑？
org.example.double01.DoubleTest.testDecimalFormat  结果分别是3.35和3.34，不符合预期3.34

如何处理，同样也是要改为字符串，再做操作
org.example.double01.DoubleTest.testDecimalFormat2

## 判等
### 问题6 
包装类的比较要通过 equals 进行，而不能使用 ==， 那 BigDecimal equals是否可用？

不行，org.example.double01.DoubleTest.testBigDecimalEquals 结果false

为什么

equals 比较的是 BigDecimal 的 value 和 scale

那要如何只比较 value 呢

compareTo

org.example.double01.DoubleTest.testBigDecimalEquals2

### 问题7

那 hashCode是否也有问题？也是比较的是 BigDecimal 的 value 和 scale
对应HashMap和HashSet 使用需要注意了
org.example.double01.DoubleTest.testBigDecimalHashCode  结果为false

那要如何处理呢？




