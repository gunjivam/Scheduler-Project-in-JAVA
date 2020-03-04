
public class Process4 extends Process {

	//Setters for Process4 objects
	
		//sets type of process to 4
		public void setType() {
			this.Type = 4;
		}
		
		//sets total run time for process4
		public void setTotalRunTime() {
			int RT = RNG.PRTprocess4();
			this.totalRunTime = RT;
		}
		
		//Sets the initial block Instant for process4
		//calls helper method from RNG class
		public void setNextBlockInstant() {
			int BI = RNG.Process4BlockInterval() ;
			this.nextBlockInstant = BI;
		}
				
		//Sets nextBlockResource by determining the next resource that is going to be used by process4
		public void setNextBlockResource(int resourceNum) {
			String R = RNG.resourceProcess4(resourceNum);
			this.nextBlockResource = R;
		}
		
		//Sets the total time for the first block depending on the random resource
		public void setTotalBlockTimeForNextBlock(int resourceNum) {
			int BT = RNG.PBTprocess4(resourceNum);
			this.totalBlockTimeForNextBlock = BT;
		}
		
		
		//Methods to update process4
		
		//Method to generate next block
		public void generateNextBlock() {
			int RT = this.totalRunTime;
			int BI = this.nextBlockInstant;
			int newBI = BI;
			
			while (newBI < RT) {
				int resourceNum = RNG.RNGMax(100);
				newBI += RNG.Process4BlockInterval();
				if (newBI < RT) {
					String R = RNG.resourceProcess4(resourceNum);
					int BT = RNG.PBTprocess4(resourceNum);
					
					this.nextBlockInstant = newBI;
					this.nextBlockResource = R;
					this.totalBlockTimeForNextBlock = BT;
					this.updateBlockRecord();
					}
				
				else {
					this.totalBlockTimeForNextBlock = 0;
					this.nextBlockResource = null;
					this.nextBlockInstant = RNG.MAXINT;
					}
				}
			}
				
		//Updates the list of block list
		public void updateBlockRecord() {
			int BI = this.nextBlockInstant;
			String R = this.nextBlockResource;
			int BT = this.totalBlockTimeForNextBlock;
			
			this.blockRecord.add(new BlockList(BI, R, BT));
		}
}
