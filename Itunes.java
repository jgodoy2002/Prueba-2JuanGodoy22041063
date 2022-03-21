/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import java.io.*;
import java.util.*;

/**
 *
 * @author jcgof
 */
public class Itunes {

    RandomAccessFile codigos, canciones, descargas;

    public Itunes() {
        try {
            codigos = new RandomAccessFile("codigos.itn", "rw");
            //int codigo disponible para una nueva cancion
            //int codigo disponible para un nuevo donwload
            codigos.writeInt(1);
            codigos.writeInt(1);
            canciones = new RandomAccessFile("songs.itn", "rw");
            //int codigo de la cancion
            //String nombre cancion
            //String nombre cantante
            //double precio para descargar
            //double suma de estrellas totales
            //int cantidad de reviews
            descargas = new RandomAccessFile("downloads.itn", "rw");
            //int codigo del download
            //Calendar fecha al momento de bajar
            //int codigo de la cancion 
            //String nombre cliente
            //double precio
        } catch (IOException e) {
            e.getMessage();
        }

    }

    private int getCodigo(long offset) throws IOException {
        codigos.seek(0);
        int codigoC = codigos.readInt();
        int codigoD = codigos.readInt();
        if (offset == 0) {
            codigos.seek(offset);
            codigos.writeInt(codigoC + 1);
            return codigoC;
        }
        codigos.seek(offset);
        codigos.writeInt(codigoD + 1);
        return codigoD;

    }

    public void addSong(String nombre, String cantante, double precio) throws IOException {
        canciones.seek(0);
        canciones.writeInt(getCodigo(0));
        canciones.writeUTF(nombre);
        canciones.writeUTF(cantante);
        canciones.writeDouble(precio);
        canciones.writeDouble(0);
        canciones.writeInt(0);
    }

    public void reviewSong(int code, int stars)throws IOException{
        
    }
    
    
    public void downloadSong(int codeSong, String cliente) throws IOException{

    }

    public String songs(String txtFile) throws IOException{

    }

    public void infoSong(int codeSong) throws IOException{

    }

}
