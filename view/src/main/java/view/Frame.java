package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import controller.IController;
import controller.IOrder;
import model.IModel;
import static view.IView.h;
import static view.IView.w;


public class Frame extends JFrame implements KeyListener {

    private Display affichage;
    private IModel model;
    private IOrder controller;


    public Frame(IModel model) {
        this.model = model;
        this.affichage = new Display(this.model);

        this.setTitle("Lorran");
        this.setResizable(false);
        this.setContentPane(this.affichage);
        this.setSize(w, h);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                affichage.manager.setPlayerDirection(0);
                break;
            case KeyEvent.VK_DOWN:
                affichage.manager.setPlayerDirection(1);
                break;
            case KeyEvent.VK_LEFT:
                affichage.manager.setPlayerDirection(2);
                break;
            case KeyEvent.VK_RIGHT:
                affichage.manager.setPlayerDirection(3);
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent keyEvent) {
       /* switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.controller.orderPerform(Order.KEY_UP, false);
                break;
            case KeyEvent.VK_DOWN:
                this.controller.orderPerform(Order.KEY_DOWN, false);
                break;
            case KeyEvent.VK_LEFT:
                this.controller.orderPerform(Order.KEY_LEFT, false);
                break;
            case KeyEvent.VK_RIGHT:
                this.controller.orderPerform(Order.KEY_RIGHT, false);
                break;
        }*/
        repaint();
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void repaint(){
        this.affichage.repaint();
    }

}
