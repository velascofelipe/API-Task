package com.example.rossmanager;

import com.example.rossmanager.domain.Task;
import com.example.rossmanager.repository.TaskRepository;
import com.example.rossmanager.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void getAllTasks() {
        // Simular el comportamiento del repositorio
        List<Task> mockTasks = new ArrayList<>();
        mockTasks.add(new Task(1L, "Task 1", "Description 1", false));
        mockTasks.add(new Task(2L, "Task 2", "Description 2", true));
        Mockito.when(taskRepository.findAll()).thenReturn(mockTasks);

        // Llamar al servicio y verificar el resultado
        List<Task> tasks = taskService.findAll();
        Assertions.assertEquals(2, tasks.size());
    }

    @Test
    void getTaskById() {
        // Simular el comportamiento del repositorio
        Task mockTask = new Task(1L, "Task 1", "Description 1", false);
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(mockTask));

        // Llamar al servicio y verificar el resultado
        Optional<Task> task = taskService.getTaskById(1L);
        Assertions.assertTrue(task.isPresent());
        Assertions.assertEquals("Task 1", task.get().getTitle());
    }

    // Otros métodos de prueba...

}