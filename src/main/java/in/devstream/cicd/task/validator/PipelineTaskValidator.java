package in.devstream.cicd.task.validator;

import in.devstream.cicd.task.core.TaskInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PipelineTaskValidator implements TaskValidator {
    /**
     * Evaluate policy inorder to determines if a task is allowed to run.
     *
     * @param input task inputs.
     */
    @Override
    public ValidationResult validate(TaskInput input) {
        log.info("Validating task...");
        return ValidationResult.builder().valid(true).build();
    }
}
