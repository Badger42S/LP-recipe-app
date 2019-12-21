package com.springlp.recipeapp.services;

import com.springlp.recipeapp.convertes.RecipeCommandToRecipe;
import com.springlp.recipeapp.convertes.RecipeToRecipeCommand;
import com.springlp.recipeapp.domain.Recipe;
import com.springlp.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeService recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;


   // @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipe() {
        Recipe recipe =new Recipe();
        HashSet recipesData=new HashSet();
        recipesData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipesData);
        Set<Recipe> recipes= recipeService.getRecipe();
        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }
}