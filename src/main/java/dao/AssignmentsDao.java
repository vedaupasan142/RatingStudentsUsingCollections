package dao;

import pojos.Assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignmentsDao {
    private Map<Integer, Assignment> assignments = new HashMap<>();

    public AssignmentsDao() {
        this.assignments.put(1, new Assignment("Ananth", "Electro Fields", "test 1", LocalDate.of(2016, 7, 21), 100));
        this.assignments.put(2, new Assignment("Bhagath", "Electro Fields", "test 1", LocalDate.of(2016, 7, 21), 78));
        this.assignments.put(3, new Assignment("Chaya", "Electro Fields", "test 1", LocalDate.of(2016, 7, 21), 68));
        this.assignments.put(4, new Assignment("Esharath", "Electro Fields", "test 1", LocalDate.of(2016, 7, 21), 87));
        this.assignments.put(5, new Assignment("Bhagath", "Electro Fields", "quiz 1", LocalDate.of(2016, 7, 22), 20));
        this.assignments.put(6, new Assignment("Chaya", "Electro Fields", "lab 1", LocalDate.of(2016, 7, 23), 10));
        this.assignments.put(7, new Assignment("Ananth", "Electro Fields", "project 1", LocalDate.of(2016, 7, 24), 100));
        this.assignments.put(8, new Assignment("Davanth", "Electro Fields", "project 1", LocalDate.of(2016, 7, 24), 100));
        this.assignments.put(9, new Assignment("Bhagath", "Electro Fields", "quiz 2", LocalDate.of(2016, 7, 25), 50));
        this.assignments.put(10, new Assignment("Ananth", "Electro Fields", "quiz 1", LocalDate.of(2016, 7, 26), 100));
        this.assignments.put(11, new Assignment("Bhagath", "Electro Fields", "lab 1", LocalDate.of(2016, 7, 27), 10));
        this.assignments.put(12, new Assignment("Chaya", "Electro Fields", "project 1", LocalDate.of(2016, 7, 28), 100));
        this.assignments.put(13, new Assignment("Bhagath", "Electro Fields", "project 1", LocalDate.of(2016, 7, 28), 100));
        this.assignments.put(14, new Assignment("Ananth", "Computing Techniques", "test 1", LocalDate.of(2016, 7, 29), 86));
        this.assignments.put(15, new Assignment("Ananth", "Electro Fields", "quiz 2", LocalDate.of(2016, 7, 29), 100));
        this.assignments.put(16, new Assignment("Bhagath", "Computing Techniques", "project 1", LocalDate.of(2016, 7, 30), 100));
        this.assignments.put(17, new Assignment("Ananth", "Electro Fields", "lab 1", LocalDate.of(2016, 7, 30), 100));
        this.assignments.put(18, new Assignment("Chaya", "Computing Techniques", "quiz 1", LocalDate.of(2016, 7, 31), 20));
        this.assignments.put(19, new Assignment("Ananth", "Electro Fields", "test 2", LocalDate.of(2016, 8, 1), 100));
        this.assignments.put(20, new Assignment("Chaya", "Electro Fields", "test 2", LocalDate.of(2016, 8, 1), 92));
    }

    public Map<Integer, Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Map<Integer, Assignment> assignments) {
        this.assignments = assignments;
    }

    public Assignment getAssignment(int serialNo) {
        return assignments.get(serialNo);
    }

    public List<Assignment> getAssignmentsByStudentName(String studentName) {
        List<Assignment> studentSpecificAssignments = new ArrayList<>();
        for (Assignment assignment : assignments.values()) {
            if (assignment.getStudentName().equalsIgnoreCase(studentName)) {
                studentSpecificAssignments.add(assignment);
            }
        }
        return studentSpecificAssignments;
    }

    public List<Assignment> getAssignmentsBySubjectName(String subjectName) {
        List<Assignment> subjectSpecificAssignments = new ArrayList<>();
        for (Assignment assignment : assignments.values()) {
            if (assignment.getSubject().equalsIgnoreCase(subjectName)) {
                subjectSpecificAssignments.add(assignment);
            }
        }
        return subjectSpecificAssignments;
    }


}
