import java.util.ArrayList;

import Assignment.java;

public class Day implements Assignment {

    private int busyHours = 0;
    private int freeHours = 0;
    private String dayOfWeek;
    private int value;
    private ArrayList<Assignment> tasksForToday;
    private ArrayList<Extracurriculars> extracurriculars;
    private ArrayList<Classes> classes;

    public Day(String dayOfWeek, ArrayList<Extracurriculars> ec, ArrayList<Classes> c) {
        this.dayOfWeek = dayOfWeek;
        this.extracurriculars = ec;
        this.classes = c;

        for (Extracurriculars e : ec) {
            this.busyHours += e.getHours();
        }
        for (Classes cl : c) {
            this.busyHours += cl.getHours();
        }

        this.freeHours = 24 - this.busyHours;

        if (dayOfWeek == "Weekend") {
            this.value = 0;
        } else if (dayOfWeek == "Monday") {
            this.value = 1;
        } else if (dayOfWeek == "Tuesday") {
            this.value = 2;
        } else if (dayOfWeek == "Wednesday") {
            this.value = 3;
        } else if (dayOfWeek == "Thursday") {
            this.value = 4;
        } else if (dayOfWeek == "Friday") {
            this.value = 5;
        }
        
        this.tasksForToday = new ArrayList<Assignment>();
    }

    public int getBusyHours() {
        return this.busyHours;
    } //check

    public void setBusyHours(int busy) {
        this.busyHours = busy;
    }

    public int getFreehours() {
        return this.freeHours;
    }

    public void setFreeHours(int free) {
        this.freeHours = free;
    }

    public String toString() {
        return this.dayOfWeek;
    }

    public int getValue() {
        return this.value;
    }

    public ArrayList<Assignment> getTasksForToday() {
        return this.tasksForToday;
    }

    @Override
    public Boolean equals(Day d) {
        if (this.dayOfWeek == d.dayOfWeek && this.freeHours == d.freeHours && this.busyHours == d.busyHours) {
            return true;
        }
    }
}
