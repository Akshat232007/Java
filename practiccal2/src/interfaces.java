interface Vehicle {
    void start();
    void accelerate(int increment);
    void brake(int decrement);
    void displayStatus();
}

class SportsCar implements Vehicle {
    private String brand;
    private int speed;
    private boolean isRunning;

    public SportsCar(String brand) {
        this.brand = brand;
        this.speed = 0;
        this.isRunning = false;
    }

    @Override
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " engine started");
        } else {
            System.out.println(brand + " engine is already running.");
        }
    }

    @Override
    public void accelerate(int increment) {
        if (isRunning) {
            speed += increment;
            System.out.println(brand + " accelerated by " + increment + " km/h.");
        } else {
            System.out.println("Cannot accelerate. Start the " + brand + " first!");
        }
    }

    @Override
    public void brake(int decrement) {
        if (speed - decrement < 0) {
            speed = 0;
        } else {
            speed -= decrement;
        }
        System.out.println(brand + " slowed down by " + decrement + " km/h.");
    }

    @Override
    public void displayStatus() {
        System.out.println("[" + brand + " Status] Engine Running: " + isRunning + " | Current Speed: " + speed + " km/h");
    }
}

public class interfaces {
    public static void main(String[] args) {
        Vehicle myCar = new SportsCar("Mustang");

        myCar.displayStatus();
        myCar.start();
        myCar.accelerate(40);
        myCar.accelerate(60);
        myCar.displayStatus();
        myCar.brake(30);
        myCar.displayStatus();
    }
}