package bill.app.services;

import bill.app.exceptions.NotFoundException;
import bill.app.repositories.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Collection<bill.app.entities.Service> getAll() {
        return serviceRepository.findAll();
    }

    public bill.app.entities.Service getById(Long serviceId) {
        return serviceRepository.findById(serviceId).stream()
                .filter(service -> service.getId().equals(serviceId))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
