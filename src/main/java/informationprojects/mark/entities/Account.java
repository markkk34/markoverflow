package informationprojects.mark.entities;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account
{
    /*@Id
    @Column(name = "account_id")
    protected Integer account_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    protected PersonalData personalData;*/


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected PersonalData personalData;

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer account_id;

    @Column(name = "rate")
    protected Integer rate;

    public Account() {}

    //CONSTR WITH PARAMS

    /*public Account(Integer rate)
    {
        this.rate = rate;
    }*/

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
