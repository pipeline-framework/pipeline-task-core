package in.devstream.cicd.task.validator;

import in.devstream.cicd.task.core.TaskInput;

public interface TaskValidator {
    /**
     * Validates a given task.
     *
     * @param input task inputs.
     */
    public ValidationResult validate(TaskInput input);
}
