package com.springlp.recipeapp.repositories;

import com.springlp.recipeapp.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void cupFind() {
        Optional<UnitOfMeasure> unitOpt=unitOfMeasureRepository.findByDescription("Cup");
        assertEquals(unitOpt.get().getDescription(),"Cup");
    }
    @Test
    public void pintFind() {
        Optional<UnitOfMeasure> unitOpt=unitOfMeasureRepository.findByDescription("Pint");
        assertEquals(unitOpt.get().getDescription(),"Pint");
    }
}