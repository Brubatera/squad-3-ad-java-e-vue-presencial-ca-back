package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.dto.entitty.CompanyDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.CompanyMapper;
import br.com.codenation.centralerros.repository.CompanyRepository;
import br.com.codenation.centralerros.service.interfaces.CompanyServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyServiceInterface {

    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;


    public CompanyDTO save(CompanyDTO company) throws MessageException {
        if (companyRepository.findById(company.getId()).isPresent()) {
            throw new MessageException("Companhia já cadastrada.");
        }
        return companyMapper.toDto(companyRepository.saveAndFlush(companyMapper.map(company)));
    }

    public Company findById(Long companyId) throws MessageException {
        if (companyRepository.findById(companyId).isPresent()) {
            return companyRepository.findById(companyId).orElse(null);
        }
        throw new MessageException("Companhia não encontrada!");
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public String delete(Long id) throws MessageException {
        Company entity = companyRepository.findById(id).orElse(null);
        companyRepository.delete(entity);
        if (entity != null) {
            return "Deletado com sucesso!";
        }
        throw new MessageException("Companhia não encontrado!");
    }

    public CompanyDTO update(CompanyDTO company) throws MessageException {
        CompanyDTO toUpdate = companyMapper.toDto(companyRepository.findById(company.getId()).orElseThrow(MessageException::new));
        toUpdate.setCode(company.getCode());
        toUpdate.setName(company.getName());

        return companyMapper.toDto(companyRepository.save(companyMapper.map(toUpdate)));
    }

}
