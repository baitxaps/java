package cn.huse;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private  Socket s;
    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
           // BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\chenhairong\\Desktop\\python\\pw.txt"));

            String line;
            // file uniqueue
            int count = 0;
            File file = new File("C:\\Users\\chenhairong\\Desktop\\python\\copy["+count+"]pw.txt");
            while (file.exists()) {
                count++;
                file = new File("C:\\Users\\chenhairong\\Desktop\\python\\copy["+count+"]pw.txt");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            while ((line= br.readLine())!=null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("file upload success");
            bwServer.newLine();
            bwServer.flush();

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

















