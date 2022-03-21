/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

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

    public void reviewSong(int code, int stars) throws IOException {
        try {
            canciones.seek(0);
            canciones.readInt();
            canciones.readUTF();
            canciones.readUTF();
            canciones.readDouble();
            int sumaE = canciones.readInt();
            int review = canciones.readInt();
            while (canciones.getFilePointer() < canciones.length()) {
                int codigo = canciones.readInt();
                long posicion = canciones.getFilePointer();
                if (codigo == code) {
                    canciones.seek(posicion);
                    canciones.readInt();
                    canciones.readUTF();
                    canciones.readUTF();
                    canciones.readDouble();
                    canciones.writeDouble(sumaE + stars / review);
                    canciones.writeInt(review + 1);
                }
            }
        } catch (IllegalArgumentException e) {
            if (stars > 5 && stars > 0) {
                JOptionPane.showMessageDialog(null, "El numero de estrellas ingresadas es menor de 0 o mayor de 5");
            }
        }
    }

    public void downloadSong(int codeSong, String cliente) throws IOException {
        canciones.seek(0);
        while (canciones.getFilePointer() < canciones.length()) {
            int codigo = canciones.readInt();
            long posicion = canciones.getFilePointer();
            if (codigo == codeSong) {
                canciones.seek(posicion);
                canciones.readInt();
                String titulo = canciones.readUTF();
                canciones.readUTF();
                double precio = canciones.readDouble();
                canciones.readDouble();
                canciones.readInt();
                descargas.seek(0);
                descargas.writeInt(getCodigo(4));
                descargas.writeUTF(Calendar.getInstance().toString());
                descargas.writeInt(codeSong);
                descargas.writeUTF(cliente);
                descargas.writeDouble(precio);
                System.out.println("GRACIAS: " + cliente + " por bajar: " + titulo + " a un costo de Lps. " + precio);
            }
        }

        JOptionPane.showMessageDialog(null, "No existe la cancion");
    }

    public void songs(String txtFile) throws IOException {
        FileWriter fw = new FileWriter(txtFile, true);
        do {
            String txt = Main.scanner.next();
            if (!txt.equals(":p")) {
                fw.write(txt + "\n");
                fw.close();
            } else {
                break;
            }

        } while (true);

    }

    public void infoSong(int codeSong) throws IOException {
        canciones.seek(0);

        while (canciones.getFilePointer() < canciones.length()) {
            int codigo = canciones.readInt();
            long posicion = canciones.getFilePointer();
            if (codigo == codeSong) {

            }
        }

    }
