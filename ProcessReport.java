import java.text.DecimalFormat;
import java.util.*;

public class ProcessReport {

	//report total number of processes and how many of each process type have been generated
	public static String NumOfProcessesGen(List<Process> Processes) {
		int type1Count = 0;
		int type2Count = 0;
		int type3Count = 0;
		int type4Count = 0;
		int totalCount = 0;
		for (int i = 0; i < Processes.size(); i++) {
			int type = Processes.get(i).getType();
			if (type == 1) {
				type1Count += 1;
			}
			else if (type == 2) {
				type2Count += 1;
			}
			else if (type == 3) {
				type3Count += 1;
			}
			else {
				type4Count +=1;
			}
			totalCount += 1;
			}
		String Report = String.format("%d processes generated, %d type1, %d type2, %d type3, and %d type4 ", 
										totalCount, type1Count, type2Count, type3Count, type4Count);
		return Report;
		}

	//labels1   ID, Type, Arrive, Running, Block List, Total Blocked
	public static String Labels1() {
		return String.format("%s %10s %10s %10s %15s %48s", "ID", "Type", "Arrive", "Running", "Block List", "Total Blocked");
	}
	
	//prints information from process object based on labels
	public static void ProcessInfo(List<Process> Processes) {
		for (int i = 0; i < Processes.size(); i++) {
			String id = Processes.get(i).getStringID();
			int type = Processes.get(i).getType();
			int arrive = Processes.get(i).getReadyTime();
			int RT = Processes.get(i).getTotalRunTime();
				
			System.out.format("%-10s %-8d %-8d %-10d  ",id, type, arrive, RT);
			
			int TBT = 0;
			List<BlockList> LBL = Processes.get(i).getBlockRecord();
			if (LBL == null) {
				System.out.print("null");
				System.out.print("                                               " + 0);
			}
			else {
				String[] LBLarr = new String[LBL.size()];
				for (int j=0; j<LBL.size(); j++) {
					BlockList BL = LBL.get(j);
					int BI = BL.getBI();
					String R = BL.getR();
					int BT = BL.getBT();
					
					TBT += BT;
					
					String blist = String.format("(%d, %s, %d)", BI, R, BT);
					LBLarr[j] = blist;
					}
				String L1 = "";
				String L2 = "";
				String L3 = "";
				String firstLine = "";
				
				if (LBLarr.length >= 1) {
					L1 = LBLarr[0];
				}
				if (LBLarr.length >=2 ){
					L2= LBLarr[1];
				}
				if (LBLarr.length >=3) {
					L3 = LBLarr[2];
				}
				if (LBLarr.length == 1){
					firstLine = String.format("%s", L1);
				}
				if (LBLarr.length == 2) {
					firstLine = String.format("%s %s", L1, L2);
				}
				if (LBLarr.length >= 3) {
					firstLine = String.format("%s %s %s", L1, L2, L3);
				}
				
				for (int k=0; k<LBLarr.length; k++) {
					if(k>0 && k%3==0) {
							System.out.println();
							System.out.print("                                         ");
						}
					if((LBLarr.length == 1 && k==0) || (LBLarr.length == 2 && k==1) || (LBLarr.length >= 3 && k==2)) {
						System.out.format("%-50s %d", firstLine, TBT); 
							}
					if(k>2) {
						System.out.print(LBLarr[k] + " ");
					}
			}
			}
			System.out.println();
			}
		}
	
	//Labels2   Running Time	  Blocks and Blocked Time per Resource 			  Total Blocking
	public static String Labels2() {
		return String.format("%-20s %-65s %s", "Running Time", "Blocks and Blocked Time per Resource", "Total Blocking");
	}
	
	//Labels3   Total	    	  A   time	       B   time	       C   time	       Total    time
	public static String Labels3() {
		return String.format("%-20s %-20s %-20s %-23s %s", "   Total", "A        time", "B        time", "C        time", "Total       time");
	}
	
	//info about labels above
	public static String totalInfo(List<Process> Processes) {
		int totalRun = 0;
		int Acount = 0;
		int Atime = 0;
		int Bcount = 0;
		int Btime = 0;
		int Ccount = 0;
		int Ctime = 0;
		int totalResource = 0;
		int totalTime = 0;
	
		for (int i = 0; i < Processes.size(); i++) {
			int RT = Processes.get(i).getTotalRunTime();
			List<BlockList> LBL = Processes.get(i).getBlockRecord();
			if (LBL != null) {
				for (int j=0; j<LBL.size(); j++) {
					BlockList BL = LBL.get(j);
					String R = BL.getR();
					int BT = BL.getBT();
				
					if (R == "A") {
						Acount += 1;
						Atime += BT;
					}
					else if (R == "B") {
						Bcount += 1;
						Btime += BT;
					}
					else if (R == "C") {
						Ccount += 1;
						Ctime += BT;
					}
					
					if (R == "A" || R == "B" || R =="C") {
						totalResource += 1;
						totalTime += BT;
					}
				}
			}
			totalRun += RT;
			}
		String info = String.format( "   %-17d %-8d %-11d %-8d %-11d %-8d %-15d %-10d %d", 
									totalRun, Acount, Atime, Bcount, Btime, Ccount, Ctime, totalResource, totalTime);
		return info;
		}
	
	//Label4   Average Interarrival Time (not counting initial process set at time 0)
	public static String Labels4() {
		return "Average Interarrival Time (not counting initial process set at time 0)";
	}
	
	//need method to get average InterarrivalTime
	public static double getInterarrivalTime(List<Process> Processes) {
		double count = 0;
		double maxAT = 0;
		for(int i=0; i<Processes.size(); i++) {
			int AT = Processes.get(i).getReadyTime();
			if (AT != 0) {
				count+=1;
			}
			if (i == Processes.size() - 1) {
				maxAT = AT;
			}
		}
		
		return maxAT/count;
	}
	
	
	//Driver for phase 1
	public static void main(String[] args) {
		List<Process> OurProcesses = new ArrayList<Process>(225);
		
		ProcessGenerator.InitialProcessGen(OurProcesses);
		ProcessGenerator.ProcessGen(RNG.GLOBALTIME, RNG.MAXINT, OurProcesses);
		
		String Report = NumOfProcessesGen(OurProcesses);
		System.out.println(Report);
		System.out.println();
		System.out.println();
		
		String L1 = Labels1();
		System.out.println(L1);
		ProcessInfo(OurProcesses);
		System.out.println();
		System.out.println();
		
		String L2 = Labels2();
		String L3 = Labels3();
		System.out.println(L2);
		System.out.println();
		System.out.println(L3);
		String nextReport = totalInfo(OurProcesses);
		System.out.println(nextReport);
		System.out.println();
		System.out.println();
		
		String L4 = Labels4();
		System.out.println(L4);
		double IAT = getInterarrivalTime(OurProcesses);
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println();
		System.out.println(df.format(IAT));
		
		}
	}