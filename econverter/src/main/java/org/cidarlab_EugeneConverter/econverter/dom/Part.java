package org.cidarlab_EugeneConverter.econverter.dom;

public class Part {
	
	public PartType partType;
	public String name;
	public String sequence;
	
	public Part() {
		// TODO Auto-generated constructor stub
	}
	
	public Part(PartType _partType, String _name, String _sequence){
		partType = _partType;
		name = _name;
		sequence = _sequence;
	}

	
}