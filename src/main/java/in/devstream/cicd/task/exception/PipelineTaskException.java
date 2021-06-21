package in.devstream.cicd.task.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.lang.Nullable;

public class PipelineTaskException extends NestedRuntimeException {

    /**
     * Construct an instance with the provided properties.
     *
     * @param message the message.
     */
    public PipelineTaskException(String message) {
        this(message, null);
    }

    /**
     * Construct an instance with the provided properties.
     *
     * @param message the message.
     * @param cause   the cause.
     */
    public PipelineTaskException(String message, @Nullable Throwable cause) {
        super(message, cause);
    }
}
