import java.util.*;

public class Monopoly {

    //ANSWER OF THE PLAYER
    public static String answerOfThePlayer;

    //NUMBER OF THE DICE
    public static int rollTotal;

    //LOCATION OF THE PLAYER
    public static Integer[] locationOfThePlayer = new Integer[6];

    //PLAYER
    public static String[] player = new String[6];

    //LOCATIONS OF THE PROPERTIES
    public static ArrayList<Integer> locationsOfTheProperties = new ArrayList<>();

    //OWNER OF THE LOCATION
    public static Integer[] ownerOfTheLocation = new Integer[6];

    //PROPERTY THAT THE PLAYER OWNS
    public static String[] propertyThatThePlayerOwns = new String[6];

    //OWNER OF THE PROPERTY
    public static ArrayList<String> ownerOfTheProperty = new ArrayList<>();

    //PLAYER WHO IS SUSPENDED
    public static ArrayList<String> playerWhoIsSuspended= new ArrayList<>();

    //MONEY BALANCE OF THE PLAYER
    public static Integer[] moneyBalanceOfThePlayer = new Integer[Player.balance];

    //PLAYER THAT IS PLAYING

    public static int playerThatIsPlaying;

    //ORIGINAL VALUE OF THE PROPERTY
    public static int originalValueOfTheProperty;

    //MORTGAGE VALUE OF THE PROPERTY
    //public static int mortgageValueOfTheProperty;

    //INDEX OF THE LOCATION
    public static int indexOfTheLocation;

    //PLAYER WHO BOUGHT THE PROPERTY
    public static ArrayList<Integer> playerWhoBoughtTheProperty = new ArrayList<>();

    //SUSPENSION ROUNDS
    public static Integer[] suspensionRounds = new Integer[6];

    //REMOVED PLAYER
    public static String[] removedPlayer = new String[6];

    //PROPERTIES OF PLAYERS
    public static List<List<String>> propertiesOfPlayers;

    //CHECK IF TRADING ACTIVATION IS TRUE
    public static boolean checkIfTradingActivationIsTrue;

    //CARD TO GET OUT FROM JAIL
    public static Integer[] cardToGetOutFromJail = new Integer[7];

    //OWNED RAILROADS
    public static Integer[] ownedRailroads = new Integer[7];

    //INDEX OF THE PLAYER WHO BOUGHT THE RAILROAD
    public static int indexOfThePlayerWhoBoughtTheRailroad;

    //POSITION
    public static boolean position;

    //PICKING A PROPERTY
    public static int pickingAProperty;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Hello Players! \nWelcome to the Monopoly! \n\nPress 'I' for introduction of the game \nPress 'Enter' to continue");

        String introduction;
        do {
            //ANSWER OF THE PLAYER
            introduction = scanner.nextLine();

            //INTRODUCTION
            if ("I".equals(introduction)) {
                //ACTIVATING THE METHOD introductionToTheGame()
                Introduction.introductionToTheGame();

            } else if (introduction.isEmpty()) {
                break;

            } else {
                System.out.println(" ");
                System.out.println("Press 'I' for introduction of the game \nPress 'Enter' to continue");
            }

        } while (!introduction.isEmpty());

        BoardSquare[] square = new BoardSquare[40];

        //ACTIVATING THE METHOD players()
        Player.players();
        /*Player.getBalance();
        Player.getLocation();*/

        for (playerThatIsPlaying = 0; playerThatIsPlaying < Player.numOfPlayers; playerThatIsPlaying++) {
            //LOCATION OF THE PLAYER
            locationOfThePlayer[playerThatIsPlaying] = Player.getLocation();
        }

        //MONEY BALANCE OF THE PLAYER
        moneyBalanceOfThePlayer = new Integer[Player.numOfPlayers];

