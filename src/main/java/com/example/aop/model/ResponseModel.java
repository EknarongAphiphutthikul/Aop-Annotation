package com.example.aop.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel implements Serializable {
	
	private static final long serialVersionUID = -2287390467531652300L;
	private String msg;

}
