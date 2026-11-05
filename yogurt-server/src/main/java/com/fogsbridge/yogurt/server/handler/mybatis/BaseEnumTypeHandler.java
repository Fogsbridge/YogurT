package com.fogsbridge.yogurt.server.handler.mybatis;

import com.fogsbridge.yogurt.server.common.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 通用枚举类型处理器
 * <p>
 * 实现了 {@link BaseEnum} 接口的枚举类型，存取采用 {@link BaseEnum#getValue()} 方法的返回值
 * <p>
 * 未实现 {@link BaseEnum} 接口的普通枚举类型，委托给 MyBatis 内置默认的 {@link EnumTypeHandler} 处理
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class BaseEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
    private final E[] enums;
    private final boolean isBaseEnum;
    private final EnumTypeHandler<E> delegate;

    public BaseEnumTypeHandler(Class<E> type) {
        this.isBaseEnum = BaseEnum.class.isAssignableFrom(type);
        this.enums = this.isBaseEnum ? type.getEnumConstants() : null;
        this.delegate = this.isBaseEnum ? null : new EnumTypeHandler<>(type);
    }

    private E convert(Object dbValue) {
        if (dbValue == null) {
            return null;
        }
        for (E e : enums) {
            Object enumValue = ((BaseEnum<?>) e).getValue();
            if (enumValue != null && enumValue.equals(dbValue)) {
                return e;
            }
            if (String.valueOf(enumValue).equals(String.valueOf(dbValue))) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("字段值 %s 无法解析为 %s", dbValue, enums.getClass().getTypeName()));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (!isBaseEnum) {
            delegate.setNonNullParameter(ps, i, parameter, jdbcType);
            return;
        }
        ps.setObject(i, ((BaseEnum<?>) parameter).getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (!isBaseEnum) {
            return delegate.getNullableResult(rs, columnName);
        }
        return convert(rs.getObject(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (!isBaseEnum) {
            return delegate.getNullableResult(rs, columnIndex);
        }
        return convert(rs.getObject(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (!isBaseEnum) {
            return delegate.getNullableResult(cs, columnIndex);
        }
        return convert(cs.getObject(columnIndex));
    }
}
