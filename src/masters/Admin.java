package masters;

public class Admin {
	
private static Course CourseList[]= {new Course(1101,"Java",30,25000),
									new Course(1102,"Dot Net",30,30000),
									new Course(1103,"Pega",45,50000)};	

private static Session SessionList[]= {new Session(211,1101,"9-10am","10/02/2019","09/03/2019"),
									new Session(212,1102,"9.30-10.30am","15/02/2019","20/03/2019")};

private static Participant pList[]=new Participant[50];
static int count=0;

static{
	Admin.registerParticipant(new Participant(91201,"Dhanus","992634567",1101,15000));
	Admin.registerParticipant(new Participant(91202,"Sitar","9894758549",1103,6000));
	Admin.registerParticipant(new Participant(91203,"Tumba","9968795999",1101,10000));
	Admin.registerParticipant(new Participant(91204,"Chiiky","785555767",1102,25000));
	
}
//Method that display course list
public static void getCoursesDetails()
{
	for (int i = 0; i < CourseList.length; i++) {
		System.out.println("Course ID: "+CourseList[i].getCousreId());
		System.out.println("Course :"+CourseList[i].getName());
		System.out.println("Duration in days: "+CourseList[i].getDuration_in_days());
		System.out.println("Course Fee: "+CourseList[i].getFee());
		System.out.println("----------------------------");
	}
}

//Method that search for course with given courseId and display details
public static void getCoursesDetails(int courseId) {
	boolean flag=false;
	for (int i = 0; i < CourseList.length; i++) {
		if(CourseList[i].getCousreId()==courseId) {
		System.out.println("---------------------------");
		System.out.println("Course ID: "+CourseList[i].getCousreId());
		System.out.println("Course :"+CourseList[i].getName());
		System.out.println("Duration in days: "+CourseList[i].getDuration_in_days());
		System.out.println("Course Fee: "+CourseList[i].getFee());
		System.out.println("---------------------------");
		flag=true;
		break;
		}
	}
	if (!flag)
		System.out.println("No course with given ID....");
}

//Method that display all sessions details
public static void getSessionList()
{
	for (int i = 0; i < SessionList.length; i++) {
		System.out.println("Session ID: "+SessionList[i].getSessionId());
		System.out.println("Course ID:"+SessionList[i].getCourseId());
		
		System.out.println("Course :"+(getCourse(SessionList[i].getCourseId())).getName());
		
		System.out.println("Session Time : "+SessionList[i].getTime());
		System.out.println("Start Date: "+SessionList[i].getStart_date());
		System.out.println("Start Date: "+SessionList[i].getEnd_date());
		System.out.println("----------------------------------");
	}
}

//Method that register a new participant
public static void registerParticipant(Participant p)
{
	try {
	pList[count]=p;
	count++;
	System.out.println("Participant record saved....");
	}
	catch(Exception e) {
		System.out.println("Error! Participant record not saved...");
	}
}

//Method that displays all participants
//public static void getParticipantDetails() {
//	System.out.println("Particpant ID>>Name>>Phone>>Course>>Session>>Fee Paid>>Balance Fee");
//	for (int i = 0; i < count; i++) {
//		System.out.println(pList[i].getId()+">>"+pList[i].getName()+">>"+pList[i].getPhone()+">>"+pList[i].getCourseId()+">>"+pList[i].getSessionId()+">>"+pList[i].getFeePaid()+">>"+(((getCourse(pList[i].getCourseId())).getFee())-(pList[i].getFeePaid())));
//	}
//	System.out.println("----------------------------");
//}
public static Participant[] getParticipantDetails() {
	return pList;
}



//Method that display participant with course and session details
public static void getParticipantDetails(int id) {
	int flag=0;
	for (int i = 0; i < count; i++) {
		if(pList[i].getId()==id) {
			System.out.println("-----------------------------------------------------");
			//Personal details
			System.out.println("Name: "+pList[i].getName());
			System.out.println("Phone: "+pList[i].getPhone());
			
			//course details
			System.out.println("course ID: "+pList[i].getCourseId());
			System.out.println("course Name: "+(getCourse(pList[i].getCourseId())).getName());
			System.out.println("Duration in days: "+(getCourse(pList[i].getCourseId())).getDuration_in_days());
			
			//session details
			System.out.println("Session ID: "+pList[i].getSessionId());
			if(pList[i].getSessionId()!=0)
				System.out.println("Session Timings: "+(getSession(pList[i].getSessionId())).getTime());
			else
				System.out.println("Session Timings: "+"Session Not alloted");
			
			//Fee details
			System.out.println("Course Fee: "+(getCourse(pList[i].getCourseId())).getFee());
			System.out.println("Fee Paid: "+pList[i].getFeePaid());
			System.out.println("Balance: "+(((getCourse(pList[i].getCourseId())).getFee())-(pList[i].getFeePaid())));
			System.out.println("----------------------------------------------------------");
			flag=1;
			break;
			}
		}
		if (flag==0)
			System.out.println("No Participant with given ID....");
}

//Method for session allotment
public static void allotSession(int pid, int sessionId) {
	int flag=0;
	p: for (int i = 0; i < count; i++) {
		if(pList[i].getId()==pid) {
			for(int j=0;j<SessionList.length;j++)
			{
				if(SessionList[j].getSessionId()==sessionId)
				{
					pList[i].setSessionId(sessionId);
					flag=1;
					System.out.println("session alloatment successful...");
					break p;
				}
			}
		}
		
	}
	if (flag==0)
		System.out.println("No Participant/Session with given ID....");
	
}

//Private Method that returns course
private static Course getCourse(int courseId) {
	for (int i = 0; i < CourseList.length; i++) {
		if(CourseList[i].getCousreId()==courseId) {
			return CourseList[i];
			}
	}
	return null;
}

//Private Method that returns session
private static Session getSession(int sessionId) {
	for (int i = 0; i < SessionList.length; i++) {
		if(SessionList[i].getSessionId()==sessionId) {
			return SessionList[i];
			}
	}
	return null;
}

}
