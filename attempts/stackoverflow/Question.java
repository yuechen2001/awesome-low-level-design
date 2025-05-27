package attempts.stackoverflow;

import java.util.List;
import java.util.ArrayList;

public class Question extends Post {
    // - list of answers 
    private List<Answer> answers = new ArrayList<>(); 
    // - list of tags 
    private List<Tag> tags = new ArrayList<>();  
    // - accepted answer = null 
    private Answer acceptedAnswer = null; 

    public Question(String content, User user) {
        super(user, content);
    }

    // - method setAcceptedAnswer(answer)
    //     - owner.updateReputation(integer x 2)
    public void setAcceptedAnswer(Answer answer) {
        if (this.acceptedAnswer == null && this.answers.contains(answer)) {
            this.acceptedAnswer = answer; 
            answer.upvote(); 
        } else {
            System.out.println("User has already accepted an answer. ");
        }
    }

    // - method isAnswerOnQuestion(answer)
    public boolean isAnswerOnQuestion(Answer answer) {
        return this.answers.contains(answer);
    }

    // - method setAnswer(answer) 
    public void setAnswer(Answer answer) {
        this.answers.add(answer); 
    }

    // - method setTag(tag)
    public void setTag(Tag tag) {
        this.tags.add(tag); 
    }

    // Getter for answers
    public List<Answer> getAnswers() {
        return this.answers;
    }
}
