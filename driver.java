package begin;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


class cultural extends student{
	
	private static final long serialVersionUID = 1L;
	static Scanner sc=new Scanner(System.in);

	public static int vote_for(student ob)
	{
		
		int k=0,ab=0;
		while(true)
		{
			
			System.out.println("1. presidential voting");
			System.out.println("2. vice-presidential voting");
			System.out.println("3. general voting");
			System.out.println("4. register as a candidate");
			System.out.println("5. go back");
			try {
				ab=sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			switch(ab)
			{
				case 1: //presidential();
						break;
				case 2: //vice_presidential();
						break;
				case 3: general(ob);
						break;
				case 4: int i=register(ob);
						if(i==1)
						{
							System.out.println("successfully registered.. ");
						}
						else if(i==0)
						{
							System.out.println("you have already registered");
						}
						break;
				case 5: k=1;
						break;
				default: System.out.println("wrong choice...");		
			}
			if(k==1)
			{
				break;
			}
		}
		
		return 0;
	}
	
	
	public static void general(student ob)
	{
		int k=0;
		while(true)
		{
			System.out.println("1. vote");
			System.out.println("2. view details of regestered candidates");
			System.out.println("3. go back");
			int q=sc.nextInt();
			switch(q)
			{
				case 1: // vote()
						break;
				case 2: try 
						{
							view_details();
						}
						catch (ClassNotFoundException e)
						{
							
							e.printStackTrace();
						} 
						catch (IOException e)
						{
					
							e.printStackTrace();
						}
						break;
				case 3: k=1;
						break;
						
				default: System.out.println("wrong choice...");		
			}
			if(k==1)
			{
				break;
			}
		}
		
			
	}
	
	
	public static void view_details() throws IOException, ClassNotFoundException
	{
		student s=null;
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt");	
		if(is.available()==0)
		{
			System.out.println("no regestered candidates yet.");
			return;
		}
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (student) ois.readObject();

			System.out.print(" 	name :  "+s.name);
			
			System.out.print(" 	id :  "+s.ID);
			
			System.out.print("	batch :  "+s.batch);
			
			System.out.print("	branch :  "+s.branch);
			
			System.out.print("	description : "+s.description);
			
			System.out.print("	achievements :  "+s.achievements);
			System.out.println();	

		}
		is.close();
}

	
	public static int register(student ob)
	{
		if(ob.c_comittee==1)
		{
			return 0;
		}
		System.out.print("enter desciption : ");
		ob.description=sc.next();
		System.out.print("enter achivements :  ");
		ob.achievements=sc.next();
		ob.c_comittee=1;
		
		try 
		{	
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\c_selected.txt"),true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(ob);
			System.out.println("Done");
			oos.close();
			fos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
//			sc.close();
		}
		return 1;
	}
	
}




class student implements Serializable 
{
	
	static Scanner sc=new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	
	String name;
	int ID;
	String DOB;
	String password;
	int batch;
	String branch;
	long phone;
	String e_mail;
	String description;
	String achievements;
	int c_comittee;
	
	public student()
	{
		name=null;
		ID=0;
		DOB=null;
		password=null;
		batch=0;
		branch=null;
		phone=0;
		e_mail=null;
		description=null;
		achievements=null;
		c_comittee=0;
	}

	
	public void input()
	{
		
		System.out.print("enter name :  ");
		this.name=sc.next();
		System.out.print("enter id :  ");
		this.ID=sc.nextInt();
		System.out.print("enter dob : ");
		this.DOB=sc.next();
		System.out.print("enter batch :  ");
		this.batch=sc.nextInt();
		System.out.print("enter branch :  ");
		this.branch=sc.next();
		System.out.print("enter phone : ");
		this.phone=sc.nextLong();
		System.out.print("enter email :  ");
		this.e_mail=sc.next();
		System.out.print("enter password :  ");
		this.password=sc.next();
		
		try 
		{	
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\project\\a.txt"),true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(this);
			System.out.println("Done");
			oos.close();
			fos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
//			sc.close();
		}
		
		
	}
	
	
	public void output() throws IOException, ClassNotFoundException
	{

		student s=null;
		
		
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (student) ois.readObject();

			System.out.print(" 	name :  "+s.name);
			
			System.out.print(" 	id :  "+s.ID);
			
			System.out.print("	dob : "+s.DOB);
			
			System.out.print("	batch :  "+s.batch);
			
			System.out.print("	branch :  "+s.branch);
			
			System.out.print("	phone : "+s.phone);
			
			System.out.print("	email :  "+s.e_mail);
			System.out.println();	

		}
		is.close();
	}
	
	
}



public class driver {
	
	static Scanner sc=new Scanner(System.in);
	
	
	public static void main_menu() 
	{
		int u=0;
		while(true)
		{
			System.out.println("welcome");
			System.out.println("1. login");
			System.out.println("2. exit");
			int d=sc.nextInt();
			switch(d)
			{
				case 1: login();
						break;
						
				case 2: u=1;
						break;
				default:System.out.println("you entered wrong choice");
			}
			if(u==1)
			{
				break;
			}
		}
		
		
		
	}
	
	public static void login()
	{
		while(true)
		{
			System.out.print("enter your ID : ");
			int id=sc.nextInt();
			System.out.println();
			System.out.print("enter your password : ");
			String pass=sc.next();
			try 
			{
				int i=check(id,pass);
				if(i==2)
				{
					break;
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static int check(int id,String pass) throws IOException, ClassNotFoundException
	{
		student s=null;
		int k=0;
		FileInputStream is = new FileInputStream("C:\\Users\\Dell\\Desktop\\project\\a.txt");	
		while(is.available()>0)
		{
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (student) ois.readObject();
			if(s.ID==id && s.password.compareTo(pass)==0)
			{
				System.out.println("correct details");
				k=1;
				break;
			}
		}	
		if(k==1)
		{
			options(s);
		}
		else
		{
			System.out.println("You entered wrong ID or Password...");
			System.out.println("1. login again");
			System.out.println("2. go back");
			int input=sc.nextInt();
			switch(input)
			{
				case 1: return 1;  // login();
						
				case 2: return 2;	// main menu()
						
				default: System.out.println("wrong choice...");		
			}
		}
		return 0;
	}
	
	
	public static void options(student ob)
	{
		System.out.println("1. cultural");
		System.out.println("2. technical");
		System.out.println("3. sports");
		System.out.println("4. literature");
		int input=sc.nextInt();
		switch(input)
		{
			case 1: cultural c=new cultural();
					c.vote_for(ob);
					break;
			case 2: 
					break;
			case 3: 
					break;
			case 4: 
					break;
			default: System.out.println("wrong choice...");		
		}
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main_menu();
//		student ob=new student();
//		ob.input();
	}

}
