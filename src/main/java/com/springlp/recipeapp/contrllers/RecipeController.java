package com.springlp.recipeapp.contrllers;

import com.springlp.recipeapp.commands.RecipeCommand;
import com.springlp.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showId(Model model, @PathVariable String id){
        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));
        return "/recipe/show";
    }
    @RequestMapping("/recipe/new")
    public String newRecipe (Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "/recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate (@ModelAttribute RecipeCommand command){
        RecipeCommand saveCommand=recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show/" + saveCommand.getId();
    }
}
