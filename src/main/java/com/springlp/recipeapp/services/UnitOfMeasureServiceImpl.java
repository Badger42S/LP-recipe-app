package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.UnitOfMeasureCommand;
import com.springlp.recipeapp.convertes.UofMToUofMCommand;
import com.springlp.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UofMToUofMCommand converter;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UofMToUofMCommand converter) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.converter = converter;
    }

    @Override
    public Set<UnitOfMeasureCommand> uomList() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false).
                map(converter::convert).
                collect(Collectors.toSet());
    }
}
