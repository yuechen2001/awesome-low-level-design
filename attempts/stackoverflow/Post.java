package attempts.stackoverflow;

import java.util.List;
import java.util.ArrayList;

abstract class Post {
    private String content; 
    // - list of comments 
    private List<Comment> comments = new ArrayList<>(); 
    // - owner: user
    private User owner; 

    public Post(User user, String content) {
        this.owner = user; 
        this.content = content; 
    }

    // - method upvote
    //     - owner.increaseReputation(integer)
    public void upvote() {
        owner.updateReputation(1); 
    }

    // - method downvote
    //     - owner.decreaseReputation(integer)
    public void downvote() {
        owner.updateReputation(- 1); 
    }
    // - method comment
    public void addComment(Comment comment) {
        this.comments.add(comment); 
    }
    

    @Override
    public String toString() {
        return this.content;
    }
}
