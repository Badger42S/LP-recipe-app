package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId (Long recipeId, Long ingredientId);
}
