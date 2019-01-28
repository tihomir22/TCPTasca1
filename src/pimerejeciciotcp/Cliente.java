/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pimerejeciciotcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            for (int i = 0; i < 3; i++) {

                //Envio un mensaje al cliente
                System.out.println("Voy a enviar mensaje al servidor");
                out.writeUTF("" + i);

                //Recibo el mensaje del servidor
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                out.flush();
                Thread.sleep(1000);
            }
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
