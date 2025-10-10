package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;
    private int MINUTES_PER_HOUR = 60;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        this(0, minutes);
    }

    public TimeSpan(int hours, int minutes) {
        setTime(hours, minutes);
    }

    public TimeSpan(TimeSpan timeSpan) {
        this.hours = timeSpan.hours;
        this.minutes = timeSpan.minutes;
        this.MINUTES_PER_HOUR = timeSpan.MINUTES_PER_HOUR;
    }

    private void setTime(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
            return;
        }

        this.hours = hours + minutes / MINUTES_PER_HOUR;
        this.minutes = minutes % MINUTES_PER_HOUR;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;

        this.hours += hours;
        this.minutes += minutes;

        this.hours += this.minutes / MINUTES_PER_HOUR;
        this.minutes = this.minutes % MINUTES_PER_HOUR;
    }

    public void add(int minutes) {
        if (minutes < 0) return;
        add(0, minutes);
    }

    public void add(TimeSpan timeSpan) {
        add(timeSpan.hours, timeSpan.minutes);
    }

    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;

        int totalCurrent = this.getTotalMinutes();
        int totalSubtract = hours * MINUTES_PER_HOUR + minutes;

        if (totalSubtract > totalCurrent) {
            this.hours = 0;
            this.minutes = 0;
            return;
        }

        int result = totalCurrent - totalSubtract;
        this.hours = result / MINUTES_PER_HOUR;
        this.minutes = result % MINUTES_PER_HOUR;
    }

    public void subtract(int minutes) {
        if (minutes < 0) return;
        subtract(0, minutes);
    }

    public void subtract(TimeSpan timeSpan) {
        subtract(timeSpan.hours, timeSpan.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    public int getTotalMinutes() {
        return hours * MINUTES_PER_HOUR + minutes;
    }

    public void scale(int factor) {
        if (factor <= 0) return;

        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / MINUTES_PER_HOUR;
        this.minutes = totalMinutes % MINUTES_PER_HOUR;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}
