package io.github.CarolinaCedro.sumaxSoft.aplication.errors.view;

import io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.response.ErrorResult;
import io.github.CarolinaCedro.sumaxSoft.aplication.errors.view.response.SuccessResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ApiResultContranstViolation {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static ApiResultContranstViolation success(Object data){
        return new SuccessResult(data);
    }

    public static ApiResultContranstViolation error(String code, String errorMessage){
        return new ErrorResult(code,errorMessage);
    }
}
