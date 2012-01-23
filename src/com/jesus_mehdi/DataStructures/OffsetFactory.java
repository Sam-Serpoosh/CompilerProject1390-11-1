package com.jesus_mehdi.DataStructures;

import java.util.HashMap;

public class OffsetFactory {

	private HashMap<String, Integer> _offsets;
	
	public OffsetFactory() {
		_offsets = new HashMap<String, Integer>();
		init();
	}
	
	public void init() {
		_offsets.put("int", 1);
		_offsets.put("string", 1);
		_offsets.put("bool", 1);
		_offsets.put("object", 1);
	}
	
	public void registerModuleType(String moduleName, int moduleSize) {
		_offsets.put(moduleName, moduleSize);
	}
	
	public int getSize(String typeName) {
		return _offsets.get(typeName);
	}
	
}
