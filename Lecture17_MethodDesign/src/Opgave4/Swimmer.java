package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Swimmer {
    private String name;
    private String club;
    private LocalDate birthday;
    private ArrayList<Double> times;

    public Swimmer(String name, String club, LocalDate birthday, ArrayList<Double> times) {
        this.name = name;
        this.club = club;
        this.birthday = birthday;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public int getYearOfBirth() {
        return birthday.getYear();
    }

    public void setClub(String club) {
        this.club = club;
    }

    public double bestTime() {
        double bestTime = this.times.get(0);
        for (double time: this.times) {
            if (time < bestTime) {
                bestTime = time;
            }

        }

        return bestTime;
    }

    public double averageTime() {
        double sum = 0;
        for (double time: this.times) {
            sum += time;
        }

        return sum / this.times.size();
    }

    public double averageWithoutWorst() {
        double sum = 0;
        double worstTime = this.times.get(0);
        for (double time: this.times) {
            sum += time;
            if (time > worstTime) {
                worstTime = time;
            }
        }

        return (sum - worstTime) / (this.times.size() - 1);

    }

}
