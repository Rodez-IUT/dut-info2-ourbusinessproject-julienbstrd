package ourbusinessproject;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;
    private String description;

    @ManyToOne
    @NotNull
    public Enterprise entreprise;

    public Project() {

    }

    public Project(String title, String description, Enterprise enterprise) {
        this.title = title;
        this.description = description;
        this.entreprise = enterprise;
    }

    public Enterprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Enterprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() { return id; }
}
