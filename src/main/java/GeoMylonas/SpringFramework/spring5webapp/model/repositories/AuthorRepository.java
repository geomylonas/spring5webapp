package GeoMylonas.SpringFramework.spring5webapp.model.repositories;

import GeoMylonas.SpringFramework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
