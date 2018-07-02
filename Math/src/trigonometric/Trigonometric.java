package trigonometric;

public class Trigonometric {
	
	/**
	 * sin��Ա߳���
	 * @param duijiao �ԽǽǶ� �磺30
	 * @param xiebian б�߳���
	 * @return �Ա߳���
	 */
	public static double sin(double duijiao, double xiebian){
		double radians = Math.toRadians(duijiao);
		double duibian = xiebian * Math.sin(radians);
		return duibian;
	}
	
	/**
	 * cos���ڱ߳���
	 * @param duijiao �ԽǽǶ� �磺30
	 * @param xiebian б�߳���
	 * @return �ڱ߳���
	 */
	public static double cos(double duijiao, double xiebian){
		double radians = Math.toRadians(duijiao);
		double linbian = xiebian * Math.cos(radians);
		return linbian;
	}
	
}