        for (playerThatIsPlaying = 0; playerThatIsPlaying < Player.numOfPlayers; playerThatIsPlaying++) {
            //MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = 1500;
        }

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        System.out.println(" ");
        System.out.println("------------------------------------------------------ ");

        //PROPERTIES OF PLAYERS (ALL PROPERTIES THAT THE PLAYERS HAVE)
        propertiesOfPlayers = Arrays.asList(
                BuyingAProperty.propertiesOfThePlayer,
                BuyingAProperty.propertiesOfThePlayer1,
                BuyingAProperty.propertiesOfThePlayer2,
                BuyingAProperty.propertiesOfThePlayer3,
                BuyingAProperty.propertiesOfThePlayer4,
                BuyingAProperty.propertiesOfThePlayer5
        );

        for (; ; ) {
            for (playerThatIsPlaying = 0; playerThatIsPlaying < Player.numOfPlayers; playerThatIsPlaying++) {

                //AFTER TRADING
                if (Trade.indexesOfThePlayersThatAreTrading.size() > 0) {

                    //IF FIRST INDEX OF THE PLAYER THAT IS TRADING IS EQUAL TO THE NEXT LAST
                    if (Trade.indexesOfThePlayersThatAreTrading.get(0) == Player.storeTheNames.size() - 1) {
                        playerThatIsPlaying = 0;

                    } else {
                        Trade.indexOfThePlayer[Trade.indexesOfThePlayersThatAreTrading.get(0)] = Trade.indexesOfThePlayersThatAreTrading.get(0) + 1;
                        playerThatIsPlaying = Trade.indexOfThePlayer[Trade.indexesOfThePlayersThatAreTrading.get(0)];
                    }

                    //REMOVING ALL INDEXES OF THE PLAYERS THAT ARE TRADING
                    Trade.indexesOfThePlayersThatAreTrading.removeAll(Trade.indexesOfThePlayersThatAreTrading);
                }

                //IF THE PLAYER CAN GET OUT OF SUSPENSION
                if (playerWhoIsSuspended.containsAll(Player.storeTheNames)) {

                    //INDEX OF THE PLAYER
                    int indexOfThePlayer = Player.storeTheNames.indexOf(playerWhoIsSuspended.get(0));

                    //SUSPENSION ROUNDS
                    suspensionRounds[indexOfThePlayer] = 0;

                    //PLAYER WHO DOESN'T HAVE SUSPENSION
                    System.out.println(" ");
                    System.out.println("Player who doesn't have suspension anymore:" + playerWhoIsSuspended.remove(0));
                }

                //IF THE PLAYER HAS A SUSPENSION
                if (Player.storeTheNames.get(playerThatIsPlaying).equals(removedPlayer[playerThatIsPlaying])) {

                    //IF SUSPENSION ROUNDS ARE MORE THAN 0
                    if (suspensionRounds[playerThatIsPlaying] != 0) {

                        //DECREASING THE SUSPENSION ROUNDS
                        suspensionRounds[playerThatIsPlaying] = suspensionRounds[playerThatIsPlaying] - 1;
                        System.out.println(" ");
                        System.out.println("Rounds of suspension of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + (suspensionRounds[playerThatIsPlaying] + 1));

                        //IF SUSPENSION ROUNDS ARE 0
                        if (suspensionRounds[playerThatIsPlaying] == 0) {

                            //REMOVING THE PLAYER THAT HAS BEEN REMOVE FROM THE ARRAY LIST playerWhoIsSuspended
                            playerWhoIsSuspended.remove(removedPlayer[playerThatIsPlaying]);
                        }
                        continue;
                    }
                }

                //PLAYER'S TURN FOR PLAYING
                System.out.println(" ");
                System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + "\n" + "Time to Play!");
                System.out.println(" ");

                //DICES
                Dice diceOne = new Dice();
                Dice diceTwo = new Dice();
                int rollOne;
                int rollTwo;

                do  {
                    //THROWING THE DICE
                    System.out.println("Press 'T' to throw the dice");

                    //ANSWER OF THE PLAYER
                    answerOfThePlayer = scanner.nextLine();

                    if ("T".equals(answerOfThePlayer)) {

                        rollOne = diceOne.roll();
                        rollTwo = diceTwo.roll();
                        rollTotal = rollOne + rollTwo;

                        //LOCATION OF THE PLAYER ON THE BOARD
                        //System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + ":" + locationOfThePlayer[playerThatIsPlaying]);

                        //IF THE LOCATION OF THE PLAYER IS MORE THAN THE LIMITS OF THE BOARD
                        /*if (locationOfThePlayer[playerThatIsPlaying] + rollTotal >= 40) {
                            System.out.println(" ");
                            System.out.println("You just passed 'Go'. Because of that, You earn $200!" );
                            locationOfThePlayer[playerThatIsPlaying] = locationOfThePlayer[playerThatIsPlaying] - 40;

                            /*System.out.println(" ");
                            System.out.println("You earn $200!");

                            System.out.println(" ");
                            //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
                            System.out.println("Money balance:" +  "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }*/

                        System.out.println(" ");
                        System.out.println("Go ahead" + " " + rollTotal + " " + "steps");

                        for (int x = 1; x <= rollTotal; x++) {
                            Thread.sleep(300);
                            System.out.println(x);
                        }

                        //IF THE LOCATION OF THE PLAYER IS MORE THAN THE LIMITS OF THE BOARD
                        if (locationOfThePlayer[playerThatIsPlaying] + rollTotal >= 40) {
                            System.out.println(" ");
                            System.out.println("You just passed 'Go'. Because of that, You earn $200!" );
                            locationOfThePlayer[playerThatIsPlaying] = locationOfThePlayer[playerThatIsPlaying] - 40;

                            /*System.out.println(" ");
                            System.out.println("You earn $200!");*/

                            //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
                            System.out.println(" ");
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
                            System.out.println("Money balance:" +  "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }

                        //LOCATION OF THE PLAYER ON THE BOARD
                        BoardSquare newPosition = square[locationOfThePlayer[playerThatIsPlaying] + rollTotal];

                        int locationWhereThePlayerIs = locationOfThePlayer[playerThatIsPlaying] + rollTotal;

                        System.out.println(" ");
                        System.out.println("You stopped on the location:" + locationWhereThePlayerIs);

                        //GO
                        if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 0) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 0
                            System.out.println(newPosition.getName());

                            //COMMUNITY CHESTS
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 2 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 17 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 33) {
                            System.out.println(" ");

                            //DISPLAYING LOCATION 2 OR 17 OR 33
                            System.out.println(newPosition.getName());

                            String drawACard;
                            do {
                                System.out.println(" ");
                                System.out.println("Press 'D' to draw a card");

                                //ANSWER OF THE PLAYER
                                drawACard = scanner.nextLine();

                                if ("D".equals(drawACard)) {
                                    System.out.println(" ");

                                    //ACTIVATING THE METHOD communityChests()
                                    CommunityChest.communityChests();
                                }
                            } while (!"D".equals(drawACard));

                            //INCOME TAX
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 4) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 4
                            System.out.println(newPosition.getName());
                            System.out.println(" ");
                            System.out.println("You owe $" + newPosition.getPrice()+"!");

                            String payTheIncomeTax = null;
                            do {
                                //IF MONEY BALANCE OF THE PLAYER IS LEES THAN THE INCOME TAX THAT HE NEEDS TO PAY
                                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < newPosition.getPrice()) {
                                    System.out.println(" ");
                                    System.out.println("You don't have enough money to pay the income tax.");

                                    //IF THE PLAYER HAS NO MONEY TO PAY THE INCOME TAX
                                    IfThePlayerHasNoMoneyToPay();

                                } else {
                                        System.out.println(" ");
                                        System.out.println("Press 'P' to pay");

                                        //ANSWER OF THE PLAYER
                                        payTheIncomeTax = scanner.nextLine();

                                        if ("P".equals(payTheIncomeTax)) {
                                            System.out.println(" ");
                                            //SUBTRACTING $200 FROM THE MONEY BALANCE OF THE PLAYER
                                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - newPosition.getPrice();
                                            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                                        }
                                    }
                            } while (!"P".equals(payTheIncomeTax));

                            //RAILROADS
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 5 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 15 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 25 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 35) {
                            //ACTIVATING THE METHOD railroadInformation()
                            RailroadInformations.railroadInformations();

                            //CHANCES
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 7 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 22 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 36) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 7 OR 22 OR 36
                            System.out.println(newPosition.getName());

                            String drawACard;
                            do {
                                System.out.println(" ");
                                System.out.println("Press 'D' to draw a card");

                                //ANSWER OF THE PLAYER
                                drawACard = scanner.nextLine();

                                if ("D".equals(drawACard)) {
                                    System.out.println(" ");

                                    //ACTIVATING THE METHOD chances()
                                    Chances.chances();
                                }
                            } while (!"D".equals(drawACard));

                            //JAIL
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 10) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 10
                            System.out.println(newPosition.getName());
                            System.out.println(" ");

                            //PLAYER WHO IS SUSPENDED
                            playerWhoIsSuspended.add(Player.storeTheNames.get(playerThatIsPlaying));

                            //PLAYER THAT IS REMOVED
                            removedPlayer[playerThatIsPlaying] = Player.storeTheNames.get(playerThatIsPlaying);
                            System.out.println(removedPlayer[playerThatIsPlaying] + " " + "is suspended for 3 rounds!");

                            //SUSPENSION ROUNDS
                            suspensionRounds[playerThatIsPlaying] = 3;

                            //ELECTRIC COMPANY
                            //WATER WORKS
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 12 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 28) {
                            //ACTIVATING THE METHOD utilities()
                            Utilities.utilities();

                            //PARKING
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 20) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 20
                            System.out.println(newPosition.getName());
                            System.out.println(" ");

