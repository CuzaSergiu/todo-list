package academy.learnprogramming.controller;


import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://lcoalhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "0") Integer id,
                              Model model) {

        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);

        // if the service doesnt find any matching id it will return null at which point we create a new item and add that to the service
        // if the service finds an item it will then let you edit
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from from = {}", todoItem);

        if (todoItem.getId() == null) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        // will redirect to the items list
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam Integer id) {
        log.info("Deleting item with id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEMS)
    public String viewItem(@RequestParam Integer id, Model model) {
        log.info("View item with id = {} ", id);
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;

    }


}
