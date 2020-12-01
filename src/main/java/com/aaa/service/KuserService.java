package com.aaa.service;

import com.aaa.dao.KuserDao;
import com.aaa.query.KUserQuery;
import com.aaa.utils.AssertUtil;
import com.aaa.vo.Kuser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 17:37
 **/
@Service
public class KuserService {
    @Autowired
    private KuserDao kuserDao;

    public Kuser queryKuserByKname(String kname){
        return kuserDao.queryKuserByKname(kname);
    }

    public Kuser queryById(Integer kno){
        return kuserDao.queryById(kno);
    }

    /**
     * 新增涉及到参数的校验
     * @param kuser
     * StringUtils.isBlank的意思 是否为空
     * 如果kuser.getKname()没拿到数据就为true 执行异常
     */
    public void save(Kuser kuser){
        AssertUtil.isTrue(StringUtils.isBlank(kuser.getKname()),"用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(kuser.getKpassword()),"用户密码不能为空！");
        Kuser kuser1 = kuserDao.queryKuserByKname(kuser.getKname());
        AssertUtil.isTrue(null != kuser1,"用户名已存在");
        AssertUtil.isTrue(kuserDao.save(kuser)<1,"用户记录添加失败");
    }

    public void update(Kuser kuser){
        AssertUtil.isTrue(StringUtils.isBlank(kuser.getKname()),"用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(kuser.getKpassword()),"用户密码不能为空！");
        AssertUtil.isTrue(null == kuserDao.queryById(kuser.getKno()),"该用户不存在");
        //用户名唯一校验
        Kuser kuser1 = kuserDao.queryKuserByKname(kuser.getKname());
        AssertUtil.isTrue(null != kuser1 && !(kuser1.getKno().equals(kuser.getKno())),"用户已存在");
        AssertUtil.isTrue(kuserDao.update(kuser)<0,"修改失败");
    }

   /* public int delete(Integer kno){
        if (kno != null){
           return kuserDao.delete(kno);
        }
        return -1;
    }*/

   public void delete(Integer kno){
       AssertUtil.isTrue(null == kno || null == kuserDao.queryById(kno),"待删除记录不存在");
       AssertUtil.isTrue(kuserDao.delete(kno)<0,"用户删除失败");
   }

   public List<Kuser> query(){
       return kuserDao.query();
   }

   public PageInfo<Kuser> selectByParams(KUserQuery kUserQuery){
       PageHelper.startPage(kUserQuery.getPageNum(),kUserQuery.getPageSize());
       return new PageInfo<Kuser>(kuserDao.selectByParams(kUserQuery));
   }
}
