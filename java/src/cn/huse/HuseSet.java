package cn.huse;

import cn.test.Student;

import java.util.*;

public class HuseSet {
    public static void setTest() {
        Set<String> set = new HashSet<String>();
        set.add("set");
        set.add("set");
        for(String s : set) {
            System.out.println(s);
        }

        HashSet<String>hst = new HashSet<>();
        hst.add("hst");
        hst.add("hst");
        for(String s : hst) {
            System.out.println(s);
        }


        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int num = s1.getAge() - s2.getAge();
                int tmp = num == 0 ? s1.getName().compareTo(s2.getName()):num;
                return tmp;
            }
        });

        Student s1 = new Student("1",22);
        Student s2 = new Student("1",22);
        Student s3 = new Student("2",22);
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        for(Student s :ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }

    public static void randomTest() {
      //  Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set = new TreeSet<Integer>();
        Random r = new Random();
        while (set.size() <10) {
            int num = r.nextInt(20)+1;
            set.add(num);
        }
        for (Integer i :set) {
            System.out.println(i);
        }

        ArgsTest(1);
        ArgsTest(4);
    }

    public  static int ArgsTest(int... a) {
        int s = 0;
        for(int i :a) {
            s +=i;
        }
        return s;
    }
}










