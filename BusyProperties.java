import java.util.Scanner;
public class BusyProperties extends Monopoly {

    //PRICE OF THE RENT
    private static int priceOfTheRent = 0;
    public static void busyProperties() throws Exception {

        Scanner scanner = new Scanner(System.in);

        BoardSquare[] square = new BoardSquare[40];
        PropertiesFromTheBoard.loadArray(square);

        //NEW POSITION
        BoardSquare newPosition = square[locationOfThePlayer[playerThatIsPlaying] + rollTotal];

        //INDEX OF THE LOCATION IN THE ARRAY LIST LOCATIONS
        indexOfTheLocation = locationsOfTheProperties.indexOf(locationOfThePlayer[playerThatIsPlaying] + rollTotal);

        //INDEX OF THE PLAYER WHO BOUGHT THE PROPERTY
        int indexOfThePlayer = playerWhoBoughtTheProperty.get(indexOfTheLocation);

        //IF THE OWNER STOPS AT HIS PROPERTY
        if (Player.storeTheNames.get(playerThatIsPlaying).equals(ownerOfTheProperty.get(indexOfTheLocation))) {
            System.out.println("You own this property.");

        } else {

            //IF THE PROPERTY HAS A HOUSE
            if (BuyingAProperty.locationsOfPropertiesWithHouse.contains(locationOfThePlayer[playerThatIsPlaying] + rollTotal)) {

                //IF THE PLAYER HAS A HOTEL
                if (BuyingAProperty.locationsOfPropertiesWithHotel.contains(locationOfThePlayer[playerThatIsPlaying] + rollTotal)) {
                    System.out.println("This property is owned. \nYou must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRentWithHotel() + "!");
                    priceOfTheRent = newPosition.getRentWithHotel();

                } else {
                    //NUMBER OF HOUSES THAT THE PROPERTY HAS
                    int numberOfHousesThatThePropertyHas = 0;

                    //COUNTING THE HOUSES THAT THE PLAYER HAS ON THAT PROPERTY
                    for (int d = 0; d < BuyingAProperty.locationsOfPropertiesWithHouse.size(); d++) {
                        if (BuyingAProperty.locationsOfPropertiesWithHouse.get(d) == locationOfThePlayer[playerThatIsPlaying] + rollTotal) {
                            numberOfHousesThatThePropertyHas++;
                        }
                    }

                    //IF THE NUMBER OF HOUSES THAT THE PROPERTY HAS = 1
                    if (numberOfHousesThatThePropertyHas == 1) {
                        System.out.println("This property is owned. \nBecause the property has 1 house, you must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRentWith1House() + "!");
                        priceOfTheRent = newPosition.getRentWith1House();

                        //IF THE NUMBER OF HOUSES THAT THE PROPERTY HAS = 2
                    } else if (numberOfHousesThatThePropertyHas == 2) {
                        System.out.println("This property is owned. \nBecause the property has 2 houses, you must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRentWith2Houses() + "!");
                        priceOfTheRent = newPosition.getRentWith2Houses();

                        //IF THE NUMBER OF HOUSES THAT THE PROPERTY HAS = 3
                    } else if (numberOfHousesThatThePropertyHas == 3) {
                        System.out.println("This property is owned. \nBecause the property has 3 houses, you must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRentWith3Houses() + "!");priceOfTheRent = newPosition.getRentWith3Houses();
                        priceOfTheRent = newPosition.getRentWith3Houses();

                        //IF THE NUMBER OF HOUSES THAT THE PROPERTY HAS = 4
                    } else if (numberOfHousesThatThePropertyHas == 4) {
                        System.out.println("This property is owned. \nBecause the property has 4 houses, you must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRentWith4Houses() + "!");
                        priceOfTheRent = newPosition.getRentWith4Houses();
                    }
                }

                //COMPLETED COLOR SET
            } else if (BuyingAProperty.completedColorSets.contains(newPosition.getColor())) {
                System.out.println("This property is owned. \nBecause the color set where the property belongs is completed, you must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRentWithColorSet() + "!");
                priceOfTheRent = newPosition.getRentWithColorSet();

            } else {
                if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 5 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 15 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 25 || locationOfThePlayer[playerThatIsPlaying] + rollTotal == 35) {

                    //INDEX OF THE PROPERTY WHO BOUGHT THE RAILROAD
                    indexOfThePlayerWhoBoughtTheRailroad = Player.storeTheNames.indexOf(ownerOfTheProperty.get(indexOfTheLocation));

                    String[] railroads = {"Union Pacific Railroad", "New York Central Railroad", "Northern Pacific Railroad", "Pennsylvania Railroad"};

                    ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] = 0;
                    //System.out.println("Properties of the player:" + propertiesOfPlayers.get(indexOfThePlayerWhoBoughtTheRailroad));
                    for (String x : propertiesOfPlayers.get(indexOfThePlayerWhoBoughtTheRailroad)) {
                        for (String railroad : railroads) {
                            if (x.contains(railroad)) {
                                //OWNED RAILROADS
                                ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] = ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] + 1;
                            }
                        }
                    }

                    //IF THE NUMBER OF RAILROADS THAT THE PLAYER HAS = 1
                    if (ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] == 1) {
                        System.out.println("This railroad is owned. \nYou must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRent() + "!");
                        priceOfTheRent = newPosition.getRent();

                        //IF THE NUMBER OF RAILROADS THAT THE PLAYER HAS = 2
                    } else if (ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] == 2) {
                        System.out.println("This railroad is owned. \nBecause" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "has 2 railroads, you must pay" + " " + "$" + newPosition.getRentWith2Railroads() + "!");
                        priceOfTheRent = newPosition.getRentWith2Railroads();

                        //IF THE NUMBER OF RAILROADS THAT THE PLAYER HAS = 3
                    } else if (ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] == 3) {
                        System.out.println("This railroad is owned. \nBecause" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "has 3 railroads, you must pay" + " " + "$" + newPosition.getRentWith3Railroads() + "!");
                        priceOfTheRent = newPosition.getRentWith3Railroads();

                        //IF THE NUMBER OF RAILROADS THAT THE PLAYER HAS = 4
                    } else if (ownedRailroads[indexOfThePlayerWhoBoughtTheRailroad] == 4) {
                        System.out.println("This railroad is owned. \nBecause" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "has 4 railroads, you must pay" + " " + "$" + newPosition.getRentWith4Railroads() + "!");
                        priceOfTheRent = newPosition.getRentWith4Railroads();
                    }

                } else {
                    //IF THE PLAYER STOPS AT PROPERTY WITHOUT HOUSE OR HOTEL
                    System.out.println("This property is owned. \nYou must pay" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "$" + newPosition.getRent() + "!");
                    priceOfTheRent = newPosition.getRent();
                }
            }

            String pay = null;

            do {
                //IF THE PLAYER HAS LESS MONEY THAN THE PRICE OF THE RENT
                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < priceOfTheRent) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money to pay the rent for this property.");
                    System.out.println(" ");
                    System.out.println("The money balance that you have at this moments is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                    IfThePlayerHasNoMoneyToPay();

                } else {
                    System.out.println(" ");
                    System.out.println("Press 'P' to pay the rent");

                    //ANSWER OF THE PLAYER
                    pay = scanner.nextLine();

                    //PAYING THE RENT
                    if ("P".equals(pay)) {
                        //BALANCE OF THE PLAYER IS DECREASING BY THE PRICE OF THE PROPERTY
                        System.out.println(" ");
                        System.out.println("-" + "$" + priceOfTheRent);
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - priceOfTheRent;
                        System.out.println("Current money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + " $" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        System.out.println(" ");

                        //THE OWNER OF THE PROPERTY IS RECEIVING MONEY FROM THE PLAYER
                        System.out.println("+" + "$" + priceOfTheRent);
                        moneyBalanceOfThePlayer[indexOfThePlayer] = moneyBalanceOfThePlayer[indexOfThePlayer] + priceOfTheRent;
                        System.out.println("Current money balance of" + " " + ownerOfTheProperty.get(indexOfTheLocation) + " " + "is:" + " $" + moneyBalanceOfThePlayer[indexOfThePlayer]);
                        break;

                    } else {
                        System.out.println("Press 'P' to pay the rent");
                    }
                }
            } while (!"P".equals(pay));
        }
    }
}
