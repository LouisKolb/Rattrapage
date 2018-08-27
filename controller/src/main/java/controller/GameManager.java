package controller;

import model.Player;
import view.IView;

import java.util.Random;

public class GameManager{

    public Player player;
    public int width, height;
    public static CaseManager caseManager;
    private Management management = null;

    int x = new Random().nextInt(29) * 30;
    int y = new Random().nextInt(19) * 30;

    public GameManager(int width, int height) {
        if(x != 0 || y != 0){
            player = new Player("Toad", 1, x, y);
        }else{
            x = new Random().nextInt(29) * 30;
            y = new Random().nextInt(19) * 30;
        }
        this.width = width;
        this.height = height;
        management = new Management();
    }

    public void setPlayerDirection(int direction){
        player.setDirection(direction);
        int aC = (((player.y+30)/30)*(IView.w/30));
        int bC = ((IView.w/30)-((player.x+30)/30));
        int c = aC - bC;
        float xC = ((30*c) + 930);

        CaseUtils.list.forEach(list -> {
            if(list.getNumber() == c){
                System.out.println("Toad est sur une case: " + list.getType());
                if (list.getType() == Case.BLACK)
                    player.isLose();
                if(list.getType() == Case.GRAY){
                    list.setType(Case.RED);
                    list.setIb();
                }
            }
        });
    }

    public static CaseManager getCaseManager() {
        return caseManager;
    }
}
