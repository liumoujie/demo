package com.manulife.lmj.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    //add date as current date to make it run

    @GetMapping
    public Mono<String> getJob() throws Exception {
//        jobLauncher.run(job, new JobParametersBuilder()
//                .addDate("date", new Date())
//                .toJobParameters());
        jobLauncher.run(job, new JobParameters());
        return Mono.just("job running ......");
    }
}
