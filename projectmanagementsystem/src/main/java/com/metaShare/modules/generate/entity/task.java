package com.metaShare.modules.generate.entity;
import java.math.BigDecimal;import com.fasterxml.jackson.annotation.JsonProperty;import com.metaShare.modules.core.entity.CustomBaseEntity;/*add customized code between this region*//*add customized code between this region*/
public class task extends CustomBaseEntity {
	private String Name;
	private String projectId;
	private String projectName;
	private String ParenttaskId;
	private String ParenttaskName;
	/*add customized code between this region*/    /*add customized code between this region*/
	
	@JsonProperty("Name")
	public String getName() {
	    return Name;
	}
	
	public void setName(String Name)
	{
	    this.Name = Name;
	}
	
	@JsonProperty("projectId")
	public String getprojectId() {
	    return projectId;
	}
	
	public void setprojectId(String projectId)
	{
	    this.projectId = projectId;
	}
	
	@JsonProperty("projectName")
	public String getprojectName() {
	    return projectName;
	}
	
	public void setprojectName(String projectName)
	{
	    this.projectName = projectName;
	}
	
	@JsonProperty("ParenttaskId")
	public String getParenttaskId() {
	    return ParenttaskId;
	}
	
	public void setParenttaskId(String ParenttaskId)
	{
	    this.ParenttaskId = ParenttaskId;
	}
	
	@JsonProperty("ParenttaskName")
	public String getParenttaskName() {
	    return ParenttaskName;
	}
	
	public void setParenttaskName(String ParenttaskName)
	{
	    this.ParenttaskName = ParenttaskName;
	}
	
	/*add customized code between this region*/    /*add customized code between this region*/
}
