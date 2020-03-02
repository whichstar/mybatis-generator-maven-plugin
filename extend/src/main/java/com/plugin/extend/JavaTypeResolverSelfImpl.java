package com.plugin.extend;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;


public class JavaTypeResolverSelfImpl
        extends JavaTypeResolverDefaultImpl {
    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        String answer;
        JavaTypeResolverDefaultImpl.JdbcTypeInformation jdbcTypeInformation = (JavaTypeResolverDefaultImpl.JdbcTypeInformation) this.typeMap.get(Integer.valueOf(introspectedColumn.getJdbcType()));
        if (jdbcTypeInformation == null) {
            switch (introspectedColumn.getJdbcType()) {
                case 3:
                    answer = "DECIMAL";


                    return answer;
                case 2:
                    answer = "NUMERIC";
                    return answer;
                case 91:
                    answer = "TIMESTAMP";
                    return answer;
            }
            answer = null;
        } else if (jdbcTypeInformation.getJdbcTypeName().equals("DATE")) {
            answer = "TIMESTAMP";
        } else {
            answer = jdbcTypeInformation.getJdbcTypeName();
        }
        return answer;
    }
}
