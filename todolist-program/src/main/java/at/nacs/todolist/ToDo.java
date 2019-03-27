package at.nacs.todolist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDo {
    private String id;
    private String title;
    private boolean done;
}