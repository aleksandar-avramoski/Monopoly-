import java.util.ArrayList;
import java.util.Scanner;
public class Player {

    //NUMBER OF PLAYERS
    public static short numOfPlayers;

    //STORE THE NAMES
    public static ArrayList<String> storeTheNames = new ArrayList<>();
    public String name;
    public int properties;
    public static int location;
    public static int balance;

    public String player;

    public Player() {
        name = "";
        location = 0;
        balance = 1500;
        player = (name + location + balance);
    }

    public Player(String name, int location, int balance) {
        this.name = name;
        this.location = location;
        this.balance = balance;

        System.out.println(name + " " + location + " " + "$" + balance);
    }

    public static void players() {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        //NUMBER OF PLAYERS WHO ARE GOING TO PLAY THE GAME
        System.out.println("How much players are going to play the game?");
        System.out.println("2-6 players");

        for (; ; ) {
            //ANSWER OF THE PLAYER
            numOfPlayers = scanner1.nextShort();

            if (numOfPlayers < 2 || numOfPlayers > 6) {
                System.out.println("2-6 players can play the game");

            } else {
                //NAMES OF THE PLAYERS
                for (int i = 1; i <= numOfPlayers; i++) {
                    System.out.println(" ");
                    System.out.println("Name of the player" + " " + i + ":");

                    //NAME OF THE PLAYER
                    String nameOfThePlayer = scanner.nextLine();

                    //ADDING THE NAME OF THE PLAYER TO THE ARRAY LIST storeTheNames
                    storeTheNames.add(nameOfThePlayer);
                }

                System.out.println(" ");
                System.out.println("The players who are playing the game are:");

                //PLAYERS WHO ARE GOING TO PLAY THE GAME
                for (int i = 0; i <= numOfPlayers; i++) {
                    for (String x : storeTheNames) {
                        i = i + 1;
                        System.out.println(i + "." + x);
                    }
                }

                System.out.println(" ");
                System.out.println("Each player is starting with $1,500.");

                //MONEY VALUE FOR PLAYER
                int moneyValueForPlayers = 1500;

                for (int i = 1; i <= storeTheNames.size(); i++) {
                    System.out.println(i + "." + storeTheNames.get(i - 1) + " " + "=" + " " + "$" + moneyValueForPlayers);
                }

                System.out.println(" ");
                System.out.println("Good luck players!");
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getHouse(){
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }*/

    public int getProperties() {
        return properties;
    }

    public void setProperties(int properties) {
        this.properties = properties;
    }


    public static int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public static int getBalance() {
        return balance;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPlayer() {
        return player;
    }



    public void setPlayer(String player) {
        this.player = player;
    }

    void setLocation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

