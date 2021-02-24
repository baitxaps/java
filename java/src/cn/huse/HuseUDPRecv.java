package cn.huse;

import java.io.*;
import java.net.*;
import java.nio.Buffer;

public class HuseUDPRecv {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        try {
          //  UPDReceive();
            TCPServer();
//            InetAddress ar = InetAddress.getByName("192.168.0.106");
//            String name = ar.getHostName();
//            String ip = ar.getHostAddress();
//            System.out.println("hostName : " + name + " ip: " + ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TCPServer() throws IOException {
        ServerSocket ss = new ServerSocket(10086);

        while(true) {
            // get a socket
            Socket s = ss.accept();
            new Thread(new ServerThread(s)).start();
        }

        //s.close(); // 一般服务器不关闭的
    }


//    public static void TCPServer() throws IOException {
//        ServerSocket ss = new ServerSocket(10086);
//
//        // get a socket
//        Socket s = ss.accept();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\chenhairong\\Desktop\\python\\pw.txt"));
//
//        String line;
//        while ((line = br.readLine())!= null) {
//            if("886".equals(line)) break;
//
//            System.out.println(line);
//            // write to file
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
//        }
//
////        InputStream is = s.getInputStream();
////        byte[] bys = new byte[1024];
////        int len = is.read(bys);
////        String data = new String(bys,0,len);
////        System.out.println("server :" + data);
////
////        // respond to client
////        OutputStream os = s.getOutputStream();
////        os.write("data has received".getBytes());
//
//        BufferedWriter bwServer =new  BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        bwServer.write("file upload success.");
//        bwServer.newLine();
//        bwServer.flush();
//
//        bw.close();
//        br.close();//----no close
//        bwServer.close(); // ---no close
//        //s.close(); // 一般服务器不关闭的
//        ss.close();
//    }

    public static void UPDReceive() throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            ds.receive(dp);

            int len = dp.getLength();
            String dataString = new String(dp.getData(), 0, len);
            System.out.println("data is : " + dataString);
        }
      //  ds.close();
    }
}













