package at.nacs.the_magic_8ball.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
