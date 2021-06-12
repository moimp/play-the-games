package org.slipp.masil.games.domains.target;

import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Column;

@EqualsAndHashCode
public class Target {

    @Column(value = "TARGET")
    private Long value;

    public Target() {
    }

    private Target(NumberGenerator numberGenerator) {
        value = numberGenerator.create();
    }

    public static Target createBy(NumberGenerator generator){
        return new Target(generator);
    }

    public Long getValue() {
        return value;
    }
}
