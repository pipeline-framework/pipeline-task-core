package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.core.TaskInput;
import in.devstream.cicd.task.policy.PolicyEvaluator;
import in.devstream.cicd.task.policy.PolicyResult;
import org.springframework.stereotype.Component;

@Component
public class PipelinePolicyEvaluator implements PolicyEvaluator {
    @Override
    public PolicyResult evaluate(TaskInput taskInput) {
        return null;
    }
}
