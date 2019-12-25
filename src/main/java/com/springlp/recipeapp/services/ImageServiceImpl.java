package com.springlp.recipeapp.services;

import com.springlp.recipeapp.domain.Recipe;
import com.springlp.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        try{
            Recipe recipe=recipeRepository.findById(id).get();
            Byte[] byteObject=new Byte[file.getBytes().length];
            int i=0;
            for(byte b:file.getBytes()){
                byteObject[i++]=b;
            }
            recipe.setImage(byteObject);
            recipeRepository.save(recipe);

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Save image");
    }
}
