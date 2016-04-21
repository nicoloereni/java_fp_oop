package test;

import examples.AClassToTest;
import examples.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class ATestClass {

    private AClassToTest aClassToTest;

    @Before
    public void setUp() throws Exception {

        aClassToTest = new AClassToTest();

    }

    @Test
    public void stringSum() {

        String result = aClassToTest.sum(getStudents());

        assertNotNull(result);
        assertEquals("pino,gino,tino,binda,", result);
    }

    @Test
    public void stringSumFpBad() {

        String result = aClassToTest.sumBadFp(getStudents());

        assertNotNull(result);
        assertEquals("pino,gino,tino,binda,", result);
    }

    @Test
    public void stringSumFpGood() {

        String result = aClassToTest.sumGoodFp(getStudents());

        assertNotNull(result);
        assertEquals("pino,gino,tino,binda,", result);
    }

    private List<Student> getStudents() {
        List<Student> students = new ArrayList();
        students.add(new Student("pino", 10, 2014));
        students.add(new Student("gino", 20, 2014));
        students.add(new Student("tino", 30, 2014));
        students.add(new Student("binda", 40, 2015));
        return students;
    }

    @Test
    public void bestScore() throws Exception {

            int result = aClassToTest.bestScoreAfterAYear(getStudents(), 2014);

        assertEquals(30, result);
    }

    @Test
    public void bestScoreFp() throws Exception {

        int result = aClassToTest.bestScoreAfterAYearFp(getStudents(), 2014);

        assertEquals(30, result);
    }

    @Test
    public void groupStudentByGradYesrOOP() throws Exception {

        Map map = aClassToTest.groupStudentByYear(getStudents());

        assertNotNull(map);
        List<Student> students2014 = (List<Student>) map.get(2014);
        assertNotNull(students2014);
        assertEquals(3,students2014.size());
        List<Student> students2015 = (List<Student>) map.get(2015);
        assertNotNull(students2015);
        assertEquals(1,students2015.size());

    }

    @Test
    public void groupStudentByGradYesrFX() throws Exception {

        Map map = aClassToTest.groupStudentByYearFX(getStudents());

        assertNotNull(map);
        List<Student> students2014 = (List<Student>) map.get(2014);
        assertNotNull(students2014);
        assertEquals(3,students2014.size());
        List<Student> students2015 = (List<Student>) map.get(2015);
        assertNotNull(students2015);
        assertEquals(1,students2015.size());

    }

    

}
