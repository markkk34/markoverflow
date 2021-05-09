package informationprojects.mark.controllers;

import informationprojects.mark.entities.*;
import informationprojects.mark.repository.PersonalDataRepository;
import informationprojects.mark.repository.UserRepository;
import informationprojects.mark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController
{
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository; //DELETEEEEEE
    @Autowired
    PersonalDataRepository personalDataRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model)
    {
        //model.put("name", name);
        return "greeting";
    }

/*    @GetMapping("/login")
    public String goLog(Map<String, Object> model)
    {
        //model.put("name", name);
        return "login";
    }*/
/*

    @PostMapping("/login")
    public String logged(Map<String, Object> model)
    {
        return "redirect:/main";
    }
*/

    @GetMapping("/main")
    public String main(String changeLogin, String changePassword, Map<String, Object> model)
    {
        if (changePassword != null && !changePassword.isEmpty())
        {
            User user1 = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
            //User userNew = user;
            user1.setPassword(changePassword);
            //user1.setUsername(changeLogin);
            userService.saveUser(user1);

            model.put("result", "выполнено");
        }

        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUser(login);
        //model.put("extra", user.getUser_id());
        model.put("name", login);//put("name", "kmd"); //user.getUsername() == null ? "null" : "Mark");
        model.put("password", userService.getUser(login).getPassword());
        //model.put("login", login);

        PersonalData personalData = userService.getPersronalDataByUserId(user.getUser_id());

        model.put("personalId", personalData.getPersonal_data_id());
        model.put("whatName",personalData.getName());
        model.put("whatAge", personalData.getAge());
        model.put("whatJob", personalData.getJob());
        model.put("whatAddress", personalData.getAddress());
        //model.put("user", userService.getUser(login));
        //System.out.println(userRepository.findById(user.getUser_id())); RIGHT
        /*Iterable<User> u = userRepository.fin);
        for (User i : u) {
            System.out.println(i.getUsername() + " " + i.getUser_id());
        }*/

        //System.out.println(personalDataRepository.findNameByPersonal_data_id(user.getUser_id()));
        //PersonalData personalData = personalDataRepository.findById(user.getUser_id()).get();
        //System.out.println(personalData.getName());

        //System.out.println(personalDataRepository.findNameByPersonal_data_id(user.getUser_id()));

        return "main";
    }

    @PostMapping("/main")
    public String changePersonalData(String changeName, Integer changeAge, String changeJob, String changeAddress,
                                     Integer personalId, Map<String, Object> model)
    {
        PersonalData personalData = userService.getPersronalDataByUserId(personalId);
        personalData.setName(changeName);
        personalData.setAddress(changeAddress);
        personalData.setAge(changeAge);
        personalData.setJob(changeJob);

        userService.savePersonalData(personalData);

        return "redirect:/main";
    }

    @PostMapping("makeReport")
    public String followToReportPage(Map<String, Object> model)
    {
        return "report";
    }

    @GetMapping("/halloffame")
    public String showTheFame(Map<String, Object> model)
    {
        Iterable<User> users = userService.getAllUsers();
        Iterable<Account> accounts = userService.getAllAccounts();
        Map<Integer, Integer> mapAccountIdRate = new HashMap<Integer, Integer>();

        for (Account i : accounts)//now we have mapped account & we can sort by rate-value
        {
            mapAccountIdRate.put(i.getAccount_id(), i.getRate());
            //System.out.println(i.getAccount_id());
        }
        //mapAccountIdRate.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        //String arrayOfOurTop;
        ArrayList<String> arrayWhoAnswered = new ArrayList<>();
        String res = "";
        for (User i : users)
        {
            arrayWhoAnswered.add("rate : " + mapAccountIdRate.get(i.getUser_id()).toString() + "; username : " +
                    i.getUsername().toString()+"\n");
            res = res + "    rate : " + mapAccountIdRate.get(i.getUser_id()).toString() + "; username : " +
                    i.getUsername().toString()+"\n";
        }

        for (String i : arrayWhoAnswered)
        {
            System.out.println(i);
        }
        Iterable<String> result = arrayWhoAnswered;
        /*for (int i = 0; i < arrayWhoAnswered.size(); i++)
        {
            result. = arrayWhoAnswered.get(i);
        }*/

        model.put("fame", res);

        /*Integer size = arrayWhoAnswered.size();
        String[] arrayResult = new String[size];
        for (int i = 0; i < size; i++)
        {
            arrayResult[i] = arrayWhoAnswered.get(i);
        }
        Iterable<String> good = arrayWhoAnswered;
        model.put("fame", good);*/
        //model.put("fame", arrayWhoAnswered);
        /*for (String i : arrayWhoAnswered)
        {
            System.out.println(i);
        }*/
        return "halloffame";
    }

    @GetMapping("/faq")
    public String loadFAQ(Map<String, Object> model)
    {
        Iterable<FAQ> faqs = userService.getAllFAQ();
        model.put("faq", faqs);
        return "faq";
    }

    @GetMapping("/sponsors")
    public String loadSponsors(Map<String, Object> model)
    {
        Iterable<Sponsor> sponsors = userService.getAllSponsors();
        model.put("sponsor", sponsors);
        return "sponsors";
    }


    /*@PostMapping("changing")
    public String changing(@RequestParam String changeVal, Map<String, Object> model)
    {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        //User userNew = user;
        user.setPassword(changeVal);
        userService.saveUser(user);

        model.put("result", "done");
        return "redirect:/main";
    }*/

    @GetMapping("/report")
    public String loadReport(Map<String, Object> model)
    {

        return "report";
    }

    @PostMapping("/report")
    public String makeReport(String reportMessage, String reportUsername, Map<String, Object> model)
    {
        User user = userService.getUser(reportUsername);
        Account account = userService.getAccountByUserId(user.getUser_id());
        account.setRate(account.getRate() - 1);
        userService.saveAccount(account);
        return "redirect:/main";
    }

}
