package org.example.repository;




import org.example.entity.Status;
import org.example.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasksRepository  extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByOrderByIdDesc();
    List<Tasks> findByStatus(Status status);
}
