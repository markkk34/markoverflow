package informationprojects.mark.entities;

import javax.persistence.*;

@Entity
@Table(name = "personal_data")
public class PersonalData
{
    /*@Id
    @Column(name = "personal_data_id")
    protected Integer personal_data_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "personal_data_id")
    protected User user;*/

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected User user;

    @Id
    @Column(name = "personal_data_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer personal_data_id;


    /*@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected Account account;*/

    @Column(name = "name")
    protected String name;
    @Column(name = "age")
    protected Integer age;
    @Column(name = "job")
    protected String job;
    @Column(name = "address")
    protected String address;

    public PersonalData(){}

    //CONSTR WITH PARAMS


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPersonal_data_id() {
        return personal_data_id;
    }

    public void setPersonal_data_id(Integer personal_data_id) {
        this.personal_data_id = personal_data_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
