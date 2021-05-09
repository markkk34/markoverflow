package informationprojects.mark.controllers;

import informationprojects.mark.entities.Account;
import informationprojects.mark.entities.Answer;
import informationprojects.mark.entities.Question;
import informationprojects.mark.entities.User;
import informationprojects.mark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/questions")
public class QuestionController
{
    @Autowired
    protected UserService userService;

    @GetMapping
    public String mainQuestions(String myQuestion, String myTag, String searchTag,
                                Boolean myDifficulty , Model model)
    {
        if (myQuestion != null && !myQuestion.isEmpty())
        {
            Question question = new Question();
            question.setQuestion(myQuestion);
            question.setTag(myTag);
            question.setDifficulty(myDifficulty);
            Account account = userService.getAccountByUserId(
                    userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()).getUser_id());
            question.setAccount(account);
            System.out.println("imma");
            userService.saveQuestion(question);
            System.out.println("here");
        }

        if (searchTag != null && !searchTag.isEmpty())
        {
            Iterable<Question> questions = userService.getQuestionsByTag(searchTag);
            model.addAttribute("questions", questions);
        }
        else {
            Iterable<Question> questions = userService.getQuestions();
            model.addAttribute("questions", questions);
        }

        return "questions";
    }

    @GetMapping("{question_id}")
    public String openAnswer(@PathVariable Integer question_id, String usernameWhoHelped,
                             String myAnswer, Question questionObj, Map<String, Object> model)
    {
        if (usernameWhoHelped != null && !usernameWhoHelped.isEmpty())
        {
            User userWhoHelped = userService.getUser(usernameWhoHelped);
            Account accountWhoHelped = userService.getAccountByUserId(userWhoHelped.getUser_id());
            accountWhoHelped.setRate(accountWhoHelped.getRate() + 1);
            userService.saveAccount(accountWhoHelped);
        }

        if (myAnswer != null && !myAnswer.isEmpty())
        {
            System.out.println("we");
            Answer answer = new Answer();
            answer.setAnswer(myAnswer);
            answer.setQuestion(questionObj);
            answer.setLogin(SecurityContextHolder.getContext().getAuthentication().getName());
            System.out.println("are");
            userService.saveAnswer(answer);
            System.out.println("here");
        }
        Question question = userService.getQuestionByQuestionId(question_id);
        System.out.println("My");
        Account account = question.getAccount();
        System.out.println("name");
        model.put("rate", account.getRate());
        User user = userService.getUserByAccountId(account.getAccount_id());
        System.out.println("is");
        model.put("username", user.getUsername());
        model.put("question", question.getQuestion());
        model.put("tag", question.getTag());
        Iterable<Answer> answers = userService.getAllAnswersByQuestionId(question);
        System.out.println("not");
        model.put("answers", answers);
        model.put("questionObj", question);
        System.out.println("long");
        //model.addAttribute("account", account);
        return "answers";
    }

    @PostMapping
    public String back(Map<String, Object> model)
    {
        return "redirect:/questions";
    }

    /*@PostMapping
    public String addAnswer(String myAnswer, Question questionObj ,Map<String, Object> model)
    {
        System.out.println("we");
        Answer answer = new Answer();
        answer.setAnswer(myAnswer);
        answer.setQuestion(questionObj);
        answer.setLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("are");
        userService.saveAnswer(answer);
        System.out.println("here");

        return "redirect:/questions/" + questionObj.getQuestion_id();
    }*/

}
