package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.core.TaskInput;

public interface PolicyEvaluator {
    /**
     * Evaluate policy before executing a task.
     *
     * @param taskInput task input.
     */
    public PolicyResult evaluate(TaskInput taskInput);
}
