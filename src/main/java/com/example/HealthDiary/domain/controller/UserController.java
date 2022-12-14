package com.example.HealthDiary.domain.controller;


import com.example.HealthDiary.domain.dto.DiaryDto;
import com.example.HealthDiary.domain.dto.SignUpDto;
import com.example.HealthDiary.domain.dto.SignInDto;
import com.example.HealthDiary.domain.entity.Diary;
import com.example.HealthDiary.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import static com.example.HealthDiary.global.constant.SessionConstant.SESSION_ID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<Void> signIn(@RequestBody SignInDto dto, HttpServletRequest request, HttpServletResponse response) {
        userService.signIn(dto, request, response);


        return ResponseEntity.status(HttpStatus.CREATED).build();
//        return new ResponseEntity("ASD" ,HttpStatus.CREATED );
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpDto dto, HttpServletRequest request) {
        userService.signUp(dto, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/note")
    public ResponseEntity<Void> note(@RequestBody DiaryDto dto, HttpServletRequest request, HttpServletResponse response) {
        userService.note(dto, request, response);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/diarys")
    public ResponseEntity<List<Diary>> inquire(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getDiaryList(userId));
    }
}
