public class Utilities extends Monopoly {
    public static void utilities() throws Exception {

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        //LOCATION OF THE PLAYER
        BoardSquare newPosition = square[locationOfThePlayer[playerThatIsPlaying] + rollTotal];

        //IF position == true
        if (position == true) {
            for (int s = 0; s < 40; s++) {
                BoardSquare position = square[s];

                if (position.getName().equals(BuyingAProperty.listOfThePlayer.get(pickingAProperty - 1))) {
                    newPosition = square[s];
                }
            }
        }

        System.out.println(" ");
        System.out.println("Name:" + newPosition.getName());
        System.out.println("Type:" + newPosition.getType());
        System.out.println("Price:" + "$" + newPosition.getPrice());
        System.out.println("Rent:" + "$" + newPosition.getRent());
        System.out.println("------------------------------------");
        System.out.println("Mortgage Value:" + "$" + newPosition.getMortgageValue());

        //mortgageValueOfTheProperty = newPosition.getMortgageValue();

        //IF position == false
        if (position == false) {
            //ACTIVATING THE METHOD buyingAProperty()
            ProcessOfBuyingAProperty.buyingAProperty();
        }

        position = false;
    }
}
