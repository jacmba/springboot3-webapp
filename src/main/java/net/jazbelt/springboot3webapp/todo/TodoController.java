package net.jazbelt.springboot3webapp.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
@RequestMapping("/todos")
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
}
