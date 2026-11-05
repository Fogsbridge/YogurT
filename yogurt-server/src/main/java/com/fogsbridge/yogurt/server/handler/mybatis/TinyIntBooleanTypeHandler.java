package com.fogsbridge.yogurt.server.handler.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TINYINT Boolean 类型处理器
 * <p>
 * 表字段类型 {@code TINYINT} 与 Java 类型 {@code Boolean} 的双向转换
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class TinyIntBooleanTypeHandler extends BaseTypeHandler<Boolean> {
    private Boolean convert(Object dbValue) {
        if (dbValue == null) {
            return null;
        }
        if (dbValue instanceof Number num) {
            int i = num.intValue();
            if (!(i == 1 || i == 0)) {
                throw new IllegalArgumentException(String.format("字段值 %s 无法解析为 %s，应为 0 或 1", dbValue, Boolean.class.getTypeName()));
            }
            return i == 1;
        }
        throw new IllegalArgumentException(String.format("字段值 %s 无法解析为 %s", dbValue, Boolean.class.getTypeName()));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, Boolean.TRUE.equals(parameter) ? 1 : 0);
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getObject(columnName));
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getObject(columnIndex));
    }

    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getObject(columnIndex));
    }
}
