package com.example.ecommerceweb.exceptions;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentNotValidException.class})
    @ResponseStatus(BAD_REQUEST)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    name = "Handle exception when the data invalid. (@RequestBody, @RequestParam, @PathVariable)",
                                    summary = "Handle Bad Request",
                                    value = """
                                            {
                                                 "timestamp": "2024-04-07T11:38:56.368+00:00",
                                                 "status": 400,
                                                 "path": "/api/v1/...",
                                                 "error": "Invalid Payload",
                                                 "message": "{data} must be not blank|null|valid"
                                             }
                                            """
                            ))})
    })
    public ErrorResponse handleValidationException(Exception e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(BAD_REQUEST.value());
        errorResponse.setPath(request.getDescription(false).replace("uri=", ""));

        String message = e.getMessage();
        if (e instanceof MethodArgumentNotValidException) {
            int start = message.lastIndexOf("[") + 1;
            int end = message.lastIndexOf("]") - 1;
            message = message.substring(start, end);
            errorResponse.setError("Invalid Payload");
            errorResponse.setMessage(message);
        } else if (e instanceof MissingServletRequestParameterException) {
            errorResponse.setError("Invalid Parameter");
            errorResponse.setMessage(message);
        } else if (e instanceof ConstraintViolationException) {
            errorResponse.setError("Invalid Parameter");
            errorResponse.setMessage(message.substring(message.indexOf(" ") + 1));
        } else {
            errorResponse.setError("Invalid Data");
            errorResponse.setMessage(message);
        }

        return errorResponse;
    }

}
