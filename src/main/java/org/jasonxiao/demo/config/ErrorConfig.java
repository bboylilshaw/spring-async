package org.jasonxiao.demo.config;

import org.jasonxiao.demo.exception.GeneralException;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.RequestDispatcher;
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
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
                Object exception = requestAttributes.getAttribute(RequestDispatcher.ERROR_EXCEPTION, RequestAttributes.SCOPE_REQUEST);
                if (exception != null && exception instanceof Exception) {
                    if (((Exception) exception).getCause() instanceof GeneralException) {
                        GeneralException e = (GeneralException) ((Exception) exception).getCause();
                        errorAttributes.put("code", e.getCode());
                    }
                }
                return errorAttributes;
            }

        };
    }

}
