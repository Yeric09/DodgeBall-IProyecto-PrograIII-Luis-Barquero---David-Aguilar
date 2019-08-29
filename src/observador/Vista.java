package observador;

import actores.Bola;
import actores.Circulo;
import actores.Raqueta;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.JFrame;

public class Vista extends JFrame implements java.util.Observer {

    Modelo modelo;
    Controlador controlador;

    public Vista() {
        this.setSize(700, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        this.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
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
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.renderModel(modelo,g);
    }
    
    public void renderModel(Modelo m,Graphics media){
        renderCirculo(m.c,media);
        renderBall(m.b,media);
        renderRacket(m.r,media);
    }
    
    public void renderCirculo(Circulo c,Graphics media){
        //media.drawOval(c.getX() - c.getRadio(), c.getY() - c.getRadio(), 2*c.getRadio(), 2-c.getRadio());
        media.setColor(Color.RED);
        media.fillOval(c.getX() - c.getRadio(), c.getY() - c.getRadio(), 2*c.getRadio(), 2-c.getRadio());
    }
    
    public void renderBall(Bola b,Graphics media){
        media.setColor(Color.GREEN);
        media.fillOval(b.x - b.getRadio(), b.y - b.getRadio(), 2* b.getRadio(), 2*b.getRadio());
    }
    
    public void renderRacket(Raqueta r,Graphics media){
        media.drawRect(r.x, r.y, r.getW(), r.getH());
        media.setColor(Color.BLUE);
        media.fillRect(r.x, r.y, r.getW(), r.getH());
        
//        if( modelo.b.raqueta){
//            golpe
//        }
    }
    
    public Modelo getModelo() {
        return modelo;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

}
