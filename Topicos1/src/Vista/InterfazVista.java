package Vista;

import Controlador.Controlador;

public interface InterfazVista {
    void setControlador (Controlador c); 
    public String getFileName(); 
    public String getText(); 
    public void setText (String s);
    
  
    public static final String ABRIR ="Abrir";
    public static final String ENCRYPT ="encriptar";
    public static final String DECRYPT ="desencriptar";
    public static final String GUARDAR ="Guardar";
}
