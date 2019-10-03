package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.dto.entitty.LogSourceDTO;
import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.LogSourceMapper;
import br.com.codenation.centralerros.repository.LogSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogSourceService {

    private LogSourceRepository logSourceRepository;
    private LogSourceMapper logSourceMapper;

    public List<LogSourceDTO> findAll() {
        return logSourceMapper.toDtoList(logSourceRepository.findAll());
    }

    public LogSourceDTO save(LogSourceDTO logSource) {
        return logSourceMapper.toDto(logSourceRepository.saveAndFlush(logSourceMapper.map(logSource)));
    }

    public LogSource findBydId(Long id) throws MessageException {
        if (logSourceRepository.findById(id).isPresent()) {
            return logSourceRepository.findById(id).orElse(null);
        }
        throw new MessageException("LogSource não encontrado!");
    }

    public LogSourceDTO update(LogSourceDTO logSource) throws MessageException {
        LogSourceDTO toUpdate = logSourceMapper.toDto(logSourceRepository.findById(logSource.getId()).orElseThrow(MessageException::new));
        toUpdate.setApplication(Application.builder().appName(logSource.getApplication().getAppName()).build());
        toUpdate.setCompany(Company.builder().code(logSource.getCompany().getCode()).build());

        return logSourceMapper.toDto(logSourceRepository.save(logSourceMapper.map(toUpdate)));
    }

    public LogSource delete(Long id) {
        LogSource entity = logSourceRepository.findById(id).orElse(null);
        logSourceRepository.delete(entity);
        return entity;
    }

}
