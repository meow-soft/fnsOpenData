package meow.soft.fnsopendata.service;

import meow.soft.fnsopendata.dto.TaxAuthorityDto;
import meow.soft.fnsopendata.model.TaxAuthority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaxAuthorityServiceTest {

    @Autowired
    TaxAuthorityService taxAuthorityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveOrUpdate() {
        taxAuthorityService.saveOrUpdate(new TaxAuthority());
    }

    @Test
    void testFindByCode() {
        TaxAuthorityDto byCode = taxAuthorityService.findByCode("1800");
        Assertions.assertNotNull(byCode);
        System.out.println(byCode);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme