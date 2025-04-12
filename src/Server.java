import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void run() throws IOException {
//        listening porn
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
//        listening for this much ms only
        serverSocket.setSoTimeout(10000);
        while (true){
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
