public abstract class Assignment {
    
    private String name;
    private String difficulty;
    private Day dueDate;
    private int timeNeeded;
    // private String size;
    // private String weight;

    public Assignment(String name, String difficulty, Day due, int time) {
        this.name = name;
        this.difficulty = difficulty;
        this.dueDate = due;
        this.timeNeeded = time;
    }

    public String getName() {
        return this.name;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public Day getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Day newDate) {
        this.dueDate = newDate;
    }

    public int getTimeNeeded() {
        return this.timeNeeded;
    }

    public void setTimeNeeded(int time) {
        this.timeNeeded = time;
    }

    public abstract void scheduleAssignment();

    public abstract void scheduleProcrastinate();


}