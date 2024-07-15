import java.util.Scanner;
public class PlayerHavingProperties extends Trade {

    //FINISHING THE BID
    private static String finishingTheBid;

    //BID FINISHED
    private static boolean bidFinished;
    public static void playerHavingProperties() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        do {
            //DISPLAYING THE PROPERTIES OF THE PLAYER
            for (int s = 1; s < propertiesOfThePlayer.size(); s++) {
                for (String x : propertiesOfThePlayer) {

                    //IF pickedProperties.contains(x)
                    if (pickedProperties.contains(x)) {
                        continue;
                    }

                    System.out.println(s + "-" + x);
                    s++;
                }
            }

            //IF THE SIZE OF THE ARRAY LIST propertiesOfThePlayer == 1
            if (propertiesOfThePlayer.size() == 1) {
                System.out.println(1 + "-" + propertiesOfThePlayer.get(0));
            }

            do {
                //PICKING THE NUMBER OF THE PROPERTY
                pickingAProperty = scanner1.nextInt();

                if (pickingAProperty <= 0 || pickingAProperty > propertiesOfThePlayer.size()) {
                    System.out.println(" ");
                    System.out.println("Invalid input. Please enter a number between 1 and " + propertiesOfThePlayer.size());

                } else {
                    System.out.println(" ");
                    //ACTIVATING THE METHOD pickingAProperty()
                    PickingAProperty.pickingAProperty();

                    //IF THE ARRAY LIST propertiesOfThePlayer IS EMPTY
                    if (propertiesOfThePlayer.isEmpty()) {
                        System.out.println(" ");

                        //IF playerWants == false
                        if (playerWants == false) {
                            System.out.println("You are not having more properties.");
                        } else {
                            System.out.println(Player.storeTheNames.get(indexOfThePlayer[1]) + " " + "is not having more properties.");
                        }

                        String answerOfThePlayerIfHeHasNoProperties;
                        do {
                            System.out.println(" ");
                            System.out.println("Press 'D' for done");

                            //IF offeringOrWantMoney == false
                            if (offeringOrWantMoney == false) {

                                //IF playerWants == false
                                if (playerWants == false) {
                                    System.out.println("Press 'M' to add money");
                                } else {
                                    System.out.println("Press 'M' to ask for more money");
                                }
                            }

                            //ANSWER OF THE PLAYER
                            answerOfThePlayerIfHeHasNoProperties = scanner.nextLine();

                            if ("D".equals(answerOfThePlayerIfHeHasNoProperties)) {
                                return;
                            }

                            //IF offeringOrWantMoney == false
                            if (offeringOrWantMoney == false) {
                                if (a == indexOfThePlayer[0]) {
                                    if ("M".equals(answerOfThePlayerIfHeHasNoProperties)) {
                                        //ACTIVATING THE METHOD moneyOffering()
                                        moneyOffering();

                                        do {
                                            System.out.println(" ");
                                            System.out.println("Press 'D' for done");

                                            //ANSWER OF THE PLAYER
                                            finishingTheBid = scanner.nextLine();

                                            if ("D".equals(finishingTheBid)) {
                                                bidFinished = true;
                                                return;
                                            }
                                        } while (true);
                                    }

                                } else {
                                    if ("M".equals(answerOfThePlayerIfHeHasNoProperties)) {
                                        //ACTIVATING THE METHOD moneyWants()
                                        moneyWants();

                                        do {
                                            System.out.println(" ");
                                            System.out.println("Press 'D' for done");

                                            //ANSWER OF THE PLAYER
                                            finishingTheBid = scanner.nextLine();

                                            if ("D".equals(finishingTheBid)) {
                                                bidFinished = true;
                                                return;
                                            }
                                        } while (true);
                                    }
                                }
                                //break;
                            }
                        } while (true); //!"D".equals(answerOfThePlayerIfHeHasNoProperties) || !"M".equals(answerOfThePlayerIfHeHasNoProperties
                    }
                    break;
                }

            } while (pickingAProperty <= 0 || pickingAProperty > propertiesOfThePlayer.size());

            do {
                //IF THE SIZE OF THE LIST propertiesThatThePlayerOwns IS NOT EQUAL TO 0
                if (propertiesThatThePlayerOwns.size() != 0) {
                    System.out.println(" ");
                    System.out.println("Press 'D' for done");

                    //IF offeringOrWantMoney == false
                    if (offeringOrWantMoney == false) {

                        //IF playerWants == false
                        if (playerWants == false) {
                            System.out.println("Press 'M' to add money");
                        } else {
                            System.out.println("Press 'M' to ask for more money");
                        }
                    }

                    System.out.println("Press 'Enter' to continue");
                }

                boolean pickOtherProperties = false;

                //IF bidFinished == false
                if (bidFinished == false) {

                    //DECISION OF THE PLAYER (ANSWER OF THE PLAYER)
                    decisionOfThePlayer = scanner.nextLine();

                    if ("D".equals(decisionOfThePlayer)) {
                        System.out.println(" ");
                        if (playerWants == false) {
                            System.out.println("Total value offers:" + "$" + totalValueOffers);
                        } else {
                            System.out.println("Total value wants:" + "$" + totalValueWants);
                        }

                        return;
                        //break;

                    } else if ("M".equals(decisionOfThePlayer)) {

                        //IF offeringOrWantMoney == false
                        if (offeringOrWantMoney == false) {
                            //If playerWants == false
                            if (playerWants == false) {
                                //ACTIVATING METHOD moneyOffering()
                                moneyOffering();
                            } else {
                                //ACTIVATING METHOD moneyWants()
                                moneyWants();
                            }

                            String choosingAnOption;
                            do {
                                System.out.println(" ");
                                System.out.println("Press 'P' to pick other properties");
                                System.out.println("Press 'D' for done");

                                //ANSWER OF THE PLAYER
                                choosingAnOption = scanner.nextLine();

                                if ("D".equals(choosingAnOption)) {
                                    System.out.println(" ");
                                    //IF playerWants == false
                                    if (playerWants == false) {
                                        System.out.println("Total value offers:" + "$" + totalValueOffers);
                                    } else {
                                        System.out.println("Total value wants:" + "$" + totalValueWants);
                                    }

                                    decisionOfThePlayer = "D";
                                    return;

                                } else if ("P".equals(choosingAnOption)) {
                                    pickOtherProperties = true;
                                    break;
                                }
                            } while (true);
                        }
                    }

                    if (pickOtherProperties == true) {
                        System.out.println(" ");
                        break;
                    }
                }

            } while (!decisionOfThePlayer.isEmpty());

        } while (!"D".equals(decisionOfThePlayer) || !"D".equals(finishingTheBid));

        playerWantsProperty = false;
    }
}
