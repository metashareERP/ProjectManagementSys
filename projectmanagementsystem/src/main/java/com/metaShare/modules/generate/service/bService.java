package com.metaShare.modules.generate.service;
import com.baomidou.mybatisplus.service.IService;import com.metaShare.common.tool.state.Result;

public interface bService extends IService<com.metaShare.modules.generate.entity.b>{
	Result selectList(int pageNum,int pageSize);
	
}
