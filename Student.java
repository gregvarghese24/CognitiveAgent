import java.utils.ArrayList;

public class Student {

    private Energy energyLevel;
    private Motivation motivationLevel;
    private String major;
    private String name;
    private int age;
    private String classstanding;
    private static Schedule schedule;
    private static ArrayList<Assignment> assignmentList;

    public Student(String name, Energy energy, Motivation motivation, Schedule schedule) {
        this.name = name;
        this.energyLevel = energy;
        this.motivationLevel = motivation;
        this.schedule = schedule;
    }

    public Energy getEnergy() {
        return this.energyLevel;
    }

    public Motivation getMotivation() {
        return this.motivationLevel;
    }

    public String getName() {
        return this.name;
    }

    public static Schedule getSchedule() {
        return schedule;
    }

    public static ArrayList<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void addAssignmentsToList(Assignment[] list) {
        for (Assignment a : list) {
            this.assignmentList.add(a);
        }
    }
}