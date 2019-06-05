package Streams;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Basics.BasicFunctions;
public class BasicStream {

	public static void main(String [] args) {
		
		
	someFunctions.infiniteStream();
		
		
		
		
		
	/*
	Stream <String> rr = Stream.of("R","R","R","R","R","r","t","t","y");
		rr.filter(a->{
			return a=="R";
		}).collect(Collectors.toList()).forEach(System.out::println);
		
	
	*/
	}

	Predicate <String> isR(){
		return r-> r=="R";
	}
		
	
	
	
	
}