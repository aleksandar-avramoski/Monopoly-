import java.util.*;
public class Auction extends Monopoly {

    //PLAYERS FROM THE AUCTION
    public static HashMap<Integer, String> playersFromTheAuction = new HashMap<>();

    //AUCTION VALUE
    public static int auctionValue;

    //PLAYER WHO IS REMOVED
    public static ArrayList<String> playerWhoIsRemoved = new ArrayList<>();

    //AUCTION ACTIVATION
    public static boolean auctionActivation;

    //INDEX OF THE PLAYER WHO WINS THE AUCTION
    public static int indexOfThePlayerWhoWinsTheAuction;

    //BID OF THE PLAYER
    public static boolean bidOfThePlayer;

    //PLAYER THAT IS PLAYING AT AUCTION
    public static int playerThatIsPlayingAtAuction;

    public static void auction() throws Exception {

        System.out.println(" ");
        System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + " " + "calls an auction.");
        System.out.println(" ");

        //STORING THE PLAYERS FOR THE AUCTION
        for (int d = 0; d < Player.storeTheNames.size(); d++) {
            if (moneyBalanceOfThePlayer[d] == 0) {
                System.out.println(Player.storeTheNames.get(d) + " " + "doesn't have enough money to propose a bid in the auction.");
                continue;
            }
            playersFromTheAuction.put(d, Player.storeTheNames.get(d));
        }

        //ORIGINAL VALUE OF THE PROPERTY
        System.out.println("Original value of the property:" + "$" + originalValueOfTheProperty);
        System.out.println(" ");
        System.out.println("-------------------------------------");
        System.out.println(" ");

        //IF playerThatIsPlaying != 0
        if (playerThatIsPlaying != 0) {
            do {
                for (playerThatIsPlayingAtAuction = playerThatIsPlaying; playerThatIsPlayingAtAuction < Player.storeTheNames.size(); playerThatIsPlayingAtAuction++) {

                    //ACTIVATING THE METHOD auctionProcess()
                    auctionProcess();
                }
            } while (playerThatIsPlayingAtAuction != Player.storeTheNames.size());
        }

