package trigonometric;

public class Trigonometric {
	
	/**
	 * sin求对边长度
	 * @param duijiao 对角角度 如：30
	 * @param xiebian 斜边长度
	 * @return 对边长度
	 */
	public static double sin(double duijiao, double xiebian){
		double radians = Math.toRadians(duijiao);
		double duibian = xiebian * Math.sin(radians);
		return duibian;
	}
	
	/**
	 * cos求邻边长度
	 * @param duijiao 对角角度 如：30
	 * @param xiebian 斜边长度
	 * @return 邻边长度
	 */
	public static double cos(double duijiao, double xiebian){
		double radians = Math.toRadians(duijiao);
		double linbian = xiebian * Math.cos(radians);
		return linbian;
	}
	
}
