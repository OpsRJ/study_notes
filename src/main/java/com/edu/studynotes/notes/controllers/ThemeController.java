package com.edu.studynotes.notes.controllers;

import com.edu.studynotes.notes.dto.ThemeDTO;
import com.edu.studynotes.notes.models.Theme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/theme")
public class ThemeController extends GenericRestController<Theme, ThemeDTO> {

}
