package com.example.flatfileparser.model;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(maxLength = 71, name = "TX57")
public class TX57 {

	@Field(ordinal = 0, at = 0, length = 2, rid = true, literal = "57", trim = true, required = true)
	private int id;
	@Field(ordinal = 1, at = 2, length = 4, trim = true)
	private int number;

	@Override
	public String toString() {
		return new StringBuilder().append("Record Type = ").append(id).append(", Store Number = ").append(number)
				.append("\n").toString();
	}

}