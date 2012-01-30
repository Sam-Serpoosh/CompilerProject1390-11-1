package com.jesus_mehdi.DataStructures;

import java.util.HashMap;

public class OffsetFactory {

	private static HashMap<String, Integer> _offsets;
	
	public OffsetFactory() {
		getOffsetFactory();
	}
	
	public HashMap<String, Integer> getOffsetFactory() {
		if (_offsets == null) {
			_offsets = new HashMap<String, Integer>();
			init();
		}
		
		return _offsets;
	}
	
	public void init() {
		_offsets.put("int", 1);
		_offsets.put("string", 1);
		_offsets.put("bool", 1);
		_offsets.put("object", 1);
		_offsets.put("void", 0);
	}
	
	public void registerModuleType(String moduleName, int moduleSize) {
		_offsets.put(moduleName, moduleSize);
	}
	
	public int getSizeOf(String type) {
		return 1;
	}
	
	public int getSize(SymbolTableRow row) {
		return row.getSize();
	}
	
}
