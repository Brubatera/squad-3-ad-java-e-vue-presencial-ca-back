package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.LogSourceDTO;
import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.LogSourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/logsource")
public class LogSourceController {

    private LogSourceService logSourceService;

    @GetMapping
    public List<LogSourceDTO> findAll() {
        return logSourceService.findAll();
    }

    @GetMapping("/{id}")
    public LogSource findById(@PathVariable Long id) throws MessageException {
        return logSourceService.findBydId(id);
    }

    @PostMapping
    public LogSourceDTO save(@RequestBody LogSourceDTO logSource) {
        return logSourceService.save(logSource);
    }

    @PutMapping
    public LogSourceDTO update(@RequestBody LogSourceDTO logSource) throws MessageException {
        return logSourceService.update(logSource);
    }

    @DeleteMapping
    public LogSource delete(@RequestBody LogSource logSource) {
        return logSourceService.delete(logSource.getId());
    }

}
