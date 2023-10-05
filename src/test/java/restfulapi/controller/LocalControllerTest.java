package restfulapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import restfulapi.entity.Local;
import restfulapi.service.LocalService;

@WebMvcTest(LocalController.class)
class LocalControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    LocalService localService;
    Local local;

    @BeforeEach
    void setUp() {
        local = Local.builder()
                     .id(6L)
                     .name("Supermarket")
                     .floor("2")
                     .code("Sup-321-2")
                     .build();
    }

    @Test
    void save() throws Exception {
        Local postLocal = Local.builder()
                               .name("Supermarket")
                               .floor("2")
                               .code("Sup-321-2")
                               .build();

        Mockito.when(localService.save(postLocal))
               .thenReturn(local);
        mockMvc.perform(MockMvcRequestBuilders.post("/locals")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content("""
                                                               {
                                                               	"name": "Supermarket",
                                                               	"floor": "2",
                                                               	"code": "Sup-321-2"
                                                               }"""))
               .andExpect(MockMvcResultMatchers.status()
                                               .isOk());
    }

    @Test
    void findLocalById() throws Exception {
        Mockito.when(localService.findById(6L))
               .thenReturn(local);
        mockMvc.perform(MockMvcRequestBuilders.get("/locals/6")
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status()
                                               .isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                                               .value(local.getName()));
    }
}