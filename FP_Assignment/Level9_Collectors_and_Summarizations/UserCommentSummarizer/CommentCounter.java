package FP_Assignment.Level9_Collectors_and_Summarizations.UserCommentSummarizer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * From a list of comments, count the number of comments by each user.
 */

public class CommentCounter {

    public static Map<String, Long> countCommentsByUser(List<Comment> comments) {
        return comments.stream()
                .collect(Collectors.groupingBy(
                        Comment::getUser,
                        Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Comment> commentList = List.of(
                new Comment("Alice", "This is a great post!"),
                new Comment("Bob", "I agree with Alice."),
                new Comment("Alice", "Thanks, Bob!"),
                new Comment("Charlie", "Interesting perspective."));

        Map<String, Long> commentCountByUser = countCommentsByUser(commentList);
        System.out.println("Comment Count by User: " + commentCountByUser);
    }
}