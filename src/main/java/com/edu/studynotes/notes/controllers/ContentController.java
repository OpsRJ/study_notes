package com.edu.studynotes.notes.controllers;

import com.edu.studynotes.notes.dto.ContentDTO;
import com.edu.studynotes.notes.models.Content;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/content")
public class ContentController extends GenericRestController<Content, ContentDTO> {
    
}