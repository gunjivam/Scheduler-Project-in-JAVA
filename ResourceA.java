
public class ResourceA extends Resource {

	//setters for ResourceA objects
	public void setType() {
		this.type = "A";
	}
	
	public void setBlockedProcessesDS() {
		this.blockedProcessesDS = new BlockedProcesses();
		this.blockedProcessesDS.setBlockedProcessesExclusive();
	}
	
	public void setExclusive() {
		this.exclusive = true;
	}
	
	//additional methods
	
	public void  finishService(Process P) {
		int oldTime = this.nextUnblockTime;		// current process finish time—for legibility
		
		this.updateActiveTime(P.blockServiceTime);
		
		if (!this.blockedProcessesDS.isEmptyExclusive()) {
	
			Process theProcess = this.blockedProcessesDS.getNextProcessExclusive();
			this.nextUnblockTime = oldTime + theProcess.totalBlockTimeForNextBlock;
			this.servingProcess = theProcess;
			theProcess.serviceStartTime = oldTime;
			this.numOfBlocks += 1;
			this.totalBlockTime += theProcess.totalBlockTimeForNextBlock;
		}
		else {
			this.nextUnblockTime = RNG.MAXINT;
			this.servingProcess = null;
			this.startIdleTime = oldTime;
			}
		
		//Scheduler.insertReadyList (servingProcess);
		//Scheduler.updateNextUnblock (nextUnblockTime, this);	// this identifies the resource
	}
	
	public void arrivingProcess (Process theProcess, int time) {
		//theProcess.blockedTime = 
		if (blockedProcessesDS.isEmptyExclusive()) {
			this.servingProcess = theProcess;
			theProcess.serviceStartTime = time;
			this.updateIdleTime (time - this.startIdleTime);
			this.nextUnblockTime = (time + theProcess.blockServiceTime);
			//Scheduler.updateNextUnblock (nextUnblockTime, this);	
		}
		else {
			blockedProcessesDS.addExclusive(theProcess);		// insert at end
		}
	}
	
	
}
