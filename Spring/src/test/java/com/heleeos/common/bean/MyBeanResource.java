package com.heleeos.common.bean;

import java.nio.charset.Charset;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import com.heleeos.util.TimeUtil;

public class MyBeanResource {

    public Resource resource;
    
    public Resource getResource() {
        return resource;
    }
    
    public void setResource(Resource resource) {
        this.resource = resource;
    }  
    
    public String toHtml() {
        try {
            String template = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
            if(StringUtils.trimToNull(template) == null) return null;
            String html = template.replaceAll("\\{\\{name\\}\\}", "Heleeos")
                                  .replaceAll("\\{\\{date\\}\\}", TimeUtil.getNow());
            return html;
        } catch (Exception e) {}
        return null;
    }
}
