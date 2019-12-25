package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.IngredientCommand;
import com.springlp.recipeapp.convertes.IngredientCommandToIngredient;
import com.springlp.recipeapp.convertes.IngredientToIngredientCommand;
import com.springlp.recipeapp.domain.Ingredient;
import com.springlp.recipeapp.domain.Recipe;
import com.springlp.recipeapp.repositories.RecipeRepository;
import com.springlp.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class IngredientServiseImpl implements IngredientService {
    private final IngredientToIngredientCommand converter;
    private final IngredientCommandToIngredient backConverter;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiseImpl(IngredientToIngredientCommand converter, IngredientCommandToIngredient backConverter, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.converter = converter;
        this.backConverter = backConverter;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(!recipeOptional.isPresent()){
            System.out.println("no recipe " + recipeId);
        }
        Optional<IngredientCommand> ingredientCommandOptional = recipeOptional.get().getIngredients().stream().
                filter(ingredient -> ingredient.getId().equals(ingredientId)).
                map(ingredient -> converter.convert(ingredient)).findFirst();
        if(!ingredientCommandOptional.isPresent()){
            System.out.println("no ingredient " + ingredientId);
        }
        return ingredientCommandOptional.get();
    }

    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());
        if(!recipeOptional.isPresent()){
            return new IngredientCommand();
        } else{
            Recipe recipe=recipeOptional.get();
            Optional<Ingredient> ingredientOptional=recipe.getIngredients().stream().
                    filter(ingredient->ingredient.getId().equals(command.getId())).
                    findFirst();
            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound=ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUnitOfMeasure(unitOfMeasureRepository.
                        findById(command.getUnitOfMeasure().getId()).
                        orElseThrow(()->new RuntimeException("UOM not found")));
            }else{
                recipe.addIngredient(backConverter.convert(command));
            }
            Recipe saveRecipe=recipeRepository.save(recipe);
            return converter.convert(saveRecipe.getIngredients().stream().
                    filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst().get());
        }
    }
}
