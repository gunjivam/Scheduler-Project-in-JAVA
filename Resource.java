
public abstract class Resource {
	
	//Data members for a resource
	
	public String type;
	public int nextUnblockTime;
	public int startIdleTime;
	public int activeTime;
	public int idleTime;
	public BlockedProcesses blockedProcessesDS;
	public Process servingProcess;
	public int count;
	public boolean exclusive;
	public int numOfBlocks;
	public int totalBlockTime;
	
	
	//Setters for resource object
	
	//sets type of resources
	public abstract void setType();
	
	//sets the next unblock time
	public void setNextUnblockTime() {
		this.nextUnblockTime = RNG.MAXINT;
	}
	
	//sets the initial startIdleTime to MAXINT
	public void setStartIdleTime() {
		this.startIdleTime = RNG.MAXINT;
		}
	
	//Initializes the active time for the resource to 0
	public void setActiveTime() {
		this.activeTime = 0;
	}
	
	//Initializes the idle time for the resource to 0
	public void setIdleTime() {
		this.idleTime = 0;
	}
	
	//Initializes the list or Queue for the blocked resources depending on the type of resource
	public abstract void setBlockedProcessesDS();
	
	//sets the process being served to null
	public void setServingProcess() {
		this.servingProcess = null;
	}
	
	//sets the count for the blocked processes list to 0
	public void setCount() {
		this.count = 0;
	}
	
	//is this resource exclusive?
	public abstract void setExclusive();
	
	//initializes number of blocks to 0
	public void setNumOfBlocks() {
		this.numOfBlocks = 0;
	}
	
	//initializes total block time to 0
	public void setTotalBlockTime() {
		this.totalBlockTime = 0;
	}
	
	
	
	//getters for resource object
	
	public String getType() {
		return this.type;
	}
	
	public int getNextUnblockTime() {
		return this.nextUnblockTime;
	}
	
	public int getStartIdleTime() {
		return this.startIdleTime;
	}
	
	public int getActiveTime() {
		return this.activeTime;
	}
	
	public int getIdleTime() {
		return this.idleTime;
	}
	
	public BlockedProcesses getBlockedProcessesDS() {
		return this.blockedProcessesDS;
	}
	
	public Process getServingProcess() {
		return this.servingProcess;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public boolean getExclusive() {
		return this.exclusive;
	}
	
	public int getNumOfBlocks() {
		return this.numOfBlocks;
	}
	
	public int getTotalBlockTime() {
		return this.totalBlockTime;
	}
	
//additional methods for updating resource object
	
	public void updateNextUnblockTime(Process P) {
		this.nextUnblockTime = P.totalBlockTimeForNextBlock;
	}
	
	public abstract void arrivingProcess(Process theProcess, int time);
	
	public void updateIdleTime(int T) {
		this.idleTime += T;
	}
	
	public void updateActiveTime(int PST) {
		this.activeTime += PST; 
	}
	
	
	public abstract void finishService (Process P);
		

		

	
	



}
