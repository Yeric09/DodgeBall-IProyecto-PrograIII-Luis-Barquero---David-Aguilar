package observador;

import actores.Bola;
import actores.Circulo;
import actores.Raqueta;
import java.util.Observable;

public class Modelo extends Observable {

    public Circulo c;
    public Bola b;
    public Raqueta r;

    public static final int ARR = 1;
    public static final int ABA = 2;
    public static final int IZQ = 3;
    public static final int DER = 4;

    public Modelo() {
        c = new Circulo(800, 100, 100);
        b = new Bola(300, 300, 20, 20, 10);
        r = new Raqueta(150, 150, 20, 20, 25, 75);
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public void step() {
        b.move(this);
        r.move(this);
        setChanged();
        this.notifyObservers();
    }

    // movimiento de raqueta
    public void move(int flecha) {
        switch (flecha) {
            case ARR: r.dy = -5; break;
            case ABA: r.dy = 5; break;
            case IZQ: r.dx = -5; break;
            case DER: r.dx = 5;
        }
    }

    public void start() {
        final int delay = 20;
        Runnable code = new Runnable() {
            public void run() {
                while (true) {
                    step();
                    setChanged();
                    notifyObservers();
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        };
    }

    public void stopVer() {
        r.dy = 0;
    }

    public void stopHor() {
        r.dx = 0;
    }

}
