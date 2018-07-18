package com.example.flatfileparser.model;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(maxLength = 31, name = "TX67")
public class TX67 {
    @Field(ordinal = 0, at = 0, length = 2, rid = true, literal = "67", trim = true)
    private int id;
    @Field(ordinal = 1, at = 2, length = 4, trim = true)
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Record Type = ").append(id)
                .append(", Store Number = ").append(number).append("\n").toString();
    }
}
