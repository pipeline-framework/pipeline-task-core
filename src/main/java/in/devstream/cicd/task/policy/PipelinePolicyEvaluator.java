package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.core.TaskInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PipelinePolicyEvaluator implements PolicyEvaluator {
    /**
     * Evaluate policy inorder to determines if a task is allowed to run.
     *
     * @param taskInput task inputs.
     */
    @Override
    public PolicyResult evaluate(TaskInput taskInput) {
        log.info("Evaluating policies before task execution...");
        return PolicyResult.builder().execute(true).build();
    }
}
