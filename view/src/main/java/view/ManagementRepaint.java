package view;

import controller.Case;
import controller.CaseObject;
import controller.CaseUtils;
import view.IView;

public class ManagementRepaint {

    boolean on = true;

    public ManagementRepaint(Display display) {
        new Thread(() -> {
            while (on) {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

            }
        }).start();
    }
}