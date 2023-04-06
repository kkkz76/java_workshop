public class Temperature {

	//declare your variables here
	private double degree;
	private char scale = 'C';
	private double celcius;
	private double fahrenheit;


	public Temperature(double degree, char scale) {
		//fill in your codes
		this.degree = degree;
		this.scale = scale;
	}

	public Temperature(double degree) {
		//fill in your codes
		this.degree = degree;
	}

	public Temperature(char scale) {
		//fill in your codes
		this.scale = scale;
	}

	public Temperature() {
		//fill in your codes
	}

	public double getCelsius() {
		//fill in your codes
		if(scale == 'F') {
			fahrenheit = degree;
			celcius = (fahrenheit - 32)*5/9;
		}else{
			celcius = degree;
		}
		
		return roundOff(celcius);
	}

	public double getFahrenheit() {
		//fill in your codes
		if(scale == 'C') {
			celcius = degree;
			fahrenheit = (celcius*9/5)+32;
		}else{
			fahrenheit = degree;
		}
		
		return roundOff(fahrenheit);
	}

	public void setScale(char scale) {
		//fill in your codes
		this.scale = scale;
	}

	public void setDegree(double degree) {
		//fill in your codes
		this.degree = degree;
		
	}

	public void setDegreeScale(double degree, char scale) {
		//fill in your codes
		this.degree = degree;
		this.scale = scale;
	}
	
	//use this method to roundoff to 2 dec places

	private double roundOff(double a) {
		return Math.round(a * 100.0) / 100.0;
	}

	
}
