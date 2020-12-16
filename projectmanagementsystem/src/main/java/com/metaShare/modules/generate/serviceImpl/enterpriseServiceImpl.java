package com.metaShare.modules.generate.serviceImpl;


@Service
public class enterpriseServiceImpl extends ServiceImpl<com.metaShare.modules.generate.dao.enterpriseDao,com.metaShare.modules.generate.entity.enterprise> implements com.metaShare.modules.generate.service.enterpriseService {
	
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public boolean insert(com.metaShare.modules.generate.entity.enterprise entity) {
		return super.insert(entity);
	}
	
	@Override
	public boolean updateById(com.metaShare.modules.generate.entity.enterprise entity) {
		        return super.updateById(entity);
	}
	
	@Override
	public Result selectList(int pageNum,int pageSize) {
		try {
		   List<com.metaShare.modules.generate.entity.enterprise> listInfo = this.selectList(null);
		    int total = listInfo.size();
		    PageDTO pageDTO = new PageTool<com.metaShare.modules.generate.entity.enterprise>().getPage(listInfo, pageSize, pageNum);
		    return Result.resultInfo(ResultCode.SUCCESS,total,pageDTO.getData());
		} catch (Exception e) {
		    e.printStackTrace();
		    return Result.resultInfo(ResultCode.FAILURE,"获取列表数据失败");
		}
	}
}