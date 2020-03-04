
public class Process1 extends Process{
	
	//Setters for Process1 objects
	
	//sets type of process to 1
	public void setType() {
		this.Type = 1;
	}
	
	//sets total run time for process1
	public void setTotalRunTime() {
		int RT = RNG.PRTprocess1();
		this.totalRunTime = RT;
	}
	
	//Sets the nextBlockInstant for process1
	//Depends on the run time for that process
	//if there is no block, Blocking instant will be set to MAXINT
	//calls helper method from RNG class
	public void setNextBlockInstant() {
		int BI;
		int RT = this.totalRunTime;
		if (RNG.willProcess1Block()) {
			BI = RNG.Process1BlockOccurAt(RT);
		}
		else {
			BI = RNG.MAXINT;
		}
		this.nextBlockInstant = BI;
	}
			
	//Sets nextBlockResource by determining the next resource that is going to be used by process1
	//if there is not block, next block resource is set to null
	public void setNextBlockResource(int resourceNum) {
		String R;
		int BI = this.nextBlockInstant;
		if (BI == 0 || BI == RNG.MAXINT) {
			R = null;
		}
		else{
			R = RNG.resourceProcess1(resourceNum);
		}
		this.nextBlockResource = R;
	}
	
	//Sets the total time for the first block depending on the random resource
	//if there is not block, block time is set to 0
	public void setTotalBlockTimeForNextBlock(int resourceNum) {
		int BT;
		int BI = this.nextBlockInstant;
		if (BI == 0 || BI == RNG.MAXINT) {
			BT = 0;
		}
		else{
			BT = RNG.PBTprocess1(resourceNum);
		}
		this.totalBlockTimeForNextBlock = BT;
	}
	
	
	
	//methods to update Process1
	
	//method to generate next block
	//Process1 does not block again 
	public void generateNextBlock() {
			this.totalBlockTimeForNextBlock = 0;
			this.nextBlockResource = null;
			this.nextBlockInstant = RNG.MAXINT;
	}
	
	//updates the list of block list
		public void updateBlockRecord() {
			int BT = this.totalBlockTimeForNextBlock;
			if (BT>0) {
				int BI = this.nextBlockInstant;
				String R = this.nextBlockResource;
				
				this.blockRecord.add(new BlockList(BI, R, BT));
				}
			else {
				this.blockRecord = null;
			}
			}
	

}
