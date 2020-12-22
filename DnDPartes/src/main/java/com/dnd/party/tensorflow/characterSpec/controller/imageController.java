package com.dnd.party.tensorflow.characterSpec.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.party.tensorflow.characterSpec.vo.imageVo;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Slf4j
@RestController
@RequestMapping("/tensorflow/image")
@CrossOrigin
public class imageController {

	
	@PostMapping("/getCharacterSpec")
	public HttpEntity<List<String>> SearchSync(@RequestBody(required=true) imageVo file) {
		ArrayList<String> list = new ArrayList<String>();
		
    	byte decode[] = Base64.decodeBase64(file.getFile().replace("data:image/png;base64,", ""));

        Tesseract tesseract = new Tesseract(); // JNA Interface
        tesseract.setLanguage("eng+kor");
        
        log.info("시작");
    	// 여기 재대로 넣을것
    	tesseract.setDatapath("src/main/resources/tess4j");

    	String result = "";
        try {
            result = tesseract.doOCR(createImageFromBytes(decode));
            list.add(result);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());

        }


		ResponseEntity<List<String>> response = new ResponseEntity<List<String>>(list, list.size()>0?HttpStatus.OK:HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
	private BufferedImage createImageFromBytes(byte[] imageData) {
	    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
	    try {
	        return ImageIO.read(bais);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	
	
}
