package com.natsucloud.sys.mapper;

import com.natsucloud.common.multidb.DataSource;
import com.natsucloud.common.multidb.DataSourceType;
import com.natsucloud.sys.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author moqishu
 * @since 2020-04-15
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectUserList();

}
