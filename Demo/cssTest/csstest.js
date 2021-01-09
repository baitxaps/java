//0.基本数据类型：
//  string ,boolean,
//	number 数字类型，任意数字
//	null 一个占位符.
// 	undefined ==null 未定义类型，只有一个固定值，表示变量声明却未定义具体的值
//  typeof(null)->obj ECMAScript实现之初的一个bug,null属于基本数据类型

//引用数据类型：都是对象
//var str = new String();
// var str = new String;

//==： 值,===： 值和类型
// var a =10;var b="10"
// a==b;true,a===b;false

// ctrl+/
// ctrl+shift+/

var str1 = "he";
var str2 = 'str2';

var flag1=true;
var flag2=false;

var num1=10;
var num2=10.2
var num3=-10;

var obj =null;
var a= undefined;
var b;

/*1.reg 
/^express$/直接量方式,表单校验
/express/ 普通方式，字符搜索
*/
var reg = /^\s*$/;	//直接量方式：必须全部字符符合正则，返回true 
var reg1= /\s*/ ;	//普通方式:只要有一个字符符合正则就返回true,(除非全部字符不合符正则，返回flase)
var flag = reg.test("   a   ");
var flag1= reg1.test("   a   ");
// alert(flag);
// alert(flag1);

//2.array
var array = ['1','2','r',5,"hello"];
array[0]= '3';
array[10]= '4';
//alert(array.length);//11 
// var result = array.join('+');
// alert(result);
// alert(array);
// var rev = array.reverse();
// alert(rev);
// alert(array);

// var tmp =array.pop();
// alert(tmp);
// array.push('a','b','c');
// alert(array.length);

//3.eval(string):传入字符串，作为js代码执行
// 注意事项：只能传递基本类型的字符串，不能传入字符串对象
eval("var x=10;");
//eval(new String("var x=10;")); 不能传入字符串对象;
//alert(x);

// 4.encode and decode
var url = "https://www.baidu.com?name=小明&psw=123";
var tmp = encodeURI(url);
//alert(tmp);
tmp=decodeURI(tmp);
//alert(tmp);

// 5. string to int
var string = "10.55";
var string2 = "this";//not a number:NaN
var num =parseFloat(string);
//alert(num);

// 6.custom  obj
function Person(n,a) {
	this.name = n;
	this.age = a;
}
var p = new Person("zhang","18");
p.name = "tan";
p.sex = "male";// 动态定义属性
//alert(p.sex);

//对象直接量 创建
var pn={name:"zhang",age:18};
//alert(pn.name);

// 7.BOM(Browser Bbject Model) 
// 用来行行浏览器相关操作：浏览器的地址，弹出消息等 （window）
// alert
// confirm:用于告知用户信息并收集用户的选择 ，sure->true , cancel->false
var fg =confirm("confirm");
//alert(fg);

// setInterval
var id;
// function run(){
// 	alert("run");
// 	clearInterval(id);
// }
// id =setInterval("run()",2000);

function run(){
	alert("run");
}
// var id = setTimeout("run()",2000);
// clearInterval(id);

//7.1 location:包含浏览器，地址栏 的信息
// href:设置或返回完整的URL
//location.href = "csstest.html";
//location.href="http://www.baidu.com";
var loc = location.href;
//alert(loc);

// 8.DOM(Document Object Model)
// 将标记型文档中所有的内容（标签，文本，属性）都封装成对象
//通过操作对象的属性或者方法,来达到操作或者改变HTML展示效果的目的.
/*
DOM对象相关方法：document
getElementById(); //document.getElementById("t1")
<input type="text" id="t1" />

getElementsByName();//document.getElementsByName(hobby)
<input type="checkbox" name="hobby" value="read" />
<input type="checkbox" name="hobby" value="code" />
<input type="checkbox" name="hobby" value="run" />

getElementsByTagName();//document.getElementsByTagName("li")
<ul>
	<li>java</li>
	<li>android</li>
	<li>ios</li>
	<li>php</li>
</ul>

getElementsByClassName();//修改元素样式 document.getElementsByClassName("h1")
<input type="radio" name="sex" value="male" class="h1" />
<input type="radio" name="sex" value="famale" clas="h1"/>

*/












