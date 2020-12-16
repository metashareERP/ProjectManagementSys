package com.metaShare.modules.generate.controller;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.*;import com.metaShare.common.tool.state.Result;import com.metaShare.common.tool.state.ResultCode;import com.metaShare.common.utils.StringUtils;import com.metaShare.modules.BaseController;import com.metaShare.modules.sys.entity.SysDicinfo;import com.metaShare.modules.sys.service.SysDictService;import java.util.List;
@Controller
@CrossOrigin
@RequestMapping(value="/api/generate/b")
public class bController extends BaseController {
	@Autowired
	private com.metaShare.modules.generate.service.bService bService;
	
	@Autowired
	private com.metaShare.modules.generate.service.taskService  taskService;
	
	@Autowired
	private com.metaShare.modules.generate.service.projectService  projectService;
	
	@Autowired
	SysDictService sysDictService;
	
		@ResponseBody
		@RequestMapping(value = "/save", method = { RequestMethod.POST })
		public Result save(com.metaShare.modules.generate.entity.b b){
			try {
	            b = this.appendRefInfo(b);
				boolean flag =   bService.insert(b);
				if(flag){
					return Result.resultInfo(ResultCode.SUCCESS,"保存成功");
				}else{
					return Result.resultInfo(ResultCode.FAILURE,"保存失败");
				}
			} catch (Exception e) {
	           e.printStackTrace();
	           return Result.resultInfo(ResultCode.FAILURE,"保存失败");
	        }
	    }
	
		@ResponseBody
		@RequestMapping(value = "/update", method = { RequestMethod.POST })
		public Result update(com.metaShare.modules.generate.entity.b b){
			try {
	            b = this.appendRefInfo(b);
	            boolean flag =   bService.updateById(b);
	            if(flag){
	                return Result.resultInfo(ResultCode.SUCCESS,"编辑成功");
	            }else{
	                return Result.resultInfo(ResultCode.FAILURE,"编辑失败");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Result.resultInfo(ResultCode.FAILURE,"编辑失败");
	        }
	    }
	
		@ResponseBody
		@RequestMapping(value = "/del", method = { RequestMethod.POST })
		public Result del(String id) {
			try {
				boolean flag =   bService.deleteById(id);
				if(flag){
					return Result.resultInfo(ResultCode.SUCCESS,"删除成功");
				}else{
					return Result.resultInfo(ResultCode.FAILURE,"删除失败");
				}
	       } catch (Exception e) {
	           e.printStackTrace();
	           return Result.resultInfo(ResultCode.FAILURE,"删除失败");
	        }
		}
	
		@ResponseBody
		@RequestMapping(value = "/getInfo")
		public Result getInfo(String id) {
			try {
				com.metaShare.modules.generate.entity.b  b =  bService.selectById(id);
				return Result.resultInfo(ResultCode.SUCCESS,b);
	       } catch (Exception e) {
	           e.printStackTrace();
	           return Result.resultInfo(ResultCode.FAILURE,"获取数据失败");
	       }
		}
	
		@ResponseBody
		@RequestMapping(value = "/list", method = { RequestMethod.POST })
		public Result list(int pageNum, int pageSize) {
			try {
				return  bService.selectList(pageNum,pageSize);
	       } catch (Exception e) {
	           e.printStackTrace();
	           return Result.resultInfo(ResultCode.FAILURE,"获取列表失败");
	        }
		}
	
	    @ResponseBody
	    @RequestMapping(value = "/allList", method = { RequestMethod.POST })
	    public Result allList() {
	        try {
				List<com.metaShare.modules.generate.entity.b> bList =    bService.selectList(null);
				return Result.resultInfo(ResultCode.SUCCESS,bList);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Result.resultInfo(ResultCode.FAILURE,"获取列表数据失败");
	        }
	    }
	
		private com.metaShare.modules.generate.entity.b appendRefInfo(com.metaShare.modules.generate.entity.b b){
	        try {
	                if(b!=null) {
						if (StringUtils.isNotEmpty(b.gettaskId())) {						 com.metaShare.modules.generate.entity.task task =taskService.selectById(b.gettaskId());						if (task != null) {							b.settaskName(task.getName());						}					}					
						if (StringUtils.isNotEmpty(b.getprojectId())) {						 com.metaShare.modules.generate.entity.project project =projectService.selectById(b.getprojectId());						if (project != null) {							b.setprojectName(project.getName());						}					}					
	                }
	                return b; 
	        } catch (Exception e) {
	                e.printStackTrace();
	                throw e;
	        }
	    }
	
}
