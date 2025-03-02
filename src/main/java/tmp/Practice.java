package tmp;

import static java.util.Optional.ofNullable;

public class Practice {


    public static void main(String[] args) {
        FeedbackRequest feedbackRequest = FeedbackRequest.builder()
//                .type(FeedbackRequest.FeedbackType.CHECKLIST)
                .build();
//        System.out.printf(ofNullable(feedbackRequest.getType().toString()).orElse("GENERAL"));
//        System.out.println(ofNullable(feedbackRequest.getType()).map(Enum::toString).orElse("GENERAL"));

    }

}
