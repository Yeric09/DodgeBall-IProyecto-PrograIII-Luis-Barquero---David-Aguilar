package actores;

import observador.Modelo;


public class Raqueta extends Actores {

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    int w;
    int h;

    public Raqueta(int x, int y, int dx, int dy,int w,int h) {
        super(x, y, dx, dy);
        this.w = w;
        this.h= h;
    }

    @Override
    public void move(Modelo m) {
        if ((x + dx + w < m.r.x + m.c.radio && y + dy + h < m.r.x + m.c.radio)) {
            x = x + dx;
            y = y + dy;
        }
    }


    
}
