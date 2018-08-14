package main;

import java.sql.SQLException;

import com.sun.tools.internal.xjc.model.Model;
import controller.ControllerFacade;
import model.ModelFacade;
import view.Frame;
import view.IView;
import view.ViewFacade;


public class Main{

    public static void main(final String[] args) {

        ModelFacade test = new ModelFacade();
        ViewFacade test2 = new ViewFacade();

        final ControllerFacade controller = new ControllerFacade(test2, test);

        try {
            controller.start();
            new Frame(test);

        } catch (final SQLException exception) {
            exception.printStackTrace();
        }

        System.out.println("- Taille de la grille: "+ IView.w + " x " + IView.h);

    }

}
