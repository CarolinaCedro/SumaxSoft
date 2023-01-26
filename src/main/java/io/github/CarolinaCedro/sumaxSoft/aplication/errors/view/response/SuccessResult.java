package io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.response;


import io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.ApiResultContranstViolation;

public class SuccessResult extends ApiResultContranstViolation {

    public SuccessResult(){}

    public SuccessResult(Object data) {
        super.setCode("success");
        this.data = data;
    }

    private Object data;

    public Object getData() {
        return data;
    }

}