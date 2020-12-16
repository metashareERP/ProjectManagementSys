package com.metaShare.modules.generate.entity;
import java.math.BigDecimal;import com.fasterxml.jackson.annotation.JsonProperty;import com.metaShare.modules.core.entity.CustomBaseEntity;/*add customized code between this region*//*add customized code between this region*/
public class b extends CustomBaseEntity {
	private String Name;
	private String taskId;
	private String taskName;
	private String projectId;
	private String projectName;
	/*add customized code between this region*/    /*add customized code between this region*/
	
	@JsonProperty("Name")
	public String getName() {
	    return Name;
	}
	
	public void setName(String Name)
	{
	    this.Name = Name;
	}
	
	@JsonProperty("taskId")
	public String gettaskId() {
	    return taskId;
	}
	
	public void settaskId(String taskId)
	{
	    this.taskId = taskId;
	}
	
	@JsonProperty("taskName")
	public String gettaskName() {
	    return taskName;
	}
	
	public void settaskName(String taskName)
	{
	    this.taskName = taskName;
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
	
	/*add customized code between this region*/    /*add customized code between this region*/
}
