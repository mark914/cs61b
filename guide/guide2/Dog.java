public class Dog {
	public int weightIntPounds;
	public static String binomen  = "ha ba dog";
	
 	/** One integer construtor for dogs.*/
 	public Dog(int w) {
		weightIntPounds = w;
	}           
	
	public void makeNoise() {
		if (weightIntPounds < 10) {
			System.out.println("yepyepyep");
		} else {
			System.out.println("bark!");	
		}

	}

	public static Dog maxDog(Dog d1, Dog d2) {
		if (d1.weightIntPounds > d2.weightIntPounds) {
			return d1;
		} 
		return d2;

	}


	public Dog maxDog(Dog d2) {
		if (weightIntPounds > d2.weightIntPounds) {
			return this;
		}
		return d2;
	}
}


