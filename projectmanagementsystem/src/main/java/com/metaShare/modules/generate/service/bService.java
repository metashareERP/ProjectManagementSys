package com.metaShare.modules.generate.service;


public interface bService extends IService<com.metaShare.modules.generate.entity.b>{
	Result selectList(int pageNum,int pageSize);
	
}