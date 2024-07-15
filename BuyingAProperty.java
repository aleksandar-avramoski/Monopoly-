import java.util.*;

public class BuyingAProperty extends Monopoly {

    //PROPERTIES OF THE PLAYER 0
    public static ArrayList<String> propertiesOfThePlayer = new ArrayList<>();
    public static ArrayList<Integer> locationsOfThePlayer = new ArrayList<>();
    public static ArrayList<String> propertiesThatHaveAHouse = new ArrayList<>();

    //PROPERTIES OF THE PLAYER 1
    public static ArrayList<String> propertiesOfThePlayer1 = new ArrayList<>();
    public static ArrayList<Integer> locationsOfThePlayer1 = new ArrayList<>();
    public static ArrayList<String> propertiesThatHaveAHouse1 = new ArrayList<>();

    //PROPERTIES OF THE PLAYER 2
    public static ArrayList<String> propertiesOfThePlayer2 = new ArrayList<>();
    public static ArrayList<Integer> locationsOfThePlayer2 = new ArrayList<>();
    public static ArrayList<String> propertiesThatHaveAHouse2 = new ArrayList<>();

    //PROPERTIES OF THE PLAYER 3
    public static ArrayList<String> propertiesOfThePlayer3 = new ArrayList<>();
    public static ArrayList<Integer> locationsOfThePlayer3 = new ArrayList<>();
    public static ArrayList<String> propertiesThatHaveAHouse3 = new ArrayList<>();

    //PROPERTIES OF THE PLAYER 4
    public static ArrayList<String> propertiesOfThePlayer4 = new ArrayList<>();
    public static ArrayList<Integer> locationsOfThePlayer4 = new ArrayList<>();
    public static ArrayList<String> propertiesThatHaveAHouse4 = new ArrayList<>();

    //PROPERTIES OF THE PLAYER 5
    public static ArrayList<String> propertiesOfThePlayer5 = new ArrayList<>();
    public static ArrayList<Integer> locationsOfThePlayer5 = new ArrayList<>();
    public static ArrayList<String> propertiesThatHaveAHouse5 = new ArrayList<>();
    public static int colorIndex;
    public static Integer[] housesOfThePlayer = new Integer[6];
    public static Integer[] hotelsOfThePlayer = new Integer[6];
    public static ArrayList<Integer> locationsOfPropertiesWithHouse = new ArrayList<>();
    public static ArrayList<Integer> locationsOfPropertiesWithHotel = new ArrayList<>();
    public static Integer[] originalSizeOfTheColorSet = new Integer[7];
    public static ArrayList<String> propertiesWith4Houses = new ArrayList<>();
    public static ArrayList<String> propertiesThatAreHavingAHouse = new ArrayList<>();
    public static List<List<String>> pickedPropertyGroup;
    public static int pickAColorSet;

    public static String property;
    public static ArrayList<String> propertiesWithHotel = new ArrayList<>();
    private static String buyingAHouse;
    public static boolean codeForBuyingAHotel = false;
    private static String buyingAHotel;
    private static ArrayList <Integer> indexesOfThePlayersThatBuysAHouseOrHotel;
    private static ArrayList<Integer> colorIndexes;
    public static List<ArrayList<String>> colorProperties;
    public static List<ArrayList<String>> secondColorProperties;
    public static List<String> listOfThePlayer;
    public static ArrayList<String> completedColorSets = new ArrayList<>();
    private static int desiredIndexOfThePlayer;
    private static int counter;
    public static Integer[] assetsOfTheProperty = new Integer[40];
    public static boolean messageAboutBuyingAHouseOrHotel = false;
    public static Integer[] completedColorSet = new Integer[7];
    public static Integer[] playerThatBoughtAHouse = new Integer[7];
    public static int indexOfThePlayerForBuyingHouse;
    private static ArrayList<String> colorSet;
    public static boolean exitFromTheColorSet = false;

