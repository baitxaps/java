package cn.huse;

import cn.test.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuseMap {

    public static void mapTest() {
        HashMap<String, Student> hm = new HashMap<>();
        Student s1 = new Student("h",30);
        Student s2 = new Student("j",31);
        Student s3 = new Student("k",32);
        hm.put("s1",s1);
        hm.put("s2",s2);
        hm.put("s3",s3);

        Set<String> keySet = hm.keySet();
        for(String key :keySet) {
            Student value = hm.get(key);
            System.out.println(key + "," +value.getName() + "," + value.getAge());
        }

        Set<Map.Entry<String ,Student>> entrySet = hm.entrySet();
        for (Map.Entry<String,Student> me: entrySet) {
            String key = me.getKey();
            Student value = me.getValue();
            System.out.println(key + "," +value.getName() + "," + value.getAge());
        }
    }
}










