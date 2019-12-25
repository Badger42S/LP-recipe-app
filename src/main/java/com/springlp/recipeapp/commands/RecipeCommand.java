package com.springlp.recipeapp.commands;

import com.springlp.recipeapp.domain.Difficulty;

import java.util.HashSet;
import java.util.Set;

public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private Set<IngredientCommand> ingredients=new HashSet<>();
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<CategoryCommand> category=new HashSet<>();
    private NotesCommand notes;
    private Byte[] image;
    public RecipeCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public Set<IngredientCommand> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientCommand> ingredients) {
        this.ingredients = ingredients;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<CategoryCommand> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryCommand> category) {
        this.category = category;
    }

    public NotesCommand getNotes() {
        return notes;
    }

    public void setNotes(NotesCommand notes) {
        this.notes = notes;
    }

    public void setImage(Byte[] image) {
        this.image=image;
    }

    public Byte[] getImage() {
        return image;
    }
}
