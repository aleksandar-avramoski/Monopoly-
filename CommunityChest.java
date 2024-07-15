import java.util.Random;
import java.util.Scanner;
public class CommunityChest extends Monopoly {

    //COMMUNITY CHEST
    public static String[] communityChest = new String[16];
    public static void communityChests() throws Exception {

        communityChest[0] = "Advanced to 'Go'.";
        communityChest[1] = "Bank error in your favor. Collect $200.";
        communityChest[2] = "Doctor's fees. Pay $50.";
        communityChest[3] = "From sale of stock you get $50.";
        communityChest[4] = "Get Out of Jail Free. This card may be kept until needed.";
        communityChest[5] = "Go to Jail. Go directly to jail. Do not pass Go, Do not collect $200.";
        communityChest[6] = "Grand Opera Night. Collect $50 from every player for opening night seats.";
        communityChest[7] = "Holiday Fund matures. Collect $100.";
        communityChest[8] = "Income tax refund. Collect $20.";
        communityChest[9] = "It is your birthday. Collect $10 from every player.";
        communityChest[10] = "Life insurance matures – Collect $100";
        communityChest[11] = "Hospital Fees. Pay $55.";
        communityChest[12] = "School fees. Pay $50.";
        communityChest[13] = "Receive $25 consultancy fee.";
        communityChest[14] = "You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.";
        communityChest[15] = "You have won second prize in a beauty contest. Collect $10.";

        //RANDOM COMMUNITY CHEST
        int randomCommunityChest = new Random().nextInt(communityChest.length);

        //DISPLAYING THE COMMUNITY CHEST
        System.out.println(communityChest[randomCommunityChest]);

        Scanner scanner=new Scanner(System.in);

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //ADVANCED TO GO
        if (randomCommunityChest == 0){
            System.out.println(" ");
            BoardSquare newPosition = square[0];

            //DISPLAYING THE POSITION 0
            System.out.println(newPosition.getName());

            //LOCATION OF THE PLAYER = 0
            locationOfThePlayer[playerThatIsPlaying] = 0;
            rollTotal = 0;

            //BANK ERROR
        } else if (randomCommunityChest == 1){
            System.out.println(" ");
            System.out.println("+$200");

            //ADDING $200 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 200;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //DOCTOR FEES
        } else if (randomCommunityChest == 2){
            //IF MONEY BALANCE OF THE PLAYER IS LESS THAN $50
            if (moneyBalanceOfThePlayer[playerThatIsPlaying] < 50){
                System.out.println(" ");
                System.out.println("You don't have enough money to pay the doctor fees.");

                //IF THE PLAYER HAS NO MONEY TO PAY $50 FOR DOCTOR FEES
                Monopoly.IfThePlayerHasNoMoneyToPay();

            } else {

                String payingDoctorFees;
                do {
                    System.out.println(" ");
                    System.out.println("Press 'P' to pay");

                    //ANSWER OF THE PLAYER
                    payingDoctorFees = scanner.nextLine();

                    if ("P".equals(payingDoctorFees)) {
                        System.out.println(" ");
                        System.out.println("-$50");

                        //SUBTRACTING $50 FROM THE MONEY BALANCE OF THE PLAYER
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - 50;
                        System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                    }
                } while (!"P".equals(payingDoctorFees));
            }

            //$50 FROM SALE OF STOCK
        } else if (randomCommunityChest == 3){
            System.out.println(" ");
            System.out.println("+$50");

            //ADDING $50 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 50;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //GETTING OUT OF JAIL
        } else if (randomCommunityChest == 4){
            cardToGetOutFromJail[playerThatIsPlaying] = 1;

            //GO TO JAIL
        } else if (randomCommunityChest == 5){
            BoardSquare newPosition=square[10];
            System.out.println(" ");

            //DISPLAYING THE POSITION 10
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

            //GRAND OPERA NIGHT
        } else if (randomCommunityChest == 6){
            System.out.println(" ");
            System.out.println("+$" + (Player.numOfPlayers - 1)  * 50);

            //ADDING $ (Player.numOfPlayers * 50) TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + (Player.numOfPlayers*50);
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //HOLIDAY XMAS FUND MATURES
        } else if (randomCommunityChest == 7){
            System.out.println(" ");
            System.out.println("+$100");

            //ADDING $100 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 100;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //INCOME TAX REFUND
        } else if (randomCommunityChest == 8){
            System.out.println(" ");
            System.out.println("+$20");

            //ADDING $20 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 20;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //IT'S YOUR BIRTHDAY
        } else if (randomCommunityChest == 9){
            System.out.println(" ");
            System.out.println("+$" + (Player.numOfPlayers - 1) * 10);

            //ADDING $ (Player.numOfPlayers * 10) TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + (Player.numOfPlayers*10);
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //LIFE INSURANCE MATURES
        } else if (randomCommunityChest == 10){
            System.out.println(" ");
            System.out.println("+$100");

            //ADDING $100 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 100;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //HOSPITAL FEES
        } else if (randomCommunityChest == 11){
            //IF MONEY BALANCE OF THE PLAYER IS LESS THAN $50
            if (moneyBalanceOfThePlayer[playerThatIsPlaying] < 50) {
                System.out.println(" ");
                System.out.println("You don't have enough money to pay the hospital fees.");

                //IF THE PLAYER HAS NO MONEY TO PAY THE HOSPITAL FEES
                Monopoly.IfThePlayerHasNoMoneyToPay();

            } else {

                String payingHospitalFees;
                do {
                    System.out.println(" ");
                    System.out.println("Press 'P' to pay");

                    //ANSWER OF THE PLAYER
                    payingHospitalFees = scanner.nextLine();

                    if ("P".equals(payingHospitalFees)) {
                        System.out.println(" ");
                        System.out.println("-$50");

                        //SUBTRACTING $50 FROM THE MONEY BALANCE OF THE PLAYER
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - 50;
                        System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                    }
                } while (!"P".equals(payingHospitalFees));
            }

            //SCHOOL FEES
        } else if (randomCommunityChest == 12){

            //IF MONEY BALANCE OF THE PLAYER IS LESS THAN $50
            if (moneyBalanceOfThePlayer[playerThatIsPlaying] < 50) {
                System.out.println(" ");
                System.out.println("You don't have enough money to pay the school fees.");

                //IF THE PLAYER HAS NO MONEY TO PAY THE SCHOOL FEES
                Monopoly.IfThePlayerHasNoMoneyToPay();

            } else {

                String payingSchoolFees;
                do {
                    System.out.println(" ");
                    System.out.println("Press 'P' to pay the school fees");

                    //ANSWER OF THE PLAYER
                    payingSchoolFees = scanner.nextLine();

                    if ("P".equals(payingSchoolFees)) {
                        System.out.println(" ");
                        System.out.println("-$50");

                        //SUBTRACTING $50 FROM THE MONEY BALANCE OF THE PLAYER
                        moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - 50;
                        System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                    }

                } while (!"P".equals(payingSchoolFees));
            }

            //RECEIVE $25 CONSULTANCY FEE
        } else if (randomCommunityChest == 13) {
            System.out.println(" ");
            System.out.println("+$25");

            //ADDING $25 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 25;
            System.out.println("Money balance of the" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);

            //YOU ARE ASSESSED FOR STREET REPAIRS
        } else if (randomCommunityChest == 14){
            //IF THE PROPERTY DOESN'T HAVE ANY HOUSE
            if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] == null) {
                System.out.println(" ");
                System.out.println("You don't have a house or hotel!");
                return;
            }

