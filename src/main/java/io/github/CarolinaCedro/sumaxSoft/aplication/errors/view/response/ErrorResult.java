package io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.response;


import io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.ApiResultContranstViolation;

public class ErrorResult extends ApiResultContranstViolation {

    public ErrorResult(){}

    public ErrorResult(String code,String errorMessage) {
        super.setCode(code);
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

}