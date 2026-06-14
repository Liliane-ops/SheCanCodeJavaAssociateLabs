
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WareHouse<T extends Products> {

    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(String id) {
        Iterator<T> iterator = items.iterator();

        while (iterator.hasNext()) {
            T item = iterator.next();

            if (item.getClass().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<T> getItems() {
        return items;
    }
}