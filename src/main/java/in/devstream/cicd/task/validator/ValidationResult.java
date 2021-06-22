package in.devstream.cicd.task.validator;

import in.devstream.cicd.task.core.Result;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class ValidationResult {
    private boolean outcome;
    private String message;
    private List<Result> results;
}
