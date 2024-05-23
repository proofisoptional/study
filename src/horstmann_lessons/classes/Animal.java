package horstmann_lessons.classes;

class Animal {
    private String name;
    private int age;

    private int[] coordinates = new int[2];

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    Animal(String name, int age, int[] coordinates){
        this.name = name;
        this.age = age;
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void move(){
        coordinates[0] = coordinates[0] + 4;
        coordinates[1] = coordinates[1] + 4;
    }
}

class Dog extends Animal {

    Dog(String name, int age, int[] coordinates) {
        super(name, age, coordinates);
    }

    @Override
    public void move(){
        int[] temp = getCoordinates();
        temp[0] = temp[0] + 5;
        temp[1] = temp[1] + 5;
        setCoordinates(temp);
    }
}

