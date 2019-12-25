package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.RecipeCommand;
import com.springlp.recipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{
    private final NotesToNotesCommand noteConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final CategoryToCategoryCommand categoryConverter;

    public RecipeToRecipeCommand(NotesToNotesCommand noteConverter, IngredientToIngredientCommand ingredientConverter,
                                 CategoryToCategoryCommand categoryConverter) {
        this.noteConverter = noteConverter;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public RecipeCommand convert(Recipe source) {
        if(source==null){
            return null;
        }
        final RecipeCommand recipeCommand=new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setServing(source.getServing());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setUrl(source.getUrl());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setNotes(noteConverter.convert(source.getNotes()));
        if(source.getCategory()!=null && source.getCategory().size()>0){
            source.getCategory().
                    forEach(category->recipeCommand.getCategory().add(categoryConverter.convert(category)));
        }
        if(source.getIngredients()!=null && source.getIngredients().size()>0){
            source.getIngredients().
                    forEach(ingredient->recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
        }
        return recipeCommand;
    }
}
