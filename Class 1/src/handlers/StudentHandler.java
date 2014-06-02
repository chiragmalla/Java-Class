package handlers;

import bo.*;

public class StudentHandler {
	
	StudentList slist=null;
	
	public StudentHandler(){
		slist= new StudentList();
	}
	
	public void insert(Student s){
		slist.add(s);
	}
	
	public boolean delete(int id){
		boolean found=false;
		for(Student s:slist)
		{
			if(s.getId()==id){
				slist.remove(s);
				found=true;
				break;
			}
			
		}
		return found;
	}
	
	public Student get(int id)
	{
		Student Student=null;
		for(Student s:slist)
		{
			if(s.getId()==id)
			{
				Student=s;
				
				break;
			}
		}
		return Student;
		
	}
	
	public void update(int id, Student Student)
	{
		Student s=this.get(id);
		if(s!=null)
		{
			s=Student;
		}
	}
	
	public StudentList getAll(){
		return slist;
	}
	

}
