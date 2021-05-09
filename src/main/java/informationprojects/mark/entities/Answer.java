package informationprojects.mark.entities;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer answer_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    protected Question question;

    @Column(name = "answer")
    protected String answer;

    @Column(name = "login")
    protected String login;

    public Answer() {}

    public Answer(String answer, String login, Question question)
    {
        this.answer = answer;
        this.login = login;
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
