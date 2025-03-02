package de.europace.doc.feedback.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static de.europace.doc.feedback.dto.FeedbackRequest.FeedbackType.GENERAL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackRequest {

    private FeedbackType type = GENERAL;
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
