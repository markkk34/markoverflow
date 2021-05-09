package informationprojects.mark.repository;

import informationprojects.mark.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer>
{
    public Iterable<Question> findAllByTag(String tag);
}
