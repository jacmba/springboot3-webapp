package net.jazbelt.springboot3webapp.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
@RequestMapping("todos")
public class TodoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllTodos(@SessionAttribute String name,  ModelMap model) {
        logger.info(String.format("Retrieveving list of ToDos for %s", name));
        List<Todo> todos = service.findByUserName(name);
        model.put("todos", todos);
        return "listTodos";
    }

    @GetMapping("/add")
    public String getNewTodoPage() {
        return "addTodo";
    }

    @PostMapping("/add")
    public String postNewTodo(@RequestParam String description,
                              @SessionAttribute String name,
                              ModelMap model) {
        service.addTodo(name, description, LocalDate.now().plusYears(1));
        return getAllTodos(name, model);
    }
}
