// import Student.java;
// import Schedule.java;
// import Day.java;
// import Energy.java;
// import Motivation.java;

import java.util.ArrayList;
import java.util.Arrays;

// import Assignment.java;
// import Exam.java;
// import Homework.java;
// import Project.java;
// import InfluenceInterface.java;

public class Agent {

    // sort the fatigue
    public static void sortFatigued(Day d) {
        ArrayList<Assignment> tasks = d.getTasksForToday();
        ArrayList<Assignment> result = new ArrayList<Assignment>();

        for (Assignment a : tasks) {
            if (a.getDifficulty() == "EASY") {
                result.add(a);
            }
        }
        for (Assignment a : tasks) {
            if (a.getDifficulty() == "MED") {
                result.add(a);
            }
        }
        for (Assignment a : tasks) {
            if (a.getDifficulty() == "HARD") {
                result.add(a);
            }
        }
        d.setTasksForToday(result);
    }
    // sort the not fatigued
    public static void sortNotFatigued(Day d) {
        ArrayList<Assignment> tasks = d.getTasksForToday();
        ArrayList<Assignment> result = new ArrayList<Assignment>();

        for (Assignment a : tasks) {
            if (a.getDifficulty() == "HARD") {
                result.add(a);
            }
        }
        for (Assignment a : tasks) {
            if (a.getDifficulty() == "MED") {
                result.add(a);
            }
        }
        for (Assignment a : tasks) {
            if (a.getDifficulty() == "EASY") {
                result.add(a);
            }
        }
        d.setTasksForToday(result);
    }

    public static void sortDueDate(Day d) {
        ArrayList<Assignment> tasks = d.getTasksForToday();
        ArrayList<Assignment> results = new ArrayList<Assignments>();


        for (Assignment a : tasks) {
            if (((a.getDueDate().getValue()) == Day.getDay())) { //if it is due today
                results.add(a);

            } else if ((Day.getDay()- (a.getDueDate().getValue())) == 1 ) { //case tomorrow
                results.add(a);

            } else if (a.getDueDate().getValue()) == 0) { //case for the weekend

            } else if (a.getDueDate().getValue() == 5) { //not a high due date priority

            } else { // not a high due date priority
                results.add(a);
            }

            d.setTasksForToday(result);

        }
    }

    public static void main(String args[]) {

        /**
         * Define classes for the week
         */
        Classes c1 = new Classes("MW", "CS 3790", 1.25);
        Classes c2 = new Classes("MWF", "CS 1331", 1);
        Classes c3 = new Classes("TR", "EAS 1600", 1.5);

        // ArrayList<Classes> cl = new ArrayList<Classes>();
        /**
         * Define extracurricular activities for the week
         */
        Extracurriculars e1 = new Sports("Football", 2);
        Extracurriculars e2 = new Sports("Soccer", 2);
        Extracurriculars e3 = new Sports("Basketball", 2);

        /**
         * Build the schedule for the week
         */
        Day weekend = new Day("Weekend", new ArrayList<Extracurriculars>(Arrays.asList(e1)), new ArrayList<Classes>());
        Day mon = new Day("Monday", new ArrayList<Extracurriculars>(Arrays.asList(e2)), new ArrayList<Classes>(Arrays.asList(c1, c2)));
        Day tue = new Day("Tuesday", new ArrayList<Extracurriculars>(Arrays.asList(e3)), new ArrayList<Classes>(Arrays.asList(c3)));
        Day wed = new Day("Wednesday", new ArrayList<Extracurriculars>(Arrays.asList(e1)), new ArrayList<Classes>(Arrays.asList(c1, c2)));
        Day thur = new Day("Thursday", new ArrayList<Extracurriculars>(Arrays.asList(e2)), new ArrayList<Classes>(Arrays.asList(c3)));
        Day fri = new Day("Friday", new ArrayList<Extracurriculars>(Arrays.asList(e1)), new ArrayList<Classes>(Arrays.asList(c2)));
        Schedule sched = new Schedule(weekend, mon, tue, wed, thur, fri);

        /**
         * Create Student object with motivation and energy
         */
        Student student = new Student("Name", new Energy("HIGH"), new Motivation("LOW"), sched);

        /**
         * Define Assignments that need to be done for this week
         */
        Assignment exam1 = new Exam("CS 3790 Exam", "MED", wed, 5);
        Assignment hw1 = new Homework("1301 HW2", "EASY", tue, 1);
        Assignment project1 = new Project("CS 3790 Project 2", "HARD", fri, 10);
        Assignment[] list = new Assignment[]{exam1, hw1, project1};
        student.addAssignmentsToList(list);

        if (student.getMotivation().getLevel() == "LOW") {
            for (Assignment a : student.getAssignmentList()) {
                a.scheduleProcrastinate();
            }
        } else {
            for (Assignment a : student.getAssignmentList()) {
                a.scheduleAssignment();
            }
        }

        if (student.getEnergy().getLevel() == "LOW") {
            /**
             * Sort assignmentList and put easy assignments at top
             */
            for (Day d : sched.getAllDays()) {
                sortFatigued(d);
            }
        } else {
            /**
             * sort assignmentList and put hard assignments at top
             */
            for (Day d : sched.getAllDays()) {
                sortNotFatigued(d);
            }
        }

    }
}