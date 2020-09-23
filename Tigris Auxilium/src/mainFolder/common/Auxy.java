package mainFolder.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.j2mT.AppleScript;
import org.j2mT.MtBasic;
import org.j2mT.Term;

import mainFolder.views.PanelApps;
import mainFolder.views.panelBrowser;

public class Auxy {

	public String processAns(String question) {
		String quest = question;
		String ans = "";
		
		switch (quest) {
		
		case "open tabs":
			ans = "Opening borwser tabs";
			System.out.println("Auxy 1");
			openTabs();
			break;
		
		case "sleep":
			ans = "Going to sleep";
			System.out.println("Auxy 2");
			sleep();
			break;
		case "shutdown":
			ans = "Shuting down";
			System.out.println("Auxy 3");
			shutdown();
			break;
			
		case "hideall":
			ans = "Clearing desktop";
			System.out.println("Auxy 4");
			hideall();
			break;
			
		case "open apps":
			ans = "Opening Apps";
			System.out.println("Auxy 5");
			appCol();
			break;
			
		case "time":
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date(); 
			ans = "The time is " + formatter.format(date);
			System.out.println("Auxy 6");
			break;
			
		case "date":
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date2 = new Date();   
			ans = "The date is " + formatter2.format(date2);
			System.out.println("Auxy 7");
			break;
			
		
		
		default:
			ans = "Sorry, I don't understand that question \n check your question or check online at the documenation";
			break;
			
		}
		
		return ans;
	}
	
	//Browser ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void openTabs() {
		panelBrowser pb = new panelBrowser();
		pb.loadTabs();
		pb.goToLinks();
			
	}
	
	//Power ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void sleep() { 
		AppleScript aps = new AppleScript();
		aps.MultilineAppleScriptTest(MtBasic.sSleep);
	}
	
	void shutdown() {
		Term term = new Term();
		term.MacTerminalCommand(MtBasic.tShutdown);
	}
	
	void hideall() {
		AppleScript aps = new AppleScript();
		aps.MultilineAppleScriptTest(MtBasic.shideAll);
		
	}
	
	//Apps ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void appCol() {
		PanelApps pa = new PanelApps();
		pa.appcolDo();
	}
}
