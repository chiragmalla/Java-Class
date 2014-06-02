

import bo.Student;
import handlers.StudentHandler;
public class program{
	
	
public static void main(String[] args){
	
	StudentHandler shandler=new StudentHandler();
	
	shandler.insert(new Student(1,"Don"));
	shandler.insert(new Student(2,"Corleone"));
	shandler.insert(new Student(3,"Micheal"));
	
	shandler.delete(2);
	
	shandler.update(3,new Student(3,"Vito"));
	
	Student ss=shandler.get(3);
	
	System.out.printf("Id %d, Name %s\r\n",ss.getId(),ss.getName());
	
	for(Student s: shandler.getAll())
	{
		System.out.printf("Id %d, Name %s\r\n",s.getId(),s.getName());
	}
	
}
	
}