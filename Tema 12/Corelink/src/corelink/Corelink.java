package Corelink; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author javier
 */
public class Corelink {


    public static void copiarFichero(BufferedReader br, PrintWriter pw) throws IOException {
        String linea;
        linea = br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
        }
    }

    public static void main(String[] args) {
       
        FileReader fr = null;
        BufferedReader br = null;
        
       
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
          
            fr = new FileReader("datos_empleados.txt");
            br = new BufferedReader(fr);

          
            fw = new FileWriter("empleados_copia.txt");
            pw = new PrintWriter(fw);

           
            copiarFichero(br, pw);
            
            System.out.println("Se ha copiado el contenido a 'empleados_copia.txt' correctamente.");

        } catch (IOException e) {
            
            System.out.println("Error durante la lectura o escritura del archivo");
            System.out.println(e.getMessage());
        } finally {
            
            if (pw != null) {
                pw.close();
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar FileWriter");
                    System.out.println(e.getMessage());
                }
            }

           
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar BufferedReader");
                    System.out.println(e.getMessage());
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar FileReader");
                    System.out.println(e.getMessage());
                }
            }
            }
        }
    }
}