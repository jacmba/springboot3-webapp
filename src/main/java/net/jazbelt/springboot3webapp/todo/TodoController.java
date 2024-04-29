package net.jazbelt.springboot3webapp.todo;

import jakarta.validation.Valid;
import net.jazbelt.springboot3webapp.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("todos")
public class TodoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllTodos(ModelMap model) {
        String name = AppUtils.getLoggedUser();
        logger.info(String.format("Retrieveving list of ToDos for %s", name));
        List<Todo> todos = service.findByUserName(name);
        model.put("todos", todos);
        return "listTodos";
    }

    @GetMapping("/add")
    public String getNewTodoPage(ModelMap model) {
        String name = AppUtils.getLoggedUser();
        Todo todo = new Todo(name, "",
                LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/add")
    public String postNewTodo(ModelMap model, @Valid Todo todo,
                              BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String name = AppUtils.getLoggedUser();
        service.addTodo(name, todo.getDescription(), todo.getTargetDate());
        return redirectToList(model);
    }

    @GetMapping("/delete/{id}")
    public String getDeleteTodo(@PathVariable int id,
                                 ModelMap model) {
        logger.info(String.format("Deleting ToDo with id %d", id));

        service.deleteTodo(id);
        return redirectToList(model);
    }

    @GetMapping("/update/{id}")
    public String getUpdateTodo(@PathVariable int id,
                                ModelMap model) {
        Optional<Todo> todo = service.findById(id);

        if (todo.isPresent()) {
            model.put("todo", todo);
            return "todo";
        }

        return redirectToList(model);
    }

    @PostMapping("/update/{id}")
    public String postUpdateTodo(ModelMap model,
                                 @Valid Todo todo,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }

        service.updateTodo(todo);
        return redirectToList(model);
    }

    private String redirectToList(ModelMap model) {
        model.addAttribute("attribute",
                "redirectWithRedirectedPrefix");
        return "redirect:/todos";
    }
}
