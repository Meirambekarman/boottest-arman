package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
