package actores;

import observador.Modelo;


public class Raqueta extends Actores {
    
    int w;
    int h;

    public Raqueta(int x, int y, int dx, int dy,int w,int h) {
        super(x, y, dx, dy);
        this.w = w;
        this.h= h;
    }

    
    @Override
    public void move(Circulo c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public void move(Modelo aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
