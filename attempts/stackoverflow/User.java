package attempts.stackoverflow;

import java.util.List;
import java.util.ArrayList;

public class User {
    // - list of questions
    private List<Question> questions = new ArrayList<>();  
    // - list of answers 
    private List<Answer> answers = new ArrayList<>(); 
    // - list of comments 
    private List<Comment> comments = new ArrayList<>(); 
    // - reputation = 0
    private int reputation = 0; 

    // - method postQuestion
    public Question postQuestion(String content) {
        Question newQuestion = new Question(content, this); 
        this.questions.add(newQuestion); 
        return newQuestion; 
    }
    // - method postAnswer 
    public void postAnswer(String content, Question question) {
        Answer newAnswer = new Answer(this, content); 
        this.answers.add(newAnswer); 
        question.setAnswer(newAnswer); 
    }

    // - method upvote(post)
    //     - post.upvote() 
    public void upvote(Post post) {
        post.upvote(); 
    }
    // - method downvote(post)
    //     - post.downvote() 
    public void downvote(Post post) {
        post.downvote(); 
    }
    // - method comment(post)
    public void comment(Post post, String content) {
        Comment newComment = new Comment(content); 
        this.comments.add(newComment); 
        post.addComment(newComment);
    }

    // - method markAnswerAsAccepted(question, answer)
    //     - check if question is under list of questions. 
    //     - check if answer is under question. 
    //     - if yes, set accepted answer to answer. 
    //     - if not, throw an error. 
    public void markAnswerAsAccepted(Question question, Answer answer) {
        if (this.questions.contains(question) && question.isAnswerOnQuestion(answer)) {
            question.setAcceptedAnswer(answer);
        }
    }

    // - method updateReputation()
    public void updateReputation(Integer value) {
        this.reputation += value; 
    }
    
    // - method setTagToQuestion(question) 
    //     - check if question is under list of questions. 
    //     if yes, set tag to question 
    public void setTagToQuestion(Question question, Tag tag) {
        if (this.questions.contains(question)) {
            question.setTag(tag);
        }
    }

    // Getter for reputation
    public int getReputation() {
        return this.reputation; 
    }
}
