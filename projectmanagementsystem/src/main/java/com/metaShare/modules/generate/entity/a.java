package com.metaShare.modules.generate.entity;

public class a extends CustomBaseEntity {
	private String Name;
	private String enterpriseId;
	private String enterpriseName;
	private String projectId;
	private String projectName;
	/*add customized code between this region*/
	
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
	
	/*add customized code between this region*/
}