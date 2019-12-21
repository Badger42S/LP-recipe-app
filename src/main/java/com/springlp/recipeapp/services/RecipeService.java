package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.RecipeCommand;
import com.springlp.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipe();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
