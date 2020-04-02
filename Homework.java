import java.util.ArrayList;
import Assignment.java;

public class Homework extends Assignment {
    
    public Homework(String name, String difficulty, Day due, int time) {
        //you procrastinate on homework, easy you do it the day of
        //medium: day of or before
        //hard: day, one day before and/or two days before
        super(name, difficulty, due, time);
    }

    /**
     * If scheduling regularly:
     *      If hw is EASY: do it the day before it's due
     *      If hw is MED: do it the previous two days
     *      If hw is HARD: do it on all previous days
     */

    public void scheduleAssignment() {
        // initial variables/assignment data
        Day dueDate = this.getDueDate();
        int dueVal = dueDate.getValue();

        if (this.getDifficulty() == "EASY") {
            // day before due
            Day dayBefore = getSchedule().getDay(dueVal - 1);
            dayBefore.getTasksForToday().add(this);
        } else if (this.getDifficulty() == "MED") {
            //do previous two days
            ArrayList<Day> prevDays = getTwoPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        } else if (this.getDifficulty() == "HARD") {
            //do it on all of the previous days
            ArrayList<Day> prevDays = getAllPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        }
    }
    




    /**
     * If procrastinating:
     *      If hw is EASY: do it the day of (on the due date)
     *      If hw is MED: do it the day of and the day before (on the due date and the prevous day)
     *      If hw is HARD: do it the day of and the previous two days
     */

    public void scheduleProcrastinate() {
        Day dueDate = this.getDueDate();
        int dueVal = dueDate.getValue();
        if (this.getDifficulty() == "EASY") {
            //day of
            Day dayOf = getSchedule.getVal(dueVal);
            dayOf.getTasksForToday().add(this);

        } else if (this.getDifficulty() == "MED") {
            //day of
            Day dayOf = getSchedule().getDay(dueVal);
            dayOf.getTasksForToday().add(this);
            //day before
            Day dayBefore = getSchedule().getDay(dueVal - 1);
            dayBefore.getTasksForToday().add(this);
        }

        else if (this.getDifficulty() == "HARD") {
            //Day of
            Day dayOf = getSchedule().getDay(dueVal);
            dayOf.getTasksForToday().add(this);

            // two previous days
            ArrayList<Day> prevDays = getTwoPreviousDays(dueDate);
            for (Day d : prevDays) {
                d.getTasksForToday().add(this);
            }
        }
    }
}
