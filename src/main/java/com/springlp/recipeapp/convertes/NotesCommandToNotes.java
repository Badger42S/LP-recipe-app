package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.NotesCommand;
import com.springlp.recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes>{
    @Override
    public Notes convert(NotesCommand source) {
        if(source==null){
            return null;
        }
        final Notes notes=new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
