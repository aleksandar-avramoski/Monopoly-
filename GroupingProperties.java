import java.util.ArrayList;
public class GroupingProperties {
    public static ArrayList<String> redColor = new ArrayList<>();
    public static ArrayList<String> whiteColor = new ArrayList<>();
    public static ArrayList<String> blueColor = new ArrayList<>();
    public static ArrayList<String> pinkColor = new ArrayList<>();
    public static ArrayList<String> brownColor = new ArrayList<>();
    public static ArrayList<String> yellowColor = new ArrayList<>();
    public static ArrayList<String> purpleColor = new ArrayList<>();
    public static ArrayList<String> blackColor = new ArrayList<>();

    public static ArrayList<String> redColor1 = new ArrayList<>();
    public static ArrayList<String> whiteColor1 = new ArrayList<>();
    public static ArrayList<String> blueColor1 = new ArrayList<>();
    public static ArrayList<String> pinkColor1 = new ArrayList<>();
    public static ArrayList<String> brownColor1 = new ArrayList<>();
    public static ArrayList<String> yellowColor1 = new ArrayList<>();
    public static ArrayList<String> purpleColor1 = new ArrayList<>();
    public static ArrayList<String> blackColor1 = new ArrayList<>();
    public static String[] colorsInTheGame= new String[7];
    public static void colorSet() throws Exception {

        BoardSquare[] square = new BoardSquare[40];

        //PROPERTIES FROM THE BOARD
        PropertiesFromTheBoard.loadArray(square);

        for (int s = 0; s < 40; s++) {

            BoardSquare newPosition = square[s];

            if (newPosition.getColor() != null) {

                //SWITCH
                switch (newPosition.getColor()) {

                    //RED COLOR
                    case "Red":

                        if (redColor.size() < 2 && redColor1.size() < 2) {
                            redColor.add(newPosition.getName());
                            redColor1.add(newPosition.getName());
                        }

                        break;

                    //WHITE COLOR
                    case "White":

                        if (whiteColor.size() < 3 && whiteColor1.size() < 3) {
                            whiteColor.add(newPosition.getName());
                            whiteColor1.add(newPosition.getName());
                        }

                        break;

                    //BLUE COLOR
                    case "Blue":

                        if (blueColor.size() < 3 && blueColor1.size() < 3) {
                            blueColor.add(newPosition.getName());
                            blueColor1.add(newPosition.getName());
                        }

                        break;

                    //PINK COLOR
                    case "Pink":

                        if (pinkColor.size() < 3 && pinkColor1.size() < 3) {
                            pinkColor.add(newPosition.getName());
                            pinkColor1.add(newPosition.getName());
                        }

                        break;

                    //BROWN COLOR
                    case "Brown":

                        if (brownColor.size() < 3 && brownColor1.size() < 3) {
                            brownColor.add(newPosition.getName());
                            brownColor1.add(newPosition.getName());
                        }

                        break;

                    //YELLOW COLOR
                    case "Yellow":

                        if (yellowColor.size() < 3 && yellowColor1.size() < 3) {
                            yellowColor.add(newPosition.getName());
                            yellowColor1.add(newPosition.getName());
                        }

                        break;

                    //PURPLE COLOR
                    case "Purple":

                        if (purpleColor.size() < 3 && purpleColor1.size() < 3) {
                            purpleColor.add(newPosition.getName());
                            purpleColor1.add(newPosition.getName());
                        }

                        break;

                    //BLACK COLOR
                    case "Black":

                        if (blackColor.size() < 2 && blackColor1.size() < 2) {
                            blackColor.add(newPosition.getName());
                            blackColor1.add(newPosition.getName());
                        }

                        break;
                }
            }
        }

        //COLORS IN THE GAME
        colorsInTheGame = new String[]{"Red", "White", "Blue", "Pink", "Brown", "Yellow", "Purple", "Black"};
    }
}
