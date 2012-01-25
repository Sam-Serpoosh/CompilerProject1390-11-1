package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

public class Signature {
	
	private ArrayList<SimpleEntry<String, String>> _arguments;
	
	public Signature() {
		_arguments = new ArrayList<SimpleEntry<String,String>>();
	}
	
	public void addArgument(String argumentName, String argumentType) {
		SimpleEntry<String, String> argument = new SimpleEntry<String, String>(argumentName, argumentType);
		_arguments.add(argument);
	}

}
