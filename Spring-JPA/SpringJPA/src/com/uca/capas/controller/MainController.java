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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Student;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.StudentRepository;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.StudentService;
import com.uca.capas.service.SucursalService;

/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/

@Controller
public class MainController {
	
	
	//Objeto Logger
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	//Objeto Singleton
	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EmpleadoService empleadosService;
	
	@Autowired
	private StudentRepository studentRepo;
	
	//Controlador principal
	@RequestMapping("/")
	public ModelAndView initMain(){
		log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		//List<Sucursal> sucursales = null;
		try {
		//Selecciono todos los elementos de la tabla student
		 //students = studentDao.findAll();
		//sucursales = sucursalService.findAll();
		 students = sService.findAll();
			log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		//mav.addObject("students",sucursales);
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/prueba")
	public ModelAndView prueba(){
		log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		//List<Student> students = null;
		List<Sucursal> sucursales = null;
		try {
		//Selecciono todos los elementos de la tabla student
		 //students = studentDao.findAll();
			sucursales = sucursalService.findAll();
		 //students = sService.findAll();
			log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("sucursales",sucursales);
		//mav.addObject("students",students);
		mav.setViewName("prueba");
		return mav;
	}
	
	//Controlador para busquedas por codigo
	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseBody
	public Student search(@RequestParam(value = "code") Integer code) {
		Student student = studentDao.findOne(code);
		return student;
	}
	
	//Controlador que lleva a formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sucursales",new Sucursal());
		//mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav; 
	}
	@RequestMapping(value="/saveEmpleado",method=RequestMethod.POST)
	public ModelAndView insertEmpleado() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("empleados",new Empleado());
		//mav.addObject("student",new Student());
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
/*	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",studentDao.findOne(code));
		mav.setViewName("form");
		return mav; 
	}*/
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
			//List<Sucursal> sucursales = null;
			List<Empleado> empleados = null;
			//sucursalService.save(s);
			empleadosService.save(e);
			//sucursales = sucursalService.findAll();
			empleados = empleadosService.findAll();
			//mav.addObject("sucursales",sucursales);
			mav.addObject("empleados", empleados);
			mav.setViewName("redirect:/verEmpleados");
		}
		return mav;
	}
	//Controlador que implementa Spring Data
	@RequestMapping(value = "/searchBy",method = RequestMethod.POST)
	public ModelAndView searchBy(@RequestParam(value = "name") String name,@RequestParam(value="age") Integer age) {
		ModelAndView mav = new ModelAndView();
		//Busco por nombre
		List<Student> studentsNameList = studentRepo.findBySName(name);
		//Busco por edad
		List<Student> studentsAgeList = studentRepo.findBySAge(age);
		mav.addObject("studentsname",studentsNameList);
		mav.addObject("studentsage",studentsAgeList);
		mav.setViewName("find");
		return mav; 
	}
	
	//Controlador login
	@RequestMapping(value="/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	//Controlador verificar
	@RequestMapping(value="/verificar")
	public ModelAndView verificar() {
		//aca debe ir el proceso para verificar que si son credenciales correctas
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping(value="/volver")
	public ModelAndView volver() {
		//aca debe ir el proceso para verificar que si son credenciales correctas
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
		//mav.setViewName("main");
		mav.setViewName("redirect:/prueba");
		return mav; 
	}
	
	@RequestMapping(value="/perfil",method=RequestMethod.POST)
	public ModelAndView verPerfil(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		Sucursal sucursales = new Sucursal();
		//List<Empleado> empleados = null;
		sucursales = sucursalService.findOne(code);
		//empleados = sucursalService.findOne(code).getEmpleados();
		//mav.addObject("empleados", empleados);
		mav.addObject("sucursales",sucursales);
		mav.setViewName("perfil");
		return mav; 
	}
	
	@RequestMapping(value="/verEmpleados")
	public ModelAndView verEmpleados(){
		//log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Empleado> empleados = null;
		//List<Sucursal> sucursales = null;
		try {
		//Selecciono todos los elementos de la tabla 
		//sucursales = sucursalService.findAll();
		 empleados = empleadosService.findAll();
			log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("empleados",empleados);
		//mav.addObject("students",students);
		mav.setViewName("verEmpleados");
		return mav;
	}
	
}
