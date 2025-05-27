# StackOverflow LLD Attempt: Review & Marking

## What You Did Well

### 1. Core Entities & Relationships
- **User, Question, Answer, Comment, Tag**: All core entities required for a StackOverflow system are implemented.
- **User–Question/Answer/Comment Relationships**: Users can post questions, answers, and comments, and these relationships are tracked via lists in the `User` class.
- **Basic Inheritance**: `Question` and `Answer` both extend `Post`, demonstrating good use of abstraction.
- **Tagging**: Questions can be tagged using a `Tag` enum.
- **Basic Voting**: Upvote and downvote methods exist and update user reputation.

### 2. Encapsulation & Structure
- **Encapsulation**: Fields are private and accessed via methods.
- **Separation of Concerns**: Each class is responsible for its own data and behavior (e.g., `addComment`, `setAnswer`).
- **Test Coverage**: The [TestStackOverflow.java](cci:7://file:///c:/Users/Admin/Documents/Zhu%20Yuechen/Personal%20Projects/awesome-low-level-design/attempts/stackoverflow/TestStackOverflow.java:0:0-0:0) script exercises most of the main flows, including edge cases (e.g., accepting an answer twice).

### 3. Code Quality
- **Override `toString()`**: For better output, you overrode `toString()` in `Post` and `Comment`.
- **No Uncaught Exceptions**: Invalid operations (e.g., accepting an answer twice) are handled gracefully.

---

## What’s Missing or Could Be Improved

### 1. Voting System
- **No Vote Entity**: There is no `Vote` class or `VoteType` enum. Voting is handled by simple methods, so you can't track who voted, prevent duplicate votes, or distinguish between upvotes and downvotes in a structured way.
- **No Votable/Commentable Interfaces**: Interfaces to generalize voting and commenting are missing, which would make the design more extensible and align with the Strategy pattern.
- **No Vote Counting**: There’s no way to get the total vote count for a post, nor are votes stored as objects.

### 2. Reputation & Business Logic
- **Non-StackOverflow Reputation Rules**: All upvotes/downvotes are ±1, regardless of whether it’s a question or answer. StackOverflow uses +10 for answer upvotes, +5 for question upvotes, -2 for downvotes, and +15 for accepted answers.
- **No Penalty for Downvoters**: On StackOverflow, the downvoter also loses 1 rep, which is not implemented.
- **No Bonus for Accepted Answers**: Accepting an answer should give a significant bonus to the answerer and a small bonus to the question owner.

### 3. Extensibility & Patterns
- **No Observer Pattern**: Reputation changes are handled directly, not via an observer/listener model.
- **No Strategy Pattern for Voting/Commenting**: Interfaces or strategies for voting/commenting are not used, which would make it easier to add new behaviors.
- **No Unique IDs or Metadata**: Entities like User, Question, Answer, and Comment do not have IDs, timestamps, or author fields, which are important for real systems.

---

## Summary Table

| Requirement/Feature                | Your Implementation | Comment |
|------------------------------------|:-------------------:|---------|
| User, Question, Answer, Comment    | ✅                  | Good use of classes and relationships |
| Tagging                            | ✅                  | Enum-based, simple but effective |
| Voting (basic)                     | ✅                  | Only basic, lacks tracking |
| Vote entity, VoteType              | ❌                  | Not implemented |
| Votable/Commentable interfaces     | ❌                  | Not implemented |
| Reputation system (basic)          | ✅                  | Only ±1, not per SO rules |
| Reputation per SO rules            | ❌                  | No bonus/penalty logic |
| Accepted answer logic              | ✅                  | Only single accepted answer, no rep bonus |
| User Management (Singleton)        | ❌                  | File present but empty |
| Extensible design patterns         | ❌                  | No interface/observer/strategy |
| IDs, timestamps, authors           | ❌                  | Not implemented |
| Test script                        | ✅                  | Good coverage of main flows |

---

## Final Comments (LLD Interview Perspective)

- **Strengths:**  
  You demonstrated a solid grasp of OOP basics, class relationships, encapsulation, and basic system flows. Your code is readable, testable, and covers the core user stories for a StackOverflow-like system.

- **Areas for Growth:**  
  For a higher-level LLD interview, focus on extensibility and real-world business logic. Add interfaces for common behaviors, use richer entities for actions like voting and commenting, and follow the actual business rules for reputation and voting. Consider how you would extend the system for features like moderation, notifications, or analytics.