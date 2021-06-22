package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.core.Result;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PolicyResult {
    private boolean execute;
    private String message;
    private List<Result> results;
}
