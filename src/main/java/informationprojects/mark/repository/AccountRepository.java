package informationprojects.mark.repository;

import informationprojects.mark.entities.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer>
{

}
