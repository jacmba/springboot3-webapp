package net.jazbelt.springboot3webapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TodoService {
    /* private static List<Todo> todos;

    private final AtomicInteger todosCount = new AtomicInteger(3);

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "john", "Learn AWS",
                        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "jack", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "jane", "Learn Full Stack",
                LocalDate.now().plusYears(3), false));
    } */

    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> find() {
        // return todos;

        return repository.findAll();
    }

    public List<Todo> findByUserName(String username) {
        /* return todos.stream()
                .filter(x -> x.getUsername().equals(username))
                .collect(Collectors.toList()); */

        return repository.findByUsername(username);
    }

    public Optional<Todo> findById(int id) {
        /* return todos.stream()
                .filter(x -> x.getId() == id)
                .findFirst(); */

        return repository.findById(id);
    }

    public void addTodo(String username, String description, LocalDate targetDate) {
        /* todos.add(new Todo(todosCount.incrementAndGet(),
                username, description, targetDate, false)); */

        repository.save(new Todo(username, description, targetDate, false));
    }

    public void deleteTodo(int id) {
        // todos.removeIf(x -> x.getId() == id);

        repository.deleteById(id);
    }

    public void updateTodo(Todo todo) {
        /* todos.stream()
                .filter(x -> x.getId() == todo.getId())
                .forEach(x -> {
                    x.setDescription(todo.getDescription());
                    x.setTargetDate(todo.getTargetDate());
                }); */

        repository.save(todo);
    }
}