    //BUYING PROPERTY
    public static void propertyBuying() throws Exception {

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //NEW POSITION
        BoardSquare newPosition = square[locationOfThePlayer[playerThatIsPlaying] + rollTotal];

        //THE PLAYER BECOMES AN OWNER OF THE PROPERTY
        ownerOfTheLocation[playerThatIsPlaying] = locationOfThePlayer[playerThatIsPlaying] + rollTotal;

        //THE PROPERTY IS ADDED TO THE LOCATIONS
        if (!locationsOfTheProperties.contains(locationOfThePlayer[playerThatIsPlaying] + rollTotal)) {
            locationsOfTheProperties.add(locationOfThePlayer[playerThatIsPlaying] + rollTotal);
            propertyThatThePlayerOwns[playerThatIsPlaying] = newPosition.getName();
        }

        //IF THE AUCTION ACTIVATION == FALSE
        if (Auction.auctionActivation == false) {
            //THE OWNER IS ADDED TO THE ARRAY LIST
            ownerOfTheProperty.add(Player.storeTheNames.get(playerThatIsPlaying));
        }

        //INDEX OF AN OWNER ADDED INTO PLAYER WHO BOUGHT THE PROPERTY
        playerWhoBoughtTheProperty.add(playerThatIsPlaying);

        //IF THE AUCTION ACTIVATION == TRUE
        if (Auction.auctionActivation == true) {
            if (Auction.indexOfThePlayerWhoWinsTheAuction == 0) {
                playerProperties();
            } else if (Auction.indexOfThePlayerWhoWinsTheAuction == 1) {
                player1Properties();
            } else if (Auction.indexOfThePlayerWhoWinsTheAuction == 2) {
                player2Properties();
            } else if (Auction.indexOfThePlayerWhoWinsTheAuction == 3) {
                player3Properties();
            } else if (Auction.indexOfThePlayerWhoWinsTheAuction == 4) {
                player4Properties();
            } else if (Auction.indexOfThePlayerWhoWinsTheAuction == 5) {
                player5Properties();
            }

        } else {
            if (playerThatIsPlaying == 0) {
                playerProperties();
            } else if (playerThatIsPlaying == 1) {
                player1Properties();
            } else if (playerThatIsPlaying == 2) {
                player2Properties();
            } else if (playerThatIsPlaying == 3) {
                player3Properties();
            } else if (playerThatIsPlaying == 4) {
                player4Properties();
            } else if (playerThatIsPlaying == 5) {
                player5Properties();
            }
        }
    }

    //PROPERTIES OF THE PLAYER
    public static void propertiesOfThePlayer() {

        if (playerThatIsPlaying == 0) {

            //LIST OF THE PLAYER
            listOfThePlayer = propertiesOfThePlayer;

            //IF THE LIST OF THE PLAYER IS EMPTY
            if (propertiesOfThePlayer.size() == 0) {
                System.out.println("You don't have any properties.");

            } else {
                counter = 1;
                for (String x : propertiesOfThePlayer) {
                    System.out.println(counter + "-" + x);
                    counter++;
                }
            }

        } else if (playerThatIsPlaying == 1) {

            //LIST OF THE PLAYER
            listOfThePlayer = propertiesOfThePlayer1;

            //IF THE LIST OF THE PLAYER IS EMPTY
            if (propertiesOfThePlayer1.size() == 0) {
                System.out.println("You don't have any properties.");

            } else {
                counter = 1;
                for (String x : propertiesOfThePlayer1) {
                    System.out.println(counter + "-" + x);
                    counter++;
                }
            }

        } else if (playerThatIsPlaying == 2) {

            //LIST OF THE PLAYER
            listOfThePlayer = propertiesOfThePlayer2;

            //IF THE LIST OF THE PLAYER IS EMPTY
            if (propertiesOfThePlayer2.size() == 0) {
                System.out.println("You don't have any properties.");

            } else {
                counter = 1;
                for (String x : propertiesOfThePlayer2) {
                    System.out.println(counter + "-" + x);
                    counter++;
                }
            }

        } else if (playerThatIsPlaying == 3) {

            //LIST OF THE PLAYER
            listOfThePlayer = propertiesOfThePlayer3;

            //IF THE LIST OF THE PLAYER IS EMPTY
            if (propertiesOfThePlayer3.size() == 0) {
                System.out.println("You don't have any properties.");

            } else {
                counter = 1;
                for (String x : propertiesOfThePlayer3) {
                    System.out.println(counter + "-" + x);
                    counter++;
                }
            }

        } else if (playerThatIsPlaying == 4) {

            //LIST OF THE PLAYER
            listOfThePlayer = propertiesOfThePlayer4;

            //IF THE LIST OF THE PLAYER IS EMPTY
            if (propertiesOfThePlayer4.size() == 0) {
                System.out.println("You don't have any properties.");

            } else {
                counter = 1;
                for (String x : propertiesOfThePlayer4) {
                    System.out.println(counter + "-" + x);
                    counter++;
                }
            }

        } else if (playerThatIsPlaying == 5) {

            //LIST OF THE PLAYER
            listOfThePlayer = propertiesOfThePlayer5;

            //IF THE LIST OF THE PLAYER IS EMPTY
            if (propertiesOfThePlayer5.size() == 0) {
                System.out.println("You don't have any properties.");

            } else {
                counter = 1;
                for (String x : propertiesOfThePlayer5) {
                    System.out.println(counter + "-" + x);
                    counter++;
                }
            }
        }
    }

