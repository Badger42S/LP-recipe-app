package com.springlp.recipeapp.convertes;
import com.springlp.recipeapp.commands.NotesCommand;
import com.springlp.recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{
    @Override
    public NotesCommand convert(Notes sorce) {
        if(sorce==null){
            return null;
        }
        final NotesCommand notesCommand=new NotesCommand();
        notesCommand.setId(sorce.getId());
        notesCommand.setRecipeNotes(sorce.getRecipeNotes());
        return notesCommand;
    }
}
