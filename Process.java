import java.util.*;

public abstract class Process {
	//data members of process
		public String StringID;
		public int Type;
		public int totalRunTime;
		public int nextBlockInstant;
		public String nextBlockResource;
		public int totalBlockTimeForNextBlock;
		public int CPUTime;
		public int blockedTime;
		public int readyTime;
		public int lastEventTime;
		public int finishTime;
		public int blockServiceTime;
		public int serviceStartTime;
		public List<BlockList> blockRecord;
		
	//methods for processes
		//Setters for process objects
		
		//Sets the StringID
		//If string id is over max limit set to "-1"
		//i keeps track of current processID index and iMax is the maximum amount of process IDs available
		public void setStringID(int i, int iMax) {
			String id;
			if (i<10) {
				id = String.format("P00%d", i);
			}
			else if (i < 100) {
				id = String.format("P0%d", i);
			}
			else if (i <= iMax){
				id = String.format("P%d", i);
			}
			else {
				id = "-1";
			}
			this.StringID = id;
			}
		
		//Sets type of process
		public abstract void setType();
		
		//Sets the total run time for a process
		public abstract void setTotalRunTime();
		
		//Sets the nextBlockInstant
		//Depends on the run time for that process
		public abstract void setNextBlockInstant();
				
		//Sets nextBlockResource by determining the next resource that is going to be used by the process
		public abstract void setNextBlockResource(int resourceNum);
		
		//Sets the total time for the first block on random resource for that process that is generated
		public abstract void setTotalBlockTimeForNextBlock(int resourceNum);
		
		//Initializes CUPTime to 0
		public void setCPUTime() {
			this.CPUTime = 0;
		}
		//Initializes blockedTime to 0
		public void setBlockedTime() {
			this.blockedTime = 0;
		}
		//Initializes readyTime to 0
		public void setReadyTime() {
			this.readyTime = 0;
		}
		//Initializes lastEventTime to 0
		public void setLastEventTime() {
			this.lastEventTime = 0;
		}
		
		//Initializes finishTime to MAXINT
		public void setFinishTime() {
			this.finishTime = RNG.MAXINT;
		}
		
		//Initializes the blockServicTime to 0
		public void setBlockServiceTime() {
			this.blockServiceTime = 0;
		}
		
		//Initializes the sericeStartTime to MAXINT
		public void setServiceStartTime() {
			this.serviceStartTime = RNG.MAXINT;
		}
		
		//Initialize list of block list
		public void setBlockRecord() {
			this.blockRecord = new ArrayList<BlockList>();
		}
		
		
		
		//Getters for process objects
		
		public String getStringID(){
			return this.StringID;
		}
		
		public int getType() {
			return this.Type;
		}
		
		public int getTotalRunTime() {
			return this.totalRunTime;
		}
		
		public String getNextBlockResource() {
			return this.nextBlockResource;
		}
		
		public int getNextBlockInstant() {
			return this.nextBlockInstant;
		}
		
		public int getTotalBlockTimeForNextBlock() {
			return this.totalBlockTimeForNextBlock;
		}
		
		public int getCPUTime() {
			return this.CPUTime;
		}
		
		public int getBlockedTime() {
			return this.blockedTime;
		}
		
		public int getReadyTime() {
			return this.readyTime;
		}
		
		public int getLastEventTime() {
			return this.lastEventTime;
		}
		
		public int getFinishTime() {
			return this.finishTime;
		}
		
		public int getBlockServiceTime() {
			return this.blockServiceTime;
		}
		
		public int getServiceStartTime() {
			return this.serviceStartTime;
		}
		
		public List<BlockList> getBlockRecord(){
			return this.blockRecord;
		}
		
		
		//Additional methods to update process objects
		
		//method to generate next block 
		public abstract void generateNextBlock();
		
		//method to updates the list of block list
		public abstract void updateBlockRecord();
		
		
		
		
		
		//public void updateBlocked (int time) { blockedTime += time – lastEventTime; }
		//public void updateReady (int time) { … }
		//public void updateCPU (int time) { … }
		
		
		//Comparator interface for process objects
		public static final Comparator<Process> By_SJF = new BySJF();
		public static final Comparator<Process> By_SRT = new BySRT();
		public static final Comparator<Process> By_LWC = new ByLWC();
		
		//compare based on shortest job
		private static class BySJF implements Comparator<Process> {
	        public int compare(Process P1, Process P2) {
	        	int P1jobTime = P1.totalRunTime;
	        	int P2jobTime = P1.totalRunTime;
	        	if (P1jobTime < P2jobTime) return 1;
	        	if (P1jobTime > P2jobTime) return -1;
	        	else return 0;
	        	}
	        }
		
		//compare based on shortest remaining run time
		private static class BySRT implements Comparator<Process> {
	        public int compare(Process P1, Process P2) {
	        	int P1remainingTime = P1.totalRunTime - P1.CPUTime;
	        	int P2remainingTime = P1.totalRunTime - P2.CPUTime;
	        	if (P1remainingTime < P2remainingTime) return 1;
	        	if (P1remainingTime > P2remainingTime) return -1;
	        	else return 0;
	        	}
	        }
		
		//compare based on least work completed
		private static class ByLWC implements Comparator<Process> {
	        public int compare(Process P1, Process P2) {
	        	int P1remainingTime = P1.totalRunTime - P1.CPUTime;
	        	int P2remainingTime = P1.totalRunTime - P2.CPUTime;
	        	if (P1remainingTime > P2remainingTime) return 1;
	        	if (P1remainingTime < P2remainingTime) return -1;
	        	else return 0;
	        	}
	        }
		

			
		}
		
