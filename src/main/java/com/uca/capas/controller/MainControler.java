package com.uca.capas.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libros;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibrosService;

@Controller
public class MainControler {
	@Autowired
	private LibrosService libroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria",new Categoria());
		mav.setViewName("categoriaForm");
		return mav;
	}
	
	@RequestMapping(value="/insertarCategoria",method = RequestMethod.POST)
	public ModelAndView insertCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("categoriaForm");
		}
		else {
			categoriaService.insert(categoria);
			mav.addObject("msg","Categoría guardada con éxito");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/libro")
	public ModelAndView libro() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = categoriaService.findAll();
		mav.addObject("categorias",categorias);
		mav.addObject("libros",new Libros());
		mav.setViewName("libroForm");
		return mav;
	}
	
	@RequestMapping(value="/insertarLibro",method = RequestMethod.POST)
	public ModelAndView insertLibro(@Valid @ModelAttribute Libros libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> categorias = categoriaService.findAll();
			mav.addObject("categorias",categorias);
			mav.setViewName("libroForm");
		}
		else {
			Date date = new Date(System.currentTimeMillis());
			libro.setF_ingreso(date);
			Categoria categoria = categoriaService.findOne(libro.getC_categoriafk());
			libro.setCategoria(categoria);
			
			libroService.insert(libro);
			
			mav.addObject("msg","Libro guardada con éxito");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libros> libros = libroService.findAll();
		mav.addObject("libros",libros);
		mav.setViewName("listado");
		return mav;
	}
}
