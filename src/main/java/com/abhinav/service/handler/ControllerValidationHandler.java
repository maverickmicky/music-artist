package com.abhinav.service.handler;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.abhinav.service.exception.ServiceException;

@ControllerAdvice
public class ControllerValidationHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerValidationHandler.class);

	@Autowired
	private MessageSource msgSource;

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageDTO processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();

		return processFieldError(error.getDefaultMessage());
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String processConstraintValidationError(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		for (ConstraintViolation<?> violation : violations) {
			 return processFieldError(violation.getMessage()).getMessage();
		}
		return processFieldError("something.went.wrong").getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(value = ServiceException.class) 
	@ResponseBody
    public String handlePlayerServiceException(ServiceException e){  
        return processFieldError(e.getMessage()).getMessage();
    }
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)  
    @ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
    public String handleNullPointerException(NullPointerException e){  
		LOGGER.error(e.getMessage());
        return processFieldError("resource.not.found").getMessage();
    } 

	private MessageDTO processFieldError(String errorMsg) {
		MessageDTO message = null;
		if (!StringUtils.isEmpty(errorMsg)) {
			Locale currentLocale = LocaleContextHolder.getLocale();
			String msg = msgSource.getMessage(errorMsg, null, currentLocale);
			message = new MessageDTO(MessageType.ERROR, msg);
		}
		return message;
	}

}
