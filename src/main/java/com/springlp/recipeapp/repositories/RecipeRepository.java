package com.springlp.recipeapp.repositories;

import com.springlp.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository <Recipe,Long> {
}
