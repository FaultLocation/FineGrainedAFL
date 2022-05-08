package downloadD4j2020;

public class ParaSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//If
		double x1 = 0;
		double x2 = 0;
		double x3 = 0;
		double x4 = 0;
		double x5 = 0;
		double x6 = 0;
		double x7 = 0;
		
		
		double log1 = Math.log(x1);
		double log2 = Math.log(x2);
		double log3 = Math.log(x3);
		double log4 = Math.log(x4);
		double log5 = Math.log(x5);
		double log6 = Math.log(x6);
		double log7 = Math.log(x7);
		
		double average = (log1+log2+log3+log4+log5+log6+log7)/7;
		
		double variance = (Math.pow((log1-average), 2)+Math.pow((log2-average), 2)+Math.pow((log3-average), 2)+
				 Math.pow((log4-average), 2)+Math.pow((log5-average), 2)+Math.pow((log6-average), 2)+Math.pow((log7-average), 2))/7;

		
	}

}
