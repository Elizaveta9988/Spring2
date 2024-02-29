package Task10;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.springHW5.model.Task;
import ru.geekbrains.springHW5.model.TaskStatus;
import ru.geekbrains.springHW5.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class TaskService {
       return repository.save(task);
}

/**
 * Получить все задачи.
 *
 * @return список задач.
 */
public List<Task> getAllTasks() {
    return repository.findAll();
}

/**
 * Просмотр задач по статусу
 *
 * @param status статус задачи
 * @return список задач одного статуса
 */
public List<Task> findByStatus(TaskStatus status) {
    return repository.findByStatus(status);
}

/**
 * Изменение статуса задачи
 *
 * @param id   ID задачи
 * @param task задача с новым статусом
 * @return сохраняет новый статут у задачи
 */
public Task updateTaskStatus(Long id, Task task) {
    Optional<Task> optionalTask = repository.findById(id);
    if (optionalTask.isPresent()) {
        Task task1 = optionalTask.get();
        task1.setStatus(task.getStatus());
        return repository.save(task1);
    } else {
        throw new IllegalArgumentException("Task not found with id");
    }
}

public void deleteTask(Long id) {
    repository.deleteById(id);
}
}
