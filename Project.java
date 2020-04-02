public class Project extends Assignment {
    
    public Project(String name, String difficulty, Day due, int time) {
        super(name, difficulty, due, time);
    }

    public void scheduleAssignment() {
        Day dueDate = this.getDueDate();
        int dueVal = dueDate.getValue();
        if (this.getDifficulty() == "EASY") {
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
        this.scheduleAssignment();
    }
}