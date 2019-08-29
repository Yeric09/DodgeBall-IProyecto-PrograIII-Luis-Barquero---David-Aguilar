package main;

import observador.Controlador;
import observador.Modelo;
import observador.Vista;


public class main {


    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo,vista);
        vista.setVisible(true);
        modelo.start();
    }
    
}
