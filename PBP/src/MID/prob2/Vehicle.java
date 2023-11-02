package MID.prob2;

public abstract class Vehicle {
    private final String maker;
    private final int price;
    public Vehicle(String maker, int price) {
        this.maker = maker;
        this.price = price;
    }
    public String getMaker() {
        return maker;
    }
    public int getPrice() {
        return price;
    }

    //  @Override
    //  public boolean equals(Vehicle v) {
    // 	 return this.maker.equals(v.maker) && this.price == v.price;
    //  }
    @Override
    public abstract String toString();
}
