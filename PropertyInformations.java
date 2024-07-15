public class PropertyInformations extends Monopoly{

    public static void propertyInformations() throws Exception {

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
        System.out.println("Color:" + newPosition.getColor());
        System.out.println("Price:" + "$" + newPosition.getPrice());
        System.out.println("-----------------------------------------------------");
        System.out.println("Rent:" + "$" + newPosition.getRent());
        System.out.println("Rent with color set:" + "$" + newPosition.getRentWithColorSet());
        System.out.println("Rent With 1 House:" + "$" + newPosition.getRentWith1House());
        System.out.println("Rent With 2 Houses:" + "$" + newPosition.getRentWith2Houses());
        System.out.println("Rent With 3 Houses:" + "$" + newPosition.getRentWith3Houses());
        System.out.println("Rent With 4 Houses:" + "$" + newPosition.getRentWith4Houses());
        System.out.println("Rent With Hotel:" + "$" + newPosition.getRentWithHotel());
        System.out.println("-----------------------------------------------------");
        System.out.println("Mortgage Value:" + "$" + newPosition.getMortgageValue());
        System.out.println("Houses Cost:" + "$" + newPosition.getHouseCost());
        System.out.println("Hotel Cost:" + "$" + newPosition.getHotelCost());

        //ORIGINAL VALUE OF THE PROPERTY
        originalValueOfTheProperty = newPosition.getPrice();

        //IF position == false
        if (position == false) {
            //ACTIVATING THE METHOD buyingAProperty()
            ProcessOfBuyingAProperty.buyingAProperty();
        }

        position = false;
    }
}
