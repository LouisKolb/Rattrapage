package controller;

import model.Player;
import view.IView;

public class Management {

    boolean on = true;

    public Management() {
        new Thread(() -> {
            while (on) {
                try {
                    Thread.sleep(1000);
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
                }
                if (!gray) {
                    Player.isWinner();
                }

                int aC = (((Player.y + 30) / 30) * (IView.w / 30));
                int bC = ((IView.w / 30) - ((Player.x + 30) / 30));
                int c = aC - bC;

                CaseUtils.list.forEach(list -> {
                    if (list.getNumber() == c) {

                        if (list.getType() == Case.BLACK) {
                            Player.isLose();
                        }
                    }

                });
            }
        }).start();
    }
}