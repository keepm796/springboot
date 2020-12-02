package com.aaa.controller;

import com.aaa.exceptions.ParamsException;
import com.aaa.query.KUserQuery;
import com.aaa.service.KuserService;
import com.aaa.vo.Kuser;
import com.aaa.vo.ResultInfo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 19:04
 **/
@RestController
@Api(tags = "用户管理模块 - 基本数据维护")
public class KuserController {

    @Autowired
    private KuserService kuserService;

    @GetMapping("byname/{kname}")
    @ApiOperation(value = "根据用户名查询用户记录")
    @ApiImplicitParam(name = "kname",value = "用户名称",required = true,paramType = "path")
    public Kuser queryKuserByKname(@PathVariable String kname){
        return kuserService.queryKuserByKname(kname);
    }

    @GetMapping("byid/{kno}")
    @ApiOperation(value = "根据用户id查询用户记录")
    @ApiImplicitParam(name = "kno",value = "用户id",required = true,paramType = "path")
    public Kuser queryById(@PathVariable Integer kno){
        return kuserService.queryById(kno);
    }

    @PostMapping("kuser")
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "kuser",value = "用户实体",dataType = "Kuser")
    public ResultInfo save(@RequestBody Kuser kuser){
        ResultInfo resultInfo = new ResultInfo();
        try {
            kuserService.save(kuser);
        } catch (ParamsException e) {
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg("记录添加失败");
        }
        return resultInfo;
    }
    @PutMapping("kuser")
    @ApiOperation(value = "修改用户")
    @ApiImplicitParam(name = "kuser",value = "用户实体",dataType = "Kuser")
    public ResultInfo update(@RequestBody Kuser kuser){
        ResultInfo resultInfo = new ResultInfo();
        try {
            kuserService.update(kuser);
        } catch (ParamsException e) {
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg("记录修改失败");
        }
        return resultInfo;
    }

    /*@DeleteMapping("kuser/{kno}")
    public int delete(@PathVariable Integer kno){
        return kuserService.delete(kno);
    }*/

    @DeleteMapping("kuser/{kno}")
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "kno",value = "通过id删除",required = true,paramType = "path")
    public ResultInfo delete(@PathVariable Integer kno){
        ResultInfo resultInfo = new ResultInfo();
        try {
            kuserService.delete(kno);
        } catch (ParamsException e) {
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setCode(300);
            resultInfo.setMsg("记录修改失败");
        }
        return resultInfo;
    }

    @RequestMapping("query")
    @ApiOperation(value = "查询所有用户信息")
    public List<Kuser> query(){
        return kuserService.query();
    }

    @GetMapping("list")
    @ApiOperation(value = "分页条件查询")
    @ApiImplicitParam(name = "kUserQuery",value = "用户查询类",dataType = "KUserQuery")
    public PageInfo<Kuser> list(KUserQuery kUserQuery){
        return kuserService.selectByParams(kUserQuery);
    }

}
