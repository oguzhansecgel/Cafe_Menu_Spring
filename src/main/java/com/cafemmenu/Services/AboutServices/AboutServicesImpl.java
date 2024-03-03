package com.cafemmenu.Services.AboutServices;

import com.cafemmenu.Entities.About;
import com.cafemmenu.Enum.CEnum;
import com.cafemmenu.Repositories.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutServicesImpl implements AboutService{
    private final AboutRepository aboutRepository;

    @Override
    public List<About> getAllAbout() {
        return aboutRepository.findAll();
    }

    @Override
    public ResponseEntity<About> getByIdAbout(Long id) {
        About about = aboutRepository.findById(id).orElse(null);
        return new ResponseEntity<About>(about,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<About> createAbout(About about) {
        aboutRepository.save(about);
        return new ResponseEntity<>(about,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<About> deleteAbout(Long id) {

        Optional<About> hasUser = aboutRepository.findById(id);
        if(hasUser !=null)
        {
            aboutRepository.deleteById(id);
            return new ResponseEntity<About>(HttpStatus.OK);
        }

        return new ResponseEntity<About>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<About> updateAbout(About about) {
        Optional<About> hasUser = aboutRepository.findById(about.getId());
        if(hasUser.isPresent())
        {
            aboutRepository.saveAndFlush(about);
            return new ResponseEntity<About>(HttpStatus.OK);
        }
        return new ResponseEntity<About>(HttpStatus.BAD_REQUEST);
    }
}
