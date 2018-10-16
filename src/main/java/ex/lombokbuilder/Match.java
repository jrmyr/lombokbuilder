package ex.lombokbuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Slf4j
public abstract class Match {

    protected String type;

    protected Long inputId;
    protected String inputSourceName;
    protected BigDecimal score;

    public Match(Long inputId, String inputSourceName, BigDecimal score) {
        this("STATIC-TYPE",
                inputId, inputSourceName, score);
    }

}
