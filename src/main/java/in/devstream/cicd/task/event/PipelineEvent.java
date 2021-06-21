package in.devstream.cicd.task.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class PipelineEvent {

    private String createdAtUTC;
    private String createdBy;


}
