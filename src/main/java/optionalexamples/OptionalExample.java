package optionalexamples;

import functionalgenerics.test;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class OptionalExample {

    public static void main(String[] args) {
        log.info("Optional Example");
        log.info("Empty Optional: {}", Optional.empty());
        log.info("of Optional: {}", Optional.of("Use when you have any daya"));                 // Non-null - use isPresent() to check
        log.info("OfNullable Optional: {}", Optional.ofNullable(null).orElse("Default")); // Null-safe Optional


        Optional<String> test1 = Optional.empty();
        // NOTE : Optional in Java 8 is immutable so can't change value, Have to reassign
        test1 = Optional.of("Test");

        // NOTE : getDefault is always executed
        log.info("OfNullable Optional: {}", test1.orElse(getDefault()));
        // NOTE : Default/getDefault is only executed if test1 is empty [becuase of lazy evaluation by Supplier interface]
        log.info("OfNullable Optional: {}", test1.orElseGet(() -> "Default"));
        log.info("OfNullable Optional: {}", test1.orElseGet(OptionalExample::getDefault));
        log.info("OfNullable Optional: {}", test1.orElseThrow(() -> new IllegalArgumentException("Exception thrown")));

        Optional<String> planet = Optional.of("Earth");

        planet.ifPresentOrElse(
                OptionalExample::process, // Correct way to pass method reference
                () -> { throw new RuntimeException("Planet is not present"); } // Wrap exception in a lambda
        );
    }

    public static String getDefault() {
        log.info("getDefault() called");
        return "Default";
    }

    public static void process(String test) {
        log.info("process() called with value: {}", test);
    }
}