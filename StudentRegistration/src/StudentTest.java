import com.acwd.m01.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student = new Student();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        student.setFirstName("Erza");
        student.setLastName("Scarlet");
        student.setGender("Female");
        student.setResidentialAddr("123 Hill View");
        student.setPhoneNum("98765431");

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void validFirstName() {
        assertTrue(student.validFirstName());
    }

    @org.junit.jupiter.api.Test
    void validLastName() {
        assertTrue(student.validLastName());
    }

    @org.junit.jupiter.api.Test
    void validGender() {
        assertTrue(student.validGender());
    }

    @org.junit.jupiter.api.Test
    void validResidentialAddr() {
        assertTrue(student.validResidentialAddr());
    }

    @org.junit.jupiter.api.Test
    void validPhoneNum() {
        assertTrue(student.validPhoneNum());
    }
}