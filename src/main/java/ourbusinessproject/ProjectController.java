package ourbusinessproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private EnterpriseProjectService entrepriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.entrepriseProjectService = enterpriseProjectService;
    }

    @RequestMapping(value="/projectsWithEnterprises")
    public List<Project> findAllProjectsWithEnterprises() {
        return entrepriseProjectService.findAllProjects();
    }
}
