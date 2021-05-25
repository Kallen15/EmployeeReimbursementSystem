package com.revature.tests;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {

	//Return a single item from a list
	public static <T> Collector<T, ?, T> returnSingle(){
		return Collectors.collectingAndThen(
				Collectors.toList(),
				list -> {
					if(list.size() != 1) {
						throw new MoreThanOneException();
					}
					return list.get(0);
				}
			);
	}
		
}