                            //PLAYER WHO IS SUSPENDED
                            playerWhoIsSuspended.add(Player.storeTheNames.get(playerThatIsPlaying));

                            //PLAYER THAT IS REMOVED
                            removedPlayer[playerThatIsPlaying] = Player.storeTheNames.get(playerThatIsPlaying);
                            System.out.println(removedPlayer[playerThatIsPlaying] + " " + "is suspended for 2 rounds!");

                            //SUSPENSION ROUNDS
                            suspensionRounds[playerThatIsPlaying] = 2;

                            //TO JAIL
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 30) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 30
                            System.out.println(newPosition.getName());
                            System.out.println(" ");

                            //PLAYER WHO IS SUSPENDED
                            playerWhoIsSuspended.add(Player.storeTheNames.get(playerThatIsPlaying));

                            //PLAYER THAT IS REMOVED
                            removedPlayer[playerThatIsPlaying] = Player.storeTheNames.get(playerThatIsPlaying);
                            System.out.println(removedPlayer[playerThatIsPlaying] + " " + "is suspended for 3 rounds!");

                            //SUSPENSION ROUNDS
                            suspensionRounds[playerThatIsPlaying] = 3;

                            //LOCATION OF THE PLAYER = 10
                            locationOfThePlayer[playerThatIsPlaying] = 10;
                            rollTotal = 0;

                            //LUXURY TAX
                        } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 38) {
                            System.out.println(" ");

                            //DISPLAYING THE LOCATION 38
                            System.out.println(newPosition.getName());
                            System.out.println(" ");
                            System.out.println("You owe $" + newPosition.getPrice());

                            String payTheLuxuryTax = null;

                            do {
                                //IF THE MONEY BALANCE OF THE PLAYER IS LESS THAN THE LUXURY TAX THAT HE NEEDS TO PAY
                                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < newPosition.getPrice()) {
                                    System.out.println(" ");
                                    System.out.println("You don't have enough money to pay the income tax.");

                                    //IF THE PLAYER HAS NO MONEY TO PAY THE INCOME TAX
                                    IfThePlayerHasNoMoneyToPay();

                                } else {
                                    System.out.println(" ");
                                    System.out.println("Press 'P' to pay");

                                    //ANSWER OF THE PLAYER
                                    payTheLuxuryTax = scanner.nextLine();

                                    if ("P".equals(payTheLuxuryTax)) {
                                        System.out.println(" ");
                                        //SUBTRACTING $200 FROM THE MONEY BALANCE OF THE PLAYER
                                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - newPosition.getPrice();
                                        System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                                    }
                                }
                            } while (!"P".equals(payTheLuxuryTax));

                        } else {
                            //ACTIVATING THE METHOD propertyInformation()
                            PropertyInformations.propertyInformations();
                        }

                        do {
                            //ACTIVATING THE METHOD optionsForThePlayer()
                            optionsForThePlayer();

                            //ANSWER OF THE PLAYER
                            answerOfThePlayer = scanner.nextLine();

                            //PROPERTIES THAT THE PLAYER OWNS
                            if ("M".equals(answerOfThePlayer)) {
                                System.out.println(" ");

                                //ACTIVATING THE METHOD propertiesOfThePlayer()
                                BuyingAProperty.propertiesOfThePlayer();

                                //TRADING
                            } else if ("R".equals(answerOfThePlayer)) {

                                //ACTIVATING THE METHOD trade()
                                Trade.trade();

                                //BUYING A HOUSE OR A HOTEL
                            } else if ("H".equals(answerOfThePlayer)) {
                                //IF messageAboutBuyingAHouseOrHotel == true
                                if (BuyingAProperty.messageAboutBuyingAHouseOrHotel == true) {
                                    BuyingAProperty.buyingAHouse();
                                }

                                //SELLING A HOUSE OR A HOTEL
                            } else if ("S".equals(answerOfThePlayer)) {

                                //ACTIVATING THE METHOD sellingAHouse()
                                SellingAHouse.sellingAHouse();

                                //LEAVING JAIL IF THE PLAYER HAS A CARD
                            } else if ("C".equals(answerOfThePlayer)) {

                                //IF THE LOCATION OF THE PLAYER IS 10
                                if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 10) {
                                    if (Chances.cardToGetOutFromJail[playerThatIsPlaying] != null) {
                                        System.out.println(" ");
                                        System.out.println("You have left the jail!");

                                        //SUSPENSION ROUNDS = 0;
                                        suspensionRounds[playerThatIsPlaying] = 0;

                                        //REMOVING THE PLAYER WHO IS PLAYING FROM THE ARRAY LIST playerWhoIsSuspended
                                        playerWhoIsSuspended.remove(Player.storeTheNames.get(playerThatIsPlaying));

                                        Chances.cardToGetOutFromJail[playerThatIsPlaying] = null;

                                    } else {
                                        break;
                                    }
                                }

                                //BANKRUPT
                            } else if ("E".equals(answerOfThePlayer)) {
                                //ACTIVATING THE METHOD bankrupt()
                               Bankrupt.bankrupt();
                            }

                            //System.out.println("Money balance: $" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

                        } while (!answerOfThePlayer.isEmpty());

                        //IF tradingActivation == false
                        if (Trade.tradingActivation == false) {
                            //thePlayer.setLocation(locationOfThePlayer[playerThatIsPlaying] + rollTotal);
                            locationOfThePlayer[playerThatIsPlaying] = locationOfThePlayer[playerThatIsPlaying] + rollTotal; //Integer.valueOf(Player.getLocation());
                            //System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + ":" + locationOfThePlayer[playerThatIsPlaying]);

                        } else {
                            //System.out.println(Player.storeTheNames.get(Trade.indexOfThePlayer[0]) + ":" + Trade.locationOfThePlayerOnTheBoard);
                            locationOfThePlayer[playerThatIsPlaying] = Trade.locationOfThePlayerOnTheBoard;
                        }

                        //TRADING ACTIVATION
                        Trade.tradingActivation = false;

                        //CHECK IF TRADING ACTIVATION IS TRUE
                        Trade.checkIfTradingActivationIsTrue = false;

                        System.out.println(" ");
                        System.out.println("---------------------------------------------------------");
                        break;
                    }
                } while (true);
            }
        }
    }

    public static void optionsForThePlayer() throws Exception {
        System.out.println(" ");
        System.out.println("Press 'M' to see your properties");
        System.out.println("Press 'Enter' to end turn");
        System.out.println("Press 'R' to trade");

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //ITERATING OVER PROPERTIES THAT ARE HAVING A HOUSE
        for (String d:BuyingAProperty.propertiesThatAreHavingAHouse) {
            if (Trade.tradingActivation == true) {
                playerThatIsPlaying = Trade.indexesOfThePlayersThatAreTrading.get(0);
            }

            //IF PROPERTY OF THE PLAYER IS A PART OF THE ARRAY LIST propertiesThatAreHavingAHouse()
            if (propertiesOfPlayers.get(playerThatIsPlaying).contains(d)) {
                System.out.println("Press 'S' to sell assets of the properties that you own");
                break;
            }
        }

        //IF LOCATION OF THE PLAYER = 10
        if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 10) {
            if (Chances.cardToGetOutFromJail[playerThatIsPlaying] != null) {
                System.out.println("Press 'C' to use your card and leave the jail");
            }
        }

        System.out.println("Press 'E' to bankrupt");

        //IF tradingActivation == true
        if (Trade.tradingActivation == true) {
            System.out.println(propertiesOfPlayers.get(Trade.indexesOfThePlayersThatAreTrading.get(0)));
            checkIfTradingActivationIsTrue = true;
        } else {
            System.out.println(propertiesOfPlayers.get(playerThatIsPlaying));
        }

        BuyingAProperty ifThePlayerCanBuyAHouse = new BuyingAProperty();

        //ACTIVATING THE METHOD checkIfThePlayerCanBuyAHouse()
        ifThePlayerCanBuyAHouse.checkIfThePlayerCanBuyAHouse();
    }

    public static void IfThePlayerHasNoMoneyToPay() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Press 'R' to trade");

        //ITERATING OVER THE PROPERTIES THAT ARE HAVING A HOUSE
        for (String d:BuyingAProperty.propertiesThatAreHavingAHouse) {
            if (Trade.tradingActivation == true) {
                playerThatIsPlaying = Trade.indexesOfThePlayersThatAreTrading.get(0);
            }

            if (propertiesOfPlayers.get(playerThatIsPlaying).contains(d)) {
                System.out.println("Press 'S' to sell assets of the properties that you own");
                break;
            }
        }

        System.out.println("Press 'E' to bankrupt");

        String chooseOneOption;

        do {
            //ANSWER OF THE PLAYER (CHOOSING ONE OPTION)
            chooseOneOption = scanner.nextLine();

            if ("R".equals(chooseOneOption)) {
                //ACTIVATING THE METHOD trade()
                Trade.trade();
                playerThatIsPlaying = Trade.indexesOfThePlayersThatAreTrading.get(0);
                System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                break;

            } else if ("E".equals(chooseOneOption)) {
                //ACTIVATING THE METHOD bankrupt()
                Bankrupt.bankrupt();
                break;

            } else if ("S".equals(chooseOneOption)) {
                //ACTIVATING THE METHOD sellingAHouse()
                SellingAHouse.sellingAHouse();
                break;
            }

        } while (true);

    }

}

