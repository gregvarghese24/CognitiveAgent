import Day.java;
import java.util.ArrayList;

public class Schedule {
    private static Day weekend;
    private static Day mon;
    private static Day tue;
    private static Day wed;
    private static Day thur;
    private static Day fri;

    public Schedule(Day weekend, Day mon, Day tue, Day wed, Day thur, Day fri) {
        this.weekend = weekend;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thur = thur;
        this.fri = fri;
    }

    @Override
    public Day getDay(int value) {
        if (value == 0) {
            return weekend;
        } else if (value == 1) {
            return mon;
        } else if (value == 2) {
            return tue;
        } else if (value == 3) {
            return wed;
        } else if (value == 4) {
            return thur;
        } else if (value == 5) {
            return fri;
        }
    }

    public static ArrayList<Day> getAllPreviousDays(Day day) {
        ArrayList<Day> ret = new ArrayList<Day>();
        if (day.equals(mon)) {
            return ret.add(weekend);
        } else if (day.equals(tue)) {
            ret.add(weekend);
            ret.add(mon);
            return ret;
        } else if (day.equals(wed)) {
            ret.add(weekend);
            ret.add(mon);
            ret.add(tue);
            return ret;
        } else if (day.equals(thur)) {
            ret.add(weekend);
            ret.add(mon);
            ret.add(tue);
            ret.add(wed);
            return ret;
        } else if (day.equals(fri)) {
            ret.add(weekend);
            ret.add(mon);
            ret.add(tue);
            ret.add(wed);
            ret.add(thur);
            return ret;
        }
    }

    public static ArrayList<Day> getTwoPreviousDays(Day day) {
        ArrayList<Day> ret = new ArrayList<Day>();
        if (day.equals(mon)) {
            return ret.add(weekend);
        } else if (day.equals(tue)) {
            ret.add(weekend);
            ret.add(mon);
            return ret;
        } else if (day.equals(wed)) {
            ret.add(mon);
            ret.add(tue);
            return ret;
        } else if (day.equals(thur)) {
            ret.add(tue);
            ret.add(wed);
            return ret;
        } else if (day.eqauals(fri)) {
            ret.add(wed);
            ret.add(thur);
            return ret;
        }
    }

    public static ArrayList<Day> getAllDays() {
        ArrayList<Day> ret = new ArrayList<Day>();
        ret.add(weekend);
        ret.add(mon);
        ret.add(tue);
        ret.add(wed);
        ret.add(thur);
        ret.add(fri);
        return ret;
    }

    public Day getWeekend() {
        return weekend;
    }

    public Day getMonday() {
        return mon;
    }

    public Day getTuesday() {
        return tue;
    }

    public Day getWednesday() {
        return wed;
    }

    public Day getThursday() {
        return thur;
    }

    public Day getFriday() {
        return fri;
    }
}