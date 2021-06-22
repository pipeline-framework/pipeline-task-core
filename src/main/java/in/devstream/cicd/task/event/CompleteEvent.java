package in.devstream.cicd.task.event;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder
public class CompleteEvent extends PipelineEvent{

}
