package com.example.demoofbugwithyaml;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Value
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
public class RulePredicate implements Predicate<String> {
    String equals;
    String contains;
    Pattern regex;
    List<String> isOneOf;

    public RulePredicate(String equals) {
        this(equals, null, null, null);
    }

    @Override
    public boolean test(String input) {
        // logic is replaced with 'return false'
        return false;
    }
}
