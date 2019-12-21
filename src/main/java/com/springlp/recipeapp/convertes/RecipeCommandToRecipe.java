package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.CategoryCommand;
import com.springlp.recipeapp.commands.IngredientCommand;
import com.springlp.recipeapp.commands.NotesCommand;
import com.springlp.recipeapp.commands.RecipeCommand;
import com.springlp.recipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe>{
    private final NotesCommandToNotes notes;
    private final CategoryCommandToCategory categories;
    private final IngredientCommandToIngredient ingredients;

    public RecipeCommandToRecipe(NotesCommandToNotes notes, CategoryCommandToCategory categories, IngredientCommandToIngredient ingredients) {
        this.notes = notes;
        this.categories = categories;
        this.ingredients = ingredients;
    }

    @Override
    public Recipe convert(RecipeCommand source) {
        if(source==null){
            return null;
        }
        final Recipe recipe=new Recipe();
        recipe.setId(source.getId());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setServing(source.getServing());
        recipe.setDirections(source.getDirections());
        recipe.setDescription(source.getDescription());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setUrl(source.getUrl());
        recipe.setSource(source.getSource());
        recipe.setNotes(notes.convert(source.getNotes()));
        if(source.getCategory()!=null && source.getCategory().size()>0){
            source.getCategory().
                    forEach(category->recipe.getCategory().add(categories.convert(category)));
        }
        if(source.getIngredients()!=null && source.getIngredients().size()>0){
            source.getIngredients().
                    forEach(ingredient->recipe.getIngredients().add(ingredients.convert(ingredient)));
        }
        return recipe;
    }
}
