package com.springlp.recipeapp.contrllers;

import com.springlp.recipeapp.domain.Category;
import com.springlp.recipeapp.domain.UnitOfMeasure;
import com.springlp.recipeapp.repositories.CategoryRepository;
import com.springlp.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
        private CategoryRepository categoryRepository;
        private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    @RequestMapping({"","/index"})
    public String getIndexPage(){
        System.out.println("OCHOA");
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Totoro");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Kilo");
        System.out.println(categoryOptional.get().getId());
        System.out.println(unitOfMeasure.get().getId());
        return "index";
    }
}
