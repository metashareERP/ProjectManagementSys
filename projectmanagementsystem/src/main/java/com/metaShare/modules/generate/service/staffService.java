package com.metaShare.modules.generate.service;


public interface staffService extends IService<com.metaShare.modules.generate.entity.staff>{
	Result selectList(int pageNum,int pageSize);
	
}