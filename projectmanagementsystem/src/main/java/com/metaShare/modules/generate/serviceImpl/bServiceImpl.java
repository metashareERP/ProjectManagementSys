package com.metaShare.modules.generate.serviceImpl;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;import com.metaShare.modules.sys.dao.SysDictDao;import com.metaShare.modules.sys.entity.SysDicinfo;import com.metaShare.common.tool.pageTool.PageDTO;import com.metaShare.common.tool.pageTool.PageTool;import com.metaShare.common.tool.state.Result;import com.metaShare.common.tool.state.ResultCode;import com.metaShare.common.utils.DateUtil;import org.apache.poi.ss.formula.functions.T;import org.aspectj.weaver.ast.Test;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.io.Serializable;import java.util.List;

@Service
public class bServiceImpl extends ServiceImpl<com.metaShare.modules.generate.dao.bDao,com.metaShare.modules.generate.entity.b> implements com.metaShare.modules.generate.service.bService {
	
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public boolean insert(com.metaShare.modules.generate.entity.b entity) {
		return super.insert(entity);
	}
	
	@Override
	public boolean updateById(com.metaShare.modules.generate.entity.b entity) {
		        return super.updateById(entity);
	}
	
	@Override
	public Result selectList(int pageNum,int pageSize) {
		try {
		   List<com.metaShare.modules.generate.entity.b> listInfo = this.selectList(null);
		    int total = listInfo.size();
		    PageDTO pageDTO = new PageTool<com.metaShare.modules.generate.entity.b>().getPage(listInfo, pageSize, pageNum);
		    return Result.resultInfo(ResultCode.SUCCESS,total,pageDTO.getData());
		} catch (Exception e) {
		    e.printStackTrace();
		    return Result.resultInfo(ResultCode.FAILURE,"获取列表数据失败");
		}
	}
}
