package functionalgenerics;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Predicate {

    public static void main(String[] args) {

        Predicate<String> isStringNotEmpty = s -> !s.isEmpty();
        System.out.println(filterList(List.of("","Kazim", "", "Kaleem"), isStringNotEmpty));
        Predicate<Integer> isIntNotEmpty = s -> s > 2;
        System.out.println(filterList(List.of(1,2,3,4), isIntNotEmpty));
    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate){
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
