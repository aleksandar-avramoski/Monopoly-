public class PickingAProperty extends Trade {
    public static void pickingAProperty() throws Exception {

        BoardSquare[] square=new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        if (indexOfThePlayerWhoIsPlaying >= 0 && indexOfThePlayerWhoIsPlaying < 6) {

            //ARRAY LIST OF PROPERTIES THAT THE PLAYER PICKS
            propertiesThatThePlayerOwns = propertiesOfPlayers.get(indexOfThePlayerWhoIsPlaying);

            //ARRAY LIST OF LOCATIONS THAT THE PLAYER PICK
            locationsOfThePropertiesThatThePlayerOwns = allLocationsOfThePlayers.get(indexOfThePlayerWhoIsPlaying);

            if (pickingAProperty > 0 && pickingAProperty <= propertiesThatThePlayerOwns.size()) {

                //IF THE INDEX OF THE PLAYER WHO IS PLAYING IS EQUAL TO THE INDEX OF THE PLAYER[0]
                if (indexOfThePlayerWhoIsPlaying == indexOfThePlayer[0]) { //a
                    arrayListOfTheLocationsOfThePlayer = allLocationsOfThePlayers.get(indexOfThePlayerWhoIsPlaying);
                    arrayListOfThePropertiesOfThePlayer = propertiesOfPlayers.get(indexOfThePlayerWhoIsPlaying);

                    for (int d = 0; d < 40; d++) {
                        BoardSquare newPosition = square[d];
                        if (propertiesThatThePlayerOwns.get(pickingAProperty - 1).equals(newPosition.getName())) {
                            //ADDING THE LOCATION TO THE ARRAY LIST locationsOfPropOfThePlayer
                            locationsOfPropOfThePlayer.add(d);
                        }
                    }

                    //ADDING THE PROPERTY TO THE ARRAY LIST propOfThePlayer
                    propOfThePlayer.add(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                } else {
                    arrayListOfTheLocationsOfThePlayer1 = allLocationsOfThePlayers.get(indexOfThePlayerWhoIsPlaying);
                    arrayListOfThePropertiesOfThePlayer1 = propertiesOfPlayers.get(indexOfThePlayerWhoIsPlaying);

                    for (int d = 0; d < 40; d++) {
                        BoardSquare newPosition = square[d];
                        if (propertiesThatThePlayerOwns.get(pickingAProperty - 1).equals(newPosition.getName())) {
                            //ADDING THE LOCATION TO THE ARRAY LIST locationsOfPropOfThePlayer1
                            locationsOfPropOfThePlayer1.add(d);
                        }
                    }

                    //ADDING THE PROPERTY TO THE ARRAY LIST propOfThePlayer1
                    propOfThePlayer1.add(propertiesThatThePlayerOwns.get(pickingAProperty - 1));
                }

                //PRINTING THE PROPERTY THAT THE PLAYER PICKED
                System.out.println(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                for (int s = 0; s < 40; s++) {
                    BoardSquare newPosition = square[s];

                    if (newPosition.getName().equals(propertiesThatThePlayerOwns.get(pickingAProperty - 1))) {

                        //IF assetsOfTheProperty[s] == null
                        if (BuyingAProperty.assetsOfTheProperty[s] == null) {
                            System.out.println(" ");
                            System.out.println("This property doesn't have any house or hotel.");

                        } else {
                            //IF assetsOfTheProperty[s] < 5
                            if (BuyingAProperty.assetsOfTheProperty[s] < 5) {
                                System.out.println(" ");
                                System.out.println("Houses that the property has:" + BuyingAProperty.assetsOfTheProperty[s]);

                            } else {
                                System.out.println(" ");
                                System.out.println("Houses that the property has:" + 4);
                                System.out.println("Hotels that the property has:" + 1);
                            }
                        }

                        System.out.println(" ");

                        //IF THE INDEX OF THE PLAYER WHO IS PLAYING IS EQUAL TO THE INDEX OF THE PLAYER[0]
                        if (indexOfThePlayerWhoIsPlaying == indexOfThePlayer[0]) {

                            //IF offeringOrWantMoney == false
                            if (offeringOrWantMoney == false) {
                                //TOTAL VALUE OFFERS
                                totalValueOffers = (totalValueOffers + newPosition.getMortgageValue() + moneyOffers);
                            } else {
                                totalValueOffers = (totalValueOffers + newPosition.getMortgageValue());
                            }

                            System.out.println("Total value offers:" + "$" + totalValueOffers);

                        } else {
                            //IF offeringOrWantMoney == false
                            if (offeringOrWantMoney == false) {
                                //TOTAL VALUE WANTS
                                totalValueWants = (totalValueWants + newPosition.getMortgageValue() + moneyWants);
                            } else {
                                totalValueWants = (totalValueWants + newPosition.getMortgageValue());
                            }

                            System.out.println("Total value wants:" + "$" + totalValueWants);
                        }

                        //IF THE INDEX OF THE PLAYER WHO IS PLAYING IS EQUAL TO THE INDEX OF THE PLAYER[0]
                        if (indexOfThePlayerWhoIsPlaying == indexOfThePlayer[0]) { //a
                            //PROPERTIES THAT THE PLAYER WHO CALLS THE AUCTION TRADE
                            propertiesThatThePlayerTrade.add(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                            //ADDING THE PICKED PROPERTY TO THE ARRAY LIST pickedProperties
                            pickedProperties.add(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                            //REMOVING THE PICKED PROPERTY FROM THE ARRAY LIST propertiesOfThePlayer
                            propertiesOfThePlayer.remove(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                        } else {
                            //PROPERTIES THAT THE PLAYER WHO IS PICKED FOR TRADING, TRADE
                            propertiesThatThePlayerTrade1.add(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                            //ADDING THE PICKED PROPERTY TO THE ARRAY LIST pickedProperties
                            pickedProperties.add(propertiesThatThePlayerOwns.get(pickingAProperty - 1));

                            //REMOVING THE PICKED PROPERTY FROM THE ARRAY LIST propertiesOfThePlayer
                            propertiesOfThePlayer.remove(propertiesThatThePlayerOwns.get(pickingAProperty - 1));
                        }
                        break;
                    }
                }

            } else {
                System.out.println(" ");
                System.out.println("Invalid property number");
            }

        } else {
            System.out.println(" ");
            System.out.println("Invalid player number");
        }
    }
}
