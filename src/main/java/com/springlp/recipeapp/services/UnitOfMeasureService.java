package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> uomList();
}
