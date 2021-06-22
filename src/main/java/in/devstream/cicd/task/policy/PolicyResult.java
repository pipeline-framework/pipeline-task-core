package in.devstream.cicd.task.policy;

import in.devstream.cicd.task.core.Result;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PolicyResult {
    private boolean outcome;
    private String message;
    private List<Result> results;
}
