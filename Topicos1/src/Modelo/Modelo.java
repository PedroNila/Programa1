
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Modelo {
    private int numUno;
    private int numDos;
    private int resultado;
    private String contenido;
    private String fileName;
    private char shiftup = (char)3;
    private char shiftdown = (char)1;
    
    public void setContenido ( String texto ){ contenido = texto ; }
    public String getContenido () { return contenido ; }
    public void setFileName ( String nombre ){ fileName = nombre ; }

    
    public String encript(){
        String ctext = "";
        for (String linea : contenido.split("\n")){
            StringBuilder cadena = new StringBuilder();
            for(char c : linea.toCharArray()){
                if(Character.isLetter(c))
                    c += shiftup;
                    cadena.append(c);
            }
            StringBuilder shift_cadena = new StringBuilder();
            String shifttext = cadena.reverse().toString();
            int h = shifttext.length()/2;
            for (char c: shifttext.substring(h, shifttext.length()).toCharArray()){
            if(Character.isLetter(c))
                c -= shiftdown;
                shift_cadena.append(c);
        }
            ctext = ctext + shifttext.substring(0,h)+shift_cadena.toString() + '\n';
        }
        contenido = ctext;
        return ctext;
    }
    
    public String decript(){
        String texto = "";
        for (String ctext: contenido.split("\n")){
            int h = ctext.length()/2;
            StringBuilder shift_cadena = new StringBuilder(ctext.substring(0,h));
            for (char c: ctext.substring(h, ctext.length()).toCharArray()){
                if (Character.isLetter(c)) c += shiftdown;
                shift_cadena.append(c);
            }
            String shifttext = shift_cadena.reverse().toString();
            StringBuilder cadena = new StringBuilder();
            for (char c: shifttext.toCharArray()){
                if (Character.isLetter(c-3)) c -= shiftup;
                cadena.append(c);
            }
            texto = texto + cadena.toString() + '\n';
        }
        contenido = texto;
        return texto;
    }
    
    public String read(){
        String cad;
        String content = "";
        File file = new File(fileName);
        try{
            if ( file . exists () ) {
            BufferedReader x = new BufferedReader ( new FileReader ( file ) )
            ;
            while (( cad = x. readLine () ) != null )
            content = content + cad + '\n';
            x. close () ;
            }
        }catch ( FileNotFoundException fileNotFoundException ){
            System .err . println (" Error al abrir el archivo .") ; }
        catch ( IOException ioException ){
            System .err . println (" Error al leer el archivo .") ; }
        contenido = content ;
        return content ;

    }
    
    public void write(){
        try{
            File archivo = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(contenido);
            bw.close();
        }catch ( FileNotFoundException fileNotFoundException )
        { System .err . println (" Error opening file .") ; }
        catch ( IOException ioException )
        { System .err . println (" Error reading file .") ; }
    }
    
    
    public int getNumUno() {
        return numUno;
    }

    public void setNumUno(int numUno) {
        this.numUno = numUno;
    }

    public int getNumDos() {
        return numDos;
    }

    public void setNumDos(int numDos) {
        this.numDos = numDos;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    public int multiplicar(){
        this.resultado = this.numUno * this.numDos;
        return this.resultado;
    }
}
