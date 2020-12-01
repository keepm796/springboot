package com.aaa.dao;

import com.aaa.query.KUserQuery;
import com.aaa.vo.Kuser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 17:23
 **/
@Repository
public interface KuserDao {

    public List<Kuser> query();

    public Kuser queryKuserByKname(String kname);

    // 通过用户ID查询用户
    public Kuser queryById(Integer kno);

    public int save(Kuser kuser);

    public int update(Kuser kuser);

    public List<Kuser> selectByParams(KUserQuery kUserQuery);

    public int delete(Integer kno);

}
