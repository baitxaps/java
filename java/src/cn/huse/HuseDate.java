package cn.huse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class HuseDate {
    private HuseDate() {
        //no instance
    }

    public static String dataToString(Date date, String format) {
        SimpleDateFormat sf = new SimpleDateFormat();
        String s = sf.format(sf);
        return s;
    }

//    public static Date stringToDate(String s, String format) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        Date parse = sdf.parse(s);
//        return  parse;
//    }

    public static Date stringToDate(String s, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date parse = sdf.parse(s);
            return  parse;
        }catch (ParseException e) {
            e.printStackTrace();
         //   return new ParseException("",0);
            return null;
        }
    }
}











