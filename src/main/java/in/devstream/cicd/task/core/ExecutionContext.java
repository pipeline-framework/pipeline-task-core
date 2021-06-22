package in.devstream.cicd.task.core;

import in.devstream.cicd.task.policy.PolicyResult;
import in.devstream.cicd.task.validator.ValidationResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.ApplicationArguments;

@Getter
@Setter
@NoArgsConstructor
public class ExecutionContext {

    private ApplicationArguments taskArguments;
    private ValidationResult validationResult;
    private PolicyResult policyResult;
    private TaskInput taskInput;

    public void load(){
    }
}
