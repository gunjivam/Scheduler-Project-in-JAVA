import java.util.*;
public class ResourceB extends Resource{
	
	private List<Process> listServingProcesses;
	private List<Integer> listNextUnblockTimes = new ArrayList<Integer>();
	
	//setters for ResourceB objects
	public void setType() {
		this.type = "B";
	}
	
	public void setBlockedProcessesDS() {
		this.blockedProcessesDS = new BlockedProcesses();
		this.blockedProcessesDS.setBlockedProcessesInclusive();
	}
		
	public void setExclusive() {
		this.exclusive = false;
	}
	
	//additional methods
	
	public void finishService(Process P) {
		int i = 0;
		int finalIndex = 0;
		while(this.blockedProcessesDS.getCountInclusive() > i) {
			if (this.blockedProcessesDS.getProcessatIndex(i) == P) {
				finalIndex = i;
			}
			else {
				i++;
			}
		}
		
		int oldTime = this.listNextUnblockTimes.remove(finalIndex);
		Process oldProcess = this.listServingProcesses.remove(finalIndex);
		
		this.updateActiveTime(oldProcess.blockServiceTime);
		this.numOfBlocks += 1;
		this.totalBlockTime += oldProcess.totalBlockTimeForNextBlock;
		
		this.blockedProcessesDS.getNextProcessInclusive(finalIndex);
		if (this.blockedProcessesDS.isEmptyInclusive()) {
			this.startIdleTime = oldTime;
			}
		
		//Scheduler.insertReadyList (oldProcess);
		//Scheduler.updateNextUnblock (nextUnblockTime, this);	// this identifies the resource
	}
	
	public void arrivingProcess (Process theProcess, int time) {
		if (blockedProcessesDS.isEmptyInclusive()) {
			blockedProcessesDS.addInclusive(theProcess);
			this.listServingProcesses.add(theProcess);
			theProcess.serviceStartTime = time;
			this.updateIdleTime (time - this.startIdleTime);
			this.listNextUnblockTimes.add(time + theProcess.blockServiceTime);
			
		}
		else {
			blockedProcessesDS.addInclusive(theProcess);
			this.listServingProcesses.add(theProcess);
			theProcess.serviceStartTime = time;
			this.listNextUnblockTimes.add(time + theProcess.blockServiceTime);
			}
	}

}
