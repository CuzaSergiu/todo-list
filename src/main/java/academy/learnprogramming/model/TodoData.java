package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// in-memory data base
public class TodoData {

    // == fields ==
    private static Integer idValue = 1;

    // make the List final so we can change the alrdy introduced data
    private final List<TodoItem> items = new ArrayList<>();

    // == constructors ==
    public TodoData() {

        // add dummy data using addItem method
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
        addItem(new TodoItem("four", "four details", LocalDate.now()));


    }

    // == public methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {

        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(Integer id) {
        // created a ListIterator
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        // loops through the list , checking if there are any elements using hasNext()
        while (itemListIterator.hasNext()) {
            // method next() is used to get the item from the list
            TodoItem item = itemListIterator.next();

            // we check if the item we get matches the id , if the condition is true we use remove() method
            if (item.getId() == id) {
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(Integer id) {
        // loops through the items list
        for (TodoItem item : items) {
            // if the getId() matches the items id it will return the item
            if (item.getId() == id) {
                return item;
            }
        }
        // otherwise it will return null
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        // created a ListIterator
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        // loops through each item
        while (itemListIterator.hasNext()) {
            TodoItem item = itemListIterator.next();

            // we check if 2 items are equal, if they match we will pass with set() method from Iterator,
            // our object to the one that matched in our list
            if (item.equals(toUpdate)) {
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }
}
