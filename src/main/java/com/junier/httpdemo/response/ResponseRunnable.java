package com.junier.httpdemo.response;

import java.io.*;
import java.net.Socket;

import com.junier.httpdemo.model.ResponseHeaders;
import com.junier.httpdemo.util.RequestParseUtil;
import com.junier.httpdemo.util.ResponseHeadersUtil;

public class ResponseRunnable implements Runnable{

    private Socket socket;
    private BufferedInputStream bis;

    public ResponseRunnable(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {

        try {
            OutputStream os = socket.getOutputStream();
            String resource = RequestParseUtil.getRequestUrl(socket);
            ResponseHeaders responseHeaders = ResponseHeadersUtil.findFile(resource);
            
            int statusCode = responseHeaders.getStatusCode();
            String englishStatusCode = responseHeaders.getEnglishStatusCode();

            os.write(("HTTP/1.1 "+statusCode+" "+englishStatusCode+"\n").getBytes());
        	os.write(("Content-Type: "+responseHeaders.getContentType()+";charset=utf-8\n").getBytes());
        	if(statusCode == 302) {
        		os.write(("Location: http://" + responseHeaders.getRedirectIp() + "\n").getBytes());
        	}
           	os.write("\n".getBytes());
           
        	if(statusCode == 200) {
            	bis = new BufferedInputStream(new FileInputStream(responseHeaders.getFile()));
                byte[] b = new byte[1024];
                int length = -1;
                while ((length = bis.read(b)) != -1) {
                    os.write(b, 0, length);
                }
                bis.close();
            }else if(statusCode != 302){
        	    System.out.println("123");
        	    os.write((statusCode + " " + englishStatusCode).getBytes());
            }
    
            os.close();
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
