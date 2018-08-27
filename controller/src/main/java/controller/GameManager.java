package controller;

import model.Player;
import view.IView;

import java.util.Random;

public class GameManager {

    public Player player;
    public int width, height;
    private Management management;

    int x = new Random().nextInt(29) * 30;
    int y = new Random().nextInt(19) * 30;

    public GameManager(int width, int height) {

        if (x != 0 && y != 0) {
            player = new Player("Toad", 1, x, y);
            int aC = (((y + 30) / 30) * (IView.w / 30));
            int bC = ((IView.w / 30) - ((x + 30) / 30));
            int c = aC - bC;

            CaseUtils.list.forEach(list -> {
                if (list.getNumber() == c) {
                    if (list.getType() == Case.BLACK) {
                        x = new Random().nextInt(29) * 30;
                        y = new Random().nextInt(19) * 30;
                    }
                }
            });


        } else {
            x = new Random().nextInt(29) * 30;
            y = new Random().nextInt(19) * 30;
        }

        this.width = width;
        this.height = height;
        management = new Management();

    }

    public void setPlayerDirection(int direction) {
        player.setDirection(direction);

        int aC = (((Player.y + 30) / 30) * (IView.w / 30));
        int bC = ((IView.w / 30) - ((Player.x + 30) / 30));
        int c = aC - bC;

        CaseUtils.list.forEach(list -> {
            if (list.getNumber() == c) {
                System.out.println("Toad est sur une case: " + list.getType() + " de numéro : " + c);

                if (list.getType() == Case.GRAY) {
                    list.setType(Case.RED);
                    list.setIb();
                }
            }
        });

        }


    }


