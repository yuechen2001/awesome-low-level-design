package attempts.stackoverflow;

public class TestStackOverflow {
    public static void main(String[] args) {
        // Create users
        User alice = new User();
        User bob = new User();
        User charlie = new User();
        User dave = new User();

        // Alice posts a question
        Question q1 = alice.postQuestion("How do I reverse a string in Java?");
        alice.setTagToQuestion(q1, Tag.JAVASCRIPT);
        alice.setTagToQuestion(q1, Tag.PYTHON);

        // Bob posts a question
        Question q2 = bob.postQuestion("What is the difference between HashMap and Hashtable?");
        bob.setTagToQuestion(q2, Tag.JAVASCRIPT);

        // Bob and Charlie answer Alice's question
        bob.postAnswer("Use StringBuilder's reverse() method.", q1);
        charlie.postAnswer("You can also use a for loop to reverse.", q1);
        dave.postAnswer("Try recursion for fun!", q1);

        // Alice and Dave answer Bob's question
        alice.postAnswer("HashMap is not synchronized, Hashtable is.", q2);
        dave.postAnswer("HashMap allows null keys, Hashtable does not.", q2);

        // Voting
        if (q1.getAnswers().size() > 1) {
            Answer charliesAnswer = q1.getAnswers().get(1);
            bob.upvote(charliesAnswer);
        }
        if (q1.getAnswers().size() > 0) {
            Answer bobsAnswer = q1.getAnswers().get(0);
            charlie.upvote(bobsAnswer);
        }
        if (q2.getAnswers().size() > 0) {
            Answer alicesAnswer = q2.getAnswers().get(0);
            dave.upvote(alicesAnswer);
        }
        alice.upvote(q1);
        alice.upvote(q2.getAnswers().get(0));
        charlie.downvote(q2.getAnswers().get(1)); // Charlie downvotes Dave's answer

        // Comments
        alice.comment(q1, "Please provide code examples!");
        dave.comment(q1.getAnswers().get(0), "Great answer!");
        bob.comment(q2, "Thanks for the clarification!");
        charlie.comment(q2.getAnswers().get(1), "Null keys are tricky!");

        // Accept answers
        alice.markAnswerAsAccepted(q1, q1.getAnswers().get(0)); // Alice accepts Bob's answer
        bob.markAnswerAsAccepted(q2, q2.getAnswers().get(0));   // Bob accepts Alice's answer
        alice.markAnswerAsAccepted(q1, q1.getAnswers().get(2)); // Try to accept Dave's answer (should not work)

        // Print reputations
        System.out.println("Alice reputation: " + alice.getReputation());
        System.out.println("Bob reputation: " + bob.getReputation());
        System.out.println("Charlie reputation: " + charlie.getReputation());
        System.out.println("Dave reputation: " + dave.getReputation());

        // Print some details
        System.out.println("\nQuestion 1: " + q1);
        System.out.println("Answers for Q1:");
        for (Answer a : q1.getAnswers()) {
            System.out.println("- " + a);
        }
        System.out.println("\nQuestion 2: " + q2);
        System.out.println("Answers for Q2:");
        for (Answer a : q2.getAnswers()) {
            System.out.println("- " + a);
        }
    }
}

