package com.metaShare.modules.generate.service;


public interface taskService extends IService<com.metaShare.modules.generate.entity.task>{
	Result selectList(int pageNum,int pageSize);
	
}