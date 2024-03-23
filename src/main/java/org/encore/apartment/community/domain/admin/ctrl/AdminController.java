package org.encore.apartment.community.domain.admin.ctrl;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.encore.apartment.community.domain.admin.data.dto.AdminNumberRequestDTO;
import org.encore.apartment.community.domain.admin.service.AdminServiceImpl;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminServiceImpl service;

    @GetMapping("/contact-number")
    public ResponseEntity<String> getAdminContactNumber(@RequestBody AdminNumberRequestDTO requestDTO){
        return new ResponseEntity<>(service.getAdminContactNumber(requestDTO), HttpStatus.OK);
    }

}
