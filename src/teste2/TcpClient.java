/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

//CLIENT CODE - RUN FROM MY DESKTOP
import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;

// tcpClient.java by fpont 3/2000
// usage : java tcpClient <server> <port>
// default port is 1500
public class TcpClient {

    public static void main(String[] args) {
        String msg2server = "";
        String mensagem = null;
        boolean flag = true;
        DataOutputStream out;
        
        try {
            Socket socket;

            while (true) {
                socket = new Socket("192.168.2.55", 7000);
                out = new DataOutputStream(socket.getOutputStream());
                if (mensagem != null || flag) {
                    msg2server = JOptionPane.showInputDialog("Escreva a mensagem para enviar");
                    out.writeUTF(msg2server);
                    flag = false;
                }


                DataInputStream in = new DataInputStream(socket.getInputStream());
                mensagem = in.readUTF();
                System.out.println(mensagem);//cliente recebendo retorno do servidor
            }

            //out.close();
            //in.close();
            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
