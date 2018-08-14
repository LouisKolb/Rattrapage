package model;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Player {

    private String name;
    private int direction;
    public int x, y;


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

    public void isWinner(long gameTimer) {
        float GameTimer = gameTimer;
        GameTimer = GameTimer / 1000;
        String time = Float.toString(GameTimer);

        try {
            String url = "jdbc:mysql://localhost:3306/rattrapage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&noAccessToProcedureBodies=true";
            String user = "root";
            String password = "root";

            Connection conn = null;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("- SQL Connecté à la BDD!");

            CallableStatement cStmt = conn.prepareCall("{call add_game(?, ?)}");
            cStmt.setString(1, this.getName());
            cStmt.setString(2, time);
            cStmt.execute();
            System.out.println("- SQL Enregistré sur la BDD!");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        System.out.println("- Le joueur " + this.getName() + " a gagné!");
        System.out.println("- Durée de la partie: " + GameTimer + "s");
        System.out.println("- FIN DE LA PARTIE !");

        JOptionPane.showMessageDialog(null, "Le joueur " + this.getName() + " a gagné!\nAppuyez sur OK puis sur R pour recommencer!", "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
    }
}
