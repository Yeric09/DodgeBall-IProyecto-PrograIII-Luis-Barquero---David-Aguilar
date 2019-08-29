package observador;

import actores.Bola;
import actores.Circulo;
import actores.Raqueta;
import java.awt.event.KeyEvent;
import java.util.Observable;

public class Modelo extends Observable {

    public Circulo c;
    public Bola b;
    public Raqueta r;

    static final int ARR = KeyEvent.VK_UP;
    static final int ABA = KeyEvent.VK_DOWN;
    static final int DER = KeyEvent.VK_RIGHT;
    static final int IZQ = KeyEvent.VK_LEFT;

    public Modelo() {
        c = new Circulo(350, 350, 295);
        b = new Bola(100, 100, 5, 5, 60);
        r = new Raqueta(60, 120, 410, 500, 0, 0);
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
            case ARR: r.dy = -10; break;
            case ABA: r.dy = 10; break;
            case IZQ: r.dx = -10; break;
            case DER: r.dx = 10;
        }
    }

    public void start() {
        final int delay = 90;
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
        Thread threat = new Thread(code);
        threat.start();
    }

    public void stopVer() {
        r.dy = 0;
    }

    public void stopHor() {
        r.dx = 0;
    }

}
