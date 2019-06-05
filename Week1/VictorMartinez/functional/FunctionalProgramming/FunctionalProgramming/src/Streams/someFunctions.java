package Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class someFunctions {

	public static <T> boolean streamMatch(Stream<T> inf, String pattern) {

		inf.anyMatch(arg -> {
			return arg.equals(pattern);
		});

		return false;
	}
	
	public static Stream<String> generateStringStream(String element){
		Stream<String> el = Stream.of(element);
		return el;
	}
	public static Stream<String> convertinArr2Stream(List<String> element) {
		return element.stream();
	}
	public static Stream <String> convertArr2ParalelSTream(List<String> element){
		return element.parallelStream();
	}
	
	public static void infiniteStream(){
		Stream<Integer> r = Stream.iterate(1, n->n+2);
		System.out.println(r.count());
	}
	

}
