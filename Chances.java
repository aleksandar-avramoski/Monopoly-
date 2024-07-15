import java.util.Random;
import java.util.Scanner;
public class Chances extends Monopoly {

    //CHANCE
    public static String[] chance = new String[16];
    public static void chances() throws Exception {

        chance[0] = "Advanced to 'Go' (Collect $200)!";
        chance[1] = "Advance to New York. If you pass Go, collect $200.";
        chance[2] = "Advance to Rome. If you pass Go, collect $200.";
        chance[3] = "Advance token to the nearest Utility. If unowned, you may buy it from the Bank. If owned, pay owner a rent.";
        chance[4] = "Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner a rent.";
        chance[5] = "Bank pays you dividend of $50.";
        chance[6] = "Get out of Jail Free. This card may be kept until needed.";
        chance[7] = "Go Back 3 Spaces.";
        chance[8] = "Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.";
        chance[9] = "Make general repairs on all your properties: For each house pay $25, for each hotel pay $100.";
        chance[10] = "Take a trip to New York Central Railroad. If you pass Go, collect $200.";
        chance[11] = "Take a walk on the AbuDhabi. Advance token to AbuDhabi.";
        chance[12] = "You have been elected Chairman of the Board. Pay each player $50.";
        chance[13] = "Your building and loan matures. Collect $150.";
        chance[14] = "Parking fine $15.";
        chance[15] = "You have won a crossword competition. Collect $100.";

        Scanner scanner = new Scanner(System.in);

        //RANDOM CHANCE
        int randomChance = new Random().nextInt(chance.length);

        //DISPLAYING THE RANDOM CHANCE
        System.out.println(chance[randomChance]);

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //ADVANCED TO GO
        if (randomChance == 0) {
            System.out.println(" ");
            BoardSquare newPosition = square[0];

            //DISPLAYING THE POSITION 0
            System.out.println(newPosition.getName());
            System.out.println(" ");
            System.out.println("+$200");

            //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //LOCATION OF THE PLAYER = 0
            locationOfThePlayer[playerThatIsPlaying] = 0;
            rollTotal = 0;

            //ADVANCE TO NEW YORK
        } else if (randomChance == 1) {
            //IF THE LOCATION OF THE PLAYER IS MORE THAN 23
            if (locationOfThePlayer[playerThatIsPlaying] > 23) {
                System.out.println(" ");
                System.out.println("+$200");

                //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
                moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
                System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
            }

            //LOCATION OF THE PLAYER = 23
            locationOfThePlayer[playerThatIsPlaying] = 23;
            rollTotal = 0;

            //PROPERTY INFORMATION
            PropertyInformations.propertyInformations();

            //ADVANCE TO ROME
        } else if (randomChance == 2) {
            //IF THE LOCATION OF THE PLAYER IS MORE THAN 16
            if (locationOfThePlayer[playerThatIsPlaying] > 16) {
                System.out.println(" ");
                System.out.println("+$200");

                //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
                moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
                System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
            }

            //LOCATION OF THE PLAYER = 16
            locationOfThePlayer[playerThatIsPlaying] = 16;
            rollTotal = 0;

            //PROPERTY INFORMATION
            PropertyInformations.propertyInformations();

            //ADVANCE TO THE NEAREST UTILITY
        } else if (randomChance == 3) {
            //IF THE LOCATION OF THE PLAYER IS GREATER OR EQUAL TO 0 AND LESS OR EQUAL TO 21
            if (locationOfThePlayer[playerThatIsPlaying] + rollTotal >= 0 && locationOfThePlayer[playerThatIsPlaying] + rollTotal <= 21) {
                BoardSquare newPosition = square[12];

                //DISPLAYING THE POSITION 12
                System.out.println(" ");
                System.out.println("Name:" + newPosition.getName());
                System.out.println("Type:" + newPosition.getType());
                System.out.println("Price:" + "$" + newPosition.getPrice());
                System.out.println("Rent:" + "$" + newPosition.getRent());
                System.out.println("------------------------------------");
                System.out.println("Mortgage Value:" + "$" + newPosition.getMortgageValue());

                //LOCATION OF THE PLAYER = 12
                locationOfThePlayer[playerThatIsPlaying] = 12;
                rollTotal = 0;

                //BUYING A PROPERTY
                ProcessOfBuyingAProperty.buyingAProperty();

            } else {
                BoardSquare newPosition = square[28];

                //DISPLAYING THE POSITION 28
                System.out.println(" ");
                System.out.println("Name:" + newPosition.getName());
                System.out.println("Type:" + newPosition.getType());
                System.out.println("Price:" + "$" + newPosition.getPrice());
                System.out.println("Rent:" + "$" + newPosition.getRent());
                System.out.println("------------------------------------");
                System.out.println("Mortgage Value:" + "$" + newPosition.getMortgageValue());

                //LOCATION OF THE PLAYER = 28
                locationOfThePlayer[playerThatIsPlaying] = 28;
                rollTotal = 0;

                //BUYING A PROPERTY
                ProcessOfBuyingAProperty.buyingAProperty();
            }
        }

        //ADVANCE TO THE NEAREST RAILROAD
        if (randomChance == 4) {
            //IF THE LOCATION OF THE PLAYER IS GREATER OR EQUAL TO 0 AND LESS OR EQUAL TO 9
            if (locationOfThePlayer[playerThatIsPlaying] + rollTotal >= 0 && locationOfThePlayer[playerThatIsPlaying] + rollTotal <= 9) {
                //LOCATION OF THE PLAYER = 5
                locationOfThePlayer[playerThatIsPlaying] = 5;
                rollTotal = 0;

                //RAILROAD INFORMATION
                RailroadInformations.railroadInformations();

                //IF THE LOCATION OF THE PLAYER IS GREATER OR EQUAL TO 10 AND LESS OR EQUAL TO 19
            } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal >= 10 && locationOfThePlayer[playerThatIsPlaying] + rollTotal <= 19) {
                locationOfThePlayer[playerThatIsPlaying] = 15;
                rollTotal = 0;

                //RAILROAD INFORMATION
                RailroadInformations.railroadInformations();

                //IF THE LOCATION OF THE PLAYER IS GREATER OR EQUAL TO 20 AND LESS OR EQUAL TO 29
            } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal >= 20 && locationOfThePlayer[playerThatIsPlaying] + rollTotal <= 29) {
                //LOCATION OF THE PLAYER = 25
                locationOfThePlayer[playerThatIsPlaying] = 25;
                rollTotal = 0;

                //RAILROAD INFORMATION
                RailroadInformations.railroadInformations();

            } else {
                //LOCATION OF THE PLAYER = 35
                locationOfThePlayer[playerThatIsPlaying] = 35;
                rollTotal = 0;

                //RAILROAD INFORMATION
                RailroadInformations.railroadInformations();
            }

