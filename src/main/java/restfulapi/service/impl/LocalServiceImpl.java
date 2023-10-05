package restfulapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restfulapi.controller.advice.exception.LocalNotFound;
import restfulapi.entity.Local;
import restfulapi.repository.LocalRepository;
import restfulapi.service.LocalService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocalServiceImpl implements LocalService {
    private final LocalRepository localRepository;

    @Override
    public List<Local> findAll() {
        return localRepository.findAll();
    }

    @Override
    public Local findById(Long id) throws LocalNotFound {
        Optional<Local> localOptional = localRepository.findById(id);
        if (localOptional.isEmpty()) {
            throw new LocalNotFound("Local not found");
        }
        return localOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Local save(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local update(Long id,
                        Local local) {
        Local localDb = localRepository.findById(id)
                                       .get();
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localDb.setCode(local.getCode());
        }
        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localDb.setFloor(local.getFloor());
        }
        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localDb.setName(local.getName());
        }
        return localRepository.save(localDb);
    }

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
    }

}
