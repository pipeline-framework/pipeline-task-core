package in.devstream.cicd.task.core;

import in.devstream.cicd.task.config.TaskConstant;
import in.devstream.cicd.task.event.AsyncEventDispatcher;
import in.devstream.cicd.task.event.CompleteEvent;
import in.devstream.cicd.task.event.StartEvent;
import in.devstream.cicd.task.exception.InvalidTaskArgumentException;
import in.devstream.cicd.task.exception.PipelineTaskException;
import in.devstream.cicd.task.exception.TaskNotAllowedToRunException;
import in.devstream.cicd.task.policy.PipelinePolicyEvaluator;
import in.devstream.cicd.task.policy.PolicyResult;
import in.devstream.cicd.task.validator.PipelineTaskValidator;
import in.devstream.cicd.task.validator.ValidationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;

@Slf4j
public abstract class PipelineTask {

    private ExecutionContext executionContext;

    /**
     * Template method that sequence implicit code execution
     */
    public final void run(ApplicationArguments args) {
        try {
            init(args);
            onInit();

            if (!isValid())
                throw new InvalidTaskArgumentException(this.executionContext, TaskConstant.INVALID_TASK_ARGUMENT);

            if (!canExecute())
                throw new TaskNotAllowedToRunException(this.executionContext, TaskConstant.TASK_NOT_ALLOWED_TO_RUN);

            execute();
            complete();

        } catch (Exception exception) {
            handleException(exception);
        } finally {
            onFinalize();
        }
    }

    /**
     * loads the execution context and dispatches start event.
     */
    private final void init(ApplicationArguments args) {

        this.executionContext= new ExecutionContext();
        executionContext.load();
        this.executionContext.setTaskArguments(args);
        StartEvent startEvent = StartEvent.builder().appComponentName("").build();
        new AsyncEventDispatcher().dispatch(startEvent);
    }

    /**
     * Pipeline task developers can optionally add initialization logic here.
     */
    public void onInit() {

        log.info("Skipping onInit... No default implementation found!");

    }

    /**
     * Validates the task inputs using a schema
     *
     * @return boolean value as outcome
     */
    private final boolean isValid() {
        TaskInput taskInput = new InputParser().parse(this.executionContext.getTaskArguments());
        ValidationResult validationResult= new PipelineTaskValidator().validate(taskInput);
        return validationResult.isOutcome();
    }

    /**
     * Construct an instance with the provided properties.
     */
    private final boolean canExecute() {
        TaskInput taskInput = new InputParser().parse(args);
        PolicyResult policyResult= new PipelinePolicyEvaluator().evaluate();
        return policyResult.isOutcome();
    }

    /**
     * This method is implemented by individual pipeline tasks.
     * The piece of automation that needs to be executed while running a task.
     */
    public abstract void execute();

    /**
     * Dispatches the task complete event.
     * Implicit task cleanup logic goes here.
     */
    private final void complete() {
        CompleteEvent completeEvent = CompleteEvent.builder().appComponentName("").build();
        new AsyncEventDispatcher().dispatch(completeEvent);
    }


    /**
     * Pipeline task developers can optionally add cleanup logic here.
     */
    public void onFinalize() {
        log.info("default finalizing... no code execution...!");
    }


    private final void handleException(Exception exception) {
        throw new PipelineTaskException(TaskConstant.PIPELINE_TASK_EXCEPTION, exception);
    }
}
