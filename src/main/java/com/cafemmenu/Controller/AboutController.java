package com.cafemmenu.Controller;

import com.cafemmenu.Entities.About;
import com.cafemmenu.Services.AboutServices.AboutServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/about")

public class AboutController {

    private final AboutServicesImpl aboutServices;
    @GetMapping("getALL")
    public List<About> getAllAbout()
    {
        return aboutServices.getAllAbout();
    }
    @GetMapping("getByIdAbout")
    public ResponseEntity<About> getByIdAbout(Long id)
    {
        return aboutServices.getByIdAbout(id);
    }
    @PostMapping("/createAbout")
    public ResponseEntity<About> createAbout(@RequestBody About about)
    {
        return aboutServices.createAbout(about);
    }
    @DeleteMapping("/deleteAbout")
    public ResponseEntity<About> deleteAbout(@RequestParam Long id){return aboutServices.deleteAbout(id);}
    @PutMapping("/updateAbout")
    public ResponseEntity<About> updateAbout(@RequestBody About about){return aboutServices.updateAbout(about);}
}
