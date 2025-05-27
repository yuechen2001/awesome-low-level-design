# Implementation Plan! 

# class: UserManagement (Singleton)
    - list of users
    - list of questions 

    - method postQuestion(User, Content)
        - user.postQuestion(content)
        - add question to list of questions. 

    - method postAnswer(User, Content, Question)
        - user.

# class User:
    - list of questions 
    - list of answers 
    - list of comments 
    - reputation = 0

    - method postQuestion
    - method postAnswer 

    - ** Remember to update user reputation **
    - method upvote(post)
        - post.upvote() 
    - method downvote(post)
        - post.downvote() 

    - method comment(post)

    - method markAnswerAsAccepted(question, answer)
        - check if question is under list of questions. 
        - check if answer is under question. 
        - if yes, set accepted answer to answer. 
        - if not, throw an error. 

    - method updateReputation()
    
    - method setTagToQuestion(question) 
        - check if question is under list of questions. 
        if yes, set tag to question 

# abstract class: Post
    - content: String 
    - list of comments 
    - owner: User
    - method upvote
        - owner.updateReputation(integer)
    - method downvote
        - owner.updateReputation(- integer)
    - method comment
# class: Question inherit Post
    - list of answers 
    - list of tags
    - accepted answer = null 

    - method setAcceptedAnswer(answer)
        - owner.updateReputation(integer x 2)
    - method isAnswerOnQuestion(answer)
    - method setAnswer(answer)
    - method setTag(tag)
# class: Answer inherit Post

# class: Comment
    - content: String 

# class Tag
    - enum 
    - values: JavaScript, Python, C
