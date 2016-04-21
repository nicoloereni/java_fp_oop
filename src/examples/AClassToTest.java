package examples;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

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

            if (student.gradScore > bestScore) {
                bestScore = student.gradScore;
            }

        }

        return bestScore;

    }


    public int bestScoreAfterAYearFp(List<Student> students, int year) {

        OptionalInt bestScore = students.stream()
                .filter(student -> student.gradYear == year)
                .mapToInt(Student::getGradeScore)
                .max();

        return bestScore.getAsInt();

    }

    public Map groupStudentByYear(List<Student> students){
        Map<Integer, List<Student>> studentByGradYear = new HashMap<>();

        for(Student student : students){

            List<Student> list = studentByGradYear.get(student.getGradYear());

            if(list == null){
                list = new ArrayList<>();
                studentByGradYear.put(student.getGradYear(), list);
            }

            list.add(student);

        }

        return studentByGradYear;

    }

    public Map groupStudentByYearFX(List<Student> students) {
        Map<Integer, List<Student>> result = students.stream().collect(groupingBy(student->student.getGradYear()));
        return result;
    }
}
