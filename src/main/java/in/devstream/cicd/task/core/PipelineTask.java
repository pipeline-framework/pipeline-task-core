package in.devstream.cicd.task.core;

import in.devstream.cicd.task.config.TaskConstant;
import in.devstream.cicd.task.event.AsyncEventDispatcher;
import in.devstream.cicd.task.event.StartEvent;
import in.devstream.cicd.task.exception.InvalidTaskArgumentException;
import in.devstream.cicd.task.exception.TaskNotAllowedToRunException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.config.Task;

@Slf4j
public abstract class PipelineTask {

    private ExecutionContext executionContext;

    public abstract void execute();

    public void onInit() {
        log.info("default onInit ..... no code execution...");
    }

    public void onFinalize() {
        log.info("default finalizing... no code execution...!");
    }

    public final void run() {
        try {
            start();
            onInit();
            if(!validate()) throw new InvalidTaskArgumentException(this.executionContext, TaskConstant.INVALID_TASK_ARGUMENT);
            if (!canExecute()) throw new TaskNotAllowedToRunException(this.executionContext, TaskConstant.TASK_NOT_ALLOWED_TO_RUN);
            validate();
            canExecute();
            execute();
            complete();
        } catch (Exception exception) {
            handleException(exception);
        }
        finally
        {
            onFinalize();
        }
    }

    /**
     * Construct an instance with the provided properties.
     *
     */
    private final void start() {

        StartEvent startEvent =StartEvent.builder().appComponentName("Test").build();
        new AsyncEventDispatcher().dispatch(startEvent);
    }

    private final boolean validate() {
        log.info("validating task!");
        return true;
    }

    private final void complete() {
        log.info("dispatching complete event");
    }

    private final boolean canExecute() {
        log.info("Evaluating policy.....");
        return true;
    }

    private final void handleException( Exception exception) {
        log.error("Error occured!...");
    }
}
