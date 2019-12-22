package com.springlp.recipeapp.services;

import com.springlp.recipeapp.commands.RecipeCommand;
import com.springlp.recipeapp.convertes.RecipeCommandToRecipe;
import com.springlp.recipeapp.convertes.RecipeToRecipeCommand;
import com.springlp.recipeapp.domain.Recipe;
import com.springlp.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandConverter;
    private final RecipeToRecipeCommand recipeConverter;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandConverter, RecipeToRecipeCommand recipeConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandConverter = recipeCommandConverter;
        this.recipeConverter = recipeConverter;
    }

    @Override
    public Set<Recipe> getRecipe() {
        Set<Recipe> recipeSet=new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe=recipeRepository.findById(id);
        if(!recipe.isPresent()){
            throw new RuntimeException("No recipe");
        }
        return recipe.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeConverter.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandConverter.convert(command);
        Recipe saveRecipe=recipeRepository.save(detachedRecipe);
        return recipeConverter.convert(saveRecipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