        for (; ; ) {
            for (playerThatIsPlayingAtAuction = 0; playerThatIsPlayingAtAuction < Player.storeTheNames.size(); playerThatIsPlayingAtAuction++) {

                //IF THE PLAYER WITHDRAW BEFORE, THEN HE'S SKIPPED
                if (playerWhoIsRemoved.contains(Player.storeTheNames.get(playerThatIsPlayingAtAuction))) {
                    continue;
                }

                //AUCTION PROCESS
                auctionProcess();

                if (bidOfThePlayer == true) {
                    System.out.println("Nobody bought the property.");
                    //ACTIVATING THE METHOD henTheAuctionFinish()
                    whenTheAuctionFinish();
                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                    bidOfThePlayer = false;
                    return;

                } else {
                    //WINNER OF THE AUCTION
                    if (playersFromTheAuction.size() == 1 && auctionValue > 0) {
                        //ACTIVATING THE METHOD winnerOfTheAuction()
                        winnerOfTheAuction();

                        //ACTIVATING THE METHOD henTheAuctionFinish()
                        whenTheAuctionFinish();
                        System.out.println(" ");
                        System.out.println("---------------------------------------------------------");
                        return;
                    }
                }
            }
        }
    }

    public static void auctionProcess() {
        Scanner scanner = new Scanner(System.in);

        String bid;

        //IF moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= auctionValue
        if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= auctionValue) {
            System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "bids");

            do {
                System.out.println(" ");
                System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlayingAtAuction) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction]);

                //OPTIONS OF THE PLAYER
                System.out.println(" ");

                if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] < auctionValue + 1 && moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] < auctionValue + 10 && moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] < auctionValue + 100) {
                    System.out.println("You don't have enough money to continue the auction.");
                    System.out.println(" ");

                } else {
                    if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= 1 && moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= auctionValue + 1) {
                        System.out.println("Press 'O' to bid $1");
                    }

                    if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= 10 && moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= auctionValue + 10) {
                        System.out.println("Press 'T' to bid $10");
                    }

                    if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= 100 && moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] >= auctionValue + 100) {
                        System.out.println("Press 'H' to bid $100");
                    }
                }

                System.out.println("Press 'W' to withdraw");


                bid = scanner.nextLine();

                //BIDDING $1
                if ("O".equals(bid)) {
                    System.out.println(" ");
                    System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "bids:" + "$1");
                    System.out.println(" ");

                    auctionValue = auctionValue + 1;
                    System.out.println("The auction value is:" + "$" + auctionValue);

                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                    break;

                    //BIDDING $10
                } else if ("T".equals(bid)) {

                    if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] < 10) {
                        continue;
                    }

                    System.out.println(" ");
                    System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "bids:" + " " + "$10");
                    System.out.println(" ");

                    auctionValue = auctionValue + 10;
                    System.out.println("The auction value is:" + "$" + auctionValue);

                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                    break;

                    //BIDDING $100
                } else if ("H".equals(bid)) {

                    if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] < 100) {
                        continue;
                    }

                    System.out.println(" ");
                    System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "bids:" + " " + "$100");
                    System.out.println(" ");

                    auctionValue = auctionValue + 100;
                    System.out.println("The auction value is:" + "$" + auctionValue);

                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                    break;

                    //WITHDRAW
                } else if ("W".equals(bid)) {
                    System.out.println(" ");
                    System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "withdraw");

                    if (playersFromTheAuction.size() == 1 && auctionValue == 0) {
                        bidOfThePlayer = true;
                    }

                    playerWhoIsRemoved.add(Player.storeTheNames.get(playerThatIsPlayingAtAuction));
                    playersFromTheAuction.remove(playerThatIsPlayingAtAuction);

                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                    break;
                }

            } while (true);

            if (moneyBalanceOfThePlayer[playerThatIsPlayingAtAuction] < auctionValue) { //|| moneyBalanceOfThePlayer[a] < auctionValue + 1 || moneyBalanceOfThePlayer[a] < auctionValue + 10 || moneyBalanceOfThePlayer[a] < auctionValue + 100) {
                System.out.println(" ");
                System.out.println("You don't have enough money to continue the auction.");

                do {
                    System.out.println(" ");
                    System.out.println("Press 'W' to withdraw");

                    bid = scanner.nextLine();

                    //WITHDRAW
                    if ("W".equals(bid)) {
                        System.out.println(" ");
                        System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "withdraw!");

                        if (playersFromTheAuction.size() == 1 && auctionValue == 0) {
                            bidOfThePlayer = true;
                        }

                        playerWhoIsRemoved.add(Player.storeTheNames.get(playerThatIsPlayingAtAuction));
                        playersFromTheAuction.remove(playerThatIsPlayingAtAuction);
                        System.out.println(" ");
                        System.out.println("---------------------------------------------------------");
                    }
                } while (!"W".equals(bid));
            }

        } else {
            System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "bids");
            System.out.println(" ");
            System.out.println("You don't have enough money to continue the auction.");

            do {
                System.out.println(" ");
                System.out.println("Press 'W' to withdraw");

                bid = scanner.nextLine();

                //WITHDRAW
                if ("W".equals(bid)) {
                    System.out.println(" ");
                    System.out.println(Player.storeTheNames.get(playerThatIsPlayingAtAuction) + " " + "withdraw");


                    if (playersFromTheAuction.size() == 1 && auctionValue == 0) {
                        bidOfThePlayer = true;
                    }

                    playerWhoIsRemoved.add(Player.storeTheNames.get(playerThatIsPlayingAtAuction));
                    playersFromTheAuction.remove(playerThatIsPlayingAtAuction);
                    System.out.println(" ");
                    System.out.println("---------------------------------------------------------");
                }
            } while (!"W".equals(bid));
        }
        System.out.println(" ");
    }
    public static void winnerOfTheAuction() throws Exception {

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //LOCATION OF THE PLAYER
        BoardSquare newPosition = square[locationOfThePlayer[playerThatIsPlaying] + rollTotal];

        for (String d : playersFromTheAuction.values()) {
            System.out.println(d + " " + "won the auction!");
            System.out.println(" ");
            System.out.println("The property is bought for:" + "$" + auctionValue);
            System.out.println(" ");
            System.out.println(d + " " + "is now the owner of" + " " + newPosition.getName() + ".");
            System.out.println(" ");

            indexOfThePlayerWhoWinsTheAuction = Player.storeTheNames.indexOf(d);

            //SUBTRACTING auctionValue FROM THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[indexOfThePlayerWhoWinsTheAuction] = moneyBalanceOfThePlayer[indexOfThePlayerWhoWinsTheAuction] - auctionValue;
            System.out.println("Money balance of" + " " + d + " " + ":" + "$" + moneyBalanceOfThePlayer[indexOfThePlayerWhoWinsTheAuction]);

            auctionActivation = true;

            //ACTIVATING THE METHOD propertyBuying()
            BuyingAProperty.propertyBuying();

            if (!locationsOfTheProperties.contains(locationOfThePlayer[playerThatIsPlaying] + rollTotal)) {
                locationsOfTheProperties.add(locationOfThePlayer[playerThatIsPlaying] + rollTotal);
            }

            //THE OWNER IS ADDED TO THE ARRAYLIST
            ownerOfTheProperty.add(Player.storeTheNames.get(indexOfThePlayerWhoWinsTheAuction));

            //INDEX OF AN OWNER
            playerWhoBoughtTheProperty.add(indexOfThePlayerWhoWinsTheAuction);

            //LOCATION OF THE PROPERTY THAT THE PLAYER BOUGHT
            ownerOfTheLocation[indexOfThePlayerWhoWinsTheAuction] = locationOfThePlayer[playerThatIsPlaying] + rollTotal;
        }
        auctionActivation = false;
    }

    public static void whenTheAuctionFinish() {
        playerWhoIsRemoved.removeAll(playerWhoIsRemoved);
        playersFromTheAuction.remove(playersFromTheAuction);
        auctionValue = 0;
    }
}


