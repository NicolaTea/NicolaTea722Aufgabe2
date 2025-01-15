package Repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepo<T> {
    private final Map<Integer, T> items = new HashMap<>();

    /**
     * Add new item
     * @param id
     * @param item
     */
    public void add(Integer id, T item) {
        if (items.containsKey(id)) {
            System.out.println("Error: An item with ID " + id + " already exists.");
        } else {
            items.put(id, item);
            System.out.println("Item with ID " + id + " added successfully.");
        }
    }

    /**
     * update an existing item
     * @param id
     * @param item
     */
    public void update(Integer id, T item) {
        if (!items.containsKey(id)) {
            System.out.println("Error: No item with ID " + id + " found to update.");
        } else {
            items.put(id, item);
            System.out.println("Item with ID " + id + " updated successfully.");
        }
    }

    /**
     * delete an item
     * @param id
     */
    public void delete(Integer id) {
        if (!items.containsKey(id)) {
            System.out.println("Error: No item with ID " + id + " found to delete.");
        } else {
            items.remove(id);
            System.out.println("Item with ID " + id + " deleted successfully.");
        }
    }

    /**
     * get all items
     * @return
     */
    public List<T> getAll() {
        return List.copyOf(items.values());
    }

    /**
     * get item by id
     * @param id
     * @return
     */
    public T getById(int id) {
        return items.get(id);
    }

}
