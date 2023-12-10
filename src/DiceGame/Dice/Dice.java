package DiceGame.Dice;

import DiceGame.Player.Player;

public class Dice {
    private static int minValue = 1;
    private static int maxValue = 6;

    public static int roll(int specialValue){
        double randomValue = Math.random();
        int DiceValue;
        if (randomValue < 0.04) {
            DiceValue = specialValue;
        } else {
            DiceValue = (int) (Math.random() * (maxValue - minValue +1)) + minValue;
        }
        System.out.println("Get " + DiceValue + " point");
        return DiceValue;
    }

}
