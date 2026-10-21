package com.fogsbridge.yogurt.server.common.context;

/**
 * 认证上下文 Holder
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class AuthContextHolder {
    private static final ThreadLocal<AuthContext> HOLDER = new ThreadLocal<>();

    private AuthContextHolder() {}

    public static void set(AuthContext context) {
        HOLDER.set(context);
    }

    public static AuthContext get() {
        return HOLDER.get(); 
    }

    public static Long getUserId() {
        AuthContext context = HOLDER.get();
        return context != null ? context.getUserId() : null;
    }

    public static String getToken() {
        AuthContext context = HOLDER.get();
        return context == null ? null : context.getToken();
    }

    public static void clear() {
        HOLDER.remove();
    }
}