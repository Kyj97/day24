import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        String date = new Date().toString();
        System.out.println("날짜와 시간을 알려 주는 서버 프로그램");
        try (ServerSocket severSocket = new ServerSocket(9000)) {
            System.out.println("클라이언트 접속 대기중");
            Socket clientSocket = severSocket.accept();
            System.out.println("클라이언트 접속됨");
            PrintWriter pw = null;
            pw = new PrintWriter(clientSocket.getOutputStream(), true);
            pw.println(new Date());

        } catch (IOException e) {
        }
    }
}


