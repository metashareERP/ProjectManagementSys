package com.metaShare.modules.generate.entity;
import java.math.BigDecimal;import com.fasterxml.jackson.annotation.JsonProperty;import com.metaShare.modules.core.entity.CustomBaseEntity;/*add customized code between this region*//*add customized code between this region*/
public class enterprise extends CustomBaseEntity {
	private String Name;
	/*add customized code between this region*/    /*add customized code between this region*/
	
	@JsonProperty("Name")
	public String getName() {
	    return Name;
	}
	
	public void setName(String Name)
	{
	    this.Name = Name;
	}
	
	/*add customized code between this region*/    /*add customized code between this region*/
}
