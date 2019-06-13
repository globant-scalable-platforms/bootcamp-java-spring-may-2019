package com.bootcamp.arrayvslinked;

public class Categories {
	public static long start, end;
	private Categories() {
		start= System.nanoTime();
	};

	public static void use(UseTemplate use) {
		Categories category = new Categories();
		try {
	    	use.execute(category);
			end=System.nanoTime();
	    }finally{	    	
	    	time(start,end);
	    }
	};
	
	public static void time (long initial, long ending) {
		System.out.println("Delays(Miliseconds): " + ((end - start)/1000000));
	}
	
}
