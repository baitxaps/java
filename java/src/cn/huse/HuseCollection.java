package cn.huse;

import java.util.*;

public class HuseCollection {
    public HuseCollection() {
        //no instance
    }

    public static void collectionTest() {
        Collection<String> c = new ArrayList<String>();
        c.add("william");
        c.add("hello");
        c.add("hello");
       // c.remove("hello");
        c.size();

        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        c.clear();
    }

    public static void listTest() {
        List<String> list = new ArrayList<>() ;
        list.add("world");

        // the 3 ways  enumIterator
        for (int i = 0; i< list.size();i++) {
           String s =  list.get(i);
            System.out.println(s);
        }

        for (String s:list){
            System.out.println(s);
        }

        // ListIterator add element ,no exception
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            String s = lit .next();
            if(s.equals("world")) lit.add("javaee");
            System.out.println(s);
        }

    }
}











