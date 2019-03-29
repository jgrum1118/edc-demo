package com.optum.chy.tmp.ggmap;

import java.util.ArrayList;

public class JsonChargeCodes {
	String cptCode;
	ArrayList<JsonModifier> modifier;

	public void setCptCode (String cptCode) {this.cptCode = cptCode;}  
	public void setModifier (ArrayList<JsonModifier> modifier) {this.modifier = modifier;}
	
}
