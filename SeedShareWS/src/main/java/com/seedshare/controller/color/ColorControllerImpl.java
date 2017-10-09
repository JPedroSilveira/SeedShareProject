package com.seedshare.controller.color;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seedshare.entity.Color;
import com.seedshare.service.color.ColorService;

/**
 * Controller interface for Color
 * 
 * @author joao.silva
 */
@RestController
@RequestMapping("/color")
public class ColorControllerImpl implements ColorController{

	@Autowired
	ColorService colorService;
	
	@Override
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody @Valid Color color) {
		return colorService.save(color);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return colorService.delete(id);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		return colorService.findOne(id);
	}

	@Override
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return colorService.findAll();
	}

}