package DiceGame.Player;

public class VirtualPlayer extends Player implements FailureReact{
    private String FailMessage;
//    Getter
    public String getFailMessage() {
        return FailMessage;
    }
//    Setter
    public void setFailMessage(String failMessage) {
        FailMessage = failMessage;
    }

//    Constructor

    public VirtualPlayer(String name, String failMessage){
        this.setName(name);
        FailMessage = failMessage;
    }
//    Method
    public void FailureReact(){
        System.out.println(this.getName() + ": " + this.getFailMessage());
    }
}

