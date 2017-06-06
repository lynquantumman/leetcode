class Lagrange{
	public double[] polynomial(double[] input_x,double[] input_y, double x){
		if (input_y.length!=input_x.length) {
			System.err.println("The length of input_x and it of input_y doesn't match!");
			return null;
		}
		int len = input_x.length;

		
		double[] base = new double[len];
		double[] ans = new double[len];
		Arrays.fill(base,1.0);
		for (int i= 0;i<len;i++) {
			for (int j = 0;j<len ;j++ ) {
				if (j!=i) {
					base[i] *= (x - input_x[j])/(input_x[i]-input_x[j]);
				}
			}
			ans[i] = base[i]*input_y[i];
		}

		double poly = 0.0;
		

		for(int i = 0;i<len;i++){
			poly += ans[i];
		}
		
		return poly;
		
	}
}