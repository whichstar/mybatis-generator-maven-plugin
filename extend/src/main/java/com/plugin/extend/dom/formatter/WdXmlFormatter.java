package com.plugin.extend.dom.formatter;

import org.mybatis.generator.api.dom.DefaultXmlFormatter;
import org.mybatis.generator.api.dom.xml.Document;

public class WdXmlFormatter
        extends DefaultXmlFormatter {
    public String getFormattedContent(Document document) {
        String content = document.getFormattedContent();
        try {
            if ("true".equalsIgnoreCase(this.context.getProperty("suppressColumnType")))
                content = content.replaceAll("[, ]?jdbcType=\"?[A-Z]+\"?", "");
            content = content.replaceAll("  ", "    ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
}