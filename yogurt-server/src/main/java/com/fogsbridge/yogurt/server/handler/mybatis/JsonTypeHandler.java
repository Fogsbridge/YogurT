package com.fogsbridge.yogurt.server.handler.mybatis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JSON 类型处理器
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {
    private final ObjectMapper MAPPER = new ObjectMapper();

    private final Class<T> type;

    public JsonTypeHandler(Class<T> type) {
        this.type = type;
    }

    private T convert(String json) {
        if (json == null || json.isBlank()) {
            return null;
        }
        try {
            return MAPPER.readValue(json, type);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("字段值 %s 反序列化为 %s 失败", json, type.getTypeName()), e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, MAPPER.writeValueAsString(parameter));
        } catch (Exception e) {
            throw new SQLException(String.format("%s 序列化为 JSON 失败", parameter.getClass().getTypeName()), e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getString(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getString(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getString(columnIndex));
    }
}
