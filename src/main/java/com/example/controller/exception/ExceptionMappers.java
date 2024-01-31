package com.example.controller.exception;

import com.example.exception.UrlNotFoundException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<ErrorResponse> mapException(UrlNotFoundException exception) {
        var errorResponse = new ErrorResponse(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404",
                "Not Found",
                exception.getMessage()
        );

        return RestResponse.status(RestResponse.Status.NOT_FOUND, errorResponse);
    }

}
