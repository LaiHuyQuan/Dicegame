package DiceGame.Player;

public interface FailureReact {
    public default void Fail(){
        System.out.println("Nooooo");
    }
}
