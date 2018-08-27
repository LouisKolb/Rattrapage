package view;

import java.awt.*;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import javax.swing.*;
import controller.*;
import model.IModel;
import model.Player;

import static view.IView.h;
import static view.IView.w;

public class Display extends JPanel {

    private IModel model;
    public GameManager manager;
    private boolean start = false;

    Image toad;

    public Display(IModel model) {
        this.setBackground(Color.GRAY);
        this.model = model;

        manager = new GameManager(w, h);

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

        int x ;
        int y ;

        contour(g);

        if (!start) {
            start = true;
            for (y = 1; y <= 18; y++) {
                for (x = 1; x <= 28; x++) {

                    int random = 1;

                    double foo = Math.random() * 100;
                    if (foo < 10) // 0-79
                         random = 0;

                    Case type = Case.getCaseType(random);

                    int aC = ((((y*30)+30)/30)*(IView.w/30));
                    int bC = ((IView.w/30)-(((x*30)+30)/30));
                    int c = aC - bC;

                    CaseUtils.list.add(new CaseObject(type, x, y, c));

                    if (Case.BLACK == type) {
                        fillBlack(g, x, y);
                    } else if (Case.GRAY == type) {
                        fillGray(g, x, y);
                    } else if (Case.RED == type) {
                        fillRed(g, x, y);
                    }
                }
            }
        } else {
            CaseUtils.list.forEach(list -> {
                if (Case.BLACK == list.getType()) {
                    fillBlack(g, list.getX(), list.getY());
                } else if (Case.GRAY == list.getType()) {
                    fillGray(g, list.getX(), list.getY());
                } else if (Case.RED == list.getType()) {
                    fillRed(g, list.getX(), list.getY());
                }
            });
        }

        g.drawImage(toad,manager.player.x, manager.player.y,30,30,null);
}

    public void contour(Graphics g) {

        for (int x = 0; x <= 30; x++) {

            Case type = Case.getCaseType(0);

            CaseUtils.list.add(new CaseObject(type, x, 0, x));
            CaseUtils.list.add(new CaseObject(type, x, 19, x+570));
            CaseUtils.list.add(new CaseObject(type, x, 20, x));
        }
        for (int y = 0; y <= 20; y++) {

            Case type = Case.getCaseType(0);

            CaseUtils.list.add(new CaseObject(type, 0, y, (y*30)+1));
            CaseUtils.list.add(new CaseObject(type, 29, y, y*30));
        }
    }


    public void fillBlack(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x * 30, y * 30, 30, 30);
    }

    public void fillGray(Graphics g, int x, int y) {
        g.setColor(Color.GRAY);
        g.fillRect(x * 30, y * 30, 30, 30);
    }

    public void fillRed(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillRect(x * 30, y * 30, 30, 30);
    }
}
