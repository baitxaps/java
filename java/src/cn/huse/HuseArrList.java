package cn.huse;

import java.util.ArrayList;

public class HuseArrList {
    private int count;
    public HuseArrList() {
        this.count = 0;
        System.out.println("houseArrList constructor");
    }

    public void testArrList() {
        ArrayList<String> array = new ArrayList<>();
        array.add("test");
        array.add("arraylist");
        array.add(1,"end");

        array.set(0,"now test");
        array.remove("test");
        array.remove(1);
        System.out.println(array.get(0));
        System.out.println(array);
    }

    public int getCount() {
        return count;
    }

}
