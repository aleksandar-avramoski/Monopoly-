import java.util.*;
public class Trade extends Monopoly {

    //PLAYERS TO TRADE WITH
    public static ArrayList<String> playersToTradeWith = new ArrayList<>();

    //PICKING A PROPERTY
    public static int pickingAProperty;

    //INDEX OF THE PLAYER
    public static Integer[] indexOfThePlayer = new Integer[3];

    //INDEXES OF THE PLAYERS THAT ARE TRADING
    public static ArrayList<Integer> indexesOfThePlayersThatAreTrading = new ArrayList<>();

    //ANSWER OF THE PLAYER
    public static String decisionOfThePlayer;

    //TOTAL VALUE OFFERS
    public static int totalValueOffers=0;

    //TOTAL VALUE WANTS
    public static int totalValueWants=0;

    //PROPERTIES THAT THE PLAYER OWNS
    public static List<String> propertiesThatThePlayerOwns;

    //LOCATION OF THE PROPERTIES THAT THE PLAYER OWNS
    public static List<Integer> locationsOfThePropertiesThatThePlayerOwns;

    public static int a;

    //MONEY OFFERS
    public static int moneyOffers;

    //MONEY WANTS
    public static int moneyWants;

    //PROPERTIES THAT THE PLAYER TRADE
    public static HashSet<String> propertiesThatThePlayerTrade = new HashSet<>();

    //PROPERTIES THAT THE PLAYER TRADE 1
    public static HashSet<String> propertiesThatThePlayerTrade1 = new HashSet<>();

    //PROPERTIES OF THE PLAYER
    public static List<String> propertiesOfThePlayer;

    //PICKED PROPERTIES
    public static HashSet<String> pickedProperties = new HashSet<>();

    //LOCATIONS OF PROP OF THE PLAYER
    public static ArrayList<Integer> locationsOfPropOfThePlayer = new ArrayList<>();

    //LOCATIONS OF PROP OF THE PLAYER 1
    public static ArrayList<Integer> locationsOfPropOfThePlayer1 = new ArrayList<>();

    //ARRAY LIST OF THE LOCATIONS OF THE PLAYER
    public static List<Integer> arrayListOfTheLocationsOfThePlayer;

    //ARRAY LIST OF THE LOCATIONS OF THE PLAYER 1
    public static List<Integer> arrayListOfTheLocationsOfThePlayer1;

    //ARRAY LIST OF THE PROPERTIES OF THE PLAYER
    public static List<String> arrayListOfThePropertiesOfThePlayer;

    //ARRAY LIST OF THE PROPERTIES OF THE PLAYER 1
    public static List<String> arrayListOfThePropertiesOfThePlayer1;

    //PROP OF THE PLAYER
    public static ArrayList<String> propOfThePlayer = new ArrayList<>();

    //PROP OF THE PLAYER 1
    public static ArrayList<String> propOfThePlayer1 = new ArrayList<>();
    //public static List<List<String>> propertiesOfThePlayers;

    //ALL LOCATIONS OF THE PLAYERS
    public static List<List<Integer>> allLocationsOfThePlayers;
    //public static boolean tradingProperties;

    //TRADING ACTIVATION
    public static boolean tradingActivation;

    //PLAYER WANTS PROPERTY
    public static boolean playerWantsProperty;

    //PICKING A PLAYER
    public static int pickingAPlayer;

    //LOCATION OF THE PLAYER ON THE BOARD
    public static int locationOfThePlayerOnTheBoard;

    //OFFERING OR WANT MONEY
    public static boolean offeringOrWantMoney;

    //PLAYER WANTS
    public static boolean playerWants;

    //INDEX OF THE PLAYER WHO IS PLAYING
    public static int indexOfThePlayerWhoIsPlaying;

    //EXIT FROM TRADING
    public static boolean exitFromTrading;
    public static void trade() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        //IF checkIfTradingActivationIsTrue == true
        if (checkIfTradingActivationIsTrue == true) {
            playerThatIsPlaying = indexesOfThePlayersThatAreTrading.get(0);
        }

