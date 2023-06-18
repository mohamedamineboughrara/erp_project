package com.example.Material;

import com.example.Material.commanApi.commands.MaterialCommand;
import com.example.Material.commanApi.enums.materialStatus;
import com.example.Material.commanApi.event.MaterialCreatedEvent;
import com.example.Material.commands.Aggregates.MaterialAggregate;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
public class MaterialTest {
    private String MATERIALID = UUID.randomUUID().toString();
    private String MATERIALNAME = "PC";
    private int QUANTITY = 20;
    private  String PHOTO = "photo.jpg";

    private final FixtureConfiguration<MaterialAggregate> testFixture = new AggregateTestFixture<>(MaterialAggregate.class);

    @Test
    public void testCreteinterview() {
        testFixture.givenNoPriorActivity()
                .when(new MaterialCommand(MATERIALID, MATERIALNAME,QUANTITY,PHOTO))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new MaterialCreatedEvent(MATERIALID, MATERIALNAME,QUANTITY,PHOTO, materialStatus.CREATED));
    }

}
