import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void run() throws IOException {
//        listening port
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server connection opened");
//        listening for this much ms only
        serverSocket.setSoTimeout(10000);
        while (!serverSocket.isClosed()){
            try {
                System.out.println("Server is listening on port 8010.");
//                accepts the incoming on port 8010
                Socket incoming = serverSocket.accept();
//                gets socket address of client
                System.out.println("Connect from client " + incoming.getRemoteSocketAddress() + " is accepted.");
//                to write to the client
                PrintWriter writeTo = new PrintWriter(incoming.getOutputStream());
//                to read from the client
                BufferedReader readFrom = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                writeTo.println("Hello from the server");
                writeTo.flush();
                readFrom.close();
                writeTo.close();
                serverSocket.close();
            }catch (Exception e){
                e.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        }catch (IOException e){
            System.err.println(e);
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//    public void run() throws IOException {
//        int port = 8010;
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("Server is listening on port " + port);
//            serverSocket.setSoTimeout(10000); // 10-second timeout for accepting connections
//
//            while (!serverSocket.isClosed()) {
//                try (Socket incoming = serverSocket.accept()) {
//                    System.out.println("Connect from client " + incoming.getRemoteSocketAddress() + " is accepted.");
//                    // Create reader and writer for client communication
//                    try (PrintWriter writeTo = new PrintWriter(incoming.getOutputStream(), true); // Auto-flush enabled
//                         BufferedReader readFrom = new BufferedReader(new InputStreamReader(incoming.getInputStream()))) {
//
//                        // Read client message (optional, since your client sends a message)
//                        String clientMessage = readFrom.readLine();
//                        System.out.println("Client says: " + clientMessage);
//
//                        // Send response to client
//                        writeTo.println("Hello from the server");
//                        // No need to flush manually due to auto-flush
//                    }
//                } catch (IOException e) {
//                    System.err.println("Error handling client: " + e.getMessage());
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Server error: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        Server server = new Server();
//        try {
//            server.run();
//        } catch (IOException e) {
//            System.err.println("Failed to start server: " + e.getMessage());
//        }
//    }
//}