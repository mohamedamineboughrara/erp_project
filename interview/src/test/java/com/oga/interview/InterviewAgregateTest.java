package com.oga.interview;

import com.oga.interview.commands.aggregates.InterviewAggregate;
import com.oga.interview.commands.commands.CreateInterviewCommand;
import com.oga.interview.enums.InterviewStatus;
import com.oga.interview.events.InterviewCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
public class InterviewAgregateTest {

    private String INTERVIEWID = UUID.randomUUID().toString();
    private String HUMANRESSOURCEMANAGREID = "HRM-001";
    private String CANDIDATEID = "CAND-001";
    private String CIVILITY = "Mr";
    private String CANDIDATENAME = "John Doe";
    private String COUNTRY = "USA";
    private String CITY = "New York";
    private String EMAILADRESS = "john.doe@example.com";
    private long PHONENUMBRE = 1234567890;
    private String DESIREDPOSITION = "Software Engineer";
    private final FixtureConfiguration<InterviewAggregate> testFixture = new AggregateTestFixture<>(InterviewAggregate.class);

    @Test
    public void testCreteinterview() {
        testFixture.givenNoPriorActivity()
                .when(new CreateInterviewCommand(INTERVIEWID, HUMANRESSOURCEMANAGREID,CANDIDATEID,CIVILITY,CANDIDATENAME,COUNTRY,CITY,EMAILADRESS,PHONENUMBRE,DESIREDPOSITION))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new InterviewCreatedEvent(INTERVIEWID, HUMANRESSOURCEMANAGREID,CANDIDATEID,CIVILITY,CANDIDATENAME,COUNTRY,CITY,EMAILADRESS,PHONENUMBRE,DESIREDPOSITION, InterviewStatus.CREATED));
    }

}
