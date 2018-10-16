package ex.lombokbuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Optional;

@ToString
@Getter
public class BasicMatch extends Match {

    @Builder(toBuilder = true)
    public BasicMatch(
            Long inputId,
            String inputSourceName,
            BigDecimal score) {
        super(inputId, inputSourceName, score);
    }

    public static class BasicMatchBuilder {

        public Optional<BasicMatch> buildOptional() {
            return Optional.of(this.build());
        }

        public Optional<Match> buildOptionalMatch() {
            return Optional.of(this.build());
        }

    }

}
