package com.metaShare.modules.generate.entity;

public class enterprise extends CustomBaseEntity {
	private String Name;
	/*add customized code between this region*/
	
	@JsonProperty("Name")
	public String getName() {
	    return Name;
	}
	
	public void setName(String Name)
	{
	    this.Name = Name;
	}
	
	/*add customized code between this region*/
}