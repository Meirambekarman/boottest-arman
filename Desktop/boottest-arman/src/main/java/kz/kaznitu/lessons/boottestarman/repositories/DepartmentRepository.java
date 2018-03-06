package kz.kaznitu.lessons.boottestarman.repositories;

import kz.kaznitu.lessons.boottestarman.models.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Optional<Department> findById(Long id);
}
