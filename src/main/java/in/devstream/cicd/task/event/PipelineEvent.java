package in.devstream.cicd.task.event;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder
@ToString
public abstract class PipelineEvent {
    private String id;
    private String appId;
    private String appComponentName;
    private String createdAtUTC;
    private String eventSource;
    private EventType eventType;
    private String name;
}