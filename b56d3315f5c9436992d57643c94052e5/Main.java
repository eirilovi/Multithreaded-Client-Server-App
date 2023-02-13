package computation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MultiThreadedServer server = new MultiThreadedServer(8080);
        Thread serverThread = new Thread(server);
        serverThread.start();

        System.out.println("Server started on port 8080");

        try {
            serverThread.join();
        } catch (InterruptedException e) {
            System.out.println("Server interrupted.");
        }
    }
}