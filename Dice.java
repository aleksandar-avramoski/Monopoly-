public class Dice {

    //TOTAL
    public static int total;
    public static int roll(){
        total = 1 + (int) (Math.random()*6);
        return total;
    }
}