            //DIVIDEND OF $50
        } else if (randomChance == 5) {
            System.out.println(" ");
            System.out.println("+$50");

            //ADDING $50 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 50;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //GETTING OUT OF THE JAIL
        } else if (randomChance == 6) {
            cardToGetOutFromJail[playerThatIsPlaying] = 1;

            //GO BACK 3 STEPS
        } else if (randomChance == 7) {
            for (int x = 1; x <= 3; x++) {
                Thread.sleep(300);
                System.out.println(x);
            }

            //IF THE LOCATION OF THE PLAYER IS 7
            if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 7) {
                BoardSquare newPosition = square[4];
                System.out.println(" ");

                //DISPLAYING THE POSITION 4
                System.out.println(newPosition.getName());
                System.out.println("You owe $" + newPosition.getPrice() + "!");

                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < 50) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money to pay the Income Tax");

                    //IF THE PLAYER HAS NO MONEY TO PAY
                    Monopoly.IfThePlayerHasNoMoneyToPay();

                } else {

                    String payTheIncomeTax;
                    do {
                        //PAYING THE INCOME TAX
                        System.out.println(" ");
                        System.out.println("Press 'P' to pay");

                        //ANSWER OF THE PLAYER
                        payTheIncomeTax = scanner.nextLine();

                        if ("P".equals(payTheIncomeTax)) {
                            System.out.println(" ");
                            System.out.println("-$50");

                            //SUBTRACTING $50 FROM THE MONEY BALANCE OF THE PLAYER
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - newPosition.getPrice();
                            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }

                    } while (!"P".equals(payTheIncomeTax));
                }

                //LOCATION OF THE PLAYER = 4
                locationOfThePlayer[playerThatIsPlaying] = 4;
                rollTotal = 0;

                //IF THE LOCATION OF THE PLAYER IS 36
            } else if (locationOfThePlayer[playerThatIsPlaying] + rollTotal == 36) {
                BoardSquare newPosition = square[33];
                System.out.println(" ");

                //DISPLAYING  THE POSITION 33
                System.out.println(newPosition.getName());

                //communityChests() METHOD
                CommunityChest randomComChest = new CommunityChest();
                randomComChest.communityChests();

                //LOCATION OF THE PLAYER = 33
                locationOfThePlayer[playerThatIsPlaying] = 33;
                rollTotal = 0;

            } else {
                //LOCATION OF THE PLAYER = 19
                locationOfThePlayer[playerThatIsPlaying] = 19;
                rollTotal = 0;

                //PROPERTY INFORMATION
                PropertyInformations.propertyInformations();
            }

            //GO TO JAIL
        } else if (randomChance == 8) {
            BoardSquare newPosition = square[10];
            System.out.println(" ");

            //SHOWING THE POSITION 10
            System.out.println(newPosition.getName());

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

            //MAKE REPAIRS OF ALL YOUR PROPERTIES
        } else if (randomChance == 9) {
            //IF THE PROPERTY DOESN'T HAVE ANY HOUSE
            if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] == null) {
                System.out.println(" ");
                System.out.println("You don't have a house or hotel!");
                return;
            }

            int hotelsThatThePlayerHas = 0;

            for (int i = 0; i < propertiesOfPlayers.get(playerThatIsPlaying).size(); i++) {
                if (BuyingAProperty.propertiesWithHotel.contains(propertiesOfPlayers.get(playerThatIsPlaying).get(i))) {
                    hotelsThatThePlayerHas++;
                }
            }

            //HOUSES OF THE PLAYER
            BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] = BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] - (hotelsThatThePlayerHas * 4);

            System.out.println(" ");
            System.out.println("Houses that you have:" + BuyingAProperty.housesOfThePlayer[playerThatIsPlaying]);
            System.out.println("Hotels that you have:" + hotelsThatThePlayerHas);

            if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] > 0 || BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] > 0) {
                System.out.println(" ");

                //IF THE PLAYER DOESN'T HAVE A HOTEL AT SPECIFIC COLOR SET
                if (BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] == null) {
                    System.out.println("You need to pay" + " " + "$" + BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + " " + "for all houses that you have");

                    //IF THE PLAYER HAS A HOTEL AT SPECIFIC COLOR SET
                } else if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] == 0) {
                    System.out.println("You need to pay" + " " + "$" + BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] * 100 + " " + "for all hotels that you have.");

                    //IF THE PLAYER HAS A HOTELS AND HOUSES AT DIFFERENT COLOR SETS
                } else {
                    System.out.println("You need to pay" + " " + "$" + BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + " " + "for all houses that you have and" + " " + "$" + hotelsThatThePlayerHas * 100 + " " + "for all hotels that you have.");
                }

                //IF hotelsOfThePlayer[playerThatIsPlaying] == null
                if (BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] == null) {
                    hotelsThatThePlayerHas = 0;

                } else {
                    hotelsThatThePlayerHas = BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying];
                }

                //MONEY BALANCE OF THE PLAYER
                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + hotelsThatThePlayerHas * 40)) {
                    System.out.println(" ");

                    //IF THE PLAYER DOESN'T HAVE A HOTEL
                    if (BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] == 0) {
                        System.out.println("You don't have enough money to pay $25 per house.");
                    } else {
                        System.out.println("You don't have enough money to pay $25 per house and $40 per hotel.");
                    }

                    //IF THE PLAYER HAS NO MONEY TO PAY
                    Monopoly.IfThePlayerHasNoMoneyToPay();

                } else {

                    String payingTheRepairs;
                    do {
                        System.out.println(" ");
                        System.out.println("Press 'P' to pay the repairs for each house and hotel");

                        //ANSWER OF THE PLAYER
                        payingTheRepairs = scanner.nextLine();

                        if ("P".equals(payingTheRepairs)) {
                            System.out.println(" ");
                            System.out.println("-$" + (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + hotelsThatThePlayerHas * 100));

                            //MONEY BALANCE OF THE PLAYER
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + hotelsThatThePlayerHas * 100);
                            System.out.println("Money balance of " + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }
                    } while (!"P".equals(payingTheRepairs));
                }

            } /*else if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] > 0) {
                System.out.println("You need to pay" + " " + "$" + BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + " " + "for all houses that you have.");

                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money to pay $25 per house");
                    Monopoly.IfThePlayerHasNoMoneyToPay();

                } else {
                    do {
                        System.out.println("Press 'P' to pay the repairs for each house and hotel");

                        answerOfThePlayer = scanner.nextLine();

                        if ("P".equals(answerOfThePlayer)) {
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25;
                            System.out.println("Money balance of the" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                            break;
                        }
                    } while (!"P".equals(answerOfThePlayer));
                }

            } else {
                System.out.println("You don't have any house or hotel");
            }*/

            //TAKE A TRIP TO NEW YORK CENTRAL RAILROAD
        } else if (randomChance == 10) {
            //IF THE LOCATION IS GREATER THAN 15
            if (locationOfThePlayer[playerThatIsPlaying] > 15) {
                System.out.println(" ");
                System.out.println("+$200");

                //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
                moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
                System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
            }

            //LOCATION OF THE PLAYER = 15
            locationOfThePlayer[playerThatIsPlaying] = 15;
            rollTotal = 0;

            //RAILROAD INFORMATION
            RailroadInformations.railroadInformations();

            //WALK INTO ABU DHABI
        } else if (randomChance == 11) {
            //LOCATION OF THE PLAYER = 39
            locationOfThePlayer[playerThatIsPlaying] = 39;
            rollTotal = 0;

            //PROPERTY INFORMATION
            PropertyInformations.propertyInformations();

            //ELECTED AS CHAIRMAN OF THE BOARD
        } else if (randomChance == 12) {
            //IF MONEY BALANCE OF THE PLAYER IS LESS THAN MONEY THAT HE NEEDS TO PAY
            if (moneyBalanceOfThePlayer[playerThatIsPlaying] < (Player.numOfPlayers - 1) * 50) {
                System.out.println(" ");
                System.out.println("You don't have enough money to pay $50 to each player.");

                //IF THE PLAYER HAS NO MONEY TO PAY $50 TO EACH PLAYER
                Monopoly.IfThePlayerHasNoMoneyToPay();

            } else {
                String paying$50ToEachPlayer;
                do {
                    System.out.println(" ");
                    System.out.println("Press 'P' to pay");

                    //ANSWER OF THE PLAYER
                    paying$50ToEachPlayer = scanner.nextLine();

                    if ("P".equals(paying$50ToEachPlayer)) {
                        System.out.println(" ");
                        System.out.println("-$" + (Player.numOfPlayers - 1) * 50);

                        //SUBTRACTING MONEY THAT HE NEEDS TO PAY FROM HIS MONEY BALANCE
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - (Player.numOfPlayers - 1) * 50;
                        System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                    }
                } while (!"P".equals(paying$50ToEachPlayer));
            }

            //BUILDING AND LOAN MATURES
        } else if (randomChance == 13){
            System.out.println(" ");
            System.out.println("+$150");

            //ADDING $150 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 150;
            System.out.println("Money balance of " + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
            System.out.println(" ");
            System.out.println("You received $150 as your building and loan matured.");

            //PARKING FINE
        } else if (randomChance == 14) {
            //IF MONEY BALANCE OF THE PLAYER IS LESS THAN $15
            if (moneyBalanceOfThePlayer[playerThatIsPlaying] < 15) {
                System.out.println(" ");
                System.out.println("You don't have enough money to pay the parking fine.");

                //IF THE PLAYER HAS NO MONEY TO PAY $15
                Monopoly.IfThePlayerHasNoMoneyToPay();

            } else {

                String payingTheParkingFine;
                do {
                    System.out.println(" ");
                    System.out.println("Press 'P' to pay the parking fine");

                    //ANSWER OF THE PLAYER
                    payingTheParkingFine = scanner.nextLine();

                    if ("P".equals(payingTheParkingFine)) {
                        System.out.println(" ");
                        System.out.println("-$15");

                        //SUBTRACTING $15 FROM THE MONEY BALANCE OF THE PLAYER
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - 15;
                        System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                    }
                } while (!"P".equals(payingTheParkingFine));
            }

            //WON CROSSWORD COMPETITION
        } else if (randomChance == 15){
            System.out.println(" ");
            System.out.println("+$100");

            //ADDING $100 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying]+100;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
        }
    }
}
