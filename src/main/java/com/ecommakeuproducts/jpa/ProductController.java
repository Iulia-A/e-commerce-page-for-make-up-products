package com.ecommakeuproducts.jpa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommakeuproducts.exception.ResourceNotFoundException;


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

	@GetMapping("/addDayCream")
	public String addDayCream(Model model) {
		model.addAttribute("dayCream", new DayCream());
		return "addDayCream";
	}
	
	@PostMapping("/createDayCream")
	public String createDayCream(@ModelAttribute DayCream dayCream, Model model) {
		model.addAttribute("dayCream", dayCream);
		dayCreamRepository.save(dayCream);
		return "redirect:dayCreams";
	}
	
	@GetMapping("/dayCreams/{id}")
	public ResponseEntity<DayCream> getDayCreamById(@PathVariable(value = "id") Long dayCreamId)
			throws ResourceNotFoundException {
		DayCream dayCream = dayCreamRepository.findById(dayCreamId)
				.orElseThrow(() -> new ResourceNotFoundException("Day cream not found for this id: " + dayCreamId));
		return ResponseEntity.ok().body(dayCream);
	}
	
//	//save dayCream
//	@PostMapping("dayCreams")
//	public DayCream createDayCream(@RequestBody DayCream dayCream) {
//		return this.dayCreamRepository.save(dayCream);
//	}
//
//	//update dayCream
//	
//	@PutMapping("/dayCreams/{id}")
//	public ResponseEntity<DayCream> updateDayCream(@PathVariable(value = "id") Long dayCreamId,
//			@Valid @RequestBody DayCream dayCreamDetails) throws ResourceNotFoundException {
//		DayCream dayCream = dayCreamRepository.findById(dayCreamId)
//				.orElseThrow(() -> new ResourceNotFoundException("Day cream not found for this id :: " + dayCreamId));
//
//		dayCream.setBrand(dayCreamDetails.getBrand());
//		dayCream.setName(dayCreamDetails.getName());
//		dayCream.setDescription(dayCreamDetails.getDescription());
//		dayCream.setIngredients(dayCreamDetails.getIngredients());
//		dayCream.setPrice(dayCreamDetails.getPrice());
//		dayCream.setSize(dayCreamDetails.getSize());
//		dayCream.setImagePath(dayCreamDetails.getImagePath());
//		
//		final DayCream updatedDayCream = dayCreamRepository.save(dayCream);
//		return ResponseEntity.ok(updatedDayCream);
//	}
	
	
	@GetMapping("/eyeCreamsAndGels")
	public String eyeCreamsAndGels(Model model) {
		model.addAttribute("eyeCreamsAndGels", eyeCreamsAndGelsRepository.findAll());
		return "eyeCreamsAndGels";
	}
	
	@GetMapping("/addEyeCreamsAndGels")
	public String addEyeCreamsAndGels(Model model) {
		model.addAttribute("eyeCreamsAndGels", new EyeCreamsAndGels());
		return "addEyeCreamsAndGels";
	}
	
	@PostMapping("/createEyeCreamsAndGels")
	public String createEyeCreamsAndGels(@ModelAttribute EyeCreamsAndGels eyeCreamsAndGels, Model model) {
		model.addAttribute("eyeCreamsAndGels", eyeCreamsAndGels);
		eyeCreamsAndGelsRepository.save(eyeCreamsAndGels);
		return "redirect:eyeCreamsAndGels";
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
	
	@GetMapping("/addFaceMask")
	public String addFaceMask(Model model) {
		model.addAttribute("faceMask", new FaceMask());
		return "addFaceMask";
	}
	
	@PostMapping("/createFaceMask")
	public String createFaceMask(@ModelAttribute FaceMask faceMask, Model model) {
		model.addAttribute("faceMask", faceMask);
		faceMaskRepository.save(faceMask);
		return "redirect:faceMasks";
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
	
	@GetMapping("/addFaceOil")
	public String addFaceOil(Model model) {
		model.addAttribute("faceOil", new FaceOils());
		return "addFaceOil";
	}
	
	@PostMapping("/createFaceOil")
	public String createFaceOil(@ModelAttribute FaceOils faceOil, Model model) {
		model.addAttribute("faceOil", faceOil);
		faceOilsRepository.save(faceOil);
		return "redirect:faceOils";
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
	
	@GetMapping("/addFaceSerum")
	public String addFaceSerum(Model model) {
		model.addAttribute("faceSerum", new FaceSerums());
		return "addFaceSerum";
	}
	
	@PostMapping("/createFaceSerum")
	public String createFaceSerum(@ModelAttribute FaceSerums faceSerum, Model model) {
		model.addAttribute("faceSerum", faceSerum);
		faceSerumsRepository.save(faceSerum);
		return "redirect:faceSerums";
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
	
	@GetMapping("/addNightCream")
	public String addNightCream(Model model) {
		model.addAttribute("nightCream", new NightCream());
		return "addNightCream";
	}
	@PostMapping("/createNightCream")
	public String createNightCream(@ModelAttribute NightCream nightCream, Model model) {
		model.addAttribute("nightCream", nightCream);
		nightCreamRepository.save(nightCream);
		return "redirect:nightCreams";
	}
}
