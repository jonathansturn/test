import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class ColbertTryParser2 {

	public static void main(String[] args) {
		readInText();
	}

	public static void readInText() {
		Scanner scan = null;
		try {
			File f = new File("log12.txt");
			scan = new Scanner(new BufferedReader(new FileReader(f)));
			//File f = new File("log14.txt");
			//PrintStream output = new PrintStream(f);
			File g = new File("log15.txt");
			PrintStream output2 = new PrintStream(g);
			File h = new File("vip2.txt");
			PrintStream output = new PrintStream(h);
			firstParserMethod(scan,output2,output,f);//,output2,output4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void firstParserMethod(Scanner scan, PrintStream output2,PrintStream output, File f) throws FileNotFoundException {//, PrintStream output2, PrintStream output4) {
		String line=null;
		String eventid=null;
		int number1 = 0;
		String date = null;
		int count=0;
		int eventid2=0;
		//String[][] test = new String[count][2];
		while(scan.hasNext()) {
			line=scan.nextLine();
			//for(int i=0;i<1;i++) {
				
			//date = line.substring(line.indexOf("start"),line.indexOf("start")+10);
			//}
			if(line.startsWith("event_id")) {
				//output.println(line);
				eventid=line.substring(11, 18);
				//output2.println(eventid);
				number1=line.indexOf("event_start",15);
				//output2.println(number1);
				date=line.substring(number1+19,number1+24);
				if(!(dealWithDateMethod(date))) {
					output2.print("https://www.showclix.com/event/"+eventid);
					//output2.print(" "+date);
					if(line.contains("VIP")) {
						output.print("https://www.showclix.com/event/"+eventid);
						output.print(" "+date);
						output.println(" VIP");
					}
					else output2.println(" "+date+" Normal");
						//output2.println(" No");
					//output2.println(line);
					//System.out.println(date);
					count++;
				}
				System.out.println(count);
				//System.out.println(date); 
				
				//if(line.contains("VIP")) {
				// DO SOMETHING!!!!!!!!!!!!!!!!!!!!
				//}
			}
			
			//date=line.substring(number1,number1+30);
			//output.println(date);
		}
		System.out.println(eventid);
		//Date nextDay = new Date(date.getTime() + (1000 * 60 * 60 * 24));
		int eventid4=Integer.parseInt(eventid);
		Date dNow = new Date();
		//eventid4++;
		for(int i=Integer.parseInt(eventid); i<Integer.parseInt(eventid)+4; i++) {
			String j = String.valueOf(i);
			System.out.println(j);
			vipMethod(scan,j,f,output,dNow);
		}
		//String j = String.valueOf(eventid4);
		//System.out.println(j);
		//scan.close();
				//if(f.contains(j))
		//	output.println("https://www.showclix.com/event/"+(eventid4+1)+" "+(dNow.getMonth()+1)+"-"+dNow.getDate()+" "+" VIP");
		//if(f.contains(((String) (eventid4+2))))
		//	output.println("https://www.showclix.com/event/"+(eventid4+2)+" "+(dNow.getMonth()+1)+"-"+dNow.getDate()+1+" "+" VIP");
		//if(f.contains(((String) (eventid4+3))))
		//	output.println("https://www.showclix.com/event/"+(eventid4+3)+" "+(dNow.getMonth()+1)+"-"+dNow.getDate()+2+" "+" VIP");
		//output2.println("https://www.showclix.com/event/"+(eventid4+2)+" "+dNow+" VIP");
		//output2.println("https://www.showclix.com/event/3925063");
	}

	private static boolean dealWithDateMethod(String date) {
		int month = Integer.parseInt(date.substring(0,2));
		int day = Integer.parseInt(date.substring(3,5));
		Date dNow = new Date();
		Date eventDate = new Date(115,month-1,day);
		//System.out.println(month+"-"+day);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dNow);
		int monthNow = 1+cal.get(Calendar.MONTH);
		int dayNow = cal.get(Calendar.DAY_OF_MONTH);
		//System.out.println(" "+eventDate.before(dNow));
		if(dayNow==day && month==monthNow)
			return false;
		//System.out.println(" "+month2);
		//if(eventDate.getMonth())
		//System.out.println(eventDate.before(dNow));
		return eventDate.before(dNow);
			
	}
	
	public static void vipMethod(Scanner scan,String j,File f,PrintStream output,Date dNow) throws FileNotFoundException {
		scan = new Scanner(new BufferedReader(new FileReader(f)));
		String line=null;
		System.out.println("1");
		while(scan.hasNext()) {
			line=scan.nextLine();
			if(line.contains(j)) {
				int n = Integer.parseInt(j)+1;
				output.println("https://www.showclix.com/event/"+n+" "+(dNow.getMonth()+1)+"-"+(dNow.getDate())+1+" "+" VIP");
			}
		}
	}

}
