package com.metaShare.modules.generate.service;


public interface projectService extends IService<com.metaShare.modules.generate.entity.project>{
	Result selectList(int pageNum,int pageSize);
	
}