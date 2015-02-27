import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class ColbertTryParser {

	public static void main(String[] args) throws IOException {
		readInText();
	}

	public static void readInText() throws IOException {
		Scanner scan = null;
		try {
			File inputFile = new File("allout.txt");
			File tempFile = new File("myTempFile.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			File f = new File("log12.txt");
			PrintStream output = new PrintStream(f);
			String currentLine;

			while((currentLine = reader.readLine()) != null) {

			    if(!(currentLine.contains("event_id"))) continue;

			    writer.write(currentLine);
			}

			writer.close();
			boolean successful = tempFile.renameTo(inputFile);
			scan = new Scanner(new BufferedReader(new FileReader("allout.txt")));
			firstParserMethod(scan,output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void firstParserMethod(Scanner scan,PrintStream output) {
		String line= null;
		int endOfLine =0;
		//line=scan.nextLine();
		//output.println(line);
		while(scan.hasNext()) {
			line = scan.nextLine();
			int number1 = 0;
    		int number2 = line.indexOf("/bundle");
    		//String line2 = line;
    		while(number1<line.length()-20) {
    			number2 = line.indexOf("/bundle");
    			//System.out.printf("1= %d 2= %d\n",number1,number2);
    			//System.out.println(number2);
    			String smallerLine = line.substring(0,number2+1);
    			output.println(smallerLine+"\n");
    			number1 = number2;
    			//System.out.printf("1= %d 2= %d  line.length()= %d\n",number1,number2, line.length());
    			line = line.substring(number2+23,line.length());
    			//System.out.printf("1= %d 2= %d  line.length()= %d\n",number1,number2, line.length());
    			//System.
    		}
			
			/**	line=scan.nextLine();
			endOfLine = line.indexOf("bundles");
			System.out.println(endOfLine);
			line=line.substring(endOfLine+9,line.length());
			output.println(line);**/
		}
		//System.out.println(endOfLine);
	}
}
/**
 * Date dNow = new Date();
SimpleDateFormat ft = 
new SimpleDateFormat ("yyyy-MM-dd");
System.out.println(ft.format(dNow));
@SuppressWarnings("deprecation")
Date when = new Date(115,0,23);
//when = 
System.out.println(dNow.before(when));
System.out.println(ft.format(when));
 */