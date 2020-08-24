package com.natsucloud.sys.service.impl;

import com.natsucloud.dba.multidb.DataSource;
import com.natsucloud.dba.multidb.DataSourceType;
import com.natsucloud.sys.entity.SysUser;
import com.natsucloud.sys.mapper.SysUserMapper;
import com.natsucloud.sys.service.ISysUserService;
import com.natsucloud.dba.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author moqishu
 * @since 2020-04-15
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @DataSource(DataSourceType.MASTER)
    public void get(){
       List<SysUser> sss = baseMapper.selectUserList();
    }

}
