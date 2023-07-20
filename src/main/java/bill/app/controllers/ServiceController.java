package bill.app.controllers;

import bill.app.entities.Service;
import bill.app.services.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public Collection<Service> getAll() {
        return serviceService.getAll();
    }

    @GetMapping("{serviceId}")
    public ResponseEntity<Service> getById(@PathVariable Long serviceId) {
        return ResponseEntity.ok(serviceService.getById(serviceId));
    }

}
