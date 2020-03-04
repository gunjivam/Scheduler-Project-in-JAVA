
public class Process3 extends Process {
	
	//Setters for Process3 objects
	
		//sets type of process to 3
		public void setType() {
			this.Type = 3;
		}
		
		//sets total run time for process3
		public void setTotalRunTime() {
			int RT = RNG.PRTprocess3();
			this.totalRunTime = RT;
		}
		
		//Sets the initial block instant for process3
		//calls helper method from RNG class
		public void setNextBlockInstant() {
			int BI = RNG.Process3BlockInterval() ;
			this.nextBlockInstant = BI;
		}
				
		//Sets nextBlockResource by determining the next resource that is going to be used by process3
		public void setNextBlockResource(int resourceNum) {
			String R = RNG.resourceProcess3(resourceNum);
			this.nextBlockResource = R;
		}
		
		//Sets the total time for the first block depending on the random resource
		public void setTotalBlockTimeForNextBlock(int resourceNum) {
			int BT = RNG.PBTprocess3(resourceNum);
			this.totalBlockTimeForNextBlock = BT;
		}
		
		
		
	//Methods to update process3
		
		//Method to generate next block
		public void generateNextBlock() {
			int RT = this.totalRunTime;
			int BI = this.nextBlockInstant;
			int newBI = BI;
			
			while (newBI < RT) {
				int resourceNum = RNG.RNGMax(100);
				newBI += RNG.Process3BlockInterval();
				if (newBI < RT) {
					String R = RNG.resourceProcess3(resourceNum);
					int BT = RNG.PBTprocess3(resourceNum);
					
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
