package informationprojects.mark.service;

import informationprojects.mark.entities.*;
import informationprojects.mark.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected PersonalDataRepository personalDataRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    protected QuestionRepository questionRepository;
    @Autowired
    protected AnswerRepository answerRepository;
    @Autowired
    protected FAQRepository faqRepository;
    @Autowired
    protected SponsorRepository sponsorRepository;

    public User getUser(String username)
    {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public Iterable<Question> getQuestions() { return questionRepository.findAll(); }

    public void saveQuestion(Question question) { questionRepository.save(question); }

    public Account getAccountByUserId(Integer id) { return accountRepository.findById(id).get();}

    public User getUserByAccountId(Integer id) { return userRepository.findById(id).get(); }

    public Iterable<Answer> getAllAnswersByQuestionId(Question question) {return answerRepository.findAllByQuestion(question); }

    public Question getQuestionByQuestionId(Integer id) { return questionRepository.findById(id).get(); }

    public Account getAccountByAccountIdFromQuestion(Integer id) { return accountRepository.findById(id).get(); }

    public void saveAnswer(Answer answer) { answerRepository.save(answer); }

    public void saveAccount(Account account) { accountRepository.save(account); }

    public PersonalData getPersronalDataByUserId(Integer id) { return personalDataRepository.findById(id).get(); }

    public void savePersonalData(PersonalData personalData) { personalDataRepository.save(personalData); }

    public Iterable<Account> getAllAccounts() { return accountRepository.findAll(); }

    public Iterable<User> getAllUsers() { return userRepository.findAll(); }

    public Iterable<Question> getQuestionsByTag(String tag) { return questionRepository.findAllByTag(tag); }

    public Iterable<FAQ> getAllFAQ() { return faqRepository.findAll(); }

    public Iterable<Sponsor> getAllSponsors() { return sponsorRepository.findAll(); }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
