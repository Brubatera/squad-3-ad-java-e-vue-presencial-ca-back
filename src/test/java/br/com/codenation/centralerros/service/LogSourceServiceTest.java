package br.com.codenation.centralerros.service;

import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.entity.ServerOrigin;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.LogSourceRepository;
import br.com.codenation.centralerros.services.LogSourceService;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogSourceServiceTest {

    @Autowired
    private LogSourceService logSourceService;

    @MockBean
    private LogSourceRepository logSourceRepository;

    @Test
    public void deveSalvarLogSource() {
        LogSource logSource = buildLogSource(null);
        Mockito.when(logSourceRepository.save(logSource)).thenReturn(buildLogSource(10L));
        LogSource result = logSourceService.save(logSource);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));

    }

    @Test
    public void deveRetornarLogSourcePeloId() throws MessageException {
        LogSource logSource = buildLogSource(null);
        Mockito.when(logSourceRepository.findById(logSource.getId())).thenReturn(Optional.of(buildLogSource(10L)));
        LogSource result = logSourceService.findBydId(logSource.getId());
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaLista() throws MessageException {
        List<LogSource> logSources = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            logSources.add(buildLogSource(null));
        }
        Mockito.when(logSourceRepository.findAll()).thenReturn(logSources);
        List<LogSource> result = logSourceService.findAll();
        Assert.assertThat(result, Matchers.equalTo(logSources));
    }

    //@Test
    //public void deveEditarLogSource() throws MessageException {
    //    LogSource logSource = buildLogSource(null);
    //    Mockito.when(logSourceRepository.findById(logSource.getId())).thenReturn(Optional.of(buildLogSource(10L)));
    //    LogSource result = logSourceService.findBydId(logSource.getId());
    //    result.setURL("localhost:8080/error/url?=9y0r nx0qw87cqn9r8wrh8qrnq8w");
    //    LogSource result2 = logSourceService.update(result);
    //    Assert.assertThat(result.getURL(), Matchers.equalTo(result2.getURL()));
//
    //}

    //@Test
    //public void deveDeletar(){
    //    LogSource logSource = buildLogSource(null);
    //}


    private LogSource buildLogSource(Long id) {
        return LogSource.builder()
                .id(id)
                .application(null)
                .serverOrigin(ServerOrigin.DEVELOPMENT)
                .URL("4:19:49 PM: Task execution finished ':classes'")
                .build();
    }

}
