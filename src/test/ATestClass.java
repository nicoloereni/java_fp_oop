package test;

import examples.AClassToTest;
import examples.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class ATestClass {

    private AClassToTest aClassToTest;

    @Before
    public void setUp() throws Exception {

        aClassToTest = new AClassToTest();

    }

    @Test
    public void stringSum(){

        String result = aClassToTest.sum(getStudents());

        assertNotNull(result);
        assertEquals("pino,gino,tino,binda,", result);
    }

    @Test
    public void stringSumFpBad(){

        String result = aClassToTest.sumBadFp(getStudents());

        assertNotNull(result);
        assertEquals("pino,gino,tino,binda,", result);
    }

    @Test
    public void stringSumFpGood(){

        String result = aClassToTest.sumGoodFp(getStudents());

        assertNotNull(result);
        assertEquals("pino,gino,tino,binda,", result);
    }

    private List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("pino"));
        students.add(new Student("gino"));
        students.add(new Student("tino"));
        students.add(new Student("binda"));
        return students;
    }

}
