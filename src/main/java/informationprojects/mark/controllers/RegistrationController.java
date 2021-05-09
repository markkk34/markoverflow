package informationprojects.mark.controllers;

import informationprojects.mark.entities.Account;
import informationprojects.mark.entities.PersonalData;
import informationprojects.mark.entities.User;
import informationprojects.mark.repository.AccountRepository;
import informationprojects.mark.repository.PersonalDataRepository;
import informationprojects.mark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController
{
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected PersonalDataRepository personalDataRepository;

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model)
    {
        User userDB = userRepository.findByUsername(user.getUsername());
        if (userDB != null)
        {
            model.put("message", "Пользователь уже зарегестрирован");
            return "registration";
        }

        //user.setRole(Collections.singleton());
        user.setEnabled(true);
        userRepository.save(user);

        System.out.println("1 - " +  user.getUser_id().longValue());
        System.out.println("2 - " + userRepository.findByUsername(user.getUsername()).getUser_id());
        //System.out.println("3 - " + userRepository.findByUsername_id(user.getUser_id()));
        //System.out.println("3 " + personalDataRepository.findById(user.getUser_id()).getPersonal_data_id());

        /*PersonalData personalData = new PersonalData();
        System.out.println("feels");
        personalData.setUser(user);
        System.out.println("so");*/
        //personalData.setPersonal_data_id(user.getUser_id());
        //personalData.setName("unknown");
        //personalData.setUser(user);
        /*personalDataRepository.save(personalData);

        Account account = new Account();
        System.out.println("good");
        account.setPersonalData(personalData);
        //account.setAccount_id(user.getUser_id());
        //account.setRate(0);
        accountRepository.save(account);
*/
        return "redirect:/login";
    }
}