    //CHECK IF THE PLAYER CAN BUY A HOUSE
    public void checkIfThePlayerCanBuyAHouse() throws Exception {

        BoardSquare[] square = new BoardSquare[40];
        PropertiesFromTheBoard.loadArray(square);

        //GROUPING PROPERTIES IN A COLOR SET
        GroupingProperties.colorSet();

        //COLOR PROPERTIES (ALL COLORS OF THE PROPERTIES)
        colorProperties = Arrays.asList(
                GroupingProperties.redColor,
                GroupingProperties.whiteColor,
                GroupingProperties.blueColor,
                GroupingProperties.pinkColor,
                GroupingProperties.brownColor,
                GroupingProperties.yellowColor,
                GroupingProperties.purpleColor,
                GroupingProperties.blackColor
        );

        //SECOND COLOR PROPERTIES (ALL COLORS OF THE PROPERTIES)
        secondColorProperties = Arrays.asList(
                GroupingProperties.redColor1,
                GroupingProperties.whiteColor1,
                GroupingProperties.blueColor1,
                GroupingProperties.pinkColor1,
                GroupingProperties.brownColor1,
                GroupingProperties.yellowColor1,
                GroupingProperties.purpleColor1,
                GroupingProperties.blackColor1
        );

        //COLOR INDEXES
        colorIndexes = new ArrayList<>();

        //INDEXES OF THE PLAYERS THAT BUYS HOUSE OR HOTEL
        indexesOfThePlayersThatBuysAHouseOrHotel = new ArrayList<>();

        //IF MESSAGE ABOUT BUYING A HOUSE OR HOTEL IS SHOWN
        messageAboutBuyingAHouseOrHotel = false;

        for (ArrayList<String> colorSet : secondColorProperties) {

            //COLOR SET
            this.colorSet = colorSet;

            //IF TRADING ACTIVATION == TRUE
            if (Trade.tradingActivation == true) {
                if (propertiesOfPlayers.get(Trade.indexOfThePlayer[0]).containsAll(colorSet)) {
                    //IF THE PLAYER CAN BUY A HOUSE
                    IfThePlayerCanBuyAHouse();
                }

            } else {
                if (propertiesOfPlayers.get(playerThatIsPlaying).containsAll(colorSet)) {
                    //IF THE PLAYER CAN BUY A HOUSE
                    IfThePlayerCanBuyAHouse();
                }
            }
        }

        //DESIRED INDEX OF THE PLAYER
        desiredIndexOfThePlayer = indexOfThePlayerForBuyingHouse;
    }

    //BUYING A HOUSE
    public static void buyingAHouse() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //EXIT OF THE COLOR SET == FALSE
        //exitFromTheColorSet = false;

