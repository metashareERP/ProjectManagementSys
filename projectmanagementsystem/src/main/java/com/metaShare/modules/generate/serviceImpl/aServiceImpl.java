package com.metaShare.modules.generate.serviceImpl;


@Service
public class aServiceImpl extends ServiceImpl<com.metaShare.modules.generate.dao.aDao,com.metaShare.modules.generate.entity.a> implements com.metaShare.modules.generate.service.aService {
	
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public boolean insert(com.metaShare.modules.generate.entity.a entity) {
		return super.insert(entity);
	}
	
	@Override
	public boolean updateById(com.metaShare.modules.generate.entity.a entity) {
		        return super.updateById(entity);
	}
	
	@Override
	public Result selectList(int pageNum,int pageSize) {
		try {
		   List<com.metaShare.modules.generate.entity.a> listInfo = this.selectList(null);
		    int total = listInfo.size();
		    PageDTO pageDTO = new PageTool<com.metaShare.modules.generate.entity.a>().getPage(listInfo, pageSize, pageNum);
		    return Result.resultInfo(ResultCode.SUCCESS,total,pageDTO.getData());
		} catch (Exception e) {
		    e.printStackTrace();
		    return Result.resultInfo(ResultCode.FAILURE,"获取列表数据失败");
		}
	}
}