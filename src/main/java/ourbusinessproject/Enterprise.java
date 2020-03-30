package ourbusinessproject;



import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue
    private Long Id;

    @NotEmpty
    private String Name;

    @NotEmpty
    @Size(min = 10)
    private String Description;

    @OneToMany(mappedBy = "entreprise")
    @JsonIgnore
    public Collection<Project>  Projects ;

    @JsonIgnore
    public Collection<Project> getProjects() {
        return Projects;
    }

    public void setProjects(Collection<Project> projects) {
        Projects = projects;
    }

    @NotEmpty
    private String ContactName;

    @NotEmpty
    @Email
    private String ContactEmail;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    public Long getId() { return Id; }

    public void addProject(Project p){
        if(this.Projects == null){
            this.Projects = new ArrayList<Project>();
        }
        this.Projects.add(p);

    }
}
