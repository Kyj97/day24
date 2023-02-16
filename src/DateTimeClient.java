import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class DateTimeClient {
    public static void main(String[] args) {
        System.out.println("에코 클라이언트 시작됨");
        try {
            Socket clientSocket = null;
            BufferedReader br = null;
            Scanner sc = new Scanner(System.in);
            try{
                while (true) {
                    System.out.print("클라이언트 > 날짜 서버의 IP 주소는? (종료 : exit) ");
                    String line = sc.nextLine();
                    if ("exit".equalsIgnoreCase(line)) {
                        break;}
                        if (clientSocket == null) {try { clientSocket = new Socket(line, 9000); break;}
                    catch (IOException ex) {
                        System.out.println("올바른 IP 입력");
                        }}
                        else if (clientSocket != null) break;
                    }
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("서버에 연결됨");
                System.out.println("서버 > " + br.readLine());

        } catch (IOException ex) {
            System.out.println("입출력 예외 발생");
        } finally {
            if (clientSocket != null) clientSocket.close();
            if (br != null) br.close();
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
 }
}



