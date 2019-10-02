package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.CompanyDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.CompanyRepository;
import br.com.codenation.centralerros.services.CompanyService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {

    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    public void deveSalvarUmaCompanhiaDto() throws MessageException {
        CompanyDTO company = buildCompanyDTO("company");
        Mockito.when(companyService.save(company)).thenReturn(buildCompanyDTO("company"));
        CompanyDTO result = companyController.save(company);
        Assert.assertThat(result.getCode(), Matchers.equalTo("company"));
    }

    @Test
    public void deveRetornarCompanhiaPeloCode() throws MessageException {
        CompanyDTO company = buildCompanyDTO("company");
        Mockito.when(companyService.findByCode(company.getCode())).thenReturn(buildCompany("company"));
        Company result = companyController.findByCode(company.getCode());
        Assert.assertThat(result.getCode(), Matchers.equalTo("company"));
    }

    @Test
    public void deveRetornarUmaListaDeCompanhias() throws MessageException {
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            companies.add(buildCompany(null));
        }
        Mockito.when(companyService.findAll()).thenReturn(companies);
        List<Company> result = companyController.findAll();
        Assert.assertThat(result, Matchers.equalTo(companies));
    }

    private CompanyDTO buildCompanyDTO(String company) {
        return CompanyDTO.builder()
                .id(null)
                .code(company)
                .name("Conta Azul SA")
                .build();
    }

    private Company buildCompany(String company) {
        return Company.builder()
                .id(null)
                .code(company)
                .name("Conta Azul SA")
                .application(null)
                .build();
    }

}