            int hotelsThatThePlayerHas = 0;

            for (int i = 0; i < propertiesOfPlayers.get(playerThatIsPlaying).size(); i++) {

                //IF propertiesWithHotel CONTAINS THE PROPERTY FROM THE PLAYER
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

                            //ADDING $ (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + hotelsThatThePlayerHas * 100) TO THE MONEY BALANCE OF THE PLAYER
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 25 + hotelsThatThePlayerHas * 100);
                            System.out.println("Money balance of " + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }
                    } while (!"P".equals(payingTheRepairs));
                }
            }

            /*if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] == null){
                System.out.println(" ");
                System.out.println("You don't have any house or hotel!");
                return;
            }

            if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] > 0 || BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] > 0) {
                System.out.println("You need to pay" + " " + "$" + BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40 + " " + "for all houses that you have and" + " " + BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] * 115 + " " + "for all hotels that you have.");

                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40 + BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] * 115)) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money to pay $40 per house and $115 per hotel.");
                    Monopoly.IfThePlayerHasNoMoneyToPay();

                } else {
                    do {
                        System.out.println(" ");
                        System.out.println("Press 'P' to pay the repairs for each house and hotel");

                        answerOfThePlayer = scanner.nextLine();

                        if ("P".equals(answerOfThePlayer)) {
                            System.out.println("-" + (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40) + (BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] * 115));
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40 + BuyingAProperty.hotelsOfThePlayer[playerThatIsPlaying] * 115);
                            System.out.println("Money balance of the" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }
                    } while (!"P".equals(answerOfThePlayer));
                }

            } else if (BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] > 0) {
                System.out.println("You need to pay" + " " + "$" + BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40 + " " + "for all houses that you have.");

                if (moneyBalanceOfThePlayer[playerThatIsPlaying] < BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money to pay $40 per house");
                    Monopoly.IfThePlayerHasNoMoneyToPay();

                } else {
                    do {
                        System.out.println("Press 'P' to pay the repairs for each house and hotel");

                        //ANSWER OF THE PLAYER
                        answerOfThePlayer = scanner.nextLine();

                        if ("P".equals(answerOfThePlayer)) {
                            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] - BuyingAProperty.housesOfThePlayer[playerThatIsPlaying] * 40;
                            System.out.println("Money balance of the" + " " + Player.storeTheNames.get(playerThatIsPlaying) + ":" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
                        }
                    } while (!"P".equals(answerOfThePlayer));
                }

            } else {
                System.out.println("You don't have any house or hotel");
            }*/

            //WON SECOND PRIZE IN A BEAUTY CONTEST
        } else if (randomCommunityChest == 15){
            System.out.println(" ");
            System.out.println("+$10");

            //ADDING $15 TO THE MONEY BALANCE OF THE PLAYER
            moneyBalanceOfThePlayer[playerThatIsPlaying] = moneyBalanceOfThePlayer[playerThatIsPlaying] + 10;
            System.out.println("Money balance of" + " " + Player.storeTheNames.get(playerThatIsPlaying) + " " + "is:" + "$" + moneyBalanceOfThePlayer[playerThatIsPlaying]);
        }
    }
}
