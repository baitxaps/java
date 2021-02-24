package cn.huse;

import entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class HuseFile {
    public static void FileTest() throws IOException {
//        File f1 = new File("C:\\Users\\chenhairong\\Desktop\\java\\java.txt");
//        System.out.println(f1.createNewFile());
//        System.out.println(f1.delete());
//        File f2 = new File("C:\\Users\\chenhairong\\Desktop");
//        System.out.println(f2.mkdir());
//        System.out.println(f2.mkdirs());

//        File[] fileArray = f2.listFiles();
//        if(fileArray == null) return;
//        for (File file:fileArray) {
//            if(file.isFile()) {
//                System.out.println("file:" + file.getName());
//            }
//        }
//
//        String[] strArray = f2.list();
//        if(strArray == null) return;
//        for(String str:strArray) {
//            System.out.println(str);
//        }


        try {
            objOutputSream();
//            systemIn();
//            copyFolderTest();
//            collectionToFileTest();
//            outputStreamWrigerTest();
//            bufferOutputStreamTest();
//            fileOutputStream();
//            fileCopyStream();

//            File f4 = new File("java\\");
//            System.out.println(f4.mkdirs());
//            File f3 = new File("java\\tmp.txt");
//            System.out.println(f3.createNewFile());
//            System.out.println(f3.delete());
//            System.out.println(f4.delete());
//            File srcFile = new File("C:\\Users\\chenhairong\\Desktop");
//            getAllFilePath(srcFile);

        } catch (IOException | ClassNotFoundException e) {
            e.fillInStackTrace();
        }
    }

    // -- 对象序列化
    private static void objOutputSream() throws IOException, ClassNotFoundException {
        // -- 对象序列化
      String file = "C:\\Users\\chenhairong\\Desktop\\python\\pw.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Person s = new Person("william", 20);
        oos.writeObject(s);
        oos.close();

        //-- 对象反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object obj = ois.readObject();
        Person st = (Person) obj;
        System.out.printf(st.getName() + " ," + st.getAge());
        ois.close();

        //-- properties => map
        Properties prop = new Properties();
        prop.put("key1","1");
        prop.put("key2","2");
        Set<Object> keySet = prop.keySet();
        for(Object key :keySet) {
            Object value = prop.get(key);
            System.out.println(key+","+value);
        }

        //-- setPorperty
        prop.setProperty("key3","3");
        System.out.println(prop.getProperty("key3"));
        System.out.println(prop);

        Set<String> names = prop.stringPropertyNames();
        for(String key:names) {
            String value = prop.getProperty(key);
            System.out.println(key+","+value);
        }

        // collection save to file
        FileWriter fw = new FileWriter(file);
        prop.store(fw,null);
        fw.close();

        // file restore to collection
        FileReader fr = new FileReader(file);
        prop.load(fr);
        fr.close();
        System.out.println(prop);
    }

    private static void systemIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("pls input the string:");
        String line = br.readLine();
        System.out.println("the string:" + line);
        System.out.println("pls input the integer:");
        int i = Integer.parseInt(br.readLine());
        System.out.println("the integer:" + i);
        br.close();

        // 上面太麻烦 用 Scanner()
        Scanner sc = new Scanner(System.in);


        //------system.out--------  => PrintStream
        PrintStream ps = System.out;// 本质是一个输出流
        ps.print("hello");
        ps.println(100);
        ps.println();

        //--- 字符打印流-------
        PrintWriter pw = new PrintWriter("C:\\Users\\chenhairong\\Desktop\\python\\pw.txt");
        pw.write("hello");
        pw.write("\r\n");
        pw.flush();
        pw.close();

        //----- copy file
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\chenhairong\\Desktop\\python\\pw.txt"));
        PrintWriter pw2 = new PrintWriter(new FileWriter("C:\\Users\\chenhairong\\Desktop\\python\\pwcopy.txt"));
        String rLine;
        while ((rLine = br2.readLine()) != null) {
            pw2.println(rLine);
        }
        br2.close();
        pw2.close();
    }

    //JDK9
    private static void exception4() throws IOException {
        FileReader fr = new FileReader("fr.txt");
        FileWriter fw = new FileWriter("fw.txt");
        try (fr; fw) {
            char[] chs = new char[1024];
            int len;
            while ((len = fr.read()) != -1) {
                fw.write(chs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //JDK7 --> recommend to use
    private static void exception3() {
        try (FileReader fr = new FileReader("fr.txt");
             FileWriter fw = new FileWriter("fw.txt");) {
            char[] chs = new char[1024];
            int len;
            while ((len = fr.read()) != -1) {
                fw.write(chs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exception2() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("fr.txt");
            fw = new FileWriter("fw.txt");
            char[] chs = new char[1024];
            int len;
            while ((len = fr.read()) != -1) {
                fw.write(chs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFolderTest() throws IOException {
        File srcFile = new File("C:\\Users\\chenhairong\\Desktop\\python");
        File destFile = new File("C:\\Users\\chenhairong\\Desktop\\dest");

        copyFolder(srcFile, destFile);   // selected the  copyFolder,alt+enter -> create method

    }

    private static void copyFolder(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()) {
            String srcFileName = srcFile.getName();
            File newFolder = new File(destFile, srcFileName);

            if (!newFolder.exists()) {
                newFolder.mkdir();
            }

            File[] fileArray = srcFile.listFiles();
            for (File file : fileArray) {
                copyFolder(file, newFolder);
            }
        } else {
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }


    public static void copyFileTest() throws IOException {
        String path = "C:\\Users\\chenhairong\\Desktop";
        File srcFolder = new File(path);
        String srcFolderName = srcFolder.getName();
        // path: 模块名+ folder（java\\folder）
        File destFolder = new File(path, "fd");
        //  File destFolder = new File("java",srcFolderName);
        if (!destFolder.exists()) {
            destFolder.mkdir();
        }

        File[] listFiles = srcFolder.listFiles();
        for (File srcFile : listFiles) {
            if (!srcFile.isDirectory()) {
                String srcFileName = srcFile.getName();
                File destFile = new File(destFolder, srcFileName);
                copyFile(srcFile, destFile);    //alt +enter ,
            }
        }
    }

    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
    }

    public static void collectionToFileTest() throws IOException {
        ArrayList<String> array = new ArrayList<>();
        array.add("hello");

        String path = "C:\\Users\\chenhairong\\Desktop\\java\\ows.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (String s : array) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }

        // txtToCollection
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            array.add(line);
        }

        for (String s : array) {
            System.out.println(s);
        }
        bw.close();
        br.close();
    }

    // 字符流，只能文本数据
    public static void outputStreamWrigerTest() throws IOException {
        String path = "C:\\Users\\chenhairong\\Desktop\\java\\ows.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path));
        osw.write(97);
        osw.flush();

        char[] chs = {'a', 'b', 'c'};
        osw.write(chs);
        osw.write(chs, 0, chs.length);
        osw.write("abcde");
        osw.write("abcde", 1, 3);
//       osw.close();


        InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
//        int ch;
//        while ((ch = isr.read())!=-1) {
//            System.out.println((char)ch);
//            osw.write(ch);
//        }
        char[] str = new char[1024];
        int len;
        while ((len = isr.read(str)) != -1) {
            System.out.println(new String(str, 0, len));
            osw.write(str, 0, len);
        }
        isr.close();
        osw.close();

        //FileReader继承InputStreamReader ,不能指定编码
        FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter(path);
        char[] frs = new char[1024];
        int frsLen;
        while ((frsLen = fr.read(frs)) != -1) {
            fw.write(frs, 0, frsLen);
        }

        //字符缓冲流
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("nell\r\n");
        int ch;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }

        while ((len = br.read(chs)) != -1) {
            System.out.println(new String(chs, 0, len));
            bw.write(chs, 0, 1024);
        }

        // newLine,readLine
        for (int i = 0; i < 10; i++) {
//            bw.write("hello" + i);
//            bw.write("\r\n");
            bw.newLine();
            bw.flush();
        }

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);// no \n
            bw.newLine();  // add \n
            bw.flush();
        }

        br.close();
        bw.close();

        fr.close();
        fw.close();
    }

    // 字节缓冲流
    private static void copyVideoTest() throws IOException {
        long startTime = System.currentTimeMillis();
        String rpath = "C:\\Users\\chenhairong\\Desktop\\java\\video.avi";
        String wpath = "C:\\Users\\chenhairong\\Desktop\\java\\a.avi";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(rpath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(wpath));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("duration: " + (endTime - startTime) + "m seconds");

    }

    public static void bufferOutputStreamTest() throws IOException {
        String path = "C:\\Users\\chenhairong\\Desktop\\java\\bos.txt";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write("world\r\n".getBytes());
        bos.write("world\r\n".getBytes());
        bos.close();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
//        int by ;
//        while ((by = bis.read())!=-1) {
//            System.out.print((char)by);
//        }

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
        bis.close();
    }


    public static void getAllFilePath(File srcfile) {
        File[] fileArray = srcfile.listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    getAllFilePath(file);
                } else {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
    }

    public static void fileOutputStream() throws IOException {
        String fPath = "C:\\Users\\chenhairong\\Desktop\\java\\fos.txt";
        FileOutputStream fos = new FileOutputStream(fPath, true);
        // 0.
        fos.write(97);
        //1.
        byte[] bys = {97, 98, 99};
        fos.write(bys);
        //2.
        bys = "ab\r\nnc".getBytes();
        fos.write(bys);
        //3.
        fos.write(bys, 1, 1);

        // 4 \r\n ->window; \n -> linux ; -r ->mac

        fos.close();
    }

    // 字节流,任意数据
    public static void fileCopyStream() throws IOException {
        String fPath = "C:\\Users\\chenhairong\\Desktop\\java\\fos.txt";
        String sPath = "C:\\Users\\chenhairong\\Desktop\\java\\save.txt";
        // 根据数据源创建输入流对象
        FileInputStream fis = new FileInputStream(fPath);
        // 根据目的地创建字节流输出对象
        FileOutputStream fos = new FileOutputStream(sPath);
        int by;
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
            fos.write(by);
        }


// byte array by reading
        byte[] rn = new byte[1024];
        int len;
        while ((len = fis.read(rn)) != -1) {
            //System.out.println(new String(rn,0,len));
            fos.write(rn, 0, len);
        }

        fos.close();
        fis.close();
    }
}





















