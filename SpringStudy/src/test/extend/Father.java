package test.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Father {
    @Autowired
    Service1 service;

    public Service1 getService() {
        return service;
    }

    public void setService(Service1 service) {
        this.service = service;
    }

    
}
