package com.ayseozcan.SBstart.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> hatalariYakalayanBenim(Exception ex) {
        String olusanHata = ex.toString();
        return new ResponseEntity<>(createErrorMessage(ex,ErrorType.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DepartmanNotFoundException.class})
    public ResponseEntity<Object> handleDepartmanNotFoundException(DepartmanNotFoundException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        SBstartException sBstartException = new SBstartException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(sBstartException, badRequest);
    }
    @ExceptionHandler(SBstartException2.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> SBstartException2Handler(SBstartException2 ex){
        return new ResponseEntity<>(createErrorMessage(ex,ex.getErrorType()), ex.getErrorType().getHttpStatus());
    }

    /**
     * Tum hatalar belli bir method uzerinde geldigi icin ek kodlamalar yapmadan tek bir yerden olusan
     * hatalarin loglanmasi ve veritabanina kayit edilmesini kolaylastirir.
     */
    private ErrorMessage createErrorMessage(Exception ex, ErrorType errorType){
        System.out.println("hata olustu...." +
                System.currentTimeMillis() + " - " + ex.toString());
        return ErrorMessage.builder()
                .message(errorType.getMessage())
                .code(errorType.getCode())
                .build();
    }
}
