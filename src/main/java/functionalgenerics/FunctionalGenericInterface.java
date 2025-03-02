package functionalgenerics;

@FunctionalInterface
public interface FunctionalGenericInterface<T, R> {
    R execute(T t);
}
