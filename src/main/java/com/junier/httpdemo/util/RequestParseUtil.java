package com.junier.httpdemo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestParseUtil {
	
	public static String getRequestUrl(Socket socket) throws IOException {
	       BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//           String line = reader.readLine();
//           System.out.println(line);
//           String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
            String line = null;
           while((line = reader.readLine())!= null){
               System.out.println(line);
           }
            reader.close();
           return "/";
	}
}
