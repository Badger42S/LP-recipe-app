package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.UnitOfMeasureCommand;
import com.springlp.recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class UofMToUofMCommand implements Converter<UnitOfMeasure,UnitOfMeasureCommand>{
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source==null){
            return null;
        }
        final UnitOfMeasureCommand unitOfMeasureCommand=new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getId());
        unitOfMeasureCommand.setDescription(source.getDescription());
        return unitOfMeasureCommand;
    }
}
