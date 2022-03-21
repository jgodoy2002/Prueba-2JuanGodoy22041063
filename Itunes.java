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

    private long getCodigo(long offset) {
        if(offset == 0){
            
        } else if(offset ==4){
            
        }
    }

    public void addSong(String nombre, String cantante, double precio) {

    }

    public void downloadSong(int codeSong, String cliente) {

    }

    public String songs(String txtFile) {

    }

    public void infoSong(int codeSong) {

    }

}
