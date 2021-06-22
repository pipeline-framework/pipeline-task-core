package in.devstream.cicd.task.event;

public interface EventDispatcher {
    public void dispatch(PipelineEvent pipelineEvent);
}
