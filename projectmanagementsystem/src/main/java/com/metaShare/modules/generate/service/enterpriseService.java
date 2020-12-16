package com.metaShare.modules.generate.service;
import com.baomidou.mybatisplus.service.IService;import com.metaShare.common.tool.state.Result;

public interface enterpriseService extends IService<com.metaShare.modules.generate.entity.enterprise>{
	Result selectList(int pageNum,int pageSize);
	
}
