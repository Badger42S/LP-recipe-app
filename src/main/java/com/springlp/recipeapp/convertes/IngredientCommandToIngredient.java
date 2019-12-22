package com.springlp.recipeapp.convertes;

import com.springlp.recipeapp.commands.IngredientCommand;
import com.springlp.recipeapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>{
    private final UofMCommandToUofM uomConverter;

    public IngredientCommandToIngredient(UofMCommandToUofM uomConverter) {
        this.uomConverter = uomConverter;
    }
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source==null){
            return null;
        }
        final Ingredient ingredient=new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasure(uomConverter.convert(source.getUnitOfMeasure()));
        return ingredient;
    }
}
