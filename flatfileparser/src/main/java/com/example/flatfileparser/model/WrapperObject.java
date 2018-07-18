package com.example.flatfileparser.model;

import org.beanio.annotation.Group;
import org.beanio.annotation.Record;

import java.util.List;

@Group
public class WrapperObject {

    @Group
    private List<RecordObject> recordObjectList;
    @Record
    private List<TX52> tx52s;

    public List<RecordObject> getRecordObjectList() {
        return recordObjectList;
    }

    public void setRecordObjectList(List<RecordObject> recordObjectList) {
        this.recordObjectList = recordObjectList;
    }

    public List<TX52> getTx52s() {
        return tx52s;
    }

    public void setTx52s(List<TX52> tx52s) {
        this.tx52s = tx52s;
    }

    @Override
    public String toString() {
        return String.valueOf(getRecordObjectList()) + String.valueOf(getTx52s());
    }
}