package cn.huse;

public interface HuseReqAPI {
    public void reqAPI();

    // 1. 接口中的默认方法
    // public 颜色是灰色，可以省略 ；实现类可以重写，重写的时候去掉default关键字
    // optional
    public default void newReqAPI() {
        show("newReqAPI");
        //staticShow("newReqAPI");
    }

   // 2.接口中的静态方法，只能接口名调用
    public static void staticReqAPI() {
        staticShow("staticReqAPi");
    }

    // 3.接口中的私有方法:当两个默认方法或者静态方法中包含一段相同的代码实现时，程序必然考虑将这段实现代码
    // 抽取成一个共性方法，而这个共性方法是不需要让别人使用的，因此用私有给隐藏起来
    // 默认方法可以调用私有的静态方法和非静态方法，静态方法只能调用私有的静态方法
    private void show(String s) {
        System.out.println(s);
    }

    private static void staticShow(String s) {
        System.out.println(s);
    }
}














