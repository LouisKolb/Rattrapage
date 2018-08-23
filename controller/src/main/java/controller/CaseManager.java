package controller;

import model.Player;
import view.IView;

import java.awt.*;
import java.util.Random;

public class CaseManager {

    int x = new Random().nextInt(870);
    int y = new Random().nextInt(595);

    //Méthode pour renvoyer le x et le y en fonction du numéro de la case
    public static void Case(int Case){

        int Yt = (Case/30)*30;
        int Xt = (Case/20)*30;


        System.out.println("X : "+Xt+" XP :"+Player.x+"\nY : "+Yt+" YP :"+Player.y);


    }

    //Méthode pour renvoyer la case sur laquelle est le Player
    public int getPlayerCase(int Playerx, int Playery){
        int Case = (((Playery+30)/30)*(IView.w/30))-((900/30)-((Playerx+30)/30));
        return Case;
    }

    public void fillCase(Graphics g){

    }

    public void fillBlack(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 30, 30);
    }

    public void fillGray(Graphics g, int x, int y){
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 30, 30);
    }

    public void fillRed(Graphics g, int x, int y){
        g.setColor(Color.RED);
        g.fillRect(x, y, 30, 30);
    }




}
