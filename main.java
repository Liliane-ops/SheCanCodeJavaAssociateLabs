import java.util.Collections;
package main;
public class main {


    public class Main {

        public static void main(String[] args) {

            WarehouseStore<Products> store = new WarehouseStore<>();

            store.addItem(
                    new Product("P001",
                            "Laptop",
                            "Electronics",
                            1200.0)
            );

            store.addItem(
                    new Product("P002",
                            "Mouse",
                            "Electronics",
                            50.0)
            );

            store.addItem(
                    new Product("P003",
                            "Table",
                            "Furniture",
                            300.0)
            );

            System.out.println("Electronics:");

            store.findByCategory("Electronics")
                    .forEach(System.out::println);

            System.out.println("\nSorted Products:");

            Collections.sort(
                    store.getItems(),
                    ProductComparator.getComparator()
            );

            store.getItems()
                    .forEach(System.out::println);
        }
    }
}
