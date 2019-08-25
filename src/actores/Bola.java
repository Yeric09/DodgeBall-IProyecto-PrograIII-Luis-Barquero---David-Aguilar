
package actores;

import observador.Modelo;


public class Bola extends Actores {
    int radio;
    

    public Bola(int x, int y, int dx, int dy, int radio) {
        super(x, y, dx, dy);
        this.radio = radio;
    }
    
    @Override
    public void move(Circulo c) {
        
    }

    public void move(Modelo aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }
    
}
