import DiceGame.Player.Player;
import DiceGame.Player.VirtualPlayer;

import java.util.ArrayList;
import java.util.Scanner;


public class Referee {
    public static ArrayList<Player> playerList = new ArrayList<>();
    public static ArrayList<VirtualPlayer> vPlayerList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    public static void Menu(){
        System.out.println("DiceGame: ");
        System.out.println("---------------------------");
        System.out.println("1. Start new game");
        System.out.println("2. Exit");
        System.out.println("---------------------------");
        System.out.println("Chose an options(1-2): ");
        int menuChoice = scanner.nextInt();
        switch (menuChoice){
            case 1:
                PlayerSetup();
                break;
            case 2:
                return;
            default:
                System.out.println("Error, chose again");
                Menu();
        }
    }

    public static void PlayerSetup(){
        System.out.println("Enter number player(0~4): ");
        int numberPlayer = scanner.nextInt();
        if (numberPlayer > 4 || numberPlayer < 0){
            System.out.println("Error, enter again");
            PlayerSetup();
        }
        scanner.nextLine();
        for (int i = 0; i < numberPlayer; i++){
            System.out.println("Enter player's name: ");
            playerList.get(i).setName(scanner.nextLine());
        }
        for (int i = numberPlayer; i < 4; i++){
            playerList.remove(numberPlayer);
        }
        for (int i = numberPlayer; i <4; i++){
            playerList.add(vPlayerList.get(i));
        }
        PlayBoard();
    }

    public static void PlayBoard(){
        for (Player player : playerList){
            int choice = (int)(Math.random() * 4) + 1;
            player.play(choice);
            if(player.getPoint() == 21){
                endGame(player);
            }
        }

        System.out.println("Continue?(1/0)");
        int continueChoice = scanner.nextInt();
        switch (continueChoice){
            case 1:
                PlayBoard();
                break;
            case 0:
                return;
            default:
                System.out.println("Error, chose again");
                PlayBoard();
        }
    }

    public static void endGame(Player player){
        System.out.println("The winner is: " + player.getName());
        for (Player players : playerList){
            if (players != player){
                players.FailureReact();
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);

        VirtualPlayer virtualPlayer1 = new VirtualPlayer("Vplayer1","Noooooo");
        VirtualPlayer virtualPlayer2 = new VirtualPlayer("Vplayer2","No!!!!!");
        VirtualPlayer virtualPlayer3 = new VirtualPlayer("Vplayer3","Nox3,14");
        VirtualPlayer virtualPlayer4 = new VirtualPlayer("Vplayer4","Yesn't");
        vPlayerList.add(virtualPlayer1);
        vPlayerList.add(virtualPlayer2);
        vPlayerList.add(virtualPlayer3);
        vPlayerList.add(virtualPlayer4);

        Menu();
    }
}