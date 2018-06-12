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

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.IFacturaService;
import com.bolsadeideas.springboot.app.models.service.IProductoService;

@Controller
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IProductoService productoService;
	
	@RequestMapping(value = "/factura/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de facturas");
		model.addAttribute("facturas", facturaService.findAll());
		return "facturas/listar";
	}
	
	@RequestMapping(value = "/factura/listar/{id}", method = RequestMethod.GET)
	public String listarId(@PathVariable(value="id") Long id, Model model) {
		Factura single = facturaService.findOne(id);
		model.addAttribute("titulo", "Facturas de usuario");
		model.addAttribute("factura", facturaService.findOne(id));
		model.addAttribute("subtotal", single.Subtotal(single.getListaProductos()));
		model.addAttribute("iva", single.Iva(single.getListaProductos(), 0.19) );
		model.addAttribute("total", single.Total());
		return "facturas/listarId";
	}
	
	@RequestMapping(value = "/factura/form")
	public String crear(Map<String, Object> model) {
		Factura factura = new Factura();
		model.put("factura", factura);
		model.put("productos", productoService.findAll());
		model.put("clientes", clienteService.findAll());
		model.put("titulo", "Formulario de factura");
		return "facturas/form";
	}
	
	@RequestMapping(value = "/factura/form", method = RequestMethod.POST)
	public String guardar(@Valid Factura factura, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("productos", productoService.findAll());
			model.addAttribute("clientes", clienteService.findAll());
			model.addAttribute("titulo", "Formulario de factura");
			return "facturas/form";
		}
		
		facturaService.save(factura);
		status.setComplete();
		return "redirect:listar";
	}

}
