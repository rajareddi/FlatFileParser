package com.example.flatfileparser.model;

import org.beanio.annotation.Group;
import org.beanio.annotation.Record;

import java.util.List;

public class RecordObject {
    @Group(collection = List.class,minOccurs = 1)
    List<HeaderRecord> headerRecords;
    @Record(collection = List.class)
    List<TX57> tx57s;

    public List<HeaderRecord> getHeaderRecords() {
        return headerRecords;
    }

    public void setHeaderRecords(List<HeaderRecord> headerRecords) {
        this.headerRecords = headerRecords;
    }

    public List<TX57> getTx57s() {
        return tx57s;
    }

    public void setTx57s(List<TX57> tx57s) {
        this.tx57s = tx57s;
    }

    @Override
    public String toString() {
        return String.valueOf(getHeaderRecords()) + String.valueOf(getTx57s());
    }

}
