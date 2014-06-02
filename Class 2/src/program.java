
import java.io.IOException;

import bo.Employee;
import handlers.EmployeeHandler;




public class program {
	
public static void main(String[] args) {
		
		EmployeeHandler ehandler=new EmployeeHandler();
		
		try{
			ehandler.loadFromFile("c:/employeelist.txt");
		}catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
			
		}
		//System.out.println(ehandler.getAll());

		ehandler.insert(new Employee(1, "Dixanta"));
		ehandler.insert(new Employee(2,"Chirag"));
		ehandler.insert(new Employee(3,"Chirayu"));
		
		//ehandler.delete(2);
		
		ehandler.update(3,new Employee(3,"test"));
		Employee ee=ehandler.get(3);
		
		
		System.out.printf("Id: %d, Name:%s\r\n",ee.getId(),ee.getName());
		
		
		for(Employee e : ehandler.getAll())
		{
			System.out.printf("Id: %d, Name:%s\r\n",e.getId(),e.getName());
			
		}
		
		try{
		ehandler.writeToFile("c:/employeelist.txt");
		}catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		

	}

}



