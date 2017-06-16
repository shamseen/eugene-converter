package org.cidarlab_EugeneConverter.econverter.dom;

import java.util.List;

public class Device {
	String Name;
	String Sequence;
	List<Part> Parts;
	
	public Device(String name, List<Part> parts){
		Name = name;
		Parts.addAll(parts);
		Sequence = "";
		GenerateSequence(parts);
	}
	
	private void GenerateSequence(List<Part> parts){
		for (Part p : parts){
			Sequence += p.Sequence;
		}
	}
}
