package cn.huse;

public class HuseException {
    public HuseException() {
        //no instance
    }

    public static void arrayException() {
        try {
            int[] arr = {2, 2, 3};
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
//           System.out.println(e.getMessage());
//           System.out.println(e.toString());
        }
    }

    //
    public void check(int score) throws HuseCustomeException {
        if(score <0 || score > 100) {
            throw new HuseCustomeException("score invalid");
        }
    }
}








