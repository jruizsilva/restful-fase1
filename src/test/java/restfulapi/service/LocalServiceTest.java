package restfulapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import restfulapi.entity.Local;
import restfulapi.repository.LocalRepository;

import java.util.Optional;

@SpringBootTest
class LocalServiceTest {
    @Autowired
    LocalService localService;
    @MockBean
    LocalRepository localRepository;

    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                           .name("Supermarket")
                           .floor("2")
                           .code("Sup-321-2")
                           .build();
        Mockito.when(localRepository.findByNameIgnoreCase("Supermarket"))
               .thenReturn(Optional.of(local));
    }

    @Test
    void findByNameIgnoreCaseShouldFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Supermarket");
        if (local.isPresent()) {
            Assertions.assertEquals("Supermarket",
                                    local.get()
                                         .getName());
            System.out.println("local = " + local);
        }
    }
}