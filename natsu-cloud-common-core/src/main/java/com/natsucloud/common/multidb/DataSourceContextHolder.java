package com.natsucloud.common.multidb;

public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType type) {
        contextHolder.set(type);
    }

    /**
     * 获取当前线程的数据源路由的key
     *
     * @return
     */
    public static DataSourceType getDataSourceType() {
        return contextHolder.get();
    }

    /**
     * 删除与当前线程绑定的数据源路由的key
     */
    public static void removeDatabaseType() {
        contextHolder.remove();
    }
}
