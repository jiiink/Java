package prob2;

public class Car extends Vehicle {
    private final String owner;
    public Car(String maker, int i, String owner) {
        super(maker, i);
        this.owner = owner;
    }
    
    // @Override
    // public boolean equals(Car c) {
    //     return this.owner.equals(c.owner);
    // }
    @Override
    public String toString() {
        String msg = "";
        msg += "Car [Maker=" + super.getMaker() + "], [Price=" + super.getPrice() + "], [Owner=" + this.getOwner() + "]";
        return msg;
    }

    private String getOwner() {
        return owner;
    }
}
