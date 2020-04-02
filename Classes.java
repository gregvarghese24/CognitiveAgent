public class Classes {

    private int classHours;
    private String days;

    public Classes(String days, int hours) {
        this.days = days;
        this.classHours = hours;
    }

    public int getHours() {
        return this.classHours;
    }

    public String getDays() {
        return this.days;
    }
}