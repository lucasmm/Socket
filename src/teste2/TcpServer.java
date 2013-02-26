/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TcpServer {

    public static void main(String args[]) {
        String mensagem = "";
        String msg2client;
        try {
            ServerSocket ss = new ServerSocket(7000);
            while (true) {
                Socket socket = ss.accept();
                System.out.println(socket.getInetAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                mensagem = in.readUTF();
                System.out.println(mensagem);//mensagem recebida do cliente
                
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                if(!mensagem.equals("")){
                    msg2client = JOptionPane.showInputDialog("Escreva a mensagem para enviar");
                    out.writeUTF(msg2client);// retornando mensagem
                    mensagem = "";
                }

                in.close();
                out.close();
                socket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
