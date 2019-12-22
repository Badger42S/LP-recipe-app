package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.IngredientCommand;
import com.springlp.recipeapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand>{
    private final UofMToUofMCommand uofMToUofMCommand;

    public IngredientToIngredientCommand(UofMToUofMCommand uofMToUofMCommand) {
        this.uofMToUofMCommand = uofMToUofMCommand;
    }
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source==null){
            return null;
        }
        final IngredientCommand ingredientCommand =new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasure(uofMToUofMCommand.convert(source.getUnitOfMeasure()));
        return ingredientCommand;
    }
}
