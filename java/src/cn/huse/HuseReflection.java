package cn.huse;

import entity.Student;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class HuseReflection {

    public static void test() {
        try {
            reflect();
        } catch (ClassNotFoundException | IllegalAccessException |
                InvocationTargetException | InstantiationException |
                NoSuchMethodException | NoSuchFieldException |IOException e) {
            e.printStackTrace();
        }
    }

    private static void reflect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, IOException {
        // 0.
        Class<Student> st = Student.class;
        System.out.println(st);

        Student s = new Student();
        Class<? extends Student> c2 = s.getClass();
        System.out.println(st == c2);

        Class<?> Person = Class.forName("entity.Person");
        System.out.println(st == Person);

        //1. get constructor
//        Constructor<?>[] cons = st.getConstructors(); // puboic methods
//        cons = st.getDeclaredConstructors(); // public & private methods
//        for(Constructor con:cons) {
//            System.out.println(con);
//        }
//        Constructor<?> con = st.getConstructor();
//        Object obj = con.newInstance();
//        System.out.println(obj);

        Constructor<?> con = Person.getConstructor(String.class, int.class);
        con.setAccessible(true); // 取消访问检查
        Object obj = con.newInstance("wiliam", 30);
        System.out.println(obj);

        //2. get var
        // Field nameField = student.getField("name"); // 只获取公有变量
        Field nameField = Person.getDeclaredField("name");//获取私有,公共变量
        nameField.setAccessible(true); // 取消访问检查
        nameField.set(obj, "jack");
        System.out.println(obj);


        //3. get methods
        Method[] methods = st.getDeclaredMethods();
        for (Method m :methods) System.out.println(m);
        Method m = st.getMethod("show");
        Constructor<?>stC = st.getConstructor();
        Object tmpObj = stC.newInstance();
        m.invoke(tmpObj);

        ArrayList<Integer> ary = new ArrayList<>();
        Class<? extends ArrayList> c = ary.getClass();
        Method th = c.getMethod("add",Object.class);
        th.invoke(ary,"a");
        th.invoke(ary,"b");
        System.out.println(ary);

        // 4. file to do
        Properties prop = new Properties();
        FileReader fr = new FileReader("C:\\Users\\chenhairong\\Desktop\\java\\bos.txt");
        prop.load(fr);

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        Class<?> tmpclass = Class.forName(className);
        Constructor<?> tmpcon = tmpclass.getConstructor();

        Object flObj = tmpcon.newInstance();
        Method flMethod = tmpclass.getMethod(methodName);
        Object result  =  flMethod.invoke(flObj);
        System.out.println(result);


    }
}












