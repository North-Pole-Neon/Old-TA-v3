package mainFolder.common;

import java.io.Serializable;

public class BrowserTabSave implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1878000447115977499L;
	public String tab1Link;
	public String tab2Link;
	public String tab3Link;
	public String tab4Link;
	public String tab5Link;
	public String tab6Link;
	public boolean tab1LinkCbx;
	public boolean tab2LinkCbx;
	public boolean tab3LinkCbx;
	public boolean tab4LinkCbx;
	public boolean tab5LinkCbx;
	public boolean tab6LinkCbx;
	
	public BrowserTabSave(String tab1Link, boolean tab1LinkCbx, String tab2Link, boolean tab2LinkCbx, String tab3Link, boolean tab3LinkCbx, String tab4Link, boolean tab4LinkCbx, String tab5Link, boolean tab5LinkCbx, String tab6Link, boolean tab6LinkCbx) {
		this.tab1Link = tab1Link;
		this.tab1LinkCbx = tab1LinkCbx;
		this.tab2Link = tab2Link;
		this.tab2LinkCbx = tab2LinkCbx;
		this.tab3Link = tab3Link;
		this.tab3LinkCbx = tab3LinkCbx;
		this.tab4Link = tab4Link;
		this.tab4LinkCbx = tab4LinkCbx;
		this.tab5Link = tab5Link;
		this.tab5LinkCbx = tab5LinkCbx;
		this.tab6Link = tab6Link;
		this.tab6LinkCbx = tab6LinkCbx;
		
		
		
	}

	public String getTab1Link() {
		return tab1Link;
	}

	public void setTab1Link(String tab1Link) {
		this.tab1Link = tab1Link;
	}

	public String getTab2Link() {
		return tab2Link;
	}

	public void setTab2Link(String tab2Link) {
		this.tab2Link = tab2Link;
	}

	public String getTab3Link() {
		return tab3Link;
	}

	public void setTab3Link(String tab3Link) {
		this.tab3Link = tab3Link;
	}

	public String getTab4Link() {
		return tab4Link;
	}

	public void setTab4Link(String tab4Link) {
		this.tab4Link = tab4Link;
	}

	public String getTab5Link() {
		return tab5Link;
	}

	public void setTab5Link(String tab5Link) {
		this.tab5Link = tab5Link;
	}

	public String getTab6Link() {
		return tab6Link;
	}

	public void setTab6Link(String tab6Link) {
		this.tab6Link = tab6Link;
	}

	public boolean isTab1LinkCbx() {
		return tab1LinkCbx;
	}

	public void setTab1LinkCbx(boolean tab1LinkCbx) {
		this.tab1LinkCbx = tab1LinkCbx;
	}

	public boolean isTab2LinkCbx() {
		return tab2LinkCbx;
	}

	public void setTab2LinkCbx(boolean tab2LinkCbx) {
		this.tab2LinkCbx = tab2LinkCbx;
	}

	public boolean isTab3LinkCbx() {
		return tab3LinkCbx;
	}

	public void setTab3LinkCbx(boolean tab3LinkCbx) {
		this.tab3LinkCbx = tab3LinkCbx;
	}

	public boolean isTab4LinkCbx() {
		return tab4LinkCbx;
	}

	public void setTab4LinkCbx(boolean tab4LinkCbx) {
		this.tab4LinkCbx = tab4LinkCbx;
	}

	public boolean isTab5LinkCbx() {
		return tab5LinkCbx;
	}

	public void setTab5LinkCbx(boolean tab5LinkCbx) {
		this.tab5LinkCbx = tab5LinkCbx;
	}

	public boolean isTab6LinkCbx() {
		return tab6LinkCbx;
	}

	public void setTab6LinkCbx(boolean tab6LinkCbx) {
		this.tab6LinkCbx = tab6LinkCbx;
	}
	
	
	
	/*public void CTabSave() {
		
	}*/
	
	
}
