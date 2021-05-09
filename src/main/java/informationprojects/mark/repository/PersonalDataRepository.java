package informationprojects.mark.repository;

import informationprojects.mark.entities.PersonalData;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalData, Integer>
{
    //PersonalData findNameByPersonal_data_id(Integer personal_data_id);
    //Iterable<PersonalData> find;
    //public PersonalData findById(Integer id);
}
