import java.util.Scanner;
import java.time.LocalDate;

//abstract class for exception handling
abstract class Exceptio
{
	abstract void except();
}

enum Specialists
{
	//List of doctors with speacialization and consultancy fee.
	s1("G.Pavan Raj  ",500, "Allergist      "),
    s2("Pavan Kumar  ",2000,"Cardiologist   "),
    s3("Shankar Reddy",300, "Dentist        "),
    s4("Surya pavan  ",500, "Dermatologist  "),
    s5("Sumanth      ",800, "Endocrinologist"),
    s6("Yaswanth     ",500, "Hematologist   "),
    s7("Ashok        ",300, "Immunologist   "),
    s8("Kiran kumar  ",1000,"Nephrologist   "),
    s9("Vishnu       ",2000,"Neurologist    "),
    s10("Sanjay      ",1000,"Gynecologist   "),
    s11("Varnik      ",500, "Ophthamologist "),
    s12("Nishanth    ",1000,"Surgeon        "),
    s13("Prudhvi     ",500, "Veterinarian   ");

	private final String s_name;
    private final int s_fee;
    private final String s_special;
    Specialists(String a, int b, String c)
    {
        s_name = a;
        s_fee = b;
        s_special = c;
    }

    public String Spl_name()
    {
        return s_name;
    }

    public int Spl_fee()
    {
        return s_fee;
    }

    public String Spl_special()
    {
        return s_special;
    }

}

//inheritance for printing doctors who are available.
class Doctors_avail
{
	void avail_human()
	{
		System.out.println("*****************************************************************************************");
        System.out.println("Doctors -------------> Consultation fee --------------> Specialization\n");
        for(Specialists S:Specialists.values())
        {
            System.out.println((S.ordinal()+1)+" : "+S.Spl_name()+" -------------> "+S.Spl_special()+" --------------> "+S.Spl_fee());
        }
        System.out.println("*****************************************************************************************");
	}
	void avail_pet()
	{
		System.out.println("************************************************************************");
		System.out.println("Doctors -------------> Consultation fee --------------> Specialization\n");
		System.out.println("Prudhvi -------------> 500              --------------> Veterinarian");
		System.out.println("************************************************************************");
	}
}

class Uni_Hospital extends Doctors_avail
{

	LocalDate l_date;
	int p_age;
	String p_name;
	long p_contactno;
	int fee;
    String name;
    String special;
	static int p_id;
	Uni_Hospital()
	{}

	Uni_Hospital(String a, int b, long c, LocalDate ld)
	{
		p_name = a;
		p_age = b;
		p_contactno = c;
		l_date = ld;
	}

	//for creating default patient id.
	static void Patient_id()
	{
		p_id++;
		System.out.println("\n\nAppointment Number : "+p_id);
		System.out.println("------------------------------");
	}

	//for showing appointment slip
	void Appointment_slip(Uni_Hospital p[], int no)
	{
		System.out.println("Name is "+p[no].p_name);
		System.out.println("Age is "+p[no].p_age);
		System.out.println("Contact number is "+p[no].p_contactno);
		System.out.println("Consultation Date : "+p[no].l_date);
		System.out.println("Docter is "+p[no].name);
		System.out.println("Specialsation : "+p[no].special);
		System.out.println("Consultation fee is "+p[no].fee);
		
	}

    public void put_Splname(String a) 
    {
        name = a;
    }

    public void put_Splfee(int b) 
    {
        fee = b;
    }

    public void put_Splspecial(String c) 
    {
        special = c;	
    }

    //for storing patient details in array of object
    static Uni_Hospital j1[] = new Uni_Hospital[1000];

