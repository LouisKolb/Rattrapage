package main;

import view.Frame;

public class ViewManagement {

    boolean on = true;

    public ViewManagement(Frame frame) {
        new Thread(() -> {
            while (on) {
                frame.repaint();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }).start();
    }

}