        //IF THE PLAYER HAS COMPLETED COLOR SET
        if (completedColorSet[indexOfThePlayerForBuyingHouse] > 0) {

            //IF "H" IS EQUALS TO ANSWER OF THE PLAYER
            if ("H".equals(answerOfThePlayer)) {
                System.out.println(" ");
                for (; ; ) {
                    System.out.println("Pick the color set where you want to buy a house or hotel:");

                    exitFromTheColorSet = false;

                    //COLOR SETS THAT THE PLAYER HAVE
                    counter = 1;
                    for (int d = 0; d < indexesOfThePlayersThatBuysAHouseOrHotel.size(); d++) {

                        //IF DESIRED INDEX OF THE PLAYER HAS COMPLETED A COLOR SET
                        if (indexesOfThePlayersThatBuysAHouseOrHotel.get(d) == desiredIndexOfThePlayer) {
                            //GETTING THE COLOR SETS THAT THE PLAYER OWNS
                            System.out.println(counter + "-" + GroupingProperties.colorsInTheGame[colorIndexes.get(d)]);
                        }
                        counter++;
                    }

                    System.out.println(" ");
                    System.out.println("Press 'E' if you don't want to pick any color set.");

                    //CONFORM PICKING A COLOR SET = FALSE
                    boolean conformPickingAColorSet = false;

                    do {
                        //INPUT
                        String input = scanner.nextLine();

                        //IF INPUT IS EMPTY
                        if (input.isEmpty()) {
                            input = scanner.nextLine();
                        }

                        //IF INPUT IS EQUAL TO "E"
                        if (input.equals("E")) {
                            return;

                        } else {
                            try {
                                //PICKING A COLOR SET
                                pickAColorSet = Integer.parseInt(input);

                                if (pickAColorSet <= counter - 1 && pickAColorSet != 0) {
                                    conformPickingAColorSet = true;
                                } else {
                                    conformPickingAColorSet = false;
                                }

                                //IF EXIT OF THE COLOR SET == FALSE
                                if (exitFromTheColorSet == false) {
                                    codeForBuyingAHotel = false;
                                }

                            } catch (NumberFormatException e) {
                                System.out.println(" ");
                                System.out.println("Invalid input. Please enter a number" + " " + "or 'E'.");
                                continue;
                            }
                        }

                        if (conformPickingAColorSet == false) {
                            System.out.println(" ");
                            if (counter == 2) {
                                System.out.println("Invalid input. Please enter the number 1 to pick a color set");
                            } else {
                                System.out.println("Invalid input. Please enter a number between 1 and" + " " + (counter - 1));
                            }
                        }
                    } while (conformPickingAColorSet == false);

                    //IS MESSAGE PRINT ABOUT BUYING A HOUSE = FALSE
                    boolean isMessagePrintAboutBuyingAHouse = false;
                    boolean isMessagePrintAboutBuyingAHouse1 = false;

                    for(;;) {
                        int s;
                        //IF ARRAY LIST propertiesWith4Houses DOESN'T CONTAIN THE PICKED PROPERTY FROM THE PLAYER
                        if (!propertiesWith4Houses.containsAll(secondColorProperties.get(colorIndexes.get(pickAColorSet - 1)))) {

                            //IF IS MESSAGE PRINT ABOUT BUYING A HOUSE == FALSE
                            if (isMessagePrintAboutBuyingAHouse == false) {
                                System.out.println(" ");
                                System.out.println("You have no option to buy a hotel for properties inside this color set!");
                                System.out.println("You need to have 4 houses on each property in the same color set to buy a hotel.");
                            }

                            System.out.println(" ");
                            System.out.println("Pick the property where you want to buy a house:");

                            //PICKING THE PROPERTY WHERE THE PLAYER WANT TO BUY A HOUSE
                            for (s = 0; s < colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size(); s++) {

                                //PROPERTIES THAT ARE PICKED
                                pickedPropertyGroup = Arrays.asList(
                                        propertiesThatHaveAHouse,
                                        propertiesThatHaveAHouse1,
                                        propertiesThatHaveAHouse2,
                                        propertiesThatHaveAHouse3,
                                        propertiesThatHaveAHouse4,
                                        propertiesThatHaveAHouse5
                                );

                                //REMOVING THE PROPERTY FROM THE COLOR SET
                                if (pickedPropertyGroup.get(indexOfThePlayerForBuyingHouse).contains(colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s))) {

                                    //REMOVING THE PROPERTY FROM THE LIST
                                    String propertyThatIsRemoved = colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s);
                                    colorProperties.get(colorIndexes.get(pickAColorSet - 1)).remove(s);

                                    //REMOVING THE PROPERTY FROM THE LIST
                                    pickedPropertyGroup.get(indexOfThePlayerForBuyingHouse).remove(propertyThatIsRemoved);
                                }

                                //RETURNING THE PROPERTIES OF THE COLOR SET THAT HAVE AT LEAST ONE HOUSE
                                if (colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size() == 0) {
                                    for (int d = 0; d < secondColorProperties.get(colorIndexes.get(pickAColorSet - 1)).size(); d++) {
                                        colorProperties.get(colorIndexes.get(pickAColorSet - 1)).add(secondColorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(d));
                                        System.out.println((d + 1) + "-" + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(d));
                                    }

                                    break;

                                } else {

                                    //PRINTING THE PROPERTY THAT IS LEFT
                                    if (colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size() == 1) {
                                        if (s == 0) {
                                            System.out.println(1 + "-" + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s));
                                        }

                                    } else {
                                        //PRINTING THE PROPERTIES FROM THE COLOR SET
                                        if (s < colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size()) {
                                            System.out.println((s + 1) + "-" + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s));

                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }

                            //IS MESSAGE PRINT ABOUT BUYING A HOUSE = TRUE
                            isMessagePrintAboutBuyingAHouse = true;

                        } else {
                            //IF propertiesWithHotel DOESN'T CONTAIN THE PROPERTY THAT THE PLAYER PICKED
                            if (!propertiesWithHotel.containsAll(colorProperties.get(colorIndexes.get(pickAColorSet - 1)))) {

                                if (isMessagePrintAboutBuyingAHouse1 == false) {
                                    System.out.println(" ");
                                    System.out.println("You have 4 houses on each of the properties in the color set!");
                                    System.out.println("You can buy a hotel for the property that you want.");
                                }

                                System.out.println(" ");
                                System.out.println("Pick the property where you want to buy a hotel:");

                                for (s = 0; s < colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size(); s++) {

                                    for (String d: secondColorProperties.get(colorIndexes.get(pickAColorSet - 1))) {
                                        if (propertiesWithHotel.contains(d)) {
                                            codeForBuyingAHotel = true;
                                        }
                                    }

                                    if (codeForBuyingAHotel == false) {
                                        //REMOVING THE PROPERTY FROM THE COLOR SET
                                        String propertyThatIsRemoved = colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s);
                                        colorProperties.get(colorIndexes.get(pickAColorSet - 1)).remove(s);

                                        //REMOVING THE PROPERTY FROM THE LIST
                                        pickedPropertyGroup.get(playerThatIsPlaying).remove(propertyThatIsRemoved);

                                    } else {
                                        if (propertiesWithHotel.contains(colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s))) {
                                            //REMOVING THE PROPERTY FROM THE COLOR SET
                                            String propertyThatIsRemoved = colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s);
                                            colorProperties.get(colorIndexes.get(pickAColorSet - 1)).remove(s);

                                            //REMOVING THE PROPERTY FROM THE LIST
                                            pickedPropertyGroup.get(indexOfThePlayerForBuyingHouse).remove(propertyThatIsRemoved);
                                        }
                                    }

                                    //RETURNING THE PROPERTIES OF THE COLOR SET THAT HAVE AT LEAST ONE HOUSE
                                    if (colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size() == 0) {
                                        for (int d = 0; d < secondColorProperties.get(colorIndexes.get(pickAColorSet - 1)).size(); d++) {
                                            colorProperties.get(colorIndexes.get(pickAColorSet - 1)).add(secondColorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(d));
                                            System.out.println((d + 1) + "-" + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(d));
                                        }

                                        break;

                                    } else {
                                        //PRINTING THE PROPERTY THAT IS LEFT
                                        if (colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size() == 1) {
                                            if (s == 0) {
                                                System.out.println(1 + "-" + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s));
                                            }

                                        } else {
                                            //PRINTING THE PROPERTIES
                                            if (s < colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size()) {
                                                System.out.println((s + 1) + "-" + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(s));
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }

                                isMessagePrintAboutBuyingAHouse1 = true;

                            } else {
                                System.out.println(" ");
                                System.out.println("You have bought maximum houses and hotels for all your properties in this color set.");
                                System.out.println(" ");
                                break;
                            }
                        }

                        int pickAProperty;
                        do {
                            //PICKING A PROPERTY
                            pickAProperty = scanner.nextInt();

                            if (pickAProperty <= 0 || pickAProperty > colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size()) {

                                if (colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size() == 1) {
                                    System.out.println(" ");
                                    System.out.println("Invalid input. Please enter the number 1 to pick a property");

                                } else {
                                    System.out.println(" ");
                                    System.out.println("Invalid input. Please enter a number between 1 and" + " " + colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size());
                                }
                            }

                        } while (pickAProperty <= 0 || pickAProperty > colorProperties.get(colorIndexes.get(pickAColorSet - 1)).size());

                        for (int d = 0; d < 40; d++) {
                            BoardSquare newPosition = square[d];

                            //IF THE NAME OF THE PROPERTY EQUALS TO THE NAME OF THE PICKED PROPERTY
                            if (newPosition.getName().equals(colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(pickAProperty - 1))) {

                                //IF propertiesWith4Houses DOESN'T CONTAIN THE PICKED PROPERTY
                                if (!propertiesWith4Houses.contains(colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(pickAProperty - 1))) {
                                    System.out.println(" ");
                                    System.out.println("Price for a house in" + " " + square[d].getName() + " " + "is:" + "$" + square[d].getHouseCost());
                                    System.out.println(" ");

                                    //LESS MONEY IN BANK ACCOUNT = FALSE
                                    boolean lessMoneyInBankAccount = false;

                                    do {
                                        //IF THE MONEY BALANCE OF THE PLAYER IS LESS THAN THE COST OF THE HOUSE
                                        if (moneyBalanceOfThePlayer[indexOfThePlayerForBuyingHouse] < square[d].getHouseCost()) {
                                            System.out.println("You don't have enough money to buy a house for this property.");
                                            System.out.println(" ");
                                            System.out.println("Press 'Enter' for back");
                                            System.out.println("Press 'E' to exit from the color set");

                                            //LESS MONEY IN BANK ACCOUNT = TRUE
                                            lessMoneyInBankAccount = true;

                                        } else {
                                            System.out.println("Press 'B' to buy a house");
                                            System.out.println("Press 'Enter' for back");
                                            System.out.println("Press 'E' to exit from the color set");
                                        }

                                        //BUYING A HOUSE
                                        buyingAHouse = scanner1.nextLine();

                                        //IF LESS MONEY IN BANK ACCOUNT = FALSE
                                        if (lessMoneyInBankAccount == false) {

                                            //IF BUYING A HOUSE IS EQUAL TO "B"
                                            if ("B".equals(buyingAHouse)) {
                                                System.out.println(" ");
                                                System.out.println("You own a house in" + " " + square[d].getName() + "!");

                                                //SHOWING THAT THE PLAYER HAS BOUGHT A HOUSE
                                                playerThatBoughtAHouse[playerThatIsPlaying] = 1;

                                                //MONEY BALANCE OF THE PLAYER
                                                moneyBalanceOfThePlayer[indexOfThePlayerForBuyingHouse] = moneyBalanceOfThePlayer[indexOfThePlayerForBuyingHouse] - square[d].getHouseCost();

                                                //PROPERTY
                                                property = square[d].getName();

                                                //LOCATIONS OF PROPERTIES WITH A HOUSE
                                                locationsOfPropertiesWithHouse.add(d);

                                                //ADDING PROPERTIES INTO THE ARRAY LIST propertiesThatAreHavingAHouse
                                                propertiesThatAreHavingAHouse.add(square[d].getName());

                                                //ADDING THE PROPERTY
                                                addingProperties();

                                                //FREQUENCY OF THE PROPERTY
                                                Integer[] frequency = new Integer[7];
                                                frequency[indexOfThePlayerForBuyingHouse] = Collections.frequency(propertiesThatAreHavingAHouse, square[d].getName());

                                                int locationOfTheProperty = 0;

                                                for (int g = 0; g < locationsOfPropertiesWithHouse.size(); g++) {

                                                    //LOCATION OF THE PROPERTY
                                                    locationOfTheProperty = locationsOfPropertiesWithHouse.get(g);

                                                    if (locationOfTheProperty == d) {
                                                        assetsOfTheProperty[locationOfTheProperty] = frequency[indexOfThePlayerForBuyingHouse];
                                                        //System.out.println("Assets of the property:" + assetsOfTheProperty[locationOfTheProperty]);
                                                        System.out.println("Houses that" + " " + square[d].getName() + " " + "has:" + assetsOfTheProperty[locationOfTheProperty]);
                                                        break;
                                                    }
                                                }

                                                if (frequency[indexOfThePlayerForBuyingHouse] == 4) {
                                                    //ADDING THE PROPERTY INTO ARRAY LIST PROPERTIES WITH 4 HOUSES
                                                    propertiesWith4Houses.add(square[d].getName());

                                                    //NUMBER OF ASSETS THAT THE PROPERTY CONTAINS
                                                    assetsOfTheProperty[locationOfTheProperty] = frequency[indexOfThePlayerForBuyingHouse];
                                                    //break;
                                                }

                                                //NUMBER OF HOUSES THAT THE PLAYER OWNS
                                                if (housesOfThePlayer[indexOfThePlayerForBuyingHouse] == null) {
                                                    housesOfThePlayer[indexOfThePlayerForBuyingHouse] = 0;
                                                }

                                                //NUMBER OF HOUSES OF THE PLAYER
                                                housesOfThePlayer[indexOfThePlayerForBuyingHouse] = housesOfThePlayer[indexOfThePlayerForBuyingHouse] + 1;
                                                break;

                                                //IF BUYING A HOUSE IS EQUAL TO "E"
                                            } else if ("E".equals(buyingAHouse)) {
                                                exitFromTheColorSet = true;
                                                break;

                                                //IF BUYING A HOUSE IS EMPTY
                                            } else if (buyingAHouse.isEmpty()) {
                                                break;
                                            }

                                        } else {
                                            //IF BUYING A HOUSE IS EQUAL TO "E"
                                            if ("E".equals(buyingAHouse)) {
                                                exitFromTheColorSet = true;
                                                break;

                                                //IF BUYING A HOUSE IS EMPTY
                                            } else if (buyingAHouse.isEmpty()) {
                                                break;
                                            }
                                        }

                                        System.out.println(" ");

                                    } while (true);

                                } else {
                                    //IF propertiesWith4Houses CONTAINS THE PICKED PROPERTY
                                    if (propertiesWith4Houses.contains(colorProperties.get(colorIndexes.get(pickAColorSet - 1)).get(pickAProperty - 1))) {
                                        System.out.println(" ");
                                        System.out.println("Price for a hotel in" + " " + square[d].getName() + " " + "is:" + "$" + square[d].getHotelCost());
                                        System.out.println(" ");

                                        //LESS MONEY IN BANK ACCOUNT = FALSE
                                        boolean lessMoneyInBankAccount = false;

                                        do {
                                            //IF THE MONEY BALANCE OF THE PLAYER IS LESS THAN THE COST OF THE HOTEL
                                            if (moneyBalanceOfThePlayer[indexOfThePlayerForBuyingHouse] < square[d].getHotelCost()) {
                                                System.out.println("You don't have enough money to buy a hotel for this property.");
                                                System.out.println(" ");
                                                System.out.println("Press 'Exit' for back");
                                                System.out.println("Press 'E' to exit from the color set");

                                                //LESS MONEY IN BANK ACCOUNT = TRUE
                                                lessMoneyInBankAccount = true;

                                            } else {
                                                System.out.println("Press 'B' to buy a hotel");
                                                System.out.println("Press 'Exit' for back");
                                                System.out.println("Press 'E' to exit from the color set");
                                            }

                                            //BUYING A HOTEL
                                            buyingAHotel = scanner1.nextLine();

                                            //IF LESS MONEY IN BANK ACCOUNT
                                            if (lessMoneyInBankAccount == false) {

                                                //BUYING A HOTEL IS EQUAL TO "B"
                                                if ("B".equals(buyingAHotel)) {
                                                    System.out.println(" ");
                                                    System.out.println("You own a hotel in" + " " + square[d].getName() + "!");

                                                    //MONEY BALANCE OF THE PLAYER
                                                    moneyBalanceOfThePlayer[indexOfThePlayerForBuyingHouse] = moneyBalanceOfThePlayer[indexOfThePlayerForBuyingHouse] - square[d].getHotelCost();

                                                    //PROPERTY
                                                    property = square[d].getName();

                                                    //PROPERTY ADDED INTO PROPERTIES WITH A HOTEL
                                                    propertiesWithHotel.add(square[d].getName());

                                                    //LOCATIONS OF PROPERTIES WITH A HOTEL
                                                    locationsOfPropertiesWithHotel.add(d);

                                                    //ADDING THE PROPERTY
                                                    addingProperties();

                                                    for (int g = 0; g < locationsOfPropertiesWithHouse.size(); g++) {

                                                        //LOCATION OF THE PROPERTY
                                                        int locationOfTheProperty = locationsOfPropertiesWithHouse.get(g);

                                                        if (locationOfTheProperty == d) {
                                                            //NUMBER OF ASSETS OF THE PROPERTY
                                                            assetsOfTheProperty[locationOfTheProperty] = 5;
                                                            //break;
                                                        }
                                                    }

                                                    //NUMBER OF HOUSES THAT THE PLAYER OWNS
                                                    if (hotelsOfThePlayer[indexOfThePlayerForBuyingHouse] == null) {
                                                        hotelsOfThePlayer[indexOfThePlayerForBuyingHouse] = 0;
                                                    }

                                                    //NUMBER OF HOTELS OF THE PLAYER
                                                    hotelsOfThePlayer[indexOfThePlayerForBuyingHouse] = hotelsOfThePlayer[indexOfThePlayerForBuyingHouse] + 1;
                                                    //System.out.println("Hotels of the player:" + hotelsOfThePlayer[indexOfThePlayerForBuyingHouse]);

                                                    //CODE FOR BUYING A HOTEL = TRUE
                                                    codeForBuyingAHotel = true;
                                                    break;

                                                    //IF "E" EQUALS buyingAHotel
                                                } else if ("E".equals(buyingAHotel)) {
                                                    codeForBuyingAHotel = true;
                                                    exitFromTheColorSet = true;
                                                    break;

                                                    //IF buyingAHotel IS EMPTY
                                                } else if (buyingAHotel.isEmpty()) {
                                                    codeForBuyingAHotel = true;
                                                    break;
                                                }

                                            } else {
                                                //IF "E" EQUALS buyingAHotel
                                                if ("E".equals(buyingAHotel)) {
                                                    codeForBuyingAHotel = true;
                                                    exitFromTheColorSet = true;
                                                    break;

                                                    //IF BUYING A HOUSE IS EMPTY
                                                } else if (buyingAHotel.isEmpty()) {
                                                    codeForBuyingAHotel = true;
                                                    break;
                                                }
                                            }

                                            System.out.println(" ");

                                        } while (true);
                                    }
                                }
                            }
                        }

                        System.out.println(" ");

                        if (exitFromTheColorSet == true) {
                            break;
                        }

                        /*if ("E".equals(buyingAHouse)) {
                            break;

                        } else if ("E".equals(buyingAHotel)) {
                            exitFromTheColorSet = true;
                            break;
                        }*/
                    }
                }
            }
        }
    }

    //IF THE PLAYER CAN BUY A HOUSE
    public static void IfThePlayerCanBuyAHouse() {
        if (Auction.auctionActivation == true) {
            //HOW MUCH COLOR SETS ARE COMPLETED
            completedColorSet[Trade.indexOfThePlayer[0]] = 1;

            //INDEX OF THE PLAYER FOR BUYING A HOUSE
            indexOfThePlayerForBuyingHouse = Trade.indexOfThePlayer[0];

            //ORIGINAL SIZE OF THE COLOR SET
            originalSizeOfTheColorSet[indexOfThePlayerForBuyingHouse] = secondColorProperties.get(secondColorProperties.indexOf(colorSet)).size();

        } else {
            //HOW MUCH COLOR SETS ARE COMPLETED
            completedColorSet[playerThatIsPlaying] = 1;

            //INDEX OF THE PLAYER FOR BUYING A HOUSE
            indexOfThePlayerForBuyingHouse = playerThatIsPlaying;

            //ORIGINAL SIZE OF THE COLOR SET
            originalSizeOfTheColorSet[playerThatIsPlaying] = secondColorProperties.get(secondColorProperties.indexOf(colorSet)).size();
        }

        //COLOR INDEX
        colorIndex = secondColorProperties.indexOf(colorSet);

        //COLOR INDEX ADDED INTO THE ARRAY LIST COLOR INDEXES
        colorIndexes.add(colorIndex);

        //INDEXES OF THE PLAYERS THAT BUYS HOUSE OR HOTEL
        indexesOfThePlayersThatBuysAHouseOrHotel.add(indexOfThePlayerForBuyingHouse);

        for (int d = 0; d < indexesOfThePlayersThatBuysAHouseOrHotel.size(); d++) {
            if (!completedColorSets.contains(GroupingProperties.colorsInTheGame[colorIndexes.get(d)])) {

                //COLOR SET ADDED INTO COMPLETED COLOR SETS
                completedColorSets.add(GroupingProperties.colorsInTheGame[colorIndexes.get(d)]);
            }
        }

        //IF MESSAGE ABOUT BUYING A HOUSE OR HOTEL IS NOT SHOWN
        if (!messageAboutBuyingAHouseOrHotel) {
            System.out.println("Press 'H' to buy a house or hotel");
            messageAboutBuyingAHouseOrHotel = true;
        }
    }

    //PROPERTIES AND THE LOCATIONS OF THE PLAYER 0
    public static void playerProperties() {
        propertiesOfThePlayer.add(propertyThatThePlayerOwns[playerThatIsPlaying]);
        locationsOfThePlayer.add(ownerOfTheLocation[playerThatIsPlaying]);
    }

    //PROPERTIES AND THE LOCATIONS OF THE PLAYER 1
    public static void player1Properties() {
        propertiesOfThePlayer1.add(propertyThatThePlayerOwns[playerThatIsPlaying]);
        locationsOfThePlayer1.add(ownerOfTheLocation[playerThatIsPlaying]);
    }

    //PROPERTIES AND THE LOCATIONS OF THE PLAYER 3
    public static void player2Properties() {
        propertiesOfThePlayer2.add(propertyThatThePlayerOwns[playerThatIsPlaying]);
        locationsOfThePlayer2.add(ownerOfTheLocation[playerThatIsPlaying]);
    }

    //PROPERTIES AND THE LOCATIONS OF THE PLAYER 4
    public static void player3Properties() {
        propertiesOfThePlayer3.add(propertyThatThePlayerOwns[playerThatIsPlaying]);
        locationsOfThePlayer3.add(ownerOfTheLocation[playerThatIsPlaying]);
    }


    //PROPERTIES AND THE LOCATIONS OF THE PLAYER 5
    public static void player4Properties() {
        propertiesOfThePlayer4.add(propertyThatThePlayerOwns[playerThatIsPlaying]);
        locationsOfThePlayer4.add(ownerOfTheLocation[playerThatIsPlaying]);
    }

    //PROPERTIES AND THE LOCATIONS OF THE PLAYER 6
    public static void player5Properties() {
        propertiesOfThePlayer5.add(propertyThatThePlayerOwns[playerThatIsPlaying]);
        locationsOfThePlayer5.add(ownerOfTheLocation[playerThatIsPlaying]);
    }

    //ADDING PROPERTIES OF THE PLAYER
    public static void addingProperties() {
        if (indexOfThePlayerForBuyingHouse == 0) {
            propertiesThatHaveAHouse.add(property);
        } else if (indexOfThePlayerForBuyingHouse == 1) {
            propertiesThatHaveAHouse1.add(property);
        } else if (indexOfThePlayerForBuyingHouse == 2) {
            propertiesThatHaveAHouse2.add(property);
        } else if (indexOfThePlayerForBuyingHouse == 3) {
            propertiesThatHaveAHouse3.add(property);
        } else if (indexOfThePlayerForBuyingHouse == 4) {
            propertiesThatHaveAHouse4.add(property);
        } else {
            propertiesThatHaveAHouse5.add(property);
        }
    }
}


