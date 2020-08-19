package com.natsucloud.sys.service;

import com.natsucloud.sys.entity.SysUser;
import com.natsucloud.common.mybatis.service.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author moqishu
 * @since 2020-04-15
 */
public interface ISysUserService extends IBaseService<SysUser> {

    void get();

}
