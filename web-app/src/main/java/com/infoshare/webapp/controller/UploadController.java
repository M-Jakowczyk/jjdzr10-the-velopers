package com.infoshare.webapp.controller;

import com.infoshare.webapp.model.Questions;
import com.infoshare.webapp.service.FileJSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class UploadController {

    @Autowired
    FileJSONService fileJSONService;

    @PostMapping("/upload")
    public String loadFile(Model model, @RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        // check if file is empty
        if (file.isEmpty() && Objects.equals(file.getContentType(), "application/json")) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        } else if (Objects.equals(file.getContentType(), "application/json")) {
            fileJSONService.loadFile(file);
            model.addAttribute("file", file);
            attributes.addFlashAttribute("message", "You successfully uploaded " + file.getName() + '!');
            return "redirect:/";
        }
        else {
            attributes.addFlashAttribute("message", "Please select a file type JSON.");
            return "redirect:/";
        }
    }

}

