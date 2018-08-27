package view;

import javax.swing.JOptionPane;


public class ViewFacade implements IView {

    public ViewFacade() {
        super();
    }


    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }


}
