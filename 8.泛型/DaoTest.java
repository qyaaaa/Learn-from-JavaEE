package javase高级.sep3;

import org.junit.Test;

import java.util.List;

public class DaoTest {
    @Test
    public void test1(){
        CustomerDao dao = new CustomerDao();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);

        StudentDao dao2 = new StudentDao();
        Student student = dao2.getIndex(1);
    }
}
