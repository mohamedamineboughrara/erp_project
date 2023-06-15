package org.oga.gestioncras;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oga.gestioncras.commands.aggregates.CRAsAggregate;
import org.oga.gestioncras.commands.commonapi.CreateCRAsCommand;
import org.oga.gestioncras.enums.CRAsStatus;
import org.oga.gestioncras.events.CRAsCreatedEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.UUID;
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
public class GestCrasTest {
    private String CRASID = UUID.randomUUID().toString();
    private String TIMESPENT = "5";
    private String DESCRIPTION ="good";
    private LocalDate STARTDATE = LocalDate.parse("2023-04-05");
    private LocalDate ENDDATE = LocalDate.parse("2023-04-05");
    private String IDPROJECT = "33";
    private String IDRESPONSABLE = "5544";
    private String IDCOLLABORATOR = "44648";
    private String COMMENT = "good";
    private double PRODUCTIVITY = 5.0 ;
    private final FixtureConfiguration<CRAsAggregate> testFixture = new AggregateTestFixture<>(CRAsAggregate.class);

    @Test
    public void testCreteCras() {
        testFixture.givenNoPriorActivity()
                .when(new CreateCRAsCommand(CRASID, TIMESPENT,DESCRIPTION,STARTDATE,ENDDATE,IDPROJECT,IDRESPONSABLE,IDCOLLABORATOR,COMMENT,PRODUCTIVITY))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new CRAsCreatedEvent(CRASID, TIMESPENT,DESCRIPTION,STARTDATE,ENDDATE,IDPROJECT,IDRESPONSABLE,IDCOLLABORATOR,COMMENT,PRODUCTIVITY, CRAsStatus.CREATED));
    }

}

