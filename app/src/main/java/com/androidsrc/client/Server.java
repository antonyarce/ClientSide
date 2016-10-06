package com.androidsrc.client;

/**
 * Created by antonyarce on 12/9/16.
 */

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

public class Server {
    MainActivity activity;
    ServerSocket serverSocket;
    ArrayList<InetAddress> listIpClient;
    ArrayList listPortClient;
    ArrayList listTotMemClient;
    ArrayList listAvaMemClient;
    String message = "";
    static int socketServerPORT;
    JSONObject jsonObject;


    public Server(MainActivity context, int port) {
        this.socketServerPORT=port;
        this.activity = context;
        Thread socketServerThread = new Thread(new SocketServerThread());
        socketServerThread.start();

    }


    public String getMessage(){
        return this.message;
    }

    public int getPort() {
        return socketServerPORT;
    }

    public void onDestroy() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private class SocketServerThread extends Thread {


        int count = 0;

        @Override
        public void run() {
            try {

                serverSocket = new ServerSocket(socketServerPORT);

                while (true) {
                    Socket socket = serverSocket.accept();

                    count++;
                    message += "#" + count + " from "
                            + socket.getInetAddress() + ":"
                            + socket.getPort() + "\n";

                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            //activity.msg.setText(message);
                        }
                    });

                    SocketServerReplyThread socketServerReplyThread = new SocketServerReplyThread(
                            socket, count);
                    socketServerReplyThread.run();

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    private class SocketServerReplyThread extends Thread {

        private Socket hostThreadSocket;
        int cnt;

        SocketServerReplyThread(Socket socket, int c) {
            hostThreadSocket = socket;
            cnt = c;
        }

        @Override
        public void run() {

            String msgReply = "Hello from node, online clients: " + cnt;

            try {
                // Recibe mensaje del cliente
                InputStream istream = hostThreadSocket.getInputStream();
                ObjectInput in = new ObjectInputStream(istream);
                message = in.readUTF();
                System.out.println(message);




                // Envia mensaje al cliente
                DataOutputStream ostream = new DataOutputStream(hostThreadSocket.getOutputStream());
                ostream.writeUTF(msgReply);
                ostream.flush();
                //message="Aqui";





            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                message += "Something wrong! " + e.toString() + "\n";
            }

            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {

                }
            });
        }

    }

    public String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress
                            .nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip = inetAddress.getHostAddress();
                    }
                }
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }
        return ip;
    }
}