package ex.lombokbuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Optional;

@ToString
@Getter
@Setter
public class DetailedMatch extends Match {

    protected BigDecimal distance;
    protected Boolean isForce;

    @Builder(buildMethodName = "internalBuild")
    public DetailedMatch(
            Long inputId,
            String inputSourceName,
            BigDecimal score,
            BigDecimal distance,
            Boolean isForce) {
        super(inputId, inputSourceName, score);
        this.distance = distance;
        this.isForce = isForce;
    }

    private void checkExtendedFields() {
        if (distance == null || isForce == null) {
            throw new IllegalStateException("'" + this.getClass().getSimpleName() + "' detailed info incomplete");
        }
    }

    public static class DetailedMatchBuilder {

        public DetailedMatch build() {
            DetailedMatch detailedMatch = internalBuild();
            detailedMatch.checkExtendedFields();
            return detailedMatch;
        }

        public Optional<Match> buildOptionalMatch() {
            Match match = this.build();
            return Optional.of(match);
        }

        // var x = a(x()); x.b(y());

        public DetailedMatchBuilder fromBasicMatch(BasicMatch basicMatch) {
            DetailedMatchBuilder dmb = this.inputId(basicMatch.getInputId());
            dmb.inputSourceName(basicMatch.getInputSourceName());
            dmb.score(basicMatch.getScore());
            return dmb;
        }

    }

}
