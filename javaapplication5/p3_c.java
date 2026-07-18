class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class MaximumStockLimitException extends Exception {
    public MaximumStockLimitException(String message) {
        super(message);
    }
}

class ProductInventory {
    private int stock;
    private final int MAX_STOCK = 100;

    public ProductInventory(int stock) {
        this.stock = stock;
    }

    public void sellProduct(int quantity)
            throws OutOfStockException, InvalidQuantityException {

        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0.");
        }

        if (quantity > stock) {
            throw new OutOfStockException("Only " + stock + " item(s) available.");
        }

        stock -= quantity;
        System.out.println(quantity + " item(s) sold successfully.");
    }

    public void addStock(int quantity)
            throws InvalidQuantityException, MaximumStockLimitException {

        if (quantity <= 0) {
            throw new InvalidQuantityException("Stock to add must be greater than 0.");
        }

        if (stock + quantity > MAX_STOCK) {
            throw new MaximumStockLimitException(
                "Cannot exceed maximum stock limit of " + MAX_STOCK + " items."
            );
        }

        stock += quantity;
        System.out.println(quantity + " item(s) added successfully.");
    }

    public void displayStock() {
        System.out.println("Current Stock: " + stock);
    }
}

public class p3_c {
    public static void main(String[] args) {

        ProductInventory inventory = new ProductInventory(20);

        inventory.displayStock();

        try {
            inventory.sellProduct(5);
        } catch (OutOfStockException | InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        inventory.displayStock();

        try {
            inventory.sellProduct(30);
        } catch (OutOfStockException | InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            inventory.sellProduct(-2);
        } catch (OutOfStockException | InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            inventory.addStock(90);
        } catch (InvalidQuantityException | MaximumStockLimitException e) {
            System.out.println("Error: " + e.getMessage());
        }

        inventory.displayStock();
    }
}