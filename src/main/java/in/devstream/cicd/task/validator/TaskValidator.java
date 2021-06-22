package in.devstream.cicd.task.validator;

import in.devstream.cicd.task.core.TaskInput;
import in.devstream.cicd.task.validator.ValidationResult;

public interface TaskValidator {
    public ValidationResult validate(TaskInput input);
}
