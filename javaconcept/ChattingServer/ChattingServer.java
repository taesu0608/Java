package javaconcept.ChattingServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattingServer {
    public static void main(String[] args){
        ServerSocket serverSorket = null;

        InputStream is = null;
        OutputStream os = null;
        Scanner sc = new Scanner(System.in);

        try{
            serverSorket = new ServerSocket(7777);
            System.out.println("클라이언트 접속 대기중...");
            Socket socket = serverSorket.accept();
            System.out.println("클라이언트 접속 완료");
            // 2. 데이터 받기
            is = socket.getInputStream();
            //byte [] bu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
