package com.springlp.recipeapp.contrllers;

import com.springlp.recipeapp.commands.IngredientCommand;
import com.springlp.recipeapp.services.IngredientService;
import com.springlp.recipeapp.services.RecipeService;
import com.springlp.recipeapp.services.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredients")
    public String listIngredients (Model model, @PathVariable String recipeId){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient (@PathVariable String recipeId, @PathVariable String id, Model model){
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("uomList", unitOfMeasureService.uomList());

        return "recipe/ingredient/ingredientform";
    }
    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveRecipeIngredient(@ModelAttribute IngredientCommand command){
        IngredientCommand saveCommand =ingredientService.saveIngredientCommand(command);

        return "redirect:/recipe/"+ saveCommand.getRecipeId()+"/ingredient/"+saveCommand.getId() +"/show";
    }
}