    //main function 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int d,y,m;
		System.out.println("\n\n***************WELCOME TO THE UNI HOSPITAL*****************\n\n");
		do
		{
			//choices for user
			System.out.println("\n\nEnter 1 for adding new patients");
			System.out.println("Enter 2 for seeing doctors availability");
			System.out.println("Enter 3 for searching patient details");
			System.out.println("Enter 4 for seeing list of all patients");
			System.out.println("Enter any key(except above four) for exiting\n\n");
			System.out.print("Enter Your Choice Please : ");

			//exception handling incase any exception occurs.
			try
			{
				choice = sc.nextInt();
			
			switch(choice)
			{
				//For adding new patients
				case 1:
					int num;
					System.out.print("\nEnter the number of patients admitting : ");
					num = sc.nextInt();
					Uni_Hospital p[] = new Uni_Hospital[num];

					for(int i=0; i<num; i++)
					{

						int check;
						System.out.println("\n**********************");
						System.out.println("Enter 1 for Humans");
						System.out.println("Enter 2 for Pets");
						System.out.println("**********************");
						check = sc.nextInt();
						//for humans
						if(check == 1)
						{
							System.out.println("\n\nEnter name of the patient : ");
							String a = sc.next();
							System.out.println("Enter age : ");
							int b = sc.nextInt();
							System.out.println("Enter mobile number : ");
							long c = sc.nextInt();
							System.out.println("Appointment Day (DD) :");
							d = sc.nextInt();
							System.out.println("Appointment Month (MM) :");
							m = sc.nextInt();
							System.out.println("Appointment Year (YY) :");
							y = sc.nextInt();
							LocalDate ld = LocalDate.of(y,m,d);
							p[i] = new Uni_Hospital(a,b,c,ld);
							//accessing parent data
							Doctors_avail D = new Doctors_avail();
                			D.avail_human();
                    		System.out.println("Enter the id : ");
                    		int choice1=sc.nextInt();

                    		//switch for accessing different different doctors
                    		switch (choice1)
                    		{
                       			case 1:
                        		{	
                        	    	Specialists d1 = Specialists.valueOf("s1");
                        	    	p[i].put_Splname(d1.Spl_name());
                        	    	p[i].put_Splfee(d1.Spl_fee());
                        	    	p[i].put_Splspecial(d1.Spl_special());
	                            	break;
                        		}
                        		case 2:
                        		{
                        		    Specialists d1 = Specialists.valueOf("s2");
                        	    	p[i].put_Splname(d1.Spl_name());
                        	    	p[i].put_Splfee(d1.Spl_fee());
                        	    	p[i].put_Splspecial(d1.Spl_special());
                        	    	break;
                        		}
                        		case 3:
                        		{
                        		    Specialists d1 = Specialists.valueOf("s3");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
	                       		}
                        		case 4:
                        		{
                        		   Specialists d1 = Specialists.valueOf("s4");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 5:
                        		{
                        		    Specialists d1 = Specialists.valueOf("s5");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
	                        	case 6:
                        		{
                        		   Specialists d1 = Specialists.valueOf("s6");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 7:
                        		{
                        		   Specialists d1 = Specialists.valueOf("s7");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 8:
	                        	{
                        		   Specialists d1 = Specialists.valueOf("s8");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 9:
                        		{
                        		   Specialists d1 = Specialists.valueOf("s9");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 10:
                        		{
	                        	   Specialists d1 = Specialists.valueOf("s10");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 11:
                        		{
                        		   Specialists d1 = Specialists.valueOf("s11");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 12:
                        		{
                        		   Specialists d1 = Specialists.valueOf("s12");
                        		    p[i].put_Splname(d1.Spl_name());
                        		    p[i].put_Splfee(d1.Spl_fee());
                        		    p[i].put_Splspecial(d1.Spl_special());
                        		    break;
                        		}
                        		case 13:
                        		{
                        			System.out.println("Appointment canceled !");
                        			System.out.println("Not available for Human");
                        			break;
	
                        		}
                        		default:
                        		{
                        			System.out.println("Appointment canceled !");
                        			System.out.println("Not available");
                        		}
                   			}
                    	}
                    	//for pets
						else if(check == 2)
						{
							System.out.println("\n\nEnter name of the pet : ");
							String a = sc.next();
							System.out.println("Enter age : ");
							int b = sc.nextInt();
							System.out.println("Enter mobile number of owner : ");
							long c = sc.nextInt();
							System.out.println("Appointment Day (DD) :");
							d = sc.nextInt();
							System.out.println("Appointment Month (MM) :");
							m = sc.nextInt();
							System.out.println("Appointment Year (YY) :");
							y = sc.nextInt();
							//accessing parent data
							Doctors_avail D = new Doctors_avail();
                			D.avail_pet();
							System.out.println("You want to consult this doctor(Enter 1 for yes otherwise no) : ");
							LocalDate ld = LocalDate.of(y,m,d);
							int ch = sc.nextInt();
							p[i] = new Uni_Hospital(a,b,c,ld);
							if(ch == 1)
							{
								Specialists d1 = Specialists.valueOf("s13");
                        		p[i].put_Splname(d1.Spl_name());
                        		p[i].put_Splfee(d1.Spl_fee());
                        		p[i].put_Splspecial(d1.Spl_special());
							}
							else
							{

								System.out.println("Appointment canceled !");
								System.out.println("Ok, Thank You!");
							}
						}
					}
					//for printing the appointment slip
					for (int i=0; i<num; i++)
					{
						if(p[i].name == null)
						{
							continue;
						}
						else
						{
							Patient_id();//function call for creating default patient id
							p[i].Appointment_slip(p,i);
							j1[p_id] = p[i];
						}
						
					}
					break;
				//For Seeing doctors availability
				case 2:
                	Doctors_avail D = new Doctors_avail();
                	D.avail_human();
                    break;


				//For Searching details of patient
				case 3:
					//inner class for searching patient with appointment number.
					class Search_patient
					{
						void search()
						{
							Uni_Hospital p1 = new Uni_Hospital();
                 		   	System.out.println("Enter appointment number : ");
                    		int apno = sc.nextInt();
                    		if(j1[apno] == null)
                    		{
                    			System.out.println("No patient is available!");
                    		}
                    		else
                    		{
                    			p1.Appointment_slip(j1,apno);
                    		}
                    
						}
					}
                	Search_patient Sp = new Search_patient();
                	Sp.search(); 
                    break;

                //For Seeing list of patients.
                case 4:
                	//inner class for seeing all the details of the appointment taken patient
                	class AllPatients
                	{
                		void patient()
                		{	
                			int c = 1;
                			if(j1[c]==null)
                    		{
                        		System.out.print("No patient is available!");
                    		}
                    		else
                    		{
                    			System.out.println("Patient name -------------> Age --------------> Date of Consultation\n");
                        		for(c=1;c<=p_id;c++)
                        		{
                            		System.out.println(j1[c].p_name+" --------> "+j1[c].p_age+" ---------> "+j1[c].l_date);
                        		}
                   		 	}
                		}
                	}
                	AllPatients Ap = new AllPatients();
                	Ap.patient();
                    break;

                default:
                	System.out.println("Thank You!");
            	
			}
			}
			catch(Exception e)
			{
				//abstact class for any exception arise.
				Exceptio Ex = new Exceptio()
				{
					void except()
					{
						System.out.println("Exception occur beacause of "+e);
						System.out.println("Please don't do this, run the program again!");
					}
				};
				Ex.except();
				choice = 10;
			}

		}while(choice < 5 && choice > 0);
	}
}
