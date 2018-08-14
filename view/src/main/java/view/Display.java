package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        rect(g);
        //paintcredit(g);
        g.drawImage(toad, manager.player.x, manager.player.y, 30, 30, null);
    }

    public void rect(Graphics g){

        g.setColor(Color.RED);


    }

    /*public void paintcredit(Graphics z) {
        Font font = new Font("Courier", Font.BOLD, 15);
        z.setFont(font);
        z.setColor(Color.YELLOW);
        z.drawString("Exia ST A1 : Louis", 325 , 570);
        this.repaint();
    }*/
}
