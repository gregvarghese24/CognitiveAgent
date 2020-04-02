import Schedule.java;
import Student.java;

public class Exam extends Assignment {
    
    public Exam(String name, String difficulty, Day due, int time) {
        super(name, difficulty, due, time);
    }

    @Override
    public void scheduleAssignment() {
        Day dueDate = this.getDueDate();
        int dueVal = dueDate.getValue();
        if (this.getDifficulty() == "EASY") {
            Day dayBefore = getSchedule().getDay(dueVal - 1);
            dayBefore.getTasksForToday().add(this);
        } else if (this.getDifficulty() == "MED") {
            ArrayList<Day> prevDays = getTwoPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        } else {
            ArrayList<Day> prevDays = getAllPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        }
    }

    public void scheduleProcrastinate() {
        Day dueDate = this.getDueDate();
        int dueVal = dueDate.getValue();
        if (this.getDifficulty() == "EASY") {
            Day dayBefore = getSchedule().getDay(dueVal - 1);
            dayBefore.getTasksForToday().add(this);
        } else if (this.getDifficulty() == "MED") {
            dueDate.getTasksForToday().add(this);
            ArrayList<Day> prevDays = getTwoPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        } else {
            dueDate.getTasksForToday().add(this);
            ArrayList<Day> prevDays = getAllPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        }
     }
}