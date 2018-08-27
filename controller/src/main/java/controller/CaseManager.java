package controller;

import model.Player;
import view.IView;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class CaseManager {

    int x = new Random().nextInt(870);
    int y = new Random().nextInt(595);

    public static HashMap map = new HashMap();

    //Méthode pour renvoyer le x et le y en fonction du numéro de la case
    public CaseManager(){


        /*int Yt = (Case/30)*30;
        int Xt = (Case);*/


        for(y=0 ; y<= 20 ; y++){
            for(x=0 ; x<= 30 ; x++){
                //map.put(new CaseLocationObject(x, y), new CaseObject(Case.getCaseType(new Random().nextInt(2)), graphics, x, y));
                System.out.println("x: " + x + " y: " + y);
            }
        }

    }





    //Méthode pour renvoyer la case sur laquelle est le Player
    public int getPlayerCase(int Playerx, int Playery){
        int Case = (((Playery+30)/30)*(IView.w/30))-((900/30)-((Playerx+30)/30));
        return Case;
    }

    public void fillCase(Graphics g){

    }




}
