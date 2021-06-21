package in.devstream.cicd.task.exception;

import in.devstream.cicd.task.core.ExecutionContext;
import lombok.Getter;

@Getter
public class TaskNotAllowedToRunException extends PipelineTaskException {

    private final ExecutionContext executionContext;

    /**
     * Construct an instance with the provided properties.
     *
     * @param executionContext task execution context.
     * @param message          the message.
     * @param cause            the cause.
     */
    public TaskNotAllowedToRunException(ExecutionContext executionContext, String message, Throwable cause) {
        super(message, cause);
        this.executionContext = executionContext;
    }
}
