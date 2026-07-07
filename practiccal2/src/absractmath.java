
abstract class Phone {
    abstract void features();
    void displayBrand(String brand) {
        System.out.println("Phone Brand: " + brand);
    }
}
class Samsung extends Phone {
    @Override
    void features() {
        System.out.println("Features: AMOLED Display, 5000mAh Battery");
    }
}
class iPhone extends Phone {
    @Override
    void features() {
        System.out.println("Features: Face ID, iOS Operating System");
    }
}
class Xiaomi extends Phone {
    @Override
    void features() {
        System.out.println("Features: Fast Charging, High-Resolution Camera");
    }
}
public class absractmath {
    public static void main(String[] args) {

        Phone phone1 = new Samsung();
        Phone phone2 = new iPhone();
        Phone phone3 = new Xiaomi();

        phone1.displayBrand("Samsung");
        phone1.features();

        System.out.println();

        phone2.displayBrand("Apple");
        phone2.features();

        System.out.println();

        phone3.displayBrand("Xiaomi");
        phone3.features();
    }
}