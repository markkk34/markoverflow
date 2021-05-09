package informationprojects.mark.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer question_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    protected Account account;

    @Column(name = "tag")
    protected String tag;
    @Column(name = "question")
    protected String question;
    @Column(name = "difficulty")
    protected Boolean difficulty;

    public Question() {}

    //CONSTR WITH PARAMS


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Boolean difficulty) {
        this.difficulty = difficulty;
    }
}
