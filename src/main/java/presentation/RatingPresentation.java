package presentation;

import pojos.SubjectRating;
import service.RatingService;
import pojos.StudentRating;

import java.util.List;
import java.util.Scanner;

public class RatingPresentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RatingService ratingService = new RatingService();
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("Enter Choice: \n   0. Exit \n   1. Get Ratings Using Student Name  \n   2. Get Ratings Using Subject Name \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Name Of Student to get Ratings: ");
                    String studentName = scanner.nextLine();
                    if (studentName.equals("0")) break;
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
                    break;
                }
                case 2: {
                    System.out.println("Enter Name Of Subject to get Ratings: ");
                    String subjectName = scanner.nextLine();
                    List<SubjectRating> subjectRatings = ratingService.getRatingsBySubjectName(subjectName);
                    if (subjectRatings.isEmpty()) {
                        System.out.println("No Subject Found!");
                        continue;
                    }
                    System.out.println("--------------------------------------------");
                    for (SubjectRating subjectRating : subjectRatings) {
                        System.out.println(subjectRating);
                        System.out.println("--------------------------------------------");
                    }
                    break;
                }
                case 0:{
                    isAlive = false;
                }
                default:
                    System.out.println("Invalid Choice!s");
            }
        }
    }
}
