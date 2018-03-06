package kz.kaznitu.lessons.boottestarman.repositories;

import kz.kaznitu.lessons.boottestarman.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findById(Long id);
}
