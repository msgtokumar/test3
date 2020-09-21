package de.rieckpil.blog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommitInfoController {

    @Value("${git.commit.message.short}")
    private String commitMessage;

    @Value("${git.build.version}")
    private String version;

    @Value("${git.commit.id}")
    private String commitId;

    @GetMapping("/commitId")
    public Map<String, String> getCommitId() {
        Map<String, String> result = new HashMap<>();


        result.put("description", commitMessage);
        result.put("version", version);
        result.put("lastcommitsha", commitId);
        return result;
    }
}
