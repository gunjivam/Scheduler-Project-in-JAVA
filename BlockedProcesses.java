import java.util.*;

public class BlockedProcesses {
	
	Queue<Process> blockedProcessesExclusive;
	List<Process> blockedProcessesInclusive;
	
	
	//methods for BlockedProcesses
	
	//Setters for blocked processes
	public void setBlockedProcessesExclusive() {
		this.blockedProcessesExclusive = new LinkedList<Process>();
	}
	
	public void setBlockedProcessesInclusive() {
		this.blockedProcessesInclusive = new ArrayList<Process>();
	}
	
	//getters for blocked processes
	public Queue<Process> getBlockedProcessesExclusive(){
		return this.blockedProcessesExclusive;
	}
	
	public List<Process> getBlockedProcessesInclusive(){
		return this.blockedProcessesInclusive;
	}
	
	//return count for the data structure
	public int getCountExclusive() {
		return this.blockedProcessesExclusive.size();
	}
	
	public int getCountInclusive() {
		return this.blockedProcessesInclusive.size();
	}
	
	//is the data structure empty
	public boolean isEmptyExclusive() {
		return this.blockedProcessesExclusive.isEmpty();
	}
	
	public boolean isEmptyInclusive() {
		return this.blockedProcessesInclusive.isEmpty();
	}
	
	//add an element to the data structure
	public void addExclusive(Process arg) {
		this.blockedProcessesExclusive.add(arg);
	}
	
	public void addInclusive(Process arg) {
		this.blockedProcessesInclusive.add(arg);
	}
	
	//get the next element in the data structure and remove it
	public Process getNextProcessExclusive() {
		Process P = this.blockedProcessesExclusive.remove();
		return P;
	}
	
	public Process getNextProcessInclusive(int i) {
		Process P = this.blockedProcessesInclusive.remove(i);
		return P;
	}
	
	//get element at index for inclusive
	public Process getProcessatIndex(int i) {
		Process P =this.blockedProcessesInclusive.get(i);
		return P;
	}
	
}