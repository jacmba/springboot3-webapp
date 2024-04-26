package net.jazbelt.springboot3webapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos;

    private final AtomicInteger todosCount = new AtomicInteger(3);

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "john", "Learn AWS",
                        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "jack", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "jane", "Learn Full Stack",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> find() {
        return todos;
    }

    public List<Todo> findByUserName(String username) {
        return todos.stream()
                .filter(x -> x.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public void addTodo(String username, String description, LocalDate targetDate) {
        todos.add(new Todo(todosCount.incrementAndGet(),
                username, description, targetDate, false));
    }

    public void deleteTodo(int id) {
        todos.removeIf(x -> x.getId() == id);
    }
}
