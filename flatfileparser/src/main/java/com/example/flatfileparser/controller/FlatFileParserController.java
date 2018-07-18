package com.example.flatfileparser.controller;

import com.example.flatfileparser.service.FlatFileParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("fileconversion")
public class FlatFileParserController {

    private final FlatFileParserService flatFileParserService;

    @Autowired
    public FlatFileParserController(FlatFileParserService flatFileParserService) {
        this.flatFileParserService = flatFileParserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void initFileLoad() throws FileNotFoundException {
        flatFileParserService.getFile();
    }

}
