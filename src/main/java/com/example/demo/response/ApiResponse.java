package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    
    private String message;
    T data;
    
    public static <T> ApiResponse<T> success(String message, T data){
    	return new ApiResponse<T>(message, data);
    }
	
    public static <T> ApiResponse<T> error(String message){
    	return new ApiResponse<T>(message, null);
    }
}
