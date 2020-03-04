import java.util.*;

public class RNG {

	//variables for use in RNG Methods
	static Random rand = new Random();
	public static int MAXINT = 25000;
	public static int GLOBALTIME = 0;
	public static int TIMEQUANTUM = 10;
	
	//percentages for which type of process to create
	public static int P1 = 50;
	public static int P2 = 30;
	public static int P3 = 17;
	//public static int P4 = 3;
	
	//Percentages for resources to be used by the different processes
	public static int RAP1 = 50;
	//public static int RBP1 = 50;
	
	//process 2 will not use resource because it does not block
	
	public static int RAP3 = 35;
	public static int RBP3 = 50;
	//public static int RCP3 = 15;
	
	public static int RBP4 = 50;
	//public static int RCP4 = 50;
	
	
	
	
	
	//RNG Methods
	
	//Random number from 0 to max exclusive of max
	public static int RNGMax (int max)  { 
		int num = rand.nextInt(max);
		return num;
		}
	
	//Random number from min to max inclusive
	public static int RNGMinMax (int min, int max) {
		int num = rand.nextInt((max+1) - min)+min;
		return num;
		}
	
	//Random number from 0 to 1 exclusive of 1
	public static float fRNG() {
		float num = rand.nextFloat();
		return num;
		}
	
	//Methods to identify what type the process is
	public static boolean isType1(int processNum) {
		return processNum < P1;
	}
	
	public static boolean isType2(int processNum) {
		return processNum >= P1 && processNum < (P1+P2);
	}
	
	public static boolean isType3(int processNum) {
		return processNum >= (P1+P2) && processNum < (P3+P2+P1);
	}
	
	//Do not need method for type4 because if the process in not one of the other three types, it must be type4

	
	
	//RNG  methods for process run time generation
		
	//RNG for type 1 processes
	public static int PRTprocess1() {
		int min = 25;
		int max = 75;
		return RNGMinMax(min, max);
		}
	
	//RNG for type 2 processes
	public static int PRTprocess2() {
		int min = 200;
		int max = 600;
		float num = fRNG();
		int value = (int) Math.ceil(min + (max - min)*Math.pow(num, 5/3));
		return value;
		}
	
	//RNG for type 3 processes
	public static int PRTprocess3() {
		int min = 150;
		int max = 500;
		float num = fRNG();
		int value = (int) Math.ceil(min + (max - min) * Math.pow(num, 5/2));
		return value;
		}
	
	//RNG for type 4 processes
	public static int PRTprocess4() {
		int min = 400;
		int max = 1000;
		return RNGMinMax(min, max);
		}
	
	
	//RNG helper methods for process random block time generation
	
	//Block on type A resource
	private static int BTtypeA() {
		int min = 60;
		int max = 100;
		return RNGMinMax(min, max);
	}
	
	//Block on type B resource
	private static int BTtypeB() {
		int min = 75;
		int max = 125;
		return RNGMinMax(min, max);
		}
	
	//Block on type C resource
	private static int BTtypeC() {
		int min = 100;
		int max = 400;
		float num = fRNG();
		int value = (int) Math.ceil(min + (max - min) * Math.pow(num, 2));
		return value;
		}
	
	//Block on type D resource
	//private static int BTtypeD() {
	//
	//}
	
	
	//RNG methods for creating blocks for each process
	
	//For Process1, determine if the process will block
	public static boolean willProcess1Block() {
		float Random = fRNG();
		return Random < .4;
		}
	
	//For Process1, determine the blocking instant
	public static int Process1BlockOccurAt(int RT) {
		int min = 0;
		int max = RT;
		return RNGMinMax(min +1, max -1);
		}
	
	//For Process1, determine the resource used
		//For Process1, is the resource A or B
		public static boolean isTypeAResourceProcess1(int resourceInt){
			if (resourceInt < RAP1) {
				return true;
			}
			else {
				return false;
				}
			}
		
		public static String resourceProcess1(int resourceInt) {
			String R;
			 if (isTypeAResourceProcess1(resourceInt)) {
				R = "A";
				}
			 else {
				 R = "B";
				 }
			 return R;
			 }
	
	//For Process1, determine the block time
	public static int PBTprocess1(int resourceInt) {
		int BT;
		if (isTypeAResourceProcess1(resourceInt)) {
				BT = BTtypeA();
			}
			else {
				BT = BTtypeB();
				}
		return BT;
		}
	
	
	//Nothing is needed for Process2 because it never blocks
		
	
	//For Process3, determine the blocking interval
	public static int Process3BlockInterval() {
		int min = 25;
		int max = 75;
		float num = fRNG();
		int value = (int) Math.ceil(min + (max - min) * Math.pow(num, 7/3));
		return value;
		}
	
	//For Process3, determine the resource used 
		//For process three, is the resource type A, B, or C
		//Is typeA?
		public static boolean isTypeAResourceProcess3(int resourceInt) {
			if (resourceInt < RAP3 ) {
				return true;
			}
			else {
				return false;
				}
		}
		//is typeB?
		public static boolean isTypeBResourceProcess3(int resourceInt) {
			if (resourceInt >= RAP3 && resourceInt < (RAP3+RBP3)) {
				return true;
			}
			else {
				return false;
				}
		}
		
		public static String resourceProcess3(int resourceInt) {
			String R;
			if (isTypeAResourceProcess3(resourceInt)) {
				R = "A";
			}
			else if (isTypeBResourceProcess3(resourceInt)) {
				R = "B";
			}
			else {
				R = "C";
			}
			return R;
			}
		
	//For Process3, determine the block time
	public static int PBTprocess3(int resourceInt) {
		int BT;
		if (isTypeAResourceProcess3(resourceInt)) {
			BT = BTtypeA();
		}
		else if (isTypeBResourceProcess3(resourceInt)) {
			BT = BTtypeB();
		}
		else {
			BT = BTtypeC();
		}
		return BT;
		}
		
		
	//For Process4, determine the blocking interval
	public static int Process4BlockInterval() {
		int min = 40;
		int max = 120;
		return RNGMinMax(min, max);
		}
	
	//For Process4, determine the resource used 
		//For process four, is the resource B or C
		public static boolean isTypeBResourceProcess4(int resourceInt) {
			if (resourceInt < RBP4) {
				return true;
			}
			else {
				return false;
				}
			}
		
		public static String resourceProcess4(int resourceInt) {
			String R;
			if (isTypeBResourceProcess4(resourceInt)) {
				R = "B";
			}
			else {
				R = "C";
			}
			return R;
			}
		
	//For Process4, determine the block time
	public static int PBTprocess4(int resourceInt) {
		int BT;
		if (isTypeBResourceProcess4(resourceInt)) {
			BT = BTtypeB();
		}
		else {
			BT = BTtypeC();
		}
		return BT;
		}
	

	//method to generate random arrival time within interval for processes
	public static int arriveIntervalVal() {
		int min = 10;
		int max = 810;
		return RNGMinMax(min, max);
	}
		
		
}

