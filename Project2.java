/* Project 2
 
*/

import java.util.Scanner;

abstract class Person{
	private String name = "";
    private String ID = "";

	public Person(String name, String iD) {
		super();
		this.name = name;
		ID = iD;
	}
	public Person() {
		super();
		this.name = null;
		ID = null;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public abstract void print();

}

abstract class Employee extends Person{

	private String dep = "";

	public Employee(String name, String iD, String dep) {
		super(name, iD);
		this.dep = dep;
	}
	public Employee() {
		super(null, null);
		this.dep = null;
	}

	public String getDep() {
        if(dep.equalsIgnoreCase("sciences")) return "Sciences";
        if(dep.equalsIgnoreCase("engineering")) return "Engineering";
        else return "Mathematics";
    }

    public void setDep(String dep) {
        this.dep = dep;
    }




}

class MyStudent extends Person{
    private double gpa = 0;
    private int chours = 0;

    public MyStudent(String name,String ID, double gpa, int chours ) {
        super(name,ID);
        this.gpa = gpa;
        this.chours = chours;
    }
    public MyStudent() {
        super(null,null);
        this.gpa = 0;
        this.chours = 0;;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getChours() {
        return chours;
    }

    public void setChours(int chours) {
        this.chours = chours;
    }

	@Override
	public void print() {
		double discount = 0, total;
		total = (getChours() * 236.45) + 52;
		if (getGpa() >= 3.85) {
			discount = total * .15;
			total -= discount;
		}
		System.out.println("\n\tHere is the tuition invoice for " + getName() + " : ");
		System.out.println(
				"\n\t---------------------------------------------------------------------------");
		System.out.printf("\t%s \t\t %s \n\tCredit Hours: %d ($236.45/credit hour)",
		getName(), getID(), getChours());
		System.out.printf(
				"\n\tFees: $52\n\n\tTotal payment(after discount): $%.2f \t($%.2f discount applied)",
				total, discount);
		System.out.println(
				"\n\t---------------------------------------------------------------------------\n");
	}
}

class MyFaculty extends Employee {
    private String rank = "";

    public MyFaculty(String name,String ID, String rank, String dep) {
        super(name,ID, dep);
        this.rank = rank;
    }
    public MyFaculty() {
        super(null,null, null);
        this.rank = null;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getRealRank(String rank) {
    	if(rank.equalsIgnoreCase("professor")) return "Professor";
        else return "Adjunct";
	}


	@Override
	public void print() {
		System.out.println(
				"\n\n---------------------------------------------------------------------------\n"
						+ getName() + "\t\t" + getID() + "\n" + getDep()
						+ " Department, " + getRealRank(getRank())
			     		+ "\n---------------------------------------------------------------------------\n\n");
	}
}

class MyStaff extends Employee {
    private String status = "";

    public MyStaff(String name, String iD, String dep, String status) {
		super(name, iD, dep);
		this.status = status;
	}
    public MyStaff() {
		super(null, null, null);
		this.status = null;
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getRealStat(String status) {
    	if(status.equalsIgnoreCase("f")) return "Full Time";
        else return "Part Time";
	}

	@Override
	public void print() {
		System.out.println("\n\n---------------------------------------------------------------------------");
		System.out.println(getName() + "\t\t" + getID());
		System.out.println(getDep() + ", " + getRealStat(getStatus()));
		System.out.println("____________________________________________________________________________\n");
	}
}
public class Project2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    	Person a[] = new Person[100];
        String input; // Used for string inputs
        int inputI;
        double inputD;
        char c;

        int choice = 0; // Used for the user choice selection menu
        Scanner s = new Scanner(System.in);

        System.out.println("\t\t\t\t\tWelcome to my Personal Management Program\n");

