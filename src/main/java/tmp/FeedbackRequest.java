package tmp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class FeedbackRequest {

    public FeedbackType type ;//= FeedbackType.GENERAL;
    @JsonAlias({"caseId", "caseid"}) // lowercase for backwards compatibility
    private String caseId;
    @JsonAlias({"userId", "userid"}) // lowercase for backwards compatibility
    private String userId;
    private int rating;
    private String feedback;
    @JsonAlias({"vertriebOrganisationId", "vertrieborganisationid"}) // lowercase for backwards compatibility
    private String vertriebOrganisationId;
    private String createdAt;

    public enum FeedbackType {
        GENERAL, CHECKLIST
    }

}
