
package Clasemain;

import Controlador.Controlador;
import Controlador.Controlador;
import Modelo.Modelo;
import Modelo.Modelo;
import Vista.Vista;

public class MainClass {

    public static void main(String[] args) {
        Modelo m = new Modelo () ;
        Vista v = new Vista () ;
        Controlador c = new Controlador (m, v) ;
        c.arrancar () ; // Arranca la interfaz ( vista )
        
    }
    
}