		do {
			System.out.println("Choose one of the options:\n");
			System.out.println("1- Enter the information of the faculty member");
			System.out.println("2- Enter the information of the student");
			System.out.println("3- Print tuition invoice");
			System.out.println("4- Print faculty information");
			System.out.println("5- Enter the information of the staff member");
			System.out.println("6- Print the information of the staff member");
			System.out.println("7- Exit Program\n");
			System.out.printf("\tEnter your selection: ");
			input = s.nextLine();
			c = input.charAt(0);
			if (!(c > '0' && c < '8' && input.length() == 1)) {
				System.out.println("\nInvalid entry-please try again\n");
				continue;
			}
			choice = Integer.parseInt(input);

			switch (choice) {
				case 1:
					String FacultyRank = " ";
					String FacultyDep = " ";
					System.out.println("\n\nEnter faculty info:");
					System.out.printf("\t\tName of the faculty: ");
					String FacultyName = s.nextLine();
					System.out.printf("\t\tID: ");
					String FacultyID = s.nextLine();
					int j = 0;
					do {
						System.out.printf("\t\tRank: ");
						input = s.nextLine();
						if (input.equalsIgnoreCase("adjunct") || input.equalsIgnoreCase("professor")) {
							j = 1;
							FacultyRank = input;
						} else
							System.out.println("\t\t\t\"" + input + "\" is invalid");
					} while (j == 0);
					int k = 0;
					do {
						System.out.printf("\t\tDepartment: ");
						input = s.nextLine();
						if (input.equalsIgnoreCase("mathematics") || input.equalsIgnoreCase("engineering")
								|| input.equalsIgnoreCase("sciences")) {
							k = 1;
							FacultyDep = input;
						} else
							System.out.println("\t\t\t\"" + input + "\" is invalid");
					} while (k == 0);
					System.out.println("\n\nFaculty added!\n\n");

					for (int d = 0; d < 100; d++) {
						if (a[d] == null) {
							a[d] = new MyFaculty(FacultyName, FacultyID, FacultyRank, FacultyDep);
							break;
						}
					}
					break;
				case 2:
					System.out.println("\nEnter Student info\n");
					System.out.print("\t\tName of Student: ");
					input = s.nextLine();
					String StudentName = input;
					System.out.print("\t\tID: ");
					input = s.nextLine();
					String StudentID = input;
					System.out.print("\t\tGpa: ");
					inputD = s.nextDouble();
					s.nextLine();
					double StudentGPA = inputD;
					System.out.print("\t\tCredit Hours: ");
					inputI = s.nextInt();
					s.nextLine();
					int StudentHours = inputI;
					System.out.println("Student Added!");

					System.out.println("\n");
					for (int d = 0; d < 100; d++) {
						if(a[d] == null) {
							a[d] = new MyStudent(StudentName, StudentID, StudentGPA, StudentHours);
							break;
						}
					}
					break;
				case 3:
					int check = 0;
					System.out.print("\tEnter the student�s id: ");
					input = s.nextLine();
					for (int d = 0; d < 100; d++) {
						if (a[d] != null) {
							if (input.equals(a[d].getID())) {
								MyStudent p = new MyStudent(a[d].getName(), a[d].getID(), ((MyStudent) a[d]).getGpa(),
										((MyStudent) a[d]).getChours());
								p.print();
								check++;
								break;
							}
						}
					}
					if (check == 0) {
						System.out.println("\tNo student matched!\n\n");
					}
					break;
				case 4:
					int check1 = 0;
					System.out.print("\tEnter the faculty's id: ");
					input = s.nextLine();
					for (int d = 0; d < 100; d++) {
						if (a[d] != null) {
							if (input.equals(a[d].getID())) {
								MyFaculty p = new MyFaculty(a[d].getName(), a[d].getID(), ((MyFaculty) a[d]).getRank(),((Employee) a[d]).getDep());
								p.print();
								check1++;
							}
						}
					}
					if (check1 == 0) {
						System.out.println("\tNo faculty member matched!\n\n");
					}
					break;
				case 5:
					String StaffStat = " ";
					String StaffDep = " ";
					System.out.print("\n\nName of the staff member: ");
					String StaffName = s.nextLine();
					System.out.print("Enter the id: ");
					String StaffID = s.nextLine();
					do {
						System.out.print("Department: ");
						String dep = s.nextLine();
						dep = dep.toLowerCase();
						if (!(dep.equals("mathematics") || dep.equals("engineering") || dep.equals("sciences"))) {
							System.out.println("Invalid entery");
							continue;
						}
						StaffDep = dep;

						break;
					} while (true);
					do {
						System.out.print("Status, Enter P for Part Time or Enter F for Full Time: ");
						String stat = s.nextLine();
						stat.toLowerCase();
						if (!(stat.equalsIgnoreCase("f") || stat.equalsIgnoreCase("p"))) {
							System.out.println("Invalid entery");
							continue;
						}
						StaffStat = stat;
						break;
					} while (true);
					System.out.println("\nStaff member added!\n\n");
					for (int d = 0; d < 100; d++) {
						if (a[d] == null) {
							a[d] = new MyStaff(StaffName, StaffID, StaffDep, StaffStat);
							break;
						}
					}
					break;

				case 6:
					int check2 = 0;
					System.out.print("\tEnter the staff's id: ");
					input = s.nextLine();
					for (int d = 0; d < 100; d++) {
						if (a[d] != null) {
							if (input.equals(a[d].getID())) {
								MyStaff p = new MyStaff(a[d].getName(), a[d].getID(), ((Employee) a[d]).getDep(),
										((MyStaff) a[d]).getStatus());
								p.print();
								check2++;
							}
						}
					}
					if (check2 == 0) {
						System.out.println("\tNo staff member matched!\n\n");
					}
					break;

				case 7:
					System.out.println("\n\nGoodbye!");
					break;
				}
		} while (choice != 7);
        s.close();
    }
}
