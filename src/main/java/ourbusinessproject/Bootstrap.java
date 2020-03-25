package ourbusinessproject;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    public InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }

    public void setInitializationService(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try{
            initializationService.initProjects();
        }catch(Exception e){

        }
    }
}
