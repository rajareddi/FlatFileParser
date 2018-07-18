package com.example.flatfileparser.service;

import com.example.flatfileparser.model.WrapperObject;
import org.beanio.BeanReader;
import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.StreamFactory;
import org.beanio.builder.*;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FlatFileParserService {

    public void getFile() throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        InputStream payload = new FileInputStream(new File("C:\\Workspace\\flatfileparser\\src\\main\\resources\\sampleFile.txt"));
        createFixedLengthFile(payload);
        long endTime = System.currentTimeMillis();
        long totalTime = ((endTime - startTime) / 1000) % 60;
        System.out.println("Time Taken" + (endTime - startTime));
        System.out.println("Sec taken" + totalTime);
    }

    public void createFixedLengthFile(InputStream payload) {
        Class[] groupClassList = new Class[]{WrapperObject.class};
        BeanReader beanReader = createBeanReader(null, "fixedlength", null, groupClassList, payload);
        Object record = null;
        long count = 0;
        while ((record = beanReader.read()) != null) {
            count = count + 1;
            System.out.println(record.toString());
        }
        System.out.println("Count" + count);
    }


    public BeanReader createBeanReader(String streamName, String format, Class[] recordList, Class[] groupList, InputStream payLoad) {
        StreamFactory factory = StreamFactory.newInstance();
        if (streamName == null) {
            streamName = "IntegrationStream";
        }
        StreamBuilder streamBuilder = new StreamBuilder(streamName).format(format);
        if ("fixedlength".equals(format)) {
            streamBuilder.parser(new FixedLengthParserBuilder());
        } else if ("xml".equals(format)) {
            streamBuilder.parser(new XmlParserBuilder());
        } else if ("csv".equals(format)) {
            streamBuilder.parser(new CsvParserBuilder());
        } else if ("delimited".equals(format)) {
            streamBuilder.parser(new DelimitedParserBuilder());
        }
        if (recordList != null) {
            for (Class classValue : recordList) {
                streamBuilder.addRecord(classValue);
            }
        }
        if (groupList != null) {
            for (Class classValue : groupList) {
                streamBuilder.addGroup(classValue);
            }
        }
        factory.define(streamBuilder);
        InputStreamReader inputStreamReader = new InputStreamReader(payLoad);
        BeanReader beanReader = factory.createReader(streamName, inputStreamReader);
        beanReader.setErrorHandler(new BeanReaderErrorHandlerSupport());
        return beanReader;
    }
}
