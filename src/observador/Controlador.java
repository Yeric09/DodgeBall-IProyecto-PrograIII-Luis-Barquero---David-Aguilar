package observador;

public class Controlador {

    Modelo modelo;
    Vista vista;

    public Controlador(Modelo m, Vista v) {
        this.modelo = m;
        this.vista = v;
        vista.setControlador(this);
        vista.setModelo(m);
    }

    void move(int flecha) {
        modelo.move(flecha);
    }

    void stopHor() {
        modelo.stopHor();
    }

    void stopVer() {
        modelo.stopVer();
    }

}
