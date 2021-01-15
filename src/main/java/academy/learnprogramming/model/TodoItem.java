package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

// @Data - automatically sets for the class getters, setters, toString, equals&hashcode
@Data
// we specified which field will have @EqualsAndHashCode only
@EqualsAndHashCode(of = "id")
public class TodoItem {

    // == fields ==

    private Integer id;
    private String title;
    private String details;
    private LocalDate deadline;

    // == constructors ==

    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

}
