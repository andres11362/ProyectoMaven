package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.service.IProductoService;

@Controller
@SessionAttributes("producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@RequestMapping(value = "/listarproductos", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", productoService.findAll());
		return "listarproductos";
	}
	@RequestMapping(value = "/form2")
	public String crear(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario de Cliente");
		return "form2";
	}
	
	@RequestMapping(value = "/form2", method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de producto");
			return "form2";
		}

		productoService.save(producto);
		status.setComplete();
		return "redirect:listarproductos";
	}
	
	@RequestMapping(value="/form2/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Producto producto = null;
		
		if(id > 0) {
			producto = productoService.findOne(id);
		} else {
			return "redirect:/listarproductos";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "form2";
	}
	
	@RequestMapping(value="/eliminarprod/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			productoService.delete(id);
		}
		return "redirect:/listarproductos";
	}
	
	
}
