package assign04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LargestNumberSolverTiming extends TimerTemplate{

	private List<Integer[]> list;
	
	public LargestNumberSolverTiming(int[] problemSizes, int timesToLoop) {
		super(problemSizes, timesToLoop);
	}

	@Override
	protected void setup(int n) {
		list = new ArrayList<Integer[]>();
		
		for(int i = 0; i<n;i++) {
			Integer[] num = new Integer[5];
			Random random = new Random();
			for(int j= 0;j<num.length;j++)
				num[j] = random.nextInt(1000);
			list.add(num);
		}
	}

	@Override
	protected void timingIteration(int n) {
		int k = Math.min(n, list.size() - 1);
	    LargestNumberSolver.findKthLargest(list, k);
	}

	@Override
	protected void compensationIteration(int n) {

		
	}
	public static void main(String[] args){

		  ArrayList<Integer> ns = new ArrayList<>();
		  for(double n = 100; n <= 1000; n += 100){
		    ns.add((int)n);
		  }

		  //convert to int[]
		  int[] problemSizes = new int[ns.size()];
		  for(int i = 0; i < problemSizes.length; i++){
		    problemSizes[i] = ns.get(i);
		  }

		  var timer = new LargestNumberSolverTiming(problemSizes, 10);
		  var results = timer.run();
		  System.out.println("n, time");
		  for(var result: results){
		    System.out.println(result.n() + ", " + result.avgNanoSecs());
		  }
		}

}
