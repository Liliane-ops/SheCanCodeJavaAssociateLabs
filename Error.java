package inventory;

public class Error {

    public static void main(String[] args) {
        WareHouse<Products.Product> store = new WareHouse<>();

        Products.Product product = new Products.Product(
                "P001",
                "Laptop",
                "Electronics",
                1200.0
        );

        store.addItem(product);

        store.getItems().forEach(System.out::println);
    }
}