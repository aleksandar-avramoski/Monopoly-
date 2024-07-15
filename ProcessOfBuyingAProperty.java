import java.util.Scanner;
public class ProcessOfBuyingAProperty extends Monopoly{
    public static void buyingAProperty() throws Exception {

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        Scanner scanner = new Scanner(System.in);

        String buyOrCallAnAuction;

        //LOCATION OF THE PLAYER
        BoardSquare newPosition = square[locationOfThePlayer[playerThatIsPlaying] + rollTotal];
        System.out.println(" ");

        //IF THE OWNER STOPS AT HIS PROPERTY
        if (locationsOfTheProperties.contains(locationOfThePlayer[playerThatIsPlaying] + rollTotal)) {
            //ACTIVATING THE METHOD busyProperties()
            BusyProperties.busyProperties();

        } else {
            //PRICE OF THE PROPERTY
            System.out.println("This property is AVAILABLE. \nDo you want to buy it for" + " " + "$" + newPosition.getPrice() + "?");

            //MONEY BALANCE OF THE PLAYER
            System.out.println(" ");
            System.out.println("Currently money balance:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
            System.out.println(" ");

            //IF MONEY BALANCE OF THE PLAYER IS LESS THAN THE PRICE OF THE PROPERTY
            if (moneyBalanceOfThePlayer[playerThatIsPlaying] < newPosition.getPrice()) {
                System.out.println("Press 'A' to call an auction");

                do {
                    //ANSWER OF THE PLAYER
                    buyOrCallAnAuction = scanner.nextLine();

                    if ("A".equals(buyOrCallAnAuction)) {
                        //ACTIVATING THE METHOD auction()
                        Auction.auction();

                    } else {
                        System.out.println("Press 'A' to call an auction");
                    }
                } while (!"A".equals(buyOrCallAnAuction));

            } else {
                do {
                    //BUY OR CALL AN AUCTION
                    System.out.println("Press 'B' to buy");
                    System.out.println("Press 'A' to call an auction");

                    //ANSWER OF THE PLAYER
                    buyOrCallAnAuction = scanner.nextLine();

                    if ("B".equals(buyOrCallAnAuction)) {
                        System.out.println(" ");
                        System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + " " + "bought" + " " + newPosition.getName() + "!");

                        //ACTIVATING THE METHOD propertyBuying
                        BuyingAProperty.propertyBuying();

                        //SUBTRACTING THE PRICE OF THE PROPERTY FROM THE MONEY BALANCE OF THE PLAYER
                        System.out.println(" ");
                        System.out.println("-$" + newPosition.getPrice());
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - newPosition.getPrice();
                        System.out.println("Currently money balance:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        break;

                    } else if ("A".equals(buyOrCallAnAuction)) {
                        //ACTIVATING THE METHOD auction()
                        Auction.auction();
                        break;
                    }

                } while (true);
            }
        }
    }

}
