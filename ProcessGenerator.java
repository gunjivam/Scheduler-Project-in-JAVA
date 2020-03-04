import java.util.*;

public class ProcessGenerator{
	public static int minP = 3;
	public static int maxP = 8;
	public static int RandomNumOfP = RNG.RNGMinMax(minP, maxP);
	
	public static int LISTINDEX = 0;
	
	public static int ProcessIDINDEX = 1;
	public static int ProcessIDmax = 225;
	
	
//helper method to decide which type of process to add to list
	public static void AddProcessToList(int P, List<Process> Plist) {
		if(RNG.isType1(P)) {
			Plist.add(new Process1());
		}
		else if (RNG.isType2(P)) {
			Plist.add(new Process2());
		}
		else if (RNG.isType3(P)) {
			Plist.add(new Process3());
		}
		else {
			Plist.add(new Process4());
		}
	}
	
//Generate from 3 to 8 initial Processes
	public static void InitialProcessGen(List<Process> Processes) {
	for (int i=0; i<RandomNumOfP; i++) {
		
		int RandomProcess = RNG.RNGMax(100);
		int RandomResource = RNG.RNGMax(100);
		
		AddProcessToList(RandomProcess, Processes);
		
		Processes.get(LISTINDEX).setStringID(ProcessIDINDEX, ProcessIDmax);
		ProcessIDINDEX += 1;
		Processes.get(LISTINDEX).setType();
		Processes.get(LISTINDEX).setTotalRunTime();
		Processes.get(LISTINDEX).setNextBlockInstant();
		Processes.get(LISTINDEX).setNextBlockResource(RandomResource);
		Processes.get(LISTINDEX).setTotalBlockTimeForNextBlock(RandomResource);
		Processes.get(LISTINDEX).setCPUTime();
		Processes.get(LISTINDEX).setBlockedTime();
		Processes.get(LISTINDEX).setReadyTime();
		Processes.get(LISTINDEX).setLastEventTime();
		Processes.get(LISTINDEX).setFinishTime();
		Processes.get(LISTINDEX).setBlockServiceTime();
		Processes.get(LISTINDEX).setServiceStartTime();
		Processes.get(LISTINDEX).setBlockRecord();
		Processes.get(LISTINDEX).updateBlockRecord();
		Processes.get(LISTINDEX).generateNextBlock();
		
		LISTINDEX += 1;
		}
	}
	
//Generate the processes with varying arrival times
	public static void ProcessGen(int Time, int maxTime, List<Process> Processes) {
		
		while(Time < maxTime) {
			int RandomProcess = RNG.RNGMax(100);
			int RandomResource = RNG.RNGMax(100);
			int nextArrival = RNG.arriveIntervalVal();
			int arrivalTime = nextArrival + Time;
			
			if (arrivalTime < maxTime) {
				AddProcessToList(RandomProcess, Processes);
				
				Processes.get(LISTINDEX).setStringID(ProcessIDINDEX, ProcessIDmax);
				ProcessIDINDEX += 1;
				Processes.get(LISTINDEX).setType();
				Processes.get(LISTINDEX).setTotalRunTime();
				Processes.get(LISTINDEX).setNextBlockResource(RandomResource);
				Processes.get(LISTINDEX).setTotalBlockTimeForNextBlock(RandomResource);
				Processes.get(LISTINDEX).setCPUTime();
				Processes.get(LISTINDEX).setBlockedTime();
				Processes.get(LISTINDEX).setLastEventTime();
				Processes.get(LISTINDEX).setFinishTime();
				Processes.get(LISTINDEX).setNextBlockInstant();
				Processes.get(LISTINDEX).setBlockServiceTime();
				Processes.get(LISTINDEX).setServiceStartTime();
				Processes.get(LISTINDEX).readyTime = arrivalTime;
				Processes.get(LISTINDEX).setBlockRecord();
				Processes.get(LISTINDEX).updateBlockRecord();
				Processes.get(LISTINDEX).generateNextBlock();
				
				LISTINDEX +=1;
			}
			Time +=nextArrival;
		}
		}
}

		
		
		
	

	
