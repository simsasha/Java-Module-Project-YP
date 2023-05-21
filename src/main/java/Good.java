public class Good {
    public double price = 0.00;
    public String name = "New Good";

    public String goodCreated(String name, double price) { // Метод создания товара.
        this.priceSet(price);
        this.nameSet(name);
        String formattedDouble = String.format("%.2f", this.price); // Можно было бы вынести в отдельный метод, чтобы было DRY, но не вижу смысла;
        String goodCreated = this.name + formattedDouble;
        return goodCreated;
    }

    public double priceSet(double price) {
        this.price = price;
        // System.out.println("Price has set " + this.price);
        return this.price;
    }

    public String nameSet(String name) {
        this.name = name;
        // System.out.println("Name has set " + this.name);
        return this.name;
    }
}
