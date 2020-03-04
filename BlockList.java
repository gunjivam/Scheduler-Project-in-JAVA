// this class is to create block list objects for the sake of recording blocks and reporting
//These objects include the block instance, block resource, and block length 
public class BlockList {
	
	public int BI;
	public String R;
	public int BT;
	
	public BlockList(int bi, String r, int bt) {
		this.BI = bi;
		this.R = r;
		this.BT = bt;
	}
	
	public int getBI() {
		return this.BI;
	}
	
	public String getR() {
		return this.R;
	}
	
	public int getBT() {
		return this.BT;
	}

}
