package C15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.imageio.IIOException;

public class DailyAdviceClient {
	
	public void go() {
		
		try {
			Socket s = new Socket("127.0.0.1", 4242);
			
			InputStreamReader sr = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(sr);
			
			String advice = reader.readLine();
			System.out.println("Today you should: " + advice);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyAdviceClient d = new DailyAdviceClient();
		d.go();
	}

}
