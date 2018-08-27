package controller;

import model.Player;
import view.IView;

public class Management {

    boolean on = true;

    public Management() {
        new Thread(() -> {
            try {
                Thread.sleep(900);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            while (on) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                boolean gray = false;
                for (CaseObject caseObject : CaseUtils.list) {
                    if (caseObject.getType() == Case.RED)
                        if (caseObject.isIb())
                            caseObject.incrementI();
                    if (caseObject.getType() == Case.GRAY) {
                        gray = true;
                    }

                    int aC = (((Player.y + 30) / 30) * (IView.w / 30));
                    int bC = ((IView.w / 30) - ((Player.x + 30) / 30));
                    int c = aC - bC;


                    if (caseObject.getNumber() == c) {

                        if (caseObject.getType() == Case.BLACK) {
                            Player.isLose();
                        }
                    }

                }
                if (!gray) {
                    Player.isWinner();
                }

            }
        }).start();
    }
}