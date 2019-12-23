package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.IngredientCommand;
import com.springlp.recipeapp.convertes.IngredientToIngredientCommand;
import com.springlp.recipeapp.domain.Recipe;
import com.springlp.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IngredientServiseImpl implements IngredientService {
    private final IngredientToIngredientCommand converter;
    private final RecipeRepository recipeRepository;

    public IngredientServiseImpl(IngredientToIngredientCommand converter, RecipeRepository recipeRepository) {
        this.converter = converter;
        this.recipeRepository = recipeRepository;
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
}
