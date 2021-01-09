package cn.huse;

import cn.test.*;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class HusemethodRef {

    public static void main(String[] args) {
        test();


    }

    // Function
    private static void covertFunction(String s,
                                       Function<String, String> fun1,
                                       Function<String, Integer> fun2,
                                       Function<Integer, Integer> fun3) {
        int i = fun1.andThen(fun2).andThen(fun3).apply(s);
        //or Integer i = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(i);
    }

    // predicate InterFace
    private static ArrayList<String> myfilter(String[] strArray, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> array = new ArrayList<>();
        for (String str : strArray) {
            if (pre1.and(pre2).test(str)) {
                array.add(str);
            }
        }
        return array;
    }

    private static void userPersionBuilder(HusePersonBuilder pb) {
        Person p = pb.build("william", 30);
        System.out.println(p.getAge() + "," + p.getName());
    }

    private static void useMystring(HuseString sub) {
        String s = sub.mySubString("subString", 2, 5);
        System.out.println(s);
    }

    private static void usePriter(HusePrinter p) {
        p.printUpperCase("print");
    }

    private static void useConverter(HuseConverter c) {
        int num = c.convert("666");
        System.out.println(num);
    }

    private static void test() {
        // 8.stream 真正把函数式风格引入到java
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("Bbbb");
        list.add("Ccccc");
        // list.stream().filter(s->s.startsWith("A")).filter(s->s.length()==1).forEach(s-> System.out.println(s));
        //or
        //list.stream().filter(s->s.startsWith("A")).filter(s->s.length()==1).forEach(System.out::println);

        //8.1
        Stream<String> front2 = list.stream().limit(2);
        Stream<String> skip = list.stream().skip(1);
        Stream.concat(front2, skip).distinct().forEach(System.out::println);
        list.stream().sorted((s1, s2) -> {
            int n1 = s1.length() - s2.length();
            int n2 = n1 == 0 ? s1.compareTo(s2) : n1;
            return n2;
        }).forEach(System.out::println);

        //7.Function
        String str = "a,40";
        covertFunction(str, (String ss) -> {
            return ss.split(",")[1];
        }, (String ss) -> {
            return Integer.parseInt(ss);
        }, (Integer i) -> {
            return i + 70;
        });
        // 简化
        covertFunction(str, ss -> ss.split(",")[1], ss -> Integer.parseInt(ss), i -> i + 70);
        // 简化
        covertFunction(str, ss -> ss.split(",")[1], Integer::parseInt, i -> i + 70);


        //6.predicate InterFace
        String[] strArray = {"A,30", "B,34", "C,35", "D,31", "F,33"};
        ArrayList<String> array = myfilter(
                strArray, s -> s.split(",")[0].length() >= 1,
                s -> Integer.parseInt(s.split(",")[1]) > 33
        );
        for (String obj : array) {
            System.out.println(obj);
        }


        // 5.引用构造器
        userPersionBuilder(((name, age) -> {
            return new Person(name, age);
        }));

        userPersionBuilder(((name, age) -> new Person(name, age)));
        //Lambda 表达式被对象的实例方法替换的时候，它的形式参数全部传递给构造器作为参数
        userPersionBuilder(Person::new);


        // 4.引用类的实例方法，其实就是引用 类中的成员方法
        useMystring((String s, int x, int y) -> {
            return s.substring(x, y);
        });
        useMystring((s, x, y) -> s.substring(x, y));
        // Lambda 表达式被对象的实例方法替换的时候，第一个参数作为调用者，后面的参数全部传递给方法作为参数
        useMystring(String::substring);


        // 3.引用对像的实例方法
        usePriter((String s) -> {
            String res = s.toUpperCase();
            System.out.println(res);
        });
        // 一个参数，参数类型可省，方法体只有一条语句，大括号和返回语句可省
        usePriter(s -> System.out.println(s.toUpperCase()));
        // Lambda 表达式被对象的实例方法替换的时候，它的形式参数全部传递给方法作为参数
        printString ps = new printString();
        usePriter(ps::printUpper);


        //2.引用类方法--
        useConverter((String s) -> {
            return Integer.parseInt(s);
        });
        useConverter(s -> Integer.parseInt(s));
        // -- lambda 表达式被类就去替换的时候，它的形式参数全部传递给静态方法作为参数
        useConverter(Integer::parseInt);//s ->parseInt

        //1.------
        usePrintable((String s) -> {
            System.out.println(s);
        });
        usePrintable(s -> System.out.println(s));
        // 方法引用符::
        usePrintable(System.out::println);
    }

    private static void usePrintable(HuseMethodRefInter ref) {
        ref.showPrint("william");
    }
}

class printString {
    public void printUpper(String s) {
        String result = s.toLowerCase();
        System.out.println(result);
    }
}
