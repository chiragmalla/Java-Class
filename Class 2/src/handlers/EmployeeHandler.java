package handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.StringTokenizer;

import java.io.InputStreamReader;

import bo.*;

public class EmployeeHandler {
	EmployeeList elist=null;
	
	public EmployeeHandler()
	{
		elist=new EmployeeList();
	}
	
	public void insert(Employee e)
	{
		elist.add(e);
	}
	
	public boolean delete(int id)
	{
		boolean found=false;
		for(Employee e:elist)
		{
			if(e.getId()==id)
			{
				elist.remove(e);
				found=true;
				break;
				
			}
		}
		return found;
	}

	public Employee get(int id)
	{
		Employee Employee=null;
		for(Employee e:elist)
		{
			if(e.getId()==id)
			{
				Employee=e;
				
				break;
				
			}
		}
		return Employee;
	}
	
	public void update(int id,Employee Employee)
	{
		
		Employee e=this.get(id);
		if(e!=null)
		{
			e=Employee;
		}
	}
	public EmployeeList getAll()
	{
		return elist;
	}

	
	public void writeToFile(String filename) throws IOException
	{
		File f=new File(filename);
		
		FileWriter fWriter=new FileWriter(f);
		
		for(Employee e : getAll()){
			
			String line= e.getId() + "," + e.getName() + "\r\n";
			fWriter.write(line);
		}
		fWriter.close();
	}
	
	public void loadFromFile(String filename) throws IOException
	{
		File f=new File(filename);
		
		FileReader fReader=new FileReader(f);
		//InputStreamReader r =new 
		//fReader.re
		BufferedReader bReader=new BufferedReader(fReader);
		String line="";
		while((line=bReader.readLine())!=null )
		{
			String tokens[]=line.split(",");
			if(tokens.length==2)
			{
				Employee e=new Employee();
				e.setId(Integer.parseInt(tokens[0]));
				e.setName(tokens[1]);
				insert(e);
			}
		}
		bReader.close();
		fReader.close();
		
		
	}
	

}