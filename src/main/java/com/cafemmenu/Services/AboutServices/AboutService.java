package com.cafemmenu.Services.AboutServices;

import com.cafemmenu.Entities.About;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AboutService {
    public List<About> getAllAbout();
    public ResponseEntity<About> getByIdAbout(Long id);
    public ResponseEntity<About> createAbout(About about);
    public ResponseEntity<About> deleteAbout(Long id);
    public ResponseEntity<About> updateAbout(About about);
}
