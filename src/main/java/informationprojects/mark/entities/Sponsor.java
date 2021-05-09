package informationprojects.mark.entities;

import javax.persistence.*;

@Entity
@Table(name = "sponsors")
public class Sponsor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sponsor_id")
    protected Integer sponsor_id;

    @Column(name = "link")
    protected String link;
    @Column(name = "company")
    protected String company;

    public Sponsor() {}

    public Integer getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(Integer sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
