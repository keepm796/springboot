package com.aaa.controller;

import com.aaa.exceptions.ParamsException;
import com.aaa.query.KUserQuery;
import com.aaa.service.KuserService;
import com.aaa.vo.Kuser;
import com.aaa.vo.ResultInfo;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("user")
public class KuserController {

    @Autowired
    private KuserService kuserService;

    @GetMapping("byname/{kname}")
    @ApiOperation(value = "根据用户名查询用户记录")
    @ApiImplicitParam(name = "userName",value = "查询参数",required = true,paramType = "path")
    public Kuser queryKuserByKname(@PathVariable String kname){
        return kuserService.queryKuserByKname(kname);
    }

    @GetMapping("byid/{kno}")
    @ApiOperation(value = "根据用户id查询用户记录")
    @ApiImplicitParam(name = "userId",value = "查询参数",required = true,paramType = "path")
    public Kuser queryById(@PathVariable Integer kno){
        return kuserService.queryById(kno);
    }

    @PostMapping("kuser")
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
    public List<Kuser> query(){
        return kuserService.query();
    }

    @GetMapping("list")
    public PageInfo<Kuser> list(KUserQuery kUserQuery){
        return kuserService.selectByParams(kUserQuery);
    }

}