        System.out.println(" ");
        System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + "," + " " + "who do you want to trade with?");

        //PLAYER WHO CALLS THE TRADE
        String playerWhoCallsTheTrade = Player.storeTheNames.get(playerThatIsPlaying);

        //PLAYERS WHO CAN BE PICKED FOR TRADING
        for (int c = 0; c < Player.numOfPlayers; c++) {
            if (Player.storeTheNames.get(c).equals(Player.storeTheNames.get(playerThatIsPlaying))) {
                continue;
            }

            //PLAYERS THAT CAN BE PICKED FOR TRADING
            playersToTradeWith.add(Player.storeTheNames.get(c));
        }

        //LIST OF A PLAYERS WHO ARE PLAYING
        for (int s = 1; s <= playersToTradeWith.size(); s++) {
            System.out.println(s + "-" + playersToTradeWith.get(s - 1));
        }

        System.out.println(" ");
        System.out.println("Pick the number of the player that you want to trade with:");

        //PICKING THE NUMBER OF A PLAYER TO TRADE WITH
        pickingAPlayer = scanner1.nextInt();

        //PLAYER THAT IS PICKED FOR TRADING
        String playerThatIsPickedForTrading = playersToTradeWith.get(pickingAPlayer - 1);

        //INDEX OF THE PLAYER THAT IS PICKED FOR TRADING
        indexOfThePlayer[1] = Player.storeTheNames.indexOf(playerThatIsPickedForTrading);

        System.out.println(" ");
        System.out.println("You pick" + " " + playerThatIsPickedForTrading + " " + "to trade with!");

        do {
        //PLAYER'S OFFERING---------------------------------------------------------------------------------------------
        //PLAYER WHO CALLS THE TRADE OFFER
        System.out.println(" ");
        System.out.println(Player.storeTheNames.get(playerThatIsPlaying) + "'s" + " " + "OFFER");

        //LOCATION OF THE PLAYER ON THE BOARD
        locationOfThePlayerOnTheBoard = locationOfThePlayer[playerThatIsPlaying] + rollTotal;

        //PLAYER'S INDEX
        indexOfThePlayer[0] = Player.storeTheNames.indexOf(Player.storeTheNames.get(playerThatIsPlaying));
        indexesOfThePlayersThatAreTrading.add(indexOfThePlayer[0]);
        indexOfThePlayerWhoIsPlaying = indexOfThePlayer[0];
        //playerThatIsPlaying = indexOfThePlayer[0]; //valueOfThePlayer.get(0);

        //ALL ARRAY LISTS OF LOCATIONS
        allLocationsOfThePlayers = Arrays.asList(
                BuyingAProperty.locationsOfThePlayer,
                BuyingAProperty.locationsOfThePlayer1,
                BuyingAProperty.locationsOfThePlayer2,
                BuyingAProperty.locationsOfThePlayer3,
                BuyingAProperty.locationsOfThePlayer4,
                BuyingAProperty.locationsOfThePlayer5
        );

            //OPTIONS TO OFFER
            System.out.println(" ");
            System.out.println("What do you want to offer?");

            //ACCEPT OR NO ACCEPT THE OFFER FROM THE PLAYER WHO CALLS THE TRADE
            String acceptOrNoAcceptTheOffer = null;

            //ANSWER OF THE PLAYER
            String answerOfThePlayer;

            //BOOLEAN
            boolean gettingOutOfLoop = false;

            do {
                System.out.println(" ");
                System.out.println("Press 'P' to offer properties");
                System.out.println("Press 'M' to offer money");

                //ANSWER OF THE PLAYER
                answerOfThePlayer = scanner.nextLine();

                //OFFER PROPERTY
                if ("P".equals(answerOfThePlayer)) {
                    System.out.println(" ");
                    System.out.println("Which property do you want to offer?");

                    //OFFERING PROPERTY
                    offeringProperty();
                    break;

                    //OFFER MONEY
                } else if ("M".equals(answerOfThePlayer)) {
                    moneyOffering();

                    offeringOrWantMoney = true;

                    if (propertiesOfPlayers.get(indexOfThePlayer[0]).size() != 0) {
                        do {
                            System.out.println(" ");
                            System.out.println("Press 'P' to pick property for trading");
                            System.out.println("Press 'N' if you don't want to pick property for trading");

                            String choosingOption;

                            //ANSWER OF THE PLAYER (CHOOSING ONE OPTION)
                            choosingOption = scanner.nextLine();

                            if ("P".equals(choosingOption)) {
                                //ACTIVATING THE METHOD offeringProperty()
                                offeringProperty();
                                gettingOutOfLoop = true;
                                break;

                            } else if ("N".equals(choosingOption)) {
                                gettingOutOfLoop = true;
                                break;
                            }
                        } while (true);

                    } else {
                        break;
                    }
                }

                if (gettingOutOfLoop == true) {
                    break;
                }

            } while (true);

            System.out.println(" ");
            System.out.println("---------------------------------------------------------");
            System.out.println(" ");

            //iF exitFromTrading == true
            if (exitFromTrading == true) {
                break;
            }

            //PLAYER'S WANTS--------------------------------------------------------------------------------------------
            //OPTIONS TO ASK FOR
            System.out.println("What do you want from" + " " + playerThatIsPickedForTrading + ":");

            //PLAYER'S INDEX
            indexOfThePlayer[1] = Player.storeTheNames.indexOf(playerThatIsPickedForTrading);
            indexesOfThePlayersThatAreTrading.add(indexOfThePlayer[1]);
            indexOfThePlayerWhoIsPlaying = indexOfThePlayer[1];
            //playerThatIsPlaying = indexOfThePlayer[1]; //valueOfThePlayer.get(1);

            do {
                System.out.println(" ");
                System.out.println("Press 'P' for properties");
                System.out.println("Press 'M' for money");

                //ANSWER OF THE PLAYER
                answerOfThePlayer = scanner.nextLine();

                //PLAYER WANTS
                playerWants = true;

                //WANT PROPERTY
                if ("P".equals(answerOfThePlayer)) {
                    playerWantsProperty = true;

                    System.out.println(" ");
                    System.out.println("Which property do you want?");

                    //ACTIVATING THE METHOD offeringProperty()
                    offeringProperty();

                    break;

                    //WANT MONEY
                } else if ("M".equals(answerOfThePlayer)) {

                    //ACTIVATING THE METHOD moneyWants()
                    moneyWants();

                    offeringOrWantMoney = true;

                    //IF propertiesOfPlayers.get(indexOfThePlayer[1]).size() != 0
                    if (propertiesOfPlayers.get(indexOfThePlayer[1]).size() != 0) {
                        do {
                            System.out.println(" ");
                            System.out.println("Press 'P' to pick property for trading");
                            System.out.println("Press 'N' if you don't want to pick property for trading");

                            String choosingOption;

                            //ANSWER OF THE PLAYER (CHOOSING ONE OPTION)
                            choosingOption = scanner.nextLine();

                            if ("P".equals(choosingOption)) {
                                //ACTIVATING THE METHOD offeringProperty()
                                offeringProperty();
                                gettingOutOfLoop = true;
                                break;

                            } else if ("N".equals(choosingOption)) {
                                gettingOutOfLoop = true;
                                break;
                            }
                        } while (true);

                    } else {
                        break;
                    }
                }

                if (gettingOutOfLoop == true) {
                    break;
                }

            } while (true);

            //EXIT FROM THE TRADING
            if (exitFromTrading == true) {
                break;
            }

            //-------------------------------------------------------------------------------------------------------------
            //TOTAL VALUE OFFERS AND WANTS
            System.out.println(" ");
            System.out.println("---------------------------------------------------------");
            System.out.println(" ");
            System.out.println("Total value offers:" + "$" + totalValueOffers);
            System.out.println("Total value wants:" + "$" + totalValueWants);
            System.out.println(" ");
            System.out.println("---------------------------------------------------------");

            String dealOrNoDeal;

            do {
                System.out.println(" ");
                System.out.println("Press 'D' for Deal?");
                System.out.println("Press 'B' to go back");
                System.out.println("Press 'E' for Exit");

                //ANSWER OF THE PLAYER
                dealOrNoDeal = scanner.nextLine();

                if ("D".equals(dealOrNoDeal)) {
                    System.out.println(" ");
                    System.out.println(playerThatIsPickedForTrading + "," + " " + "do you accept this offer?");

                    do {
                        System.out.println(" ");
                        System.out.println("Press 'A' to accept the offer");
                        System.out.println("Press 'N' to decline the offer");

                        //ANSWER OF THE PLAYER
                        acceptOrNoAcceptTheOffer = scanner.nextLine();

                        //ACCEPTING THE OFFER
                        if ("A".equals(acceptOrNoAcceptTheOffer)) {
                            System.out.println(" ");
                            System.out.println("Exchange accept!");

                            List<String> playerProperties;
                            List<Integer> playerLocations;

                            //IF !propertiesThatThePlayerTrade1.isEmpty()
                            if (!propertiesThatThePlayerTrade1.isEmpty()) {
                                tradingActivation = true;

                                System.out.println(" ");
                                System.out.println("---------------------------------------------------------");
                                System.out.println(" ");
                                System.out.println("Properties that" + " " + playerWhoCallsTheTrade + " " + "receive:");

                                //PROPERTIES THAT THE PLAYER WHO CALLS THE TRADE RECEIVE
                                for (String x : propertiesThatThePlayerTrade1) {
                                    System.out.println(x);
                                }

                                for (int s = 0; s < locationsOfPropOfThePlayer1.size(); s++) {
                                    indexOfTheLocation = locationsOfTheProperties.indexOf(locationsOfPropOfThePlayer1.get(s));

                                    //REPLACING THE OWNERS OF THE PROPERTY/IES
                                    ownerOfTheProperty.remove(indexOfTheLocation);
                                    ownerOfTheProperty.add(indexOfTheLocation, playerWhoCallsTheTrade);
                                }

                                //GETTING THE ARRAY LIST OF PROPERTIES OF THE PLAYER
                                playerProperties = propertiesOfPlayers.get(indexOfThePlayer[0]);
                                //GETTING THE ARRAY LIST OF LOCATIONS OF THE PLAYER
                                playerLocations = allLocationsOfThePlayers.get(indexOfThePlayer[0]);

                                //REMOVING THE PROPERTIES THAT THE PLAYER TRADE FROM HIS ARRAY LIST
                                playerProperties.removeAll(propertiesThatThePlayerTrade);
                                //REMOVING THE LOCATIONS THAT THE PLAYER TRADE FROM HIS ARRAY LIST
                                playerLocations.removeAll(locationsOfPropOfThePlayer);

                                //ADDING THE PROPERTIES THAT THE PLAYER WHO IS PICKED FOR TRADING,TRADE
                                playerProperties.addAll(propertiesThatThePlayerTrade1);
                                //ADDING THE LOCATIONS THAT THE PLAYER WHO IS PICKED FOR TRADING,TRADE
                                playerLocations.addAll(locationsOfPropOfThePlayer1);

                                /*System.out.println(" ");
                                System.out.println("Money balance of" + " " + playerWhoCallsTheTrade + ":" + "$" + moneyBalanceOfThePlayer[indexOfThePlayer[0]]);*/
                            }

                            if (moneyWants > 0) {
                                tradingActivation = true;

                                System.out.println(" ");
                                System.out.println("Money that" + " " + playerWhoCallsTheTrade + " " + "receive:");
                                System.out.println("+" + "$" + moneyWants);

                                if (moneyOffers > 0) {
                                    System.out.println(" ");
                                    System.out.println("Money that" + " " + playerWhoCallsTheTrade + " " + "has spent:");
                                    System.out.println("-" + "$" + moneyOffers);
                                }

                                moneyBalanceOfThePlayer[indexOfThePlayer[0]] = moneyBalanceOfThePlayer[indexOfThePlayer[0]] + moneyWants;
                                moneyBalanceOfThePlayer[indexOfThePlayer[0]] = moneyBalanceOfThePlayer[indexOfThePlayer[0]] - moneyOffers;

                                System.out.println(" ");
                                System.out.println("Money balance of" + " " + playerWhoCallsTheTrade + ":" + "$" + moneyBalanceOfThePlayer[indexOfThePlayer[0]]);
                            }

                            System.out.println(" ");
                            System.out.println("---------------------------------------------------------");
                            System.out.println(" ");

                            if (!propertiesThatThePlayerTrade.isEmpty()) {
                                indexOfThePlayer[1] = Player.storeTheNames.indexOf(playerThatIsPickedForTrading);

                                System.out.println("Properties that" + " " + playerThatIsPickedForTrading + " " + "receive:");

                                //PROPERTIES THAT THE PLAYER THAT IS PICKED FOR TRADING RECEIVE
                                for (String y : propertiesThatThePlayerTrade) {
                                    System.out.println(y);
                                }

                                for (int s = 0; s < locationsOfPropOfThePlayer.size(); s++) {
                                    indexOfTheLocation = locationsOfTheProperties.indexOf(locationsOfPropOfThePlayer.get(s));

                                    //REPLACING THE OWNERS OF THE PROPERTY/IES
                                    ownerOfTheProperty.remove(indexOfTheLocation);
                                    ownerOfTheProperty.add(indexOfTheLocation, playerThatIsPickedForTrading);
                                }

                                //GETTING THE ARRAY LIST OF PROPERTIES OF THE PLAYER
                                playerProperties = propertiesOfPlayers.get(indexOfThePlayer[1]);
                                //GETTING THE ARRAY LIST OF LOCATIONS OF THE PLAYER
                                playerLocations = allLocationsOfThePlayers.get(indexOfThePlayer[1]);

                                //REMOVING THE PROPERTIES THAT THE PLAYER TRADE FROM HIS ARRAY LIST
                                playerProperties.removeAll(propertiesThatThePlayerTrade1);
                                //REMOVING THE LOCATIONS THAT THE PLAYER TRADE FROM HIS ARRAY LIST
                                playerLocations.removeAll(locationsOfPropOfThePlayer1);

                                //ADDING THE PROPERTIES THAT THE PLAYER WHO IS PICKED FOR TRADING,TRADE
                                playerProperties.addAll(propertiesThatThePlayerTrade);
                                //ADDING THE LOCATIONS THAT THE PLAYER WHO IS PICKED FOR TRADING,TRADE
                                playerLocations.addAll(locationsOfPropOfThePlayer);

                                /*System.out.println(" ");
                                System.out.println("Money balance of" + " " + playerThatIsPickedForTrading + ":" + "$" + moneyBalanceOfThePlayer[indexOfThePlayer[1]]);*/
                            }

                            if (moneyOffers > 0) {
                                //System.out.println(" ");
                                System.out.println("Money that" + " " + playerThatIsPickedForTrading + " " + "receive:");
                                System.out.println("+" + "$" + moneyOffers);

                                if (moneyWants > 0) {
                                    System.out.println(" ");
                                    System.out.println("Money that" + " " + playerThatIsPickedForTrading + " " + "has spent:");
                                    System.out.println("-" + "$" + moneyWants);
                                }

                                //indexOfThePlayer[1] = Player.storeTheNames.indexOf(playerThatIsPickedForTrading);
                                moneyBalanceOfThePlayer[indexOfThePlayer[1]] = moneyBalanceOfThePlayer[indexOfThePlayer[1]] + moneyOffers;
                                moneyBalanceOfThePlayer[indexOfThePlayer[1]] = moneyBalanceOfThePlayer[indexOfThePlayer[1]] - moneyWants;

                                System.out.println(" ");
                                System.out.println("Money balance of" + " " + playerThatIsPickedForTrading + ":" + "$" + moneyBalanceOfThePlayer[indexOfThePlayer[1]]);
                            }

                            //ACTIVATING THE METHOD ifTheTradingFinish()
                            ifTheTradingFinish();

                            System.out.println(" ");
                            System.out.println("---------------------------------------------------------");
                            //System.out.println(" ");
                            return;

                            //NOT ACCEPTING THE OFFER
                        } else if ("N".equals(acceptOrNoAcceptTheOffer)) {
                            System.out.println(" ");
                            System.out.println("The bid is not accepted!");

                            if (propertiesThatThePlayerTrade.size() > 0) {
                                tradingActivation = true;

                                //RETURNING PROPERTIES THAT THE PLAYER HAS TRADED
                                propertiesOfPlayers.get(indexOfThePlayer[0]).addAll(propertiesThatThePlayerTrade);

                                //PROPERTIES THAT THE PLAYER TRADE
                                propertiesThatThePlayerTrade.removeAll(propertiesThatThePlayerTrade);

                                //LOCATIONS OF PROPERTIES OF THE PLAYER
                                locationsOfPropOfThePlayer.removeAll(locationsOfPropOfThePlayer);

                                //PROPERTIES OF THE PLAYER
                                propOfThePlayer.removeAll(propOfThePlayer);

                            } else {
                                tradingActivation = true;
                            }

                            if (propertiesThatThePlayerTrade1.size() > 0) {

                                //RETURNING PROPERTIES THAT THE PLAYER HAS TRADED
                                propertiesOfPlayers.get(indexOfThePlayer[1]).addAll(propertiesThatThePlayerTrade1);

                                //PROPERTIES THAT THE PLAYER HAS TRADED
                                propertiesThatThePlayerTrade1.removeAll(propertiesThatThePlayerTrade1);

                                //LOCATIONS OF THE PROPERTIES OF THE PLAYER
                                locationsOfPropOfThePlayer1.removeAll(locationsOfPropOfThePlayer1);

                                //PROPERTIES OF THE PLAYER
                                propOfThePlayer1.removeAll(propOfThePlayer1);
                            }

                            //ACTIVATING THE METHOD IF THE TRADING IS FINISH
                            ifTheTradingFinish();
                            return;
                        }

                    } while (true);

                }  else if ("B".equals(dealOrNoDeal)) {
                    //ACTIVATING THE METHOD exitOrGetBackFromTrading()
                    exitOrGetBackFromTrading();

                    //ACTIVATING THE METHOD ifTheTradingFinish()
                    ifTheTradingFinish();
                    break;

                } else if ("E".equals(dealOrNoDeal)) {
                    //ACTIVATING THE METHOD exitOrGetBackFromTrading()
                    exitOrGetBackFromTrading();

                    //ACTIVATING THE METHOD ifTheTradingFinish()
                    ifTheTradingFinish();
                    return;
                }

            } while (true); //!"D".equals(dealOrNoDeal) || !"B".equals(dealOrNoDeal) || !"E".equals(dealOrNoDeal)

            /*System.out.println(" ");
            System.out.println(Player.storeTheNames.get(indexOfThePlayer[0]) + ":" + locationOfThePlayerOnTheBoard);*/

            if (!"A".equals(acceptOrNoAcceptTheOffer) || !"N".equals(acceptOrNoAcceptTheOffer)) {
                System.out.println(" ");
                System.out.println("---------------------------------------------------------");
                //break;
            }

        } while (true);
    }
    public static void moneyOffering(){

        Scanner scanner1 = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Enter the amount of money that you want to offer:");
        System.out.println("Money balance:" + " " + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

        for (; ; ) {

            //MONEY OFFERING
            moneyOffers = scanner1.nextInt();

            if (moneyOffers > moneyBalanceOfThePlayer[playerThatIsPlaying]) {
                System.out.println(" ");
                System.out.println("You can't offer more than:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            } else if (moneyOffers <= 0) {
                System.out.println(" ");
                System.out.println("You must offer more than:" + "$" + "0");

            } else {
                System.out.println(" ");
                System.out.println("Total value offers:" + "$" + (moneyOffers + totalValueOffers));

                //TOTAL VALUE OFFERS
                totalValueOffers = totalValueOffers + moneyOffers;
                break;
            }
        }
    }

    public static void moneyWants() {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Enter the amount of money that you want:");
        System.out.println("Money balance:" + " " + "$" + moneyBalanceOfThePlayer[indexOfThePlayer[1]]);

        for (; ; ) {
            //MONEY WANTS
            moneyWants = scanner1.nextInt();

            if (moneyWants > moneyBalanceOfThePlayer[indexOfThePlayer[1]]) {
                System.out.println(" ");
                System.out.println("You can't ask for more than:" + "$" + moneyBalanceOfThePlayer[indexOfThePlayer[1]]);

            } else if (moneyWants <= 0) {
                System.out.println(" ");
                System.out.println("You can't ask for:" + "$" + "0");

            } else {
                System.out.println(" ");
                System.out.println("Total value wants:" + "$" + (moneyWants + totalValueWants));

                //TOTAL VALUE WANTS
                totalValueWants = totalValueWants + moneyWants;
                break;
            }
        }
    }

    public static void offeringProperty() throws Exception {
        Scanner scanner = new Scanner(System.in);

        for (a = indexOfThePlayerWhoIsPlaying; a < propertiesOfPlayers.size(); a++) {

            //PICKING ARRAY LIST OF A PLAYER
            propertiesOfThePlayer = propertiesOfPlayers.get(a);

            //IF THE PLAYER IS HAVING PROPERTIES
            if (propertiesOfThePlayer.size() != 0) {

                //ACTIVATING THE METHOD playerHavingProperties()
                PlayerHavingProperties.playerHavingProperties();
                break;

                //IF THE PLAYER IS NOT HAVING ANY PROPERTIES
            } else {
                System.out.println(" ");
                //IF playerWants == false
                if (playerWants == false) {
                    System.out.println("You are not owning a property!");
                } else {
                    System.out.println(Player.storeTheNames.get(indexOfThePlayer[1]) + " " + "is not having any property!");
                }

                do {
                    System.out.println(" ");
                    //IF playerWants == false
                    if (playerWants == false) {
                        System.out.println("Press 'M' to offer money");
                        System.out.println("Press 'E' to exit from trading");
                    } else {
                        System.out.println("Press 'M' to ask for money");
                    }

                    //CHECK THIS BECAUSE I CHANGE THE VARIABLE NAME
                    String answerOfThePlayer = scanner.nextLine();

                    if ("M".equals(answerOfThePlayer)) {
                        if (playerWants == false) {
                            moneyOffering();
                            return;

                        } else {
                            moneyWants();
                            return;
                        }

                    } else if ("E".equals(answerOfThePlayer)) {
                        exitFromTrading = true;
                        System.out.println(" ");
                        System.out.println("---------------------------------------------------------");
                        System.out.println(" ");
                        return;
                    }

                } while (true);
            }
            //break;
        }
    }
    public static void exitOrGetBackFromTrading() {

        //IF propertiesThatThePlayerTrade.size() > 0
        if (propertiesThatThePlayerTrade.size() > 0) {
            //RETURNING PROPERTIES THAT THE PLAYER HAS TRADED
            propertiesOfPlayers.get(indexOfThePlayer[0]).addAll(propertiesThatThePlayerTrade);

            //PROPERTIES THAT THE PLAYER TRADE
            propertiesThatThePlayerTrade.removeAll(propertiesThatThePlayerTrade);

            //LOCATIONS OF PROPERTIES OF THE PLAYER
            locationsOfPropOfThePlayer.removeAll(locationsOfPropOfThePlayer);

            //PROPERTIES OF THE PLAYER
            propOfThePlayer.removeAll(propOfThePlayer);
        }

        //IF propertiesThatThePlayerTrade1.size() > 0
        if (propertiesThatThePlayerTrade1.size() > 0) {
            //RETURNING PROPERTIES THAT THE PLAYER HAS TRADED
            propertiesOfPlayers.get(indexOfThePlayer[1]).addAll(propertiesThatThePlayerTrade1);

            //PROPERTIES THAT THE PLAYER HAS TRADED
            propertiesThatThePlayerTrade1.removeAll(propertiesThatThePlayerTrade1);

            //LOCATIONS OF THE PROPERTIES OF THE PLAYER
            locationsOfPropOfThePlayer1.removeAll(locationsOfPropOfThePlayer1);

            //PROPERTIES OF THE PLAYER
            propOfThePlayer1.removeAll(propOfThePlayer1);
        }

        pickedProperties.removeAll(pickedProperties);
        totalValueOffers = 0;
        totalValueWants = 0;
    }

    public static void ifTheTradingFinish() {
        offeringOrWantMoney = false;
        playerWants = false;
        playersToTradeWith.removeAll(playersToTradeWith);
        propertiesThatThePlayerTrade.removeAll(propertiesThatThePlayerTrade);
        propertiesThatThePlayerTrade1.removeAll(propertiesThatThePlayerTrade1);
        pickedProperties.removeAll(pickedProperties);
        totalValueOffers = 0;
        totalValueWants = 0;
        moneyOffers = 0;
        moneyWants = 0;
    }
}
