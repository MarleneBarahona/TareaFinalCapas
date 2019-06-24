package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.SucursalService;

@Controller
public class MainController {
	
	
	//Objeto Logger
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EmpleadoService empleadosService;
	
	//Controlador principal
	@RequestMapping(value="/prueba")
	public ModelAndView prueba(){
		log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		try {
			sucursales = sucursalService.findAll();
			log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("sucursales",sucursales);
		mav.setViewName("prueba");
		return mav;
	}
	
	
	//Controlador que lleva a formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sucursales",new Sucursal());
		mav.setViewName("form");
		return mav; 
	}
	@RequestMapping(value="/saveEmpleado",method=RequestMethod.POST)
	public ModelAndView insertEmpleado() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("empleados",new Empleado());
		mav.setViewName("formEmpleado");
		return mav; 
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		Sucursal sucursales = new Sucursal();
		sucursales = sucursalService.findOne(code);
		mav.addObject("sucursales",sucursales);
		mav.setViewName("form");
		return mav; 
	}
	@RequestMapping(value="/updateEmpleado",method=RequestMethod.POST)
	public ModelAndView updateEmpleado(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		Empleado empleados = new Empleado();
		empleados = empleadosService.findOne(code);
		mav.addObject("empleados",empleados);
		mav.setViewName("formEmpleado");
		return mav; 
	}
	//controlador de introducir datos sucursal
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute("sucursales") Sucursal s,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("form");
		}
		else {
			List<Sucursal> sucursales = null;
			sucursalService.save(s);
			sucursales = sucursalService.findAll();
			mav.addObject("sucursales",sucursales);
			mav.setViewName("redirect:/prueba");
		}
		return mav;
	}
	@RequestMapping(value="/formDataEmpleado")
	public ModelAndView saveEmpleado(@ModelAttribute("empleados") Empleado e,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("formEmpleado");
		}
		else {
			List<Empleado> empleados = null;
			empleadosService.save(e);
			empleados = empleadosService.findAll();
			mav.addObject("empleados", empleados);
			mav.setViewName("redirect:/verEmpleados");
		}
		return mav;
	}
	
	//Controlador login
	@RequestMapping(value="/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	//Controlador verificar
	@RequestMapping(value="/verificar",method=RequestMethod.POST)
	public ModelAndView verificar(@RequestParam(name = "email") String user, @RequestParam(name = "password") String pass) {
		//aca debe ir el proceso para verificar que si son credenciales correctas
		ModelAndView mav = new ModelAndView();
		if(user.isEmpty() || pass.isEmpty()) {
			mav.setViewName("login");
		}else {
			mav.setViewName("redirect:/prueba");
		}
		return mav;
	}
	@RequestMapping(value="/volver")
	public ModelAndView volver() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/prueba");
		return mav;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		sucursalService.delete(code);
		sucursales = sucursalService.findAll();
		mav.addObject("code", code);
		mav.addObject("sucursales",sucursales);
		mav.setViewName("redirect:/prueba");
		return mav; 
	}
	@RequestMapping(value="/deleteEmpleado",method=RequestMethod.POST)
	public ModelAndView deleteEmpleado(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		List<Empleado> empleados = null;
		empleadosService.delete(code);
		empleados = empleadosService.findAll();
		mav.addObject("code", code);
		mav.addObject("empleados",empleados);
		mav.setViewName("redirect:/verEmpleados");
		return mav; 
	}
	
	@RequestMapping(value="/perfil",method=RequestMethod.POST)
	public ModelAndView verPerfil(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		Sucursal sucursales = new Sucursal();
		sucursales = sucursalService.findOne(code);
		mav.addObject("sucursales",sucursales);
		mav.setViewName("perfil");
		return mav; 
	}
	
	@RequestMapping(value="/verEmpleados")
	public ModelAndView verEmpleados(){
		ModelAndView mav = new ModelAndView();
		List<Empleado> empleados = null;
		try {
		 empleados = empleadosService.findAll();
			log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("empleados",empleados);
		mav.setViewName("verEmpleados");
		return mav;
	}
	
}
