public class House {
    private String address;
    private double price;
    private double rentEstimate;
    private int squareFeet;
    private int bedrooms;
    private int bathrooms;
    private double correlation;

    public House(String address, double price, double rentEstimate, int squareFeet, int bedrooms, int bathrooms, double correlation){
        this.address = address;
        this.price = price;
        this.rentEstimate = rentEstimate;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.correlation = correlation;
    }

    public double getPrice(){
        return price;
    }

    public double getRentEstimate(){
        return rentEstimate;
    }

    public int getSquareFeet(){
        return squareFeet;
    }

    public int getBedrooms(){
        return bedrooms;
    }

    public int getBathrooms(){
        return bathrooms;
    }

    public double getCorrelation(){
        return correlation;
    }
}
