import java.io.*;
/*
 * @author Shazin Sadakath
 */
public class JavaUnicodeEncoding {
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            bw = new BufferedWriter(new FileWriter(args[1]));
            String line = null;
            while((line = br.readLine()) != null) {
                for(char c:line.toCharArray()) {
                    bw.write(String.format("\\u%04X",(int) c));
                }
                bw.flush();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            usage();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if(br != null) {
                br.close();
            }
            
            if(bw != null) {
                bw.close();
            }
        }
    }
    
    private static void usage() {
        System.out.println("java JavaUnicodeEncoding <input class filename /> <output class filename/>");
    }
}