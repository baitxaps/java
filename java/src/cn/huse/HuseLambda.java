package cn.huse;

/*
类型不同
匿名内部类：可以是接口，抽象类，具体类
Lambda:只能是接口
限制不同：
如果接口中有且仅有一个抽象方法，可用Lambda表达式，也可用匿名内部内
如果接口中多于一个抽象方法，只能使用匿名内部类，不能使用Lambda表达式

实现原理不同:
匿名内部类：编译之后，产行一个单独的.class字节码文件
Lambda:编译之后，没有一个单独的.class字节码文件。对应的字节码会在运行的时候动态生成
 */
public class HuseLambda implements HuseReqAPI { // 函数式思想

    public static void lambda() {
        test();
    }

    private static void testAPI(HuseReqAPI req) {
        req.reqAPI();
    }

    @Override
    public void reqAPI() {
        System.out.println("lambda reqAPI");
    }


    public static void test() {
        //------start------
        HuseReqAPI.staticReqAPI();
        HuseReqAPI req = new HuseLambda();
        testAPI(req);

        testAPI(new HuseReqAPI() {
            @Override
            public void reqAPI() {
                System.out.println("lambda reqAPI");
            }
        });

        testAPI(()->{
            System.out.println("lambda reqAPI");
        });
        //------end------


        // Lambda
        new Thread(() -> {
            System.out.println("thread start.");
        });

        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thead start.");
            }
        }).start();
    }
}




















