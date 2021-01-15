package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(Integer id);

    TodoItem getItem(Integer id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();

}
