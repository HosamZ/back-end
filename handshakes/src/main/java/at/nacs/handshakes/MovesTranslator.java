package at.nacs.handshakes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class MovesTranslator {
    private final MovesLoader movesLoader;

    public List<String> translateToMoves(int price) {
        Map<Integer, String> moves = movesLoader.getMoves();
        return Stream.of(String.valueOf(price).split(""))
                .map(Integer::valueOf)
                .filter(moves::containsKey)
                .map(moves::get)
                .collect(Collectors.toList());
    }
}