package cn.ieayoio.http.sunhttpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * Created by ieayoio on 16-10-8.
 */
public class TServer {
    public static void main ( String[] args ) {
        String serv = "localhost";
        InetSocketAddress address = new InetSocketAddress(serv, 9988);
        try {
            HttpServer server = HttpServer.create(address, 5);
            HttpHandler handler = new EchoHandler();
            server.createContext("/tc", handler);
            server.setExecutor(null);
            server.start();
            System.out.println("server started at " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class EchoHandler implements HttpHandler {
        public void handle ( HttpExchange httpExchange ) throws IOException {
            System.out.println(httpExchange.getRequestURI().toString());
            String resp = "Hello world!";
            httpExchange.sendResponseHeaders(200, resp.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(resp.getBytes());
            os.flush();
        }

    }
}