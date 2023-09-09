package com.example.gfichpaie;

import com.example.gfichpaie.aggregates.FicheDePaie;
import com.example.gfichpaie.commonapi.CreateFichedePaieCommand;
import com.example.gfichpaie.enums.FicheDePaieStatus;
import com.example.gfichpaie.events.FicheDePaieCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
@Slf4j
public class FicheDePaieTest {
    private final String FICHEID = UUID.randomUUID().toString();
    private final Date DATE = new Date();

    private final FixtureConfiguration<FicheDePaie> testFixture = new AggregateTestFixture<>(FicheDePaie.class);

    @Test
    public void testCreteFicheDePaie() {
        String USERNAME = "User 1";
        Double SALAIREBRUT = 3500.0;
        Double IMPOTS = 700.0;
        String COLLABORATORS = "amine";
        Double SALAIRENET = 2800.0;
        Double CHARGESOCIAL = 300.0;
        Double PRIME = 500.0;
        Double TJM = 200.0;
        testFixture.givenNoPriorActivity()
                .when(new CreateFichedePaieCommand(FICHEID, USERNAME,DATE, SALAIREBRUT, IMPOTS, COLLABORATORS, SALAIRENET, CHARGESOCIAL, PRIME, TJM))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new FicheDePaieCreatedEvent(FICHEID, USERNAME,DATE, SALAIREBRUT, IMPOTS, COLLABORATORS, SALAIRENET, CHARGESOCIAL, PRIME, TJM, FicheDePaieStatus.CREATED));


    }

}

