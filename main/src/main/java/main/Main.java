package main;

import model.ModelFacade;
import controller.ControllerFacade;
import view.Frame;
import view.ViewFacade;


public class Main{

    public static void main(final String[] args) {

        ModelFacade test = new ModelFacade();
        ViewFacade test2 = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(test2, test);
        controller.start();
        Frame frame = new Frame(test);
        new ViewManagement(frame);
    }

}
