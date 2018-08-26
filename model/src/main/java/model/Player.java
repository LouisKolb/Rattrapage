package model;

import javax.swing.*;
import java.sql.*;

import view.IView;
import view.IView.*;

public class Player {

    public long startTime = System.currentTimeMillis();
    private String name;
    private int direction;
    public static int x;
    public static int y;


    public Player(String name, int direction, int x, int y) {
        this.name = name;
        this.direction = direction;
        this.x = x;
        this.y = y;

    }

    public void next() {
        switch (direction) {
            case 0://Haut
                if(y != 0)
                    y = y -30;
                else
                    y = y;
                break;
            case 1://Bas
                if(y != 570)
                    y = y + 30;
                else
                    y = y;
                break;
            case 2://Gauche
                if(x != 0)
                    x = x - 30;
                else
                    x = x;
                break;
            case 3://Droite
                if(x != 870)
                    x = x + 30;
                else
                    x = x;

                break;
        }
    }


    public String getName() {
        return name;
    }

    public void setDirection(int direction) {
        this.direction = direction;
        next();
    }

    public int getDirection() {
        return direction;
    }

    public void isWinner(){
        float time = System.currentTimeMillis() - startTime;
        time = time /1000;

        System.out.println("- Partie Gagné");
        System.out.println("- Durée de la partie: " + time + "s");
        System.out.println("- Partie terminé !");

        String pseudo = JOptionPane.showInputDialog(null, "Vous avez gagné :(\nTemps écoulé : "+ time + " s\nEntrer votre pseudo :","Victoire ! !" ,JOptionPane.INFORMATION_MESSAGE );

        try{
            String url="jdbc:mysql://82.244.188.72:3306/rattrapage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&noAccessToProcedureBodies=true";
            String user="louis";
            String password="louis";

            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("- Connection à la BDD opérationnel !");

            CallableStatement cStmt = conn.prepareCall("{call add_game(?, ?, ?)}");
            cStmt.setString(1, pseudo);
            cStmt.setFloat(2, time);
            cStmt.setString(3, "Victoire");
            cStmt.execute();
            System.out.println("- Données enregistré dans la BDD");
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        System.exit(1);

    }

    public void isLose(){
        float time = System.currentTimeMillis() - startTime;
        time = time /1000;

        System.out.println("- Partie perdu");
        System.out.println("Durée de la partie: " + time + "s");
        System.out.println("- FIN DE LA PARTIE !");

        String pseudo = JOptionPane.showInputDialog(null, "Vous avez perdu :(\nTemps écoulé : "+ time + " s\nEntrer votre pseudo :","Défaite !" ,JOptionPane.INFORMATION_MESSAGE );

        try{
            String url="jdbc:mysql://82.244.188.72:3306/rattrapage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&noAccessToProcedureBodies=true";
            String user="louis";
            String password="louis";

            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("- Connection à la BDD opérationnel !");

            CallableStatement cStmt = conn.prepareCall("{call add_game(?, ?, ?)}");
            cStmt.setString(1, pseudo);
            cStmt.setFloat(2, time);
            cStmt.setString(3, "Défaite");
            cStmt.execute();
            System.out.println("- Données enregistré dans la BDD");
        }
        catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        System.exit(1);

    }
}
