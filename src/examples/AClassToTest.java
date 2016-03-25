package examples;

import java.util.List;

public class AClassToTest {

    public String sum(List<Student> students) {

        String names = "";

        for (Student student : students) {
            names += student.name + ",";
        }

        return names;
    }

    /**
     * Use of mutable accumulator
     */
    public String sumBadFp(List<Student> students) {

        final StringBuilder stringBuilder = new StringBuilder();

        students.stream().forEach(student -> stringBuilder.append(student.name).append(","));

        return stringBuilder.toString();
    }

    /**
     * No mutable
     */
    public String sumGoodFp(List<Student> students) {

        String names = students.stream()
                .map(student -> student.name + ",")
                .reduce("", (a, b) -> a + b);

        return names;
    }

    public int bestScoreAfterAYear(List<Student> students, int year) {

        int bestScore = 0;

        for (Student student : students) {

            if (student.gradYear != year) {
                continue;
            }

            if (student.gradScore > bestScore){
                bestScore = student.gradScore;
            }

        }

        return bestScore;

    }

}
