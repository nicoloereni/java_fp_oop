package examples;

public class Student {

    public String name;
    public int gradScore;
    public int gradYear;

    public Student(String name, int gradScore, int gradYear) {
        this.name = name;
        this.gradScore = gradScore;
        this.gradYear = gradYear;
    }

    public int getGradeScore() {
        return gradScore;
    }

    public int getGradYear() {
        return gradYear;
    }
}
