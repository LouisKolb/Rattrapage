package main;

import java.sql.SQLException;

import model.ModelFacade;
import controller.ControllerFacade;
import view.Frame;
import view.IView;
import view.ViewFacade;


public class Main{

    public static void main(final String[] args) {

        ModelFacade test = new ModelFacade();
        ViewFacade test2 = new ViewFacade();

        final ControllerFacade controller = new ControllerFacade(test2, test);

        controller.start();
        new Frame(test);

        float startTime = System.currentTimeMillis();

        System.out.println("- Taille de la grille: "+ IView.w + " x " + IView.h);

    }

}
