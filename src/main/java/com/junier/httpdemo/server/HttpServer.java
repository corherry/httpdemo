package com.junier.httpdemo.server;


import com.junier.httpdemo.response.ResponseRunnable;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5555);
        System.out.println("Http Server1 has started...");
        while (true) {
            Socket socket = server.accept();
            new Thread(new ResponseRunnable(socket)).start();
        }
    }
}




