package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.GameManager;
import model.IModel;
import model.Player;

import static view.IView.h;
import static view.IView.w;

public class Display extends JPanel {

    private IModel model;
    public GameManager manager;

    Image toad;

    public Display(IModel model) {
        this.setBackground(Color.GRAY);
        this.model = model;

        manager = new GameManager(w,h);

        try {
            this.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadImage() throws IOException {
        toad = ImageIO.read(getClass().getClassLoader().getResource("toad.png"));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(toad, manager.player.x, manager.player.y, 30, 30, null);

        /*if(manager.player.x >= 0 && manager.player.x <= 870 && manager.player.y == 0 || manager.player.x >= 0 && manager.player.x <= 870 && manager.player.y == 570 || manager.player.y >= 0 && manager.player.y <= 570 && manager.player.x == 0 || manager.player.y >= 0 && manager.player.y <= 570 && manager.player.x == 870){
        }*/

    }

    public void contour(Graphics g){

        g.setColor(Color.BLACK);

        for(int x=0; x <= 30; x ++){
            g.fillRect(x*30, 0, 30, 30);
        }
        for(int x=0; x <= 30; x ++){
            g.fillRect(x*30, 570, 30, 60);
        }
        for(int y=0; y <= 30; y ++){
            g.fillRect(0, y*30, 30, 30);
        }
        for(int y=0; y <= 30; y ++){
            g.fillRect(870, y*30, 30, 30);
        }
    }

    /*public void paintcredit(Graphics z) {
        Font font = new Font("Courier", Font.BOLD, 15);
        z.setFont(font);
        z.setColor(Color.YELLOW);
        z.drawString("Exia ST A1 : Louis", 325 , 570);
        this.repaint();
    }*/
}
