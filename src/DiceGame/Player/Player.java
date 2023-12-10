package DiceGame.Player;

import DiceGame.Dice.Dice;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private  String Name;
    private  int Point = 0;
//    Getter
    public  String getName() {
        return Name;
    }

    public  int getPoint() {
        return Point;
    }

//  Setter
    public void setName(String name) {
        this.Name = name;
    }
    public void setPoint(int point) {
        this.Point = point;
    }

//  Constructor
    public Player(String name) {
        this.Name = name;
    }

    //method
    Scanner scanner = new Scanner(System.in);
    public void play(int choice, Player player){
        int newPoint = player.getPoint() + Dice.roll(choice);
        if (newPoint > 21) newPoint = 0;
        player.setPoint(newPoint);
        System.out.println(player.getName() + "'s current point: " + player.getPoint());
    }
}
