/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Model.Message;
import Model.Student;
import Model.Subject;
import Model.Teacher;
import Model.User;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface UserInterface {
    public User getUser(String username, String password);
    public User getUser(String username);
    public List<Teacher> getTeacherList();
    public User getUserRow(int id);
    public List<User> getActiveUserList();
    public List<Subject> getSubjectList();
    public Teacher getTeacherRow(int id);
    public Teacher getTeacherRow(String name);
    public Student getStudentRow(int id);
    public Student getStudentRowByAccID(int id);
    public List<Student> getStudentList();
    public List<Student> getStudentList(int teac_id);
    public void insertUser(User user);
    public void insertUser(Teacher teacher);
    public void insertUser(Student student);
    public void insertUserActivity(int acc_id);
    public void deleteUser(int acc_id) ;
    public void deleteTeacher(int acc_id) ;
    public void deleteStudent(int acc_id);
    public void editUser(int id, User user);
    public void editUser(Teacher teacher);
    public boolean editUser(Student student);
    public void editUserActivity(int acc_id, String status ) ;
    public void updatePassword(int id, String password);
    public boolean hasSimilarUser( User user );
    public List<Message> getStudentMessages();
    public List<Message> getStudentMessages(int acc_id);
    public List<Message> getTodayMessages();
    public void insertMessage(Message message);
    public void updateMessageStatus(int m_id, String status);
}
