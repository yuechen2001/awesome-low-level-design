package attempts.stackoverflow;

import java.util.List;
import java.util.ArrayList;

public class UserManagement {
    // Singleton instance 
    private static UserManagement INSTANCE; 
    // - list of users
    private List<User> users = new ArrayList<>(); 
    // - list of questions 
    private List<Question> questions = new ArrayList<>(); 

    private UserManagement() {

    }

    public static UserManagement getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserManagement(); 
        }
        return INSTANCE; 
    }

    public List<User> getUsers() {
        return this.users; 
    }

    public void setUser(User user) {
        this.users.add(user); 
    }

    public List<Question> getQuestions() {
        return this.questions; 
    }

    private void setQuestion(Question question) {
        this.questions.add(question); 
    }

    public void postQuestion(User user, String content) {
        if (this.users.contains(user)) {
            Question newQuestion = user.postQuestion(content); 
            this.setQuestion(newQuestion); 
        }
    }

    public void postAnswer(User user, String content, Question question) {
        if (this.users.contains(user)) {
            user.postQuestion(content); 
        }
    }
}
