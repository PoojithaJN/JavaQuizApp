import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println("\n" + questionText);
        char optionChar = 'A';
        for (String option : options) {
            System.out.println(optionChar + ". " + option);
            optionChar++;
        }
    }

    public boolean checkAnswer(char answer) {
        return Character.toUpperCase(answer) == Character.toUpperCase(correctAnswer);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[]{"London", "Berlin", "Paris", "Madrid"}, 'C'));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 'B'));
        questions.add(new Question("Who developed Java?",
                new String[]{"Bjarne Stroustrup", "James Gosling", "Dennis Ritchie", "Guido van Rossum"}, 'B'));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"implement", "inherits", "extends", "super"}, 'C'));
        questions.add(new Question("Which of these is a valid Collection type?",
                new String[]{"HashMap", "ArrayList", "TreeSet", "All of the above"}, 'D'));

        int score = 0;

        System.out.println("🎯 Welcome to the Java Quiz!");
        System.out.println("----------------------------");

        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = sc.next().charAt(0);
            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctAnswer);
            }
        }

        System.out.println("\n🏁 Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());
        sc.close();
    }
}
