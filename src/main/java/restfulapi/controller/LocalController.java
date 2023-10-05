package restfulapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restfulapi.controller.advice.exception.LocalNotFound;
import restfulapi.entity.Local;
import restfulapi.service.LocalService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/locals")
public class LocalController {
    private final LocalService localService;

    @GetMapping
    public List<Local> findAll() {
        return localService.findAll();
    }

    @GetMapping("/{id}")
    public Local findById(@PathVariable Long id) throws LocalNotFound {
        return localService.findById(id);
    }

    @PostMapping
    public Local save(@Valid @RequestBody Local local) {
        return localService.save(local);
    }

    @PutMapping("/{id}")
    public Local update(@PathVariable Long id,
                        @RequestBody Local local) {
        return localService.update(id, local);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        localService.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Local> findByNameIgnoreCase(@PathVariable String name) {
        /*Optional<Local> localOptional = localService.findByNameIgnoreCase(name);
        if (localOptional.isPresent()) {
            return localOptional.get();
        }
        return null;*/
        return localService.findByNameIgnoreCase(name);
    }

}
