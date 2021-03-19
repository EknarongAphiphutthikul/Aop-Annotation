package com.example.aop.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Request1Model implements Serializable{

	private static final long serialVersionUID = -6858156804090412657L;
	private String header;
	private String req1;

}
