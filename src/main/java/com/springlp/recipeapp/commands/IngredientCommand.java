package com.springlp.recipeapp.commands;

import com.springlp.recipeapp.domain.UnitOfMeasure;

import java.math.BigDecimal;

public class IngredientCommand {
    private Long id;
    private String description;
    private UnitOfMeasureCommand unitOfMeasureCommand;
    private BigDecimal amount;

    public IngredientCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitOfMeasureCommand getUnitOfMeasureCommand() {
        return unitOfMeasureCommand;
    }

    public void setUnitOfMeasureCommand(UnitOfMeasureCommand unitOfMeasureCommand) {
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
