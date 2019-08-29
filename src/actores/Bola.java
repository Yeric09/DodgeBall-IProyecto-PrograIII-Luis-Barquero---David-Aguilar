
package actores;

import observador.Modelo;


public class Bola extends Actores {
    int radio;
    public boolean raqueta;
    

    public Bola(int x, int y, int dx, int dy, int radio) {
        super(x, y, dx, dy);
        this.radio = radio;
    }
    
    @Override
    public void move(Modelo m) {
        if( sobreLimite(m) == true){
            x = x - dx;
            y = y - dy;
        }else{
            x = x + dx;
            y = y + dy;
        }
    }
    
    public boolean sobreLimite(Modelo m){
        if( (this.x - m.c.x)* (this.x - m.c.x)+ (this.y - m.c.y)* (this.y - m.c.y) == m.c.getRadio()){
            return true;
        }else{
            return false;
        }
    }
    
    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }
    
}
