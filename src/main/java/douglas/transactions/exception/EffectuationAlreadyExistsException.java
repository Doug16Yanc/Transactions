package douglas.transactions.exception;

import org.springframework.http.ProblemDetail;

public class EffectuationAlreadyExistsException extends EffectuationException {

    private String detail;

    public EffectuationAlreadyExistsException(String detail) {
        this.detail = detail;
    }
    @Override
    public ProblemDetail toProblemDetail() {
        return super.toProblemDetail();
    }
}
