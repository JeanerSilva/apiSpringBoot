package com.example.apidemo.apidemo.Response;
import com.example.apidemo.apidemo.Product.Product;
import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

public class Response {    
    
    public Response() {}

    public Response (HttpStatus httpCode, String menssage, Product product) {
        this.httpCode = httpCode;
        this. menssage = menssage;
        this. product = product;
    }

    @Getter @Setter private HttpStatus httpCode;
    @Getter @Setter private String menssage;
    @Getter @Setter private Product product;
}
