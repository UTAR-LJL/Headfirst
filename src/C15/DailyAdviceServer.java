package C15;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
	
	String[] adviceLlist =  {"Take smaller bites",
			"Go for the tight jeans. No they do NOT make you look fat.",
			"One word: inappropriate", "Just for today, be honest. Tell your boss what "
					+ "you *really* think", "You might want to rethink that haircut."};
	
	public void go() {
		
		try {
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true) {
				
				Socket s = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(s.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	private String getAdvice() {
		int random = (int) (Math.random() * adviceLlist.length);
		return adviceLlist[random];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyAdviceServer d = new DailyAdviceServer();
		d.go();
	}

}
