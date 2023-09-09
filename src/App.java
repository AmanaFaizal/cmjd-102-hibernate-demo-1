
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

import util.SessionFactoryConfiguration;
import entity.StudentEntity;
import entity.embeded.StudentName;
import repository.StudentRepository;

public class App {
    public static void main(String[] args) throws Exception {
        Session s = SessionFactoryConfiguration.getInstance().getSession();
        StudentRepository repo = new StudentRepository();
        StudentEntity  entity = new StudentEntity();
        entity.setNic("995616779V");
        StudentName studentName = new StudentName("Stu 3", "stu Last 3");
        entity.setName(studentName);
        List<String> mobiles = new ArrayList<>();
        mobiles.add("0772235367");
        mobiles.add("0715353222");
        entity.setMobiles(mobiles);

        repo.saveStudent(entity);

        
        StudentEntity studentEntity = repo.getStudent(3);
        System.out.println(studentEntity.toString());

        studentEntity.setNic("881879789V");
        studentEntity.getName().setFirstName("Updated First Name");

        repo.updateStudent(studentEntity);

        studentEntity = repo.getStudent(3);
        System.out.println(studentEntity.toString());

        repo.deleteStudent(studentEntity);
    }
}


    