package org.mybatis.example;

import com.mybatis.test.IUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(resource);

        //构建sqlSession工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        SqlSession session = sessionFactory.openSession();

        //autoCommit
        SqlSession session = sessionFactory.openSession(true);

//        IUserMapper userDao = session.getMapper(IUserMapper.class);

        try {

            //映射器实例
            IUserMapper userDao1 = session.getMapper(IUserMapper.class);

//            List<User> users = session.selectList("com.mybatis.test.IUserMapper.selectUser");

            User user = new User();
            user.setName("tianjing");
            user.setAge(15);
            user.setGender(1);
//            int id = userDao1.insertUser(user);
//            session.commit();
//            System.out.println("id:" + id);
            List<User> users = userDao1.selectUser();

            List<Integer> idList = Arrays.asList(new Integer(1), new Integer(23), new Integer(2));
            List<String> nameList = Arrays.asList("sun", "tianjing", "jing", "tian");
            List<User> userList = userDao1.selectUserByIdAndNameList(idList, nameList);

            System.out.println("size: " + userList.size());

            List<User> userList1 = userDao1.selectUserByIdAndNameList2(idList, nameList);
            System.out.println("size2: " + userList1.size() + "-------------");

            System.out.println("This is user list:");
            System.out.println("size: " + users.size());

            List<User> userList2 = userDao1.selectLikeIfElse("tian tian", 20, 1);
            System.out.println("id: " + users.get(0).getId() +
                "    name: " + users.get(0).getName() +
                "    age: " + users.get(0).getAge() +
                "    gender: " + users.get(0).getGender());

            System.out.println("if else: " + userList2);
            List<User> users2 = loadUsers();
            List<User> userList3 = userDao1.selectUserByNameAndAgeList(users2);
            for (int i = 0; i < userList3.size(); i++) {
                System.out.println("user " + i + " : " + userList3.get(i).getName() + " age " + userList3.get(i).getAge());
            }


            System.out.print("999999999999999");
        } finally {

            session.close();
        }

//        LocalDate nowDate = LocalDate.now();
//        LocalDate date = LocalDate.parse("2016-11-28");
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
//        Date newdate = formatter.parse("07-011-2016");
//        System.out.println("month difference is : " + date.until(nowDate, ChronoUnit.MONTHS));
    }

    private static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("jing", 17);
//        User user2 = new User("sun", 17);
//        User user3 = new User("sun", 20);
        User user4 = new User("tian", 20);
        users.add(user1);
//        users.add(user2);
//        users.add(user3);
        users.add(user4);
        return users;
    }
}
