package restfulapi.service;

import restfulapi.controller.advice.exception.LocalNotFound;
import restfulapi.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    List<Local> findAll();
    Local findById(Long id) throws LocalNotFound;
    void deleteById(Long id);
    Local save(Local local);
    Local update(Long id,
                 Local local);
    Optional<Local> findByNameIgnoreCase(String name);
}
