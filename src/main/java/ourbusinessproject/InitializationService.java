package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InitializationService {

    public Project Project1E1;

    public Project Project1E2;

    public Project Project2E1;

    public Enterprise Entreprise1;

    public Enterprise Entreprise2;

    @Autowired
    public EnterpriseProjectService EnterpriseProjectService;

    public Project projet;

    public Project getProject1E1() {
        return Project1E1;
    }

    public void setProject1E1(Project project1E1) {
        Project1E1 = project1E1;
    }

    public Project getProject1E2() {
        return Project1E2;
    }

    public void setProject1E2(Project project1E2) {
        Project1E2 = project1E2;
    }

    public Project getProject2E1() {
        return Project2E1;
    }

    public void setProject2E1(Project project2E1) {
        Project2E1 = project2E1;
    }

    public Enterprise getEntreprise1() {
        return Entreprise1;
    }

    public void setEntreprise1(Enterprise entreprise1) {
        Entreprise1 = entreprise1;
    }

    public Enterprise getEntreprise2() {
        return Entreprise2;
    }

    public void setEntreprise2(Enterprise entreprise2) {
        Entreprise2 = entreprise2;
    }

    @Transactional
    public void initProjects() {
        /*
         * Lorsque l'initialisation de l'un des projet ne se fais pas correctement en omettant
         * par exemple une information obligatoire (le titre ou la description ou l'entreprise par exemple)
         * Cela fausse la transaction qui s'arrete alors et renvoie une erreur sans initialiser les projet correctement ecrit
         * La transaction fait donc toute les initialisation si correcte sinon aucune si ,l'une d'elle est incorrecte
         */
        Entreprise1 = new Enterprise();
        Entreprise1.setName("Entreprise1");
        Entreprise1.setDescription("description Entreprise1");
        Entreprise1.setContactEmail("contact@entreprise1.fr");
        Entreprise1.setContactName("entreprise1 contact");

        Entreprise2 = new Enterprise();
        Entreprise2.setName("Entreprise2");
        Entreprise2.setDescription("description Entreprise2");
        Entreprise2.setContactEmail("contact@Entreprise2.fr");
        Entreprise2.setContactName("Entreprise2 contact");

        Project1E1 = new Project();
        Project1E1.setTitle("projet 1 E1");
        Project1E1.setDescription("Description Projet 1 E1");
        Project1E1.setEntreprise(Entreprise1);

        Project2E1 = new Project();
        Project2E1.setTitle("projet 2 E1");
        Project2E1.setDescription("Description Projet 2 E1");
        Project2E1.setEntreprise(Entreprise1);

        Project1E2 = new Project();
        Project1E2.setTitle("projet 1 E2");
        Project1E2.setDescription("Description Projet 1 E2");
        Project1E2.setEntreprise(Entreprise2);

        Entreprise1.addProject(Project1E1);
        Entreprise1.addProject(Project2E1);
        Entreprise2.addProject(Project1E2);

        EnterpriseProjectService.save(Project1E1);
        EnterpriseProjectService.save(Project2E1);
        EnterpriseProjectService.save(Project1E2);
    }
}
