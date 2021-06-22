package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.core.TaskInput;
import in.devstream.cicd.task.policy.PolicyResult;

public interface PolicyEvaluator {
    public PolicyResult evaluate(TaskInput taskInput);
}
