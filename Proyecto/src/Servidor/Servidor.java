package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args){

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final int PUERTO = 5000;

    try{
        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado");

        while(true){

            sc = servidor.accept(); //Servidor se queda esperando a que le lleguen envios

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF(); //Se queda a la espera de un mensaje del cliente

            System.out.println(mensaje);

            out.writeUTF("hola mundo desde el servidor");

            sc.close(); //Cierra el cliente.
            System.out.println ("Cliente desconectado");

        }

    } catch (IOException ex){
        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
    }


    }
}
