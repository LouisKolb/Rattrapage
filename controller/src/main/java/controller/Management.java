package controller;

import model.Player;

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
                for (CaseObject caseObject : CaseUtils.list){
                    if(caseObject.getType() == Case.RED)
                        if (caseObject.isIb())
                            caseObject.incrementI();
                    if (caseObject.getType() == Case.GRAY){
                        gray = true;
                    }
                }
                if(!gray)
                    Player.isWinner();
            }
        }).start();
    }

    public void interupt() {
        Thread.currentThread().interrupt();
    }
}