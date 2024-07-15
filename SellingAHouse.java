import java.util.ArrayList;
import java.util.Scanner;

public class SellingAHouse extends Monopoly {
    public static void sellingAHouse() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        ArrayList<Integer> locationOfPropertiesWithHouse = new ArrayList<>();
        ArrayList<Integer> houseCost = new ArrayList<>();
        ArrayList<String> propertiesWithHouse = new ArrayList<>();

        for (; ; ) {
            System.out.println(" ");

            int c = 0;
            for (int d = 0; d < 40; d++) {
                BoardSquare position = square[d];

                //PROPERTIES THAT ARE HAVING A HOUSE OR HOTEL
                if (BuyingAProperty.propertiesThatAreHavingAHouse.contains(position.getName())) {
                    if (propertiesOfPlayers.get(playerThatIsPlaying).contains(position.getName())) {
                        c = c + 1;
                        System.out.println(c + "-" + position.getName());

                        //ADDING THE LOCATION OF THE PROPERTY INTO THE ARRAY LIST locationOfPropertiesWithHouse
                        locationOfPropertiesWithHouse.add(d);

                        //ADDING THE NAME OF THE PROPERTY INTO THE ARRAY LIST propertiesWithHouse
                        propertiesWithHouse.add(position.getName());

                        //ADDING THE HOUSE COST OF THE PROPERTY INTO THE ARRAY LIST houseCost
                        houseCost.add(position.getHouseCost());
                    }
                }
            }

            boolean notSellingAHouse = false;

            do {
                System.out.println(" ");
                System.out.println("Pick a property to sell its asset:");

                //PICKING A PROPERTY
                pickingAProperty = scanner1.nextInt();

                if (pickingAProperty <= locationOfPropertiesWithHouse.size()) {
                    break;

                } else {
                    System.out.println("Invalid input number.");
                }

            } while (pickingAProperty <= locationOfPropertiesWithHouse.size());

            //LOCATION OF THE PROPERTY
            int locationOfTheProperty = locationOfPropertiesWithHouse.get(pickingAProperty - 1);

            String sellingAHouse;

            do {
                //IF BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] > 0
                if (BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] > 0) {

                    //IF ASSETS OF THE PROPERTY = 5
                    if (BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] == 5) {
                        System.out.println(" ");
                        System.out.println("Hotels that" + " " + propertiesWithHouse.get(pickingAProperty - 1) + " " + "has:" + 1);
                        System.out.println("Houses that" + " " + propertiesWithHouse.get(pickingAProperty - 1) + " " + "has:" + 4);
                        System.out.println(" ");
                        System.out.println("If you sell the hotel you will receive:" + "$" + (houseCost.get(pickingAProperty - 1) / 2));
                        System.out.println(" ");
                        System.out.println("Do you want to sell the hotel?");

                        //IF ASSETS OF THE PROPERTY < 5
                    } else {
                        System.out.println(" ");
                        System.out.println("Houses that" + " " + propertiesWithHouse.get(pickingAProperty - 1) + " " + "has:" + BuyingAProperty.assetsOfTheProperty[locationOfTheProperty]);
                        System.out.println(" ");
                        System.out.println("If you sell a house, you will receive:" + "$" + (houseCost.get(pickingAProperty - 1) / 2));
                        System.out.println(" ");
                        System.out.println("Do you want to sell a house?");
                    }

                    do {
                        //IF THE PLAYER WANTS TO SELL AN ASSET OR NOT
                        System.out.println(" ");
                        System.out.println("Press 'Y' for yes");
                        System.out.println("Press 'N' for no");

                        //ANSWER OF THE PLAYER
                        sellingAHouse = scanner.nextLine();

                        //IF THE PLAYER WANTS TO SELL AN ASSET
                        if ("Y".equals(sellingAHouse)) {
                            System.out.println(" ");
                            BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] = BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] - 1;
                            System.out.println("+" + "$" + (houseCost.get(pickingAProperty - 1) / 2));

                            //ADDING (houseCost.get(pickingAProperty - 1) / 2) TO THE MONEY BALANCE OF THE PLAYER
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + (houseCost.get(pickingAProperty - 1) / 2);
                            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + ":" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                            System.out.println(" ");
                            System.out.println("---------------------------------------------------------");
                            break;

                            //IF THE PLAYER DOESN'T WANT TO SELL AN ASSET
                        } else if ("N".equals(sellingAHouse)) {
                            System.out.println(" ");
                            System.out.println("---------------------------------------------------------");
                            notSellingAHouse = true;
                            break;
                        }
                    } while (true);

                    if (notSellingAHouse == true) {
                        break;
                    }

                    //IF THE ASSETS OF THE PROPERTIES = 0
                    if (BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] == 0) {
                        break;
                    }

                } else {
                    System.out.println(" ");
                    System.out.println(propertiesWithHouse.get(pickingAProperty - 1) + " " + "doesn't have any house.");
                    break;
                }

            } while (true);

            String decision;

            if (BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] == 0) {
                System.out.println(" ");
            } else {
                System.out.println(" ");
            }

            //CONTINUE..................................
           // if (notSellingAHouse == true || BuyingAProperty.assetsOfTheProperty[locationOfTheProperty] == 0) {
                do {
                    //OPTION FOR THE PLAYER TO EXIT OR TO CONTINUE SELLING PROPERTIES ASSETS
                    System.out.println("Press 'E' to exit");
                    System.out.println("Press 'C' to continue selling properties assets");

                    decision = scanner.nextLine();

                    if ("E".equals(decision)) {
                        locationOfPropertiesWithHouse.removeAll(locationOfPropertiesWithHouse);
                        return;

                    } else if ("C".equals(decision)) {
                        break;
                    }

                } while (true);
            //}
        }
    }
}
