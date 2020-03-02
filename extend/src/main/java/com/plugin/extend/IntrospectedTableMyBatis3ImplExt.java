package com.plugin.extend;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

public class IntrospectedTableMyBatis3ImplExt
        extends IntrospectedTableMyBatis3Impl
{
    public List<GeneratedXmlFile> getGeneratedXmlFiles() {
        List<GeneratedXmlFile> answer = new ArrayList<>();

        if (this.xmlMapperGenerator != null) {
            Document document = this.xmlMapperGenerator.getDocument();
            boolean mergeable = false;
            if ("true".equalsIgnoreCase(this.context.getProperty("mergeable"))) {
                mergeable = true;
            }



            GeneratedXmlFile gxf = new GeneratedXmlFile(document, getMyBatis3XmlMapperFileName(), getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), mergeable, this.context.getXmlFormatter());

            if (this.context.getPlugins().sqlMapGenerated(gxf, (IntrospectedTable)this)) {
                answer.add(gxf);
            }
        }

        return answer;
    }
}
