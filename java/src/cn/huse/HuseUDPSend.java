package cn.huse;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class HuseUDPSend {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
           // UDPsend();
            TCPClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void TCPClient() throws IOException {
        Socket s = new Socket("192.168.0.106",10086);

        // write data to keyword
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // to file
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chenhairong\\Desktop\\python\\pw.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine())!=null) {
           // OutputStream os = s.getOutputStream();
           // os.write(line.getBytes());
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        OutputStream os = s.getOutputStream();
//        os.write("hello tcp!".getBytes());

        //respond to server
//        InputStream is = s.getInputStream();
//        byte[] bys = new byte[1024];
//        int len = is.read(bys);
//        String data = new String(bys,0,len);
//        System.out.println("client: " + data);

//        bw.write("886");
//        bw.newLine();
//        bw.flush();

        s.shutdownOutput(); // send  msg to end

        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();
        System.out.println("server respond: " + data);

        br.close();//---no close
        brClient.close();// ---->no close
        bw.close();
        s.close();
    }

    public static void UDPsend() throws IOException {
        DatagramSocket ds = new DatagramSocket();
       // byte[] bys = "hello,udp".getBytes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine())!=null) {
            if("886".equals(line)) break;

            byte[] bys = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.0.106"), 10086);
            ds.send(dp);
        }

        ds.close();
    }
}















