package com.metaShare.modules.generate.controller;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.*;import com.metaShare.common.tool.state.Result;import com.metaShare.common.tool.state.ResultCode;import com.metaShare.common.utils.StringUtils;import com.metaShare.modules.BaseController;import com.metaShare.modules.sys.entity.SysDicinfo;import com.metaShare.modules.sys.service.SysDictService;import java.util.List;
@Controller
@CrossOrigin
@RequestMapping(value="/api/generate/staff")
public class staffController extends BaseController {
	@Autowired
	private com.metaShare.modules.generate.service.staffService staffService;
	
	@Autowired
	SysDictService sysDictService;
	
		@ResponseBody
		@RequestMapping(value = "/save", method = { RequestMethod.POST })
		public Result save(com.metaShare.modules.generate.entity.staff staff){
			try {
	            staff = this.appendRefInfo(staff);
				boolean flag =   staffService.insert(staff);
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
		public Result update(com.metaShare.modules.generate.entity.staff staff){
			try {
	            staff = this.appendRefInfo(staff);
	            boolean flag =   staffService.updateById(staff);
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
				boolean flag =   staffService.deleteById(id);
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
				com.metaShare.modules.generate.entity.staff  staff =  staffService.selectById(id);
				return Result.resultInfo(ResultCode.SUCCESS,staff);
	       } catch (Exception e) {
	           e.printStackTrace();
	           return Result.resultInfo(ResultCode.FAILURE,"获取数据失败");
	       }
		}
	
		@ResponseBody
		@RequestMapping(value = "/list", method = { RequestMethod.POST })
		public Result list(int pageNum, int pageSize) {
			try {
				return  staffService.selectList(pageNum,pageSize);
	       } catch (Exception e) {
	           e.printStackTrace();
	           return Result.resultInfo(ResultCode.FAILURE,"获取列表失败");
	        }
		}
	
	    @ResponseBody
	    @RequestMapping(value = "/allList", method = { RequestMethod.POST })
	    public Result allList() {
	        try {
				List<com.metaShare.modules.generate.entity.staff> staffList =    staffService.selectList(null);
				return Result.resultInfo(ResultCode.SUCCESS,staffList);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Result.resultInfo(ResultCode.FAILURE,"获取列表数据失败");
	        }
	    }
	
		private com.metaShare.modules.generate.entity.staff appendRefInfo(com.metaShare.modules.generate.entity.staff staff){
	        try {
	                if(staff!=null) {
	                }
	                return staff; 
	        } catch (Exception e) {
	                e.printStackTrace();
	                throw e;
	        }
	    }
	
}
