package com.dk.jobby.jobpost.controller;

import com.dk.jobby.jobpost.domain.Job;
import com.dk.jobby.jobpost.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String home(Model model) {
        List<Job> jobListings = jobService.getAllJobs();
        model.addAttribute("jobListings", jobListings);
        return "home";
    }

    @GetMapping("/job-posting")
    public String jobPostingForm(Model model) {
        model.addAttribute("job", new Job());
        return "job-posting";
    }

    @PostMapping("/submit-job")
    public String submitJob(@ModelAttribute Job job) {
        jobService.saveJob(job);
        return "redirect:/";
    }
}