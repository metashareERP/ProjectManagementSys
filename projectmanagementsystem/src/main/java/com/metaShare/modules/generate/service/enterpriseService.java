package com.metaShare.modules.generate.service;


public interface enterpriseService extends IService<com.metaShare.modules.generate.entity.enterprise>{
	Result selectList(int pageNum,int pageSize);
	
}