package RatingService;

import RatingDao.AssignmentsDao;
import RatingDao.DistributionsDao;
import pojos.Assignment;
import pojos.StudentRating;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class RatingService {
    AssignmentsDao assignmentsDao = new AssignmentsDao();
    DistributionsDao distributionsDao = new DistributionsDao();

    public List<StudentRating> getRatingByStudentName(String studentName) {
        List<StudentRating> studentRatings = new ArrayList<>();
        Map<String, List<Assignment>> subjectWithAssignments = new Hashtable<>();
        for (Assignment assignment : assignmentsDao.getAssignmentsByStudentName(studentName)) {
            if (!subjectWithAssignments.containsKey(assignment.getSubject())) {
                ArrayList<Assignment> assignments = new ArrayList<>();
                assignments.add(assignment);
                subjectWithAssignments.put(assignment.getSubject(), assignments);
            } else {
                subjectWithAssignments.get(assignment.getSubject()).add(assignment);
            }
        }
        for (String subject : subjectWithAssignments.keySet()) {
            List<Assignment> tests = new ArrayList<>();
            List<Assignment> quizzes = new ArrayList<>();
            List<Assignment> labs = new ArrayList<>();
            List<Assignment> projects = new ArrayList<>();
            for (Assignment assignment : subjectWithAssignments.get(subject)) {
                switch (assignment.getAssignmentCategory()) {
                    case "test 1":
                    case "test 2":
                        tests.add(assignment);
                        break;
                    case "quiz 1":
                    case "quiz 2":
                        quizzes.add(assignment);
                        break;
                    case "lab 1":
                        labs.add(assignment);
                        break;
                    case "project 1":
                        projects.add(assignment);
                        break;
                }
            }
            double testScore = 0, quizScore = 0, labScore = 0, projectScore = 0, overallRating = 0;

            for (Assignment assignment : tests) {
                testScore += getScore(distributionsDao.getCategory("test"), tests.size(), assignment.getPoints());
            }
            for (Assignment assignment : quizzes) {
                quizScore += getScore(distributionsDao.getCategory("quiz"), quizzes.size(), assignment.getPoints());
            }
            for (Assignment assignment : labs) {
                labScore += getScore(distributionsDao.getCategory("labWork"), labs.size(), assignment.getPoints());
            }
            for (Assignment assignment : projects) {
                projectScore += getScore(distributionsDao.getCategory("project"), projects.size(), assignment.getPoints());
            }
            overallRating = (testScore + quizScore + labScore + projectScore);
            if (tests.size() < 1) testScore = -1;
            if (quizzes.size() < 1) quizScore = -1;
            if (labs.size() < 1) labScore = -1;
            if (projects.size() < 1) projectScore = -1;
            studentRatings.add(new StudentRating(subject, testScore, quizScore, labScore, projectScore, overallRating));
        }
        return studentRatings;
    }

    private double getScore(double maxScore, int occurrence, double points) {
        return ((maxScore / occurrence) * points) / 100;
    }


}
