package com.metaShare.modules.generate.entity;
import java.math.BigDecimal;import com.fasterxml.jackson.annotation.JsonProperty;import com.metaShare.modules.core.entity.CustomBaseEntity;/*add customized code between this region*//*add customized code between this region*/
public class project extends CustomBaseEntity {
	private String Name;
	private String enterpriseId;
	private String enterpriseName;
	/*add customized code between this region*/    /*add customized code between this region*/
	
	@JsonProperty("Name")
	public String getName() {
	    return Name;
	}
	
	public void setName(String Name)
	{
	    this.Name = Name;
	}
	
	@JsonProperty("enterpriseId")
	public String getenterpriseId() {
	    return enterpriseId;
	}
	
	public void setenterpriseId(String enterpriseId)
	{
	    this.enterpriseId = enterpriseId;
	}
	
	@JsonProperty("enterpriseName")
	public String getenterpriseName() {
	    return enterpriseName;
	}
	
	public void setenterpriseName(String enterpriseName)
	{
	    this.enterpriseName = enterpriseName;
	}
	
	/*add customized code between this region*/    /*add customized code between this region*/
}
