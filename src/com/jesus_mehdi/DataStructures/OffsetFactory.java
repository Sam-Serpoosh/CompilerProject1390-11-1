package com.jesus_mehdi.DataStructures;

import java.util.HashMap;

public class OffsetFactory {

	private HashMap<String, Integer> _offsets;
	
	public OffsetFactory() {
		_offsets = new HashMap<String, Integer>();
		init();
	}
	
	public void init() {
		_offsets.put("int", 4);
		_offsets.put("string", 8);
	}
	
	public int getSize(String typeName) {
		return _offsets.get(typeName);
	}
	
}
