package in.devstream.cicd.task.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class AsyncEventDispatcher implements EventDispatcher {
    /**
     * Construct an instance with the provided properties.
     *
     * @param pipelineEvent pipeline event to be dispatched.
     */
    @Override
    public void dispatch(PipelineEvent pipelineEvent) {
        log.info(String.format("dispatching %s event",pipelineEvent.toString()));
    }
}
