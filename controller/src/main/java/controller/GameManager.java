package controller;

import model.Player;

import java.util.Random;

public class GameManager{

    public Player player;
    public int width, height;

    int x = new Random().nextInt(30) * 30;
    int y = new Random().nextInt(20) * 30;


    public GameManager(int width, int height) {
        player = new Player("Toad", 1, x, y);

        this.width = width;
        this.height = height;
    }

    public void setPlayerDirection(int direction){
        player.setDirection(direction);
    }
}
