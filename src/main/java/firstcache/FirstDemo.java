package firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tute.Student;

public class FirstDemo {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Session s=factory.openSession();
	//by default enable
	Student student=s.get(Student.class, 2347);
	System.out.println(student);
	
	Student  student2=s.get(Student. class,2347);
	System.out.println(student2);
	 	s.close();
	
}
}
