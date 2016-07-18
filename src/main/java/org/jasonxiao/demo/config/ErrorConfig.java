package org.jasonxiao.demo.config;

import org.jasonxiao.demo.exception.GenericException;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * Created by Jason on 2/5/16.
 */
@Configuration
public class ErrorConfig {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {

            @Override
            public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
                System.out.println("get error attributes");
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
                Throwable error = super.getError(requestAttributes);
                if (error != null && error instanceof GenericException) {
                    errorAttributes.put("code", ((GenericException) error).getCode());
                    errorAttributes.put("message", error.getMessage());
                }
                return errorAttributes;
            }

        };
    }
}
