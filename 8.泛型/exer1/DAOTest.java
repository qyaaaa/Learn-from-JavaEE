package javase高级.sep3.exer1;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆ling"));
        dao.save("1003",new User(1003,30,"蔡"));

        dao.update("1003",new User(1003,20,"方文山"));

        dao.delete("1002");
        List<User> list = dao.list();
        list.forEach(System.out :: println);
    }
}
