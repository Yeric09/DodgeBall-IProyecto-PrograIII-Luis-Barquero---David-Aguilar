package observador;

import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.JFrame;

public class Vista extends JFrame implements java.util.Observer {

    Modelo modelo;
    Controlador controlador;

    public Vista() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }

            public void keyRealeased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                controlador.move(modelo.ARR);
                break;
            case KeyEvent.VK_DOWN:
                controlador.move(modelo.ABA);
                break;
            case KeyEvent.VK_LEFT:
                controlador.move(modelo.IZQ);
                break;
            case KeyEvent.VK_RIGHT:
                controlador.move(modelo.DER);
                break;
        }
    }

    private void formKeyReleased(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT: case KeyEvent.VK_RIGHT: controlador.stopHor(); break;
            case KeyEvent.VK_UP: case KeyEvent.VK_DOWN: controlador.stopVer(); break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

}
