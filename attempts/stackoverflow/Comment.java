package attempts.stackoverflow;

public class Comment {
    private String content; 

    public Comment(String content) {
        this.content = content; 
    }

    @Override
    public String toString() {
        return this.content;
    }
}
