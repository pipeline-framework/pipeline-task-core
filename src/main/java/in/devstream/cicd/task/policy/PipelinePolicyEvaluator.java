package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.policy.PolicyEvaluator;
import in.devstream.cicd.task.policy.PolicyResult;
import org.springframework.stereotype.Component;

@Component
public class PipelinePolicyEvaluator implements PolicyEvaluator {
    @Override
    public PolicyResult evaluate() {
        return null;
    }
}
