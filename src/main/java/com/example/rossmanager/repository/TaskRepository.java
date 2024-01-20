
package com.example.rossmanager.repository;
import com.example.rossmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;




public interface TaskRepository extends JpaRepository<Task, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}