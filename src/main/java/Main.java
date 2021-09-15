import RatingService.RatingService;
import pojos.StudentRating;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Name Of Student to get Ratings [enter 0 to quit]: ");
            String studentName = scanner.nextLine();
            if (studentName.equals("0")) break;
            RatingService ratingService = new RatingService();
            List<StudentRating> studentRatings = ratingService.getRatingByStudentName(studentName);
            if (studentRatings.isEmpty()) {
                System.out.println("No Student Found!");
                continue;
            }
            System.out.println("--------------------------------------------");
            for (StudentRating studentRating : studentRatings) {
                System.out.println(studentRating);
                System.out.println("--------------------------------------------");
            }
        }
    }
}
