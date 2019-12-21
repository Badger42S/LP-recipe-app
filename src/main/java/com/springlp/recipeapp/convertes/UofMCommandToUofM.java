package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.UnitOfMeasureCommand;
import com.springlp.recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UofMCommandToUofM implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if(unitOfMeasureCommand==null){
            return null;
        }
        final UnitOfMeasure unitOfMeasure=new UnitOfMeasure();
        unitOfMeasure.setId(unitOfMeasureCommand.getId());
        unitOfMeasure.setDescription(unitOfMeasureCommand.getDescription());
        return unitOfMeasure;
    }
}
