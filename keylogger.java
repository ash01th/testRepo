import java.io.*;

public class Keylogger {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"));
      String line;
      while ((line = br.readLine()) != null) {
         bw.write(line);
         bw.newLine();
         bw.flush();
      }
   }
}
