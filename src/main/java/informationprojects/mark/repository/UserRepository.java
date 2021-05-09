package informationprojects.mark.repository;

import informationprojects.mark.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>
{
    //Integer findByUsername(String username);
    User findByUsername(String username);
    User findPasswordByUsername(String username);
    //User findByUser_id(Integer user_id);
    //Iterable<User> findAllByUser_id(Integer user_id);
    //User findByUsername_id(Integer id);
}
