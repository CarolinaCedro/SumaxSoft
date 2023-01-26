package io.github.CarolinaCedro.sumaxSoft.aplication.errors;

import io.github.CarolinaCedro.sumaxSoft.aplication.errors.exception.CustomException;
import io.github.CarolinaCedro.sumaxSoft.aplication.errors.exception.ExceptionManager;
import io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.ApiErrors;
import io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.ApiResultContranstViolation;
import org.hibernate.ObjectNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @Resource
    ExceptionManager exceptionManager;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrorMethodArgumentNotValidadeException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ApiErrors(messages);
    }


    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleResponseStatusException(ResponseStatusException ex){
        String mensagemError = ex.getMessage();
        return new ApiErrors(mensagemError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResultContranstViolation constraintViolationException(ConstraintViolationException e) {
        String code = "";
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
        if (iterator.hasNext()) {
            code = (iterator.next()).getMessage();
        }
        CustomException exception = exceptionManager.create(code);
        return ApiResultContranstViolation
                .error(exception.getCode(), exception.getMessage());
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleDataIntegratyViolation(DataIntegrityViolationException ex){
        String mensagemError = "Error: Database duplicate data error";
        return new ApiErrors(mensagemError);
    }


}