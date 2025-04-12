
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public  void run() throws Exception {
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter writeTo = new PrintWriter(socket.getOutputStream());
        BufferedReader readFrom = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writeTo.println("Hello from the client");
        String line = readFrom.readLine();
        System.out.println("Response from socket: " + line);
        readFrom.close();
//        writeTo.flush();
        writeTo.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}

//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.InetAddress;
//import java.net.Socket;
//
//public class Client {
//    public void run() throws Exception {
//        int port = 8010;
//        InetAddress address = InetAddress.getByName("localhost");
//        try (Socket socket = new Socket(address, port);
//             PrintWriter writeTo = new PrintWriter(socket.getOutputStream(), true); // Auto-flush enabled
//             BufferedReader readFrom = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//
//            // Send message to server
//            writeTo.println("Hello from the client");
//            // No need to flush manually due to auto-flush
//
//            // Read response from server
//            String line = readFrom.readLine();
//            System.out.println("Response from server: " + line);
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            Client client = new Client();
//            client.run();
//        } catch (Exception e) {
//            System.err.println("Client error: " + e.getMessage());
//        }
//    }
//}
