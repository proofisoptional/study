package patterns.builder;

public class Truck {
    private String owner;
    private String stsNumber;
    private int year;
    private String trailer;
    private int weight;
    private int power;

    public Truck() {

    }

    public Truck(String owner, String stsNumber, int year, String trailer, int weight, int power) {
        this.owner = owner;
        this.stsNumber = stsNumber;
        this.year = year;
        this.trailer = trailer;
        this.weight = weight;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "owner='" + owner + '\'' +
                ", stsNumber='" + stsNumber + '\'' +
                ", year=" + year +
                ", trailer='" + trailer + '\'' +
                ", weight=" + weight +
                ", power=" + power +
                '}';
    }

    public static TruckBuilder builder(){
        return new TruckBuilder();
    }

    public static class TruckBuilder{
        private String owner;
        private String stsNumber;
        private int year;
        private String trailer;
        private int weight;
        private int power;
        public TruckBuilder owner(String owner){
            this.owner = owner;
            return this;
        }
        public TruckBuilder stsNumber(String stsNumber){
            this.stsNumber = stsNumber;
            return this;
        }
        public TruckBuilder year(int year){
            this.year = year;
            return this;
        }
        public TruckBuilder trailer(String trailer){
            this.trailer = trailer;
            return this;
        }
        public TruckBuilder weight(int weight){
            this.weight = weight;
            return this;
        }
        public TruckBuilder power(int power){
            this.power = power;
            return this;
        }

        public Truck build(){
            return new Truck(owner, stsNumber, year, trailer, weight, power);
        }


    }
}
