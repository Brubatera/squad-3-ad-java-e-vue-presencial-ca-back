package br.com.codenation.centralerros.controller;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LogSourceControllerTest {
//
//    @Autowired
//    private LogSourceController logSourceController;
//
//    @MockBean
//    private LogSourceService logSourceService;
//
//    @MockBean
//    private LogSourceRepository logSourceRepository;
//
//    @Test
//    public void deveSalvarLogSource() {
//        LogSource logSource = buildLogSource(null);
//        Mockito.when(logSourceService.save(logSource)).thenReturn(buildLogSource(10L));
//        LogSource result = logSourceController.save(logSource);
//        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
//    }
//
//    @Test
//    public void deveRetornarUmaLista() {
//        List<LogSource> logSources = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            logSources.add(buildLogSource(null));
//        }
//        Mockito.when(logSourceService.findAll()).thenReturn(logSources);
//        List<LogSource> result = logSourceController.findAll();
//        Assert.assertThat(result, Matchers.equalTo(logSources));
//    }
//
//    private LogSource buildLogSource(Long id) {
//        return LogSource.builder()
//                .id(id)
//                .URL("localhost:8080/logsource/kljnalvbdlivbf9v7dfgvdabfvldbfvjhabdvkbvfdsd?idpass=@")
//                .serverOrigin(ServerOrigin.DEVELOPMENT)
//                .application(Application.builder().appName("AWS clound").build())
//                .build();
//    }
//
//}
//