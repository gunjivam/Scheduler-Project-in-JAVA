
public class Process2 extends Process {
	
	//Setters for Process2 objects
	
		//sets type of process to 2
		public void setType() {
			this.Type = 2;
		}
		
		//sets total run time for process2
		public void setTotalRunTime() {
			int RT = RNG.PRTprocess2();
			this.totalRunTime = RT;
		}
		
		//Process2 does not block so 
		//blockInstant is set to MAXINT
		public void setNextBlockInstant() {
			this.nextBlockInstant = RNG.MAXINT;
		}
				
		//Resource is set to null
		public void setNextBlockResource(int resourceNum) {
			this.nextBlockResource = null;
		}
		
		//Block Time is set to 0
		public void setTotalBlockTimeForNextBlock(int resourceNum) {
			this.totalBlockTimeForNextBlock = 0;
		}
		
		
		
		//methods to update Process2
		
		//method to generate next block
		//Process2 does not block 
		public void generateNextBlock() {}
		
		//blockRecord is null
		public void updateBlockRecord() {
			this.blockRecord = null;
			}

}
