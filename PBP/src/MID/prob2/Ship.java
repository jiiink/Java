package prob2;

public class Ship extends Vehicle {
    private final int weight;
    public Ship(String maker, int price, int weight) {
        super(maker, price);
        this.weight = weight;
    }

    //  @Override
    //  public boolean equals(Ship s) {
    //      return super.equals(s) && this.weight == s.weight;
    //  }
    @Override
    public String toString() {
        String msg = "";
        msg += "Ship [Maker=" + super.getMaker() + "], [Price=" + super.getPrice() + "], [Weight=" + this.getWeight() + "]";
        return msg;
    }

    private int getWeight() {
        return weight;
    }
}
