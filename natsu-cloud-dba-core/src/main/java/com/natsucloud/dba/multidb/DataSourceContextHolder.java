package com.natsucloud.dba.multidb;

public class DataSourceContextHolder {

    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     *  所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源变量
     * @param type
     */
    public static void setDataSourceType(DataSourceType type) {
        contextHolder.set(type);
    }

    /**
     * 获取当前线程的数据源路由的key
     *
     */
    public static DataSourceType getDataSourceType() {
        return contextHolder.get();
    }

    /**
     * 删除与当前线程绑定的数据源路由的key
     *
     */
    public static void removeDatabaseType() {
        contextHolder.remove();
    }
}
