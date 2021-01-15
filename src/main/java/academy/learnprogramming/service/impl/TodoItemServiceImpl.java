package academy.learnprogramming.service.impl;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    @Getter
    private final TodoData data = new TodoData();

    // == public methods ==
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(Integer id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(Integer id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
