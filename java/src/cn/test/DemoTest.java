package cn.test;
import cn.huse.*;
import entity.Animal;
import entity.Student;

import java.io.IOException;
import java.util.Scanner;

// r:397
public class DemoTest {
    public static void main(String[] args) {
        try {
           jdbcTest.test();
        }catch (Exception e){
            e.printStackTrace();
        }

       // HuseReflection.test();
        //HuseLambda.lambda();
        //HuseThread.runableTest();
        //HuseThread.threadRun();
    }

    public static void arrlist() {
        HuseArrList arrlist = new HuseArrList();
        arrlist.testArrList();
    }

    public static String reverseText(String s) {
        return new StringBuffer(s).reverse().toString();
    }
    public static void stringBuilderTest() {
        // 1.
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());
        sb.append("java method ").append("string num: ").append(100);
        System.out.println("string: " + sb);
        sb.reverse();
        System.out.println(" sb.reverse:" + sb);

        //2. stringBuilder ->string
        String he = sb.toString();
        System.out.println(he);

        //3. string -> stringBuilder
        sb = new StringBuffer(he);
        System.out.println(sb);
    }

    public static void classMethod() {
        try {
            HuseFile.FileTest();
        }catch (IOException e) {
            e.fillInStackTrace();
        }finally {

        }

        // HuseMap.mapTest();
        // HuseSet.randomTest();
        // HuseSet.setTest();
        // HuseCollection.collectionTest();
        // HuseCollection.listTest();

        HuseException.arrayException();
        HuseReqAPI api = new HuseAPIHuse();
        api.reqAPI();


        Student st = new Student("william", 20);
        System.out.println(st.getAge() + st.getName());
        Animal al = new Animal();
        System.out.println(al);

        // arrlist();
        //Phone p = new Phone(20, "iPhone");
        Student s = new Student();
        s.show();
        s.setAge(20);
        s.show();

        // stringBuilderTest();
        String reverse = reverseText("aabbcc");
        System.out.println(reverse);

//       inputNo();
//       int[] data={1,2,3};
//       refaddr(data);
//       System.out.println(data[0]);
    }

    public static void inputNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input No.1:");
//        int no1 = sc.nextInt();
//        System.out.println("input No.2:");
//        int no2 = sc.nextInt();

        System.out.println("input string:");
        String line = sc.nextLine();
        System.out.println("line: " + line + 2);
        System.out.println(line.length());

    }

    public static int isEvent(int a) {
        return a;
    }

    public static void refaddr(int[] arr) {
        arr[0] = 100;
    }
}

























