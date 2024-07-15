public class BoardSquare {
    public String name;
    public String type;
    public String color;
    public int price;
    public int rent;
    public int rentWithColorSet;
    public int rentWith1House;
    public int rentWith2Houses;
    public int rentWith3Houses;
    public int rentWith4Houses;
    public int rentWithHotel;
    public int mortgageValue;
    public int houseCost;
    public int hotelCost;
    public int rentWith2Railroads;
    public int rentWith3Railroads;
    public int rentWith4Railroads;

    //CONSTRUCTORS
    public BoardSquare(){
        name = "";
        type = "";
        color = "";
        price = 0;
        rent = 0;
        rentWith1House = 0;
        rentWith2Houses = 0;
        rentWith3Houses = 0;
        rentWith4Houses = 0;
        rentWithHotel = 0;
        mortgageValue = 0;
        houseCost = 0;
        hotelCost = 0;
    }

    //GO, SUSPENSION, CHANCES, COMMUNITY CHESTS
    public BoardSquare(String name) {
        this.name = name;
    }

    //TAXES
    public BoardSquare (String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    //RAilROADS
    public BoardSquare (String name, String type, String color, int price, int rent, int rentWith2Railroads, int rentWith3Railroads, int rentWith4Railroads, int mortgageValue) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
        this.rent = rent;
        this.rentWith2Railroads = rentWith2Railroads;
        this.rentWith3Railroads = rentWith3Railroads;
        this.rentWith4Railroads = rentWith4Railroads;
        this.mortgageValue = mortgageValue;
    }

    //UTILITIES (I THINK?)
    public BoardSquare (String name, String type, int price, int rent, int mortgageValue) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
        this.mortgageValue = mortgageValue;
    }

    //PROPERTIES
    public BoardSquare(String name, String type, String color,int price, int rent, int rentWithColorSet, int rentWith1House,int rentWith2Houses,int rentWith3Houses,int rentWith4Houses,int rentWithHotel,int mortgageValue,int houseCost,int hotelCost) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
        this.rent = rent;
        this.rentWithColorSet = rentWithColorSet;
        this.rentWith1House = rentWith1House;
        this.rentWith2Houses = rentWith2Houses;
        this.rentWith3Houses = rentWith3Houses;
        this.rentWith4Houses = rentWith4Houses;
        this.rentWithHotel = rentWithHotel;
        this.mortgageValue = mortgageValue;
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
    }

    //ACCESS FOR EACH PROPERTY
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }
    public int getRentWithColorSet() {
        return rentWithColorSet;
    }
    public String getColor() {
        return color;
    }

    public int getRentWith1House() {
        return rentWith1House;
    }

    public int getRentWith2Houses() {
        return rentWith2Houses;
    }

    public int getRentWith3Houses() {
        return rentWith3Houses;
    }

    public int getRentWith4Houses() {
        return rentWith4Houses;
    }

    public int getRentWithHotel() {
        return rentWithHotel;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

    public int getRentWith2Railroads() {
        return rentWith2Railroads;
    }
    public int getRentWith3Railroads() {
        return rentWith3Railroads;
    }

    public int getRentWith4Railroads() {
        return rentWith4Railroads;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public int getHotelCost() {
        return hotelCost;
    }

    // a method to return the BoardSquare's data as a String
    /*public String toString() {
        String info = (name +", "+type+", "+color+","+price + ", "+ rent+ ", "+rentWith1House+", "+rentWith2Houses+", "+rentWith3Houses+", "+rentWith4Houses+", "+rentWithHotel+", "+mortgageValue+", "+houseCost+", "+hotelCost);
        return info;
    }*/

}


