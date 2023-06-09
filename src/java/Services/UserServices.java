/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DBConnection.DBConnection;
import Model.College;
import Model.Course;
import Model.Message;
import Model.Section;
import Model.Semester;
import Model.Student;
import Model.Subject;
import Model.Teacher;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class UserServices implements UserInterface{

    /**
     * This will get the User from account table
 This is used for authentication in login jsp
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUser(String username, String password) {
        User user = null;
        String query = "select * from accounts where ACC_USERNAME=? and ACC_PASSWORD=?";
        if (!username.equals("") && !password.equals("")) {
            PreparedStatement pstm = new DBConnection().getStatement(query);

            try {
                pstm.setString(1, username);
                pstm.setString(2, password);

                ResultSet rs = pstm.executeQuery();
                System.out.println("get User query:" + pstm);
                while (rs.next()) {
                    System.out.println("This is a user");
                    user = new User();
                    user.setId(rs.getInt("ACC_ID"));
                    user.setUsername(rs.getString("ACC_USERNAME"));
                    user.setPassword(rs.getString("ACC_PASSWORD"));
                    user.setRole(rs.getString("ACC_ROLE"));
                    System.out.println("Role id " + user.getId() + " role: " + user.getRole());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return user;
    }
    
    
    @Override
    public User getUser(String username) {
        User user = null;
        String query = "select * from accounts where ACC_USERNAME=?";
        if (!username.equals("")) {
            PreparedStatement pstm = new DBConnection().getStatement(query);

            try {
                pstm.setString(1, username);

                ResultSet rs = pstm.executeQuery();
                System.out.println("get User query:" + pstm);
                while (rs.next()) {
                    System.out.println("This is a user");
                    user = new User();
                    user.setId(rs.getInt("ACC_ID"));
                    user.setUsername(rs.getString("ACC_USERNAME"));
                    user.setRole(rs.getString("ACC_ROLE"));
                    System.out.println("Role id " + user.getId() + " role: " + user.getRole());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return user;
    }
    

    /**
     * This method will return the list of teacher from database
     * @return userList
     */
    @Override
    public List<Teacher> getTeacherList() {
        List<Teacher> userList = new ArrayList<>();
        String query = "SELECT * FROM `teacher` LEFT JOIN `accounts` ON teacher.ACC_ID = accounts.ACC_ID";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                Teacher teacher = new Teacher();
       
                teacher.setUser(new User(rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), rs.getString("TEAC_EMAIL"), rs.getString("TEAC_PHONE"),rs.getString("TEAC_ADDRESS") ));
                teacher.setAcc_id(rs.getInt("ACC_ID"));
                userList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User getUserRow(int id){
        User user = new User();
        String query = "select * from account where ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                
                user.setId(rs.getInt("TEAC_ID"));
                user.setUsername(rs.getString("ACC_USERNAME"));
                user.setPassword(rs.getString("ACC_PASSWORD"));
                user.setRole(rs.getString("ACC_ROLE"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    
    @Override
    public List<User> getActiveUserList() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM `user_activity` RIGHT JOIN `teacher` ON teacher.ACC_ID = user_activity.USER_ID";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("TEAC_ID"));
                user.setFullName(rs.getString("TEAC_NAME"));
                user.setStatus(rs.getString("STATUS"));
                user.setDate(rs.getDate("ACTIVE_DATE"));
       
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    
    
    /**
     * This will return the all the subjects from the database
     * @return 
     */
    @Override
    public List<Subject> getSubjectList() {
        List<Subject> userList = new ArrayList<>();
        String query = "SELECT * FROM `subject` LEFT JOIN teacher ON subject.TEAC_ID = teacher.TEAC_ID; ";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                Teacher teacher = new Teacher();
                Subject subject = new Subject( 
                        rs.getInt("SUB_ID"), 
                        rs.getString("SUB_NAME"), 
                        rs.getString("SUB_CODE")
                );
                
                teacher.setUser(new User(rs.getInt("TEAC_ID"), 
                        rs.getString("TEAC_NAME"), 
                        rs.getString("TEAC_EMAIL"),
                        rs.getString("TEAC_PHONE"), 
                        rs.getString("TEAC_ADDRESS")));
//                teacher.setSubjects(new Subject[] {subject});
                subject.setTeacher(teacher);
                userList.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    /**
     * This method will get a teacher row
     * @param id
     * @return 
     */
    @Override
      public Teacher getTeacherRow(int id){
        Teacher teacher = new Teacher();
        String query = "SELECT * FROM `teacher` LEFT JOIN `accounts` ON teacher.ACC_ID = accounts.ACC_ID where teacher.ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            System.out.println("Query: " + pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                teacher.setAcc_id( rs.getInt("ACC_ID") );
                teacher.setUser(new User( rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), rs.getString("TEAC_EMAIL"), rs.getString("TEAC_PHONE"), rs.getString("TEAC_ADDRESS") ));
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }
      
    @Override
      public Teacher getTeacherRow(String name){
        Teacher teacher = null;
        String query = "SELECT * FROM `teacher` LEFT JOIN `accounts` ON teacher.ACC_ID = accounts.ACC_ID where teacher.TEAC_NAME=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1,name);
            System.out.println("Query: " + pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                teacher = new Teacher();
                teacher.setUser(new User( rs.getInt("TEAC_ID"), rs.getString("TEAC_NAME"), rs.getString("TEAC_EMAIL"), rs.getString("TEAC_PHONE"), rs.getString("TEAC_ADDRESS") ));
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teacher;
    }
      
    @Override
      public Student getStudentRow(int id){
        Student student = new Student();
        String query = "SELECT * FROM `student` left JOIN course on student.C_ID = course.C_ID LEFT JOIN semester ON semester.SEM_ID = student.SEM_ID LEFT JOIN section on student.SEC_ID = section.SECTION_ID where STUD_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            System.out.println("Query: " + pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                System.out.println("\nquery : " + pstm);
                student.setRoll(rs.getInt("ACC_ID") );
                student.setUser(new User( 
                        rs.getInt("STUD_ID"), rs.getString("STUD_NAME"), 
                        rs.getString("STUD_EMAIL"), rs.getString("STUD_PHONE"), 
                        rs.getString("STUD_ADD")));
                
                student.setCollege(new College(
                        (new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME"))),
                        (new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))), 
                        (new Section(rs.getInt("SEC_ID"), rs.getString("SECTION_NAME")))
                ));
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }
      
      
    @Override
      public Student getStudentRowByAccID(int id){
        Student student = new Student();
        String query = "SELECT * FROM `student` left JOIN course on student.C_ID = course.C_ID LEFT JOIN semester ON semester.SEM_ID = student.SEM_ID LEFT JOIN section on student.SEC_ID = section.SECTION_ID where student.ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            System.out.println("Query: " + pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                System.out.println("\nquery : " + pstm);
                student.setRoll(rs.getInt("STUD_ID"));
                student.setUser(new User( 
                        rs.getInt("ACC_ID"), rs.getString("STUD_NAME"), 
                        rs.getString("STUD_EMAIL"), rs.getString("STUD_PHONE"), 
                        rs.getString("STUD_ADD")));
                
                student.setCollege(new College(
                        (new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME"))),
                        (new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))), 
                        (new Section(rs.getInt("SEC_ID"), rs.getString("SECTION_NAME")))
                ));
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }
      
     
      /**
     * This method will get get the list of student 
     * @return 
     */
    @Override
    public List<Student> getStudentList() {
        List<Student> userList = new ArrayList<>();
        String query = "SELECT * FROM `student` left JOIN course on student.C_ID = course.C_ID LEFT JOIN semester ON semester.SEM_ID = student.SEM_ID LEFT JOIN section on student.SEC_ID = section.SECTION_ID; ";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                College college = new College();
                Student student = new Student();
                student.setRoll(rs.getInt("ACC_ID"));
                student.setUser(new User(
                        rs.getInt("STUD_ID"), 
                        rs.getString("STUD_NAME"), 
                        rs.getString("STUD_EMAIL"), 
                        rs.getString("STUD_PHONE"), 
                        rs.getString("STUD_ADD")
                ));
                student.setCollege(new College(
                        (new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME"))), 
                        (new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))), 
                        (new Section( rs.getInt("SEC_ID"), rs.getString("SECTION_NAME") ))
                ));
                
                userList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
     
    
    /**
     * This  method will provide the list of student associated with a teacher
     * @param teac_id
     * @return 
     */
    @Override
    public List<Student> getStudentList(int teac_id) {
        List<Student> userList = new ArrayList<>();
        String query = "SELECT * from teacher LEFT JOIN subject ON teacher.TEAC_ID = subject.TEAC_ID LEFT JOIN student ON subject.SEM_ID = student.SEM_ID LEFT JOIN semester on student.SEM_ID = semester.SEM_ID LEFT JOIN course on semester.C_ID = course.C_ID LEFT JOIN section ON student.SEC_ID = section.SECTION_ID WHERE teacher.ACC_ID=? and student.STUD_ID IS NOT null;";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, teac_id);
            System.out.println("pstm: " + pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setUser(new User(
                        rs.getInt("STUD_ID"), 
                        rs.getString("STUD_NAME"), 
                        rs.getString("STUD_EMAIL"), 
                        rs.getString("STUD_PHONE"), 
                        rs.getString("STUD_ADD")
                ));
                
                student.setCollege(new College(
                        (new Course(rs.getInt("C_ID"), rs.getString("COURSE_NAME"))), 
                        (new Semester(rs.getInt("SEM_ID"), rs.getString("SEM_NAME"))), 
                        (new Section( rs.getInt("SEC_ID"), rs.getString("SECTION_NAME") ))
                ));
                userList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    /**
     * This method will insert User in accounts table
  This method is used in addTeacher jsp
     * @param user 
     */
    @Override
    public void insertUser(User user) {
        String query = "insert into accounts (ACC_USERNAME,ACC_PASSWORD,ACC_ROLE)"
                + "values(?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());

            System.out.println("insert user query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will insert teacher details in account and teacher table
     * @param teacher 
     */
    @Override
    public void insertUser(Teacher teacher) {
        insertUser(teacher.getUser()); //This method will insert the teacher details in Accout table
        User newUser = getUser(teacher.getUser().getUsername(), teacher.getUser().getPassword());
        insertUserActivity(newUser.getId());
        String query = "INSERT INTO `teacher`(`TEAC_NAME`, `TEAC_ADDRESS`, `TEAC_EMAIL`, `TEAC_PHONE`, `ACC_ID`) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, teacher.getUser().getFullName());
            pstm.setString(2, teacher.getUser().getAddress());
            pstm.setString(3, teacher.getUser().getEmail());
            pstm.setString(4, teacher.getUser().getPhone());
            pstm.setInt(5, newUser.getId());
            System.out.println("insert Teacher query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
     /**
     * This method will insert student in student and account tables
     * @param student 
     */
    @Override
    public void insertUser(Student student) {
        insertUser(student.getUser()); //This method will insert the student details in Accout table
        User newUser = getUser(student.getUser().getUsername(), student.getUser().getPassword());
        
        String query = "INSERT INTO `student`(`STUD_NAME`, `STUD_ADD`, `STUD_EMAIL`, `STUD_PHONE`, `SEM_ID`, `C_ID`, `SEC_ID`, `ACC_ID`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, student.getUser().getFullName());
            pstm.setString(2, student.getUser().getAddress());
            pstm.setString(3, student.getUser().getEmail());
            pstm.setString(4, student.getUser().getPhone());
            pstm.setString(5, student.getUser().getSemester());
            pstm.setString(6, student.getUser().getCourse());
            pstm.setString(7, student.getUser().getSection());
            pstm.setInt(8, newUser.getId());
            
            System.out.println("insert Student query:" + pstm);
            
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
     public void insertUserActivity(int acc_id) {
        
        String query = "INSERT INTO `user_activity`(`USER_ID`) VALUES (?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);          
            
            System.out.println("insert activity query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method will delete a user from account table
     * @param acc_id 
     */
    @Override
    public void deleteUser(int acc_id) {
        String query = "DELETE FROM `accounts` WHERE ACC_ID = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            System.out.println("insert user query:" + pstm);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method will delete the teacher from teacher and account table
     * @param acc_id 
     */
    @Override
    public void deleteTeacher(int acc_id) {
        deleteUser(acc_id);
        String query = "DELETE FROM `teacher` WHERE ACC_ID = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            System.out.println("insert user query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    /**
     * This method is used for deleting a student completely
     * @param acc_id 
     */
    @Override
    public void deleteStudent(int acc_id) {
        deleteUser(acc_id);
        String query = "DELETE FROM `student` WHERE ACC_ID = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, acc_id);
            System.out.println("insert user query:" + pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void editUser(int id, User user) {

        String query = "update accounts set ACC_USERNAME=?,ACC_PASSWORD=?, ACC_ROLE=? where ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getRole());
        pstm.setInt(4, user.getId());

        pstm.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void editUser(Teacher teacher) {

        String query = "UPDATE `teacher` SET `TEAC_NAME`=?,`TEAC_ADDRESS`=?,`TEAC_EMAIL`=?,`TEAC_PHONE`=? WHERE TEAC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        
        try {
            pstm.setString(1, teacher.getUser().getFullName());
            pstm.setString(2, teacher.getUser().getAddress());
            pstm.setString(3, teacher.getUser().getEmail());
            pstm.setString(4, teacher.getUser().getPhone());
            pstm.setInt(5, teacher.getAcc_id());
            
            System.out.println("The Update query: " + pstm);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public boolean editUser(Student student) {
        String query = "UPDATE `student` SET `STUD_NAME`=?,`STUD_ADD`=?,`STUD_EMAIL`=?,`STUD_PHONE`=?, `SEM_ID`=?, `C_ID`=?, `SEC_ID`=? WHERE `STUD_ID`=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        
        try {
            pstm.setString(1, student.getUser().getFullName());
            pstm.setString(2, student.getUser().getAddress());
            pstm.setString(3, student.getUser().getEmail());
            pstm.setString(4, student.getUser().getPhone());
            pstm.setInt(5, student.getCollege().getSemester().getId());
            pstm.setInt(6, student.getCollege().getCourse().getId());
            pstm.setInt (7, student.getCollege().getSection().getId());
            pstm.setInt(8, student.getUser().getId());
            
            System.out.println("The Update query: " + pstm);
            boolean i = pstm.execute();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    @Override
    public void editUserActivity(int acc_id, String status ) {

        String query = "update user_activity set STATUS=? where USER_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, status);
        pstm.setInt(2, acc_id);
        
            System.out.println(pstm);
        pstm.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void updatePassword(int id, String password) {
        String query = "update accounts set ACC_PASSWORD=? where ACC_ID=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
        pstm.setString(1, password);
        pstm.setInt(2, id);

        pstm.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public boolean hasSimilarUser( User user ) {
        String query = "SELECT * FROM `accounts` LEFT JOIN student on accounts.ACC_ID = student.ACC_ID LEFT JOIN teacher ON accounts.ACC_ID = teacher.ACC_ID where STUD_PHONE=? OR STUD_EMAIL=?";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getPhone());
            pstm.setString(2, user.getEmail());
            ResultSet rs = pstm.executeQuery();
            System.out.println(pstm);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    @Override
     public List<Message> getStudentMessages() {
        List<Message> messages = new ArrayList<>();
        String query = "SELECT * FROM `message` left join student on message.stud_id = student.acc_id";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Message message = new Message(rs.getInt("M_ID"), rs.getString("MESSAGE_TEXT"), rs.getString("MESSAGE_DATE"), rs.getString("CATEGORY"), rs.getString("STATUS"), new Student());
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
    
    /**
     *
     * @param acc_id
     * @return
     */
    @Override
        public List<Message> getStudentMessages(int acc_id) {
        List<Message> messages = new ArrayList<>();
        String query = "SELECT * FROM `message` left join student on message.stud_id = student.acc_id where student.acc_id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setInt(1, acc_id);
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Message message = new Message(rs.getInt("M_ID"), rs.getString("MESSAGE_TEXT"), rs.getString("MESSAGE_DATE"), rs.getString("CATEGORY"), rs.getString("STATUS"), new Student());
                System.out.println("name: " + message.getDate());
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
    
    @Override
    public List<Message> getTodayMessages() {
        List<Message> messages = new ArrayList<>();
        String query = "SELECT * FROM `message` left join student on message.stud_id = student.acc_id LEFT JOIN SEMESTER on student.sem_id = semester.sem_id where DATE(`MESSAGE_DATE`) = CURDATE()";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setUser(new User(rs.getInt("STUD_ID"), rs.getString("STUD_NAME"), query, query, query));
                student.setCollege(new College(new Semester(rs.getString("SEM_NAME"))));
                Message message = new Message(rs.getInt("M_ID"), 
                        rs.getString("MESSAGE_TEXT"), 
                        rs.getString("MESSAGE_DATE"), 
                        rs.getString("CATEGORY"), 
                        rs.getString("STATUS"),
                        student
                        );
                System.out.println("Testing here");
                System.out.println("message: " + message.getDate());
                System.out.println("\n\nsemester added: " + message.getStudent().getCollege().getSemester());
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
    
    @Override
    public void insertMessage(Message message) {
        String query = "INSERT INTO `message`(`MESSAGE_TEXT`, `STUD_ID`, `CATEGORY`) VALUES(?, ?, ?)";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, message.getMessage());
            pstm.setInt(2, message.getStudent().getUser().getId());
            pstm.setString(3, message.getCategory());
            System.out.println(pstm);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public void updateMessageStatus(int m_id, String status) {
        String query = "UPDATE message set status= ? where m_id=?" ;
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, status);
            pstm.setInt(2, m_id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

 
}
