package in.devstream.cicd.task.validator;

import in.devstream.cicd.task.core.Result;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ValidationResult {
    private boolean valid;
    private String message;
    private List<Result> results;
}
