package informationprojects.mark.repository;

import informationprojects.mark.entities.Answer;
import informationprojects.mark.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer>
{
    public Iterable<Answer> findAllByQuestion(Question question);
}
