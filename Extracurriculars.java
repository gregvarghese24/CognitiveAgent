public abstract class Extracurriculars {

    private int hours;
    private String name;

    public Extracurriculars(String name, int hours) {
        this.hours = hours;
        this.name = name;
    }

    public int getHours() { return this.hours; }

}
