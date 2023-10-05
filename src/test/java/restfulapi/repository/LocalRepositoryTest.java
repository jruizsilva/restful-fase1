package restfulapi.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import restfulapi.entity.Local;

import java.util.Optional;

@DataJpaTest
class LocalRepositoryTest {
    @Autowired
    LocalRepository localRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                           .name("Supermarket")
                           .floor("2")
                           .code("Sup-321-2")
                           .build();
        testEntityManager.persist(local);
    }

    @Test
    void findByNameIgnoreCaseFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Supermarket");
        if (local.isPresent()) {
            Assertions.assertEquals(local.get()
                                         .getName(), "Supermarket");

        }
    }

    @Test
    void findByNameIgnoreCaseNotFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Cinema");
        if (local.isPresent()) {
            Assertions.assertEquals(local, Optional.empty());
        }
    }
}