package com.ecommakeuproducts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommakeuproducts.exception.ResourceNotFoundException;
import com.ecommakeuproducts.jpa.DayCream;
import com.ecommakeuproducts.jpa.EyeCreamsAndGels;
import com.ecommakeuproducts.jpa.FaceMask;
import com.ecommakeuproducts.jpa.FaceOils;
import com.ecommakeuproducts.jpa.FaceSerums;
import com.ecommakeuproducts.jpa.NightCream;
import com.ecommakeuproducts.repository.DayCreamRepository;
import com.ecommakeuproducts.repository.EyeCreamsAndGelsRepository;
import com.ecommakeuproducts.repository.FaceMaskRepository;
import com.ecommakeuproducts.repository.FaceOilsRepository;
import com.ecommakeuproducts.repository.FaceSerumsRepository;
import com.ecommakeuproducts.repository.NightCreamRepository;

@Service
@Controller
//@RequestMapping("/api/skin")
public class ProductController {

	@Autowired
	private DayCreamRepository dayCreamRepository;
	@Autowired
	private EyeCreamsAndGelsRepository eyeCreamsAndGelsRepository;
	@Autowired
	private FaceMaskRepository faceMaskRepository;
	@Autowired
	private FaceOilsRepository faceOilsRepository;
	@Autowired
	private FaceSerumsRepository faceSerumsRepository;
	@Autowired
	private NightCreamRepository nightCreamRepository;

	@GetMapping("/dayCreams")
	public String dayCreams(Model model) {
		model.addAttribute("dayCreams", dayCreamRepository.findAll());
		return "dayCreams";
	}

	// get daycreams by id
	@GetMapping("/dayCreams/{id}")
	public ResponseEntity<DayCream> getDayCreamById(@PathVariable(value = "id") Long dayCreamId)
			throws ResourceNotFoundException {
		DayCream dayCream = dayCreamRepository.findById(dayCreamId)
				.orElseThrow(() -> new ResourceNotFoundException("Day cream not found for this id: " + dayCreamId));
		return ResponseEntity.ok().body(dayCream);
	}
	
	//save dayCream
	@PostMapping("dayCreams")
	public DayCream createDayCream(@RequestBody DayCream dayCream) {
		return this.dayCreamRepository.save(dayCream);
	}

	//update dayCream
	
	@PutMapping("/dayCreams/{id}")
	public ResponseEntity<DayCream> updateDayCream(@PathVariable(value = "id") Long dayCreamId,
			@Valid @RequestBody DayCream dayCreamDetails) throws ResourceNotFoundException {
		DayCream dayCream = dayCreamRepository.findById(dayCreamId)
				.orElseThrow(() -> new ResourceNotFoundException("Day cream not found for this id :: " + dayCreamId));

		dayCream.setBrand(dayCreamDetails.getBrand());
		dayCream.setName(dayCreamDetails.getName());
		dayCream.setDescription(dayCreamDetails.getDescription());
		dayCream.setIngredients(dayCreamDetails.getIngredients());
		dayCream.setPrice(dayCreamDetails.getPrice());
		dayCream.setSize(dayCreamDetails.getSize());
		dayCream.setImagePath(dayCreamDetails.getImagePath());
		
		final DayCream updatedDayCream = dayCreamRepository.save(dayCream);
		return ResponseEntity.ok(updatedDayCream);
	}
	@GetMapping("/eyeCreamsAndGels")
	public String eyeCreamsAndGels(Model model) {
		model.addAttribute("eyeCreamsAndGels", eyeCreamsAndGelsRepository.findAll());
		return "eyeCreamsAndGels";
	}
	
	@GetMapping("/eyeCreamsAndGels/{id}")
	public ResponseEntity<EyeCreamsAndGels> getEyeCreamsAndGelsById(@PathVariable(value = "id") Long eyeCreamsAndGelsId)
			throws ResourceNotFoundException {
		EyeCreamsAndGels eyeCreamAndGel = eyeCreamsAndGelsRepository.findById(eyeCreamsAndGelsId)
				.orElseThrow(() -> new ResourceNotFoundException("Eye cream and gels not found for this id: " + eyeCreamsAndGelsId));
		return ResponseEntity.ok().body(eyeCreamAndGel);
	}

	@GetMapping("/faceMasks")
	public String faceMasks(Model model) {
		model.addAttribute("faceMasks", faceMaskRepository.findAll());
		return "faceMasks";
	}
	
	@GetMapping("/faceMasks/{id}")
	public ResponseEntity<FaceMask> getFaceMaskById(@PathVariable(value = "id") Long faceMaskId)
			throws ResourceNotFoundException {
		FaceMask faceMask = faceMaskRepository.findById(faceMaskId)
				.orElseThrow(() -> new ResourceNotFoundException("Face mask not found for this id: " + faceMaskId));
		return ResponseEntity.ok().body(faceMask);
	}

	@GetMapping("/faceOils")
	public String faceOils(Model model) {
		model.addAttribute("faceOils", faceOilsRepository.findAll());
		return "faceOils";
	}
	
	@GetMapping("/faceOils/{id}")
	public ResponseEntity<FaceOils> getFaceOilById(@PathVariable(value = "id") Long faceOilId)
			throws ResourceNotFoundException {
		FaceOils faceOil = faceOilsRepository.findById(faceOilId)
				.orElseThrow(() -> new ResourceNotFoundException("Face oil not found for this id: " + faceOilId));
		return ResponseEntity.ok().body(faceOil);
	}

	@GetMapping("/faceSerums")
	public String faceSerums(Model model) {
		model.addAttribute("faceSerums", faceSerumsRepository.findAll());
		return "faceSerums";
	}
	
	@GetMapping("/faceSerums/{id}")
	public ResponseEntity<FaceSerums> getFaceSerumById(@PathVariable(value = "id") Long faceSerumId)
			throws ResourceNotFoundException {
		FaceSerums faceSerum = faceSerumsRepository.findById(faceSerumId)
				.orElseThrow(() -> new ResourceNotFoundException("Face serum not found for this id: " + faceSerumId));
		return ResponseEntity.ok().body(faceSerum);
	}

	@GetMapping("/nightCreams")
	public String nightCreams(Model model) {
		model.addAttribute("nightCreams", nightCreamRepository.findAll());
		return "nightCreams";
	}
	
	@GetMapping("/nightCreams/{id}")
	public ResponseEntity<NightCream> getNightCreamById(@PathVariable(value = "id") Long nightCreamId)
			throws ResourceNotFoundException {
		NightCream nightCream = nightCreamRepository.findById(nightCreamId)
				.orElseThrow(() -> new ResourceNotFoundException("Night cream not found for this id: " + nightCreamId));
		return ResponseEntity.ok().body(nightCream);
	}
}
