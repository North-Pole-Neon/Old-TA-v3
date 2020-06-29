package mainFolder.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BrowserTab_GenRead {
	
	public String tab1LINK;
	public String tab2LINK;
	public String tab3LINK;
	public String tab4LINK;
	public String tab5LINK;
	public String tab6LINK;
	public boolean tab1LINKCbx;
	public boolean tab2LINKCbx;
	public boolean tab3LINKCbx;
	public boolean tab4LINKCbx;
	public boolean tab5LINKCbx;
	public boolean tab6LINKCbx;
	
	public static void main(String[] args) {
		
	}
	
	
	
	public void browserTabWrite(String tab1, boolean tab1Ok, String tab2, boolean tab2Ok, String tab3, boolean tab3Ok, String tab4, boolean tab4Ok, String tab5, boolean tab5Ok, String tab6, boolean tab6Ok) {
		
		BrowserTabSave save1 = new BrowserTabSave(tab1, tab1Ok, tab2, tab2Ok, tab3, tab3Ok, tab4, tab4Ok, tab5, tab5Ok, tab6, tab6Ok);
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(new File("./src/mainFolder/resources/BrowserTabSave.tigaux")); //Custom Extension
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(save1);
			oos.close();
			fos.close();
		
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		
	}
	
	public void readTabSave() {
		try 
		{
			FileInputStream fis = new FileInputStream(new File("./src/mainFolder/resources/BrowserTabSave.tigaux"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			BrowserTabSave save2 = (BrowserTabSave)ois.readObject();
			ois.close();
			fis.close();
			
			System.out.println("Tabs  are: " + save2.tab1Link + "" +save2.tab1LinkCbx);
			// Thats a lot of little ^
			
			tab1LINK = save2.getTab1Link();
			tab1LINKCbx = save2.isTab1LinkCbx();
			tab2LINK = save2.getTab2Link();
			tab2LINKCbx = save2.isTab2LinkCbx();
			tab3LINK = save2.getTab3Link();
			tab3LINKCbx = save2.isTab3LinkCbx();
			tab4LINK = save2.getTab4Link();
			tab4LINKCbx = save2.isTab3LinkCbx();
			tab5LINK = save2.getTab5Link();
			tab5LINKCbx = save2.isTab3LinkCbx();
			tab6LINK = save2.getTab6Link();
			tab6LINKCbx = save2.isTab3LinkCbx();

			
			
		}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
