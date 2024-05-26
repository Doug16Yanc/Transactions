package douglas.transactions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class EffectuationException extends RuntimeException{

    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Effectuation data already exists.");

        return problemDetail;
    }
}
