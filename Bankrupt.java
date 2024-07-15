import java.util.Scanner;
public class Bankrupt {
    public static void bankrupt() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Are you sure you want to bankrupt?");
        System.out.println(" ");

        String answer;

        do {
            System.out.println("Press 'Y' for yes");
            System.out.println("Press 'N' for no");

            //ANSWER OF THE PLAYER
            answer = scanner.nextLine();

            if ("Y".equals(answer)) {
                System.out.println(" ");
                System.out.println("You're out of the game");

                //REMOVING THE PLAYER FROM THE ARRAY LIST storeTheNames
                Player.storeTheNames.remove(Monopoly.playerThatIsPlaying);

                if (Player.storeTheNames.size() == 1) {
                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println(" ");

                    //WINNER OF THE GAME
                    System.out.println(Player.storeTheNames.get(0) + " " + "is the winner of the game!");
                    System.exit(0);
                }

            } else if ("N".equals(answer)) {
                return;
            }

        } while (true);

    }
}
