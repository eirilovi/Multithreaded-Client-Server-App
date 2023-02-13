package computation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import computation.ResponseGenerator;

public class SearchSimulator {
    public static void processClientRequest(Socket clientSocket) throws IOException {
        // simulate a heavy computation
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // write the HTML response to the client
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        String htmlResponse = ResponseGenerator.generateHTMLResponse();
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html");
        writer.println("Content-Length: " + htmlResponse.length());
        writer.println();
        writer.println(htmlResponse);
        writer.flush();
        clientSocket.close();
    }
}
