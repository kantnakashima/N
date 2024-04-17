package com.example.tokuten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.tokuten.model.ClassnumModel;
import com.example.tokuten.model.StudentModel;
import com.example.tokuten.service.ClassnumService;
import com.example.tokuten.service.StudentService;

import io.micrometer.common.lang.NonNull;

@Controller
public class MainController {
	@Autowired
	private ClassnumService ClassnumService;
	
	@Autowired
	private StudentService StudentService;
	
  @GetMapping("/")
  public String top(Model model) {
    model.addAttribute("message", "ログイン");
    return "top";
  }
  @GetMapping("/menyu")
  public String menyu(Model model) {
    model.addAttribute("message", "ようこそ");
    return "menyu";
  }
  @GetMapping("/gakuseiitiran")
  public String gakuseiitiran(Model model) {
    model.addAttribute("StudentModelList", StudentService.getStudentModelList());
    return "gakuseiitiran";
  }
  @GetMapping("/Classnum/")
  public ModelAndView add(ClassnumModel Classnummodel, ModelAndView model) {
      model.addObject("CLASS_NUM", Classnummodel);
      model.setViewName("Classnum");
      return model;
  }
  @PostMapping("/Classnum/")
  public String userset(@Validated @ModelAttribute @NonNull ClassnumModel Classnummodel, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
    	  System.out.println(Classnummodel);
          this.ClassnumService.save(Classnummodel);
          redirectAttributes.addFlashAttribute("exception", "");

      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "top";

    }
  @GetMapping("/Student/")
  public ModelAndView add(StudentModel Studentmodel, ModelAndView model) {
      model.addObject("STUDENT", Studentmodel);
      model.setViewName("Student");
      return model;
  }
  @PostMapping("/Student/")
  public String userset(@Validated @ModelAttribute @NonNull StudentModel Studentmodel, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
    	  System.out.println(Studentmodel);
          this.StudentService.save(Studentmodel);
          redirectAttributes.addFlashAttribute("exception", "");

      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "redirect:/gakuseiitiran";
    }
  @PostMapping("/Student/{id}")
  public String delete(@PathVariable Long id) {
	  StudentService.delete(id);
	  return "gakuseiitiran";
  }
  @GetMapping("/gakuseikousin/{id}")
  public String gakuseikousin(Model model, @PathVariable("id") Long id) {
      StudentModel student = StudentService.get(id);
      model.addAttribute("STUDENT", student);
      return "gakuseikousin";
  }
  @PostMapping("/gakuseikousin")
  public String update(@ModelAttribute @Validated StudentModel student, BindingResult result, RedirectAttributes redirectAttributes) {
      if (result.hasErrors()) {
          return "gakuseikousin";
      }

      try {
          StudentService.update(student);
          redirectAttributes.addFlashAttribute("successMessage", "学生情報が更新されました。");
      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("errorMessage", "更新中にエラーが発生しました。");
      }
      return "redirect:/gakuseiitiran";
  }

}