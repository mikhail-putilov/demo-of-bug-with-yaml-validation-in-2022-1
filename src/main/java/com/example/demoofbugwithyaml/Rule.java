package com.example.demoofbugwithyaml;

import lombok.Value;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

@Value
public class Rule<O> {
    List<Map<String, RulePredicate>> inputs;
    O output;

    @ConstructorBinding
    public Rule(List<Map<String, RulePredicate>> inputs, Map<String, RulePredicate> input, O output) {
        this.inputs = preferInputsOverInput(inputs, input);
        this.output = output;
    }

    public Rule(Map<String, RulePredicate> input, O output) {
        this(null, input, output);
    }

    private List<Map<String, RulePredicate>> preferInputsOverInput(List<Map<String, RulePredicate>> inputs,
                                                                   Map<String, RulePredicate> input) {
        if (inputs != null) {
            return inputs;
        } else if (input != null) {
            return List.of(input);
        } else {
            return emptyList();
        }
    }
}
