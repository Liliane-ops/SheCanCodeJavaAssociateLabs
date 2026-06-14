package inventory;

public class Products {

    public static class Product {

        private String id;
        private String name;
        private String category;
        private double price;

        public Product(String id, String name, String category, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        Product product = new Product(
                "P001",
                "Laptop",
                "Electronics",
                1200000.00
        );

        System.out.println(product);
    }
}