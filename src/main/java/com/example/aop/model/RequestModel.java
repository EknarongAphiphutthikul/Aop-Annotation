package com.example.aop.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestModel implements Serializable {
	
	private static final long serialVersionUID = 6053510193796207624L;
	private String header;
}
