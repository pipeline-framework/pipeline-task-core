package in.devstream.cicd.task.core;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class PipelineTask {


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
            //if(!validate()) throw new InvalidTaskArgumentException("s");
            //if (!canExecute()) throw new TaskNotAllowedToRunException("s");
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


    private final void start() {

        log.info("dispatching start event.");
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
