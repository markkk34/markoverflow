package informationprojects.mark.entities;

import javax.persistence.*;

@Entity
@Table(name = "faq")
public class FAQ
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "faq_id")
    protected Integer faq_id;

    @Column(name = "question")
    protected String question;
    @Column(name = "answer")
    protected String answer;

    public FAQ() {}

    public Integer getFaq_id() {
        return faq_id;
    }

    public void setFaq_id(Integer faq_id) {
        this.faq_id = faq_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
