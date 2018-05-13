package com.ravi.travel.budget_travel.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;


@RestController
public class BlogsController {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  /*  @Value("${multipart.location}")
    private String location ;


    @RequestMapping(value = "/upload" , method = RequestMethod.POST , produces = MediaType.IMAGE_GIF_VALUE)
    public String upload(@RequestParam("file") String file , @RequestParam("start") int start ,
                         @RequestParam("end") int end , @RequestParam("speed") int speed , @RequestParam("repeat") int repeat)
    throws IOException {

        log.info("File :"+file);
        log.info("Start :"+start);
        log.info("End :"+end);
        log.info("Speed :"+speed);
        log.info("repeat :"+repeat);
        log.info("Saved file to {}");
        return "";
    }*/
}
