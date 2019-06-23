package com.globant.bootcamp.swagger2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.globant.bootcamp.swagger2.model.Glober;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Swagger2DemoController")
@RestController
public class Swagger2DemoController {

	private List<Glober> globers = new ArrayList<>();
	{
		globers.add(new Glober("Alejo", "SP", "COL"));
		globers.add(new Glober("Lucho", "SP", "COL"));
		globers.add(new Glober("William", "BD", "USA"));
	}

	@ApiOperation(value = "Get list of Globers in the System ", response = Iterable.class, tags = "getGlobers")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not authorized!"),
			@ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not found!!!") })

	@RequestMapping(value = "/getGlobers", method = RequestMethod.GET)
	public List<Glober> getGlobers() {
		return globers;
	}

	@ApiOperation(value = "Get specific Glober in the System ", response = Glober.class, tags = "getGlober")
	@RequestMapping(value = "/getGlober/{name}", method = RequestMethod.GET)
	public Glober getGlober(@PathVariable(value = "name") String name) {
		return globers.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Get specific Glober By Country in the System ", response = Glober.class, tags = "getGloberByCountry")
	@RequestMapping(value = "/getGloberByCountry/{country}", method = RequestMethod.GET)
	public List<Glober> getGloberByCountry(@PathVariable(value = "country") String country) {
		return globers.stream().filter(x -> x.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
	}

	@ApiOperation(value = "Get specific Glober By Studio in the System ",response = Glober.class,tags="getGloberByStudio")
	@RequestMapping(value = "/getGloberByStudio/{studio}", method = RequestMethod.GET)
	public List<Glober> getGloberByStudio(@PathVariable(value = "studio") String studio) {
		return globers.stream().filter(x -> x.getStudio().equalsIgnoreCase(studio)).collect(Collectors.toList());
	}

	@ApiOperation(value = "Add new Glober ",response = Glober.class,tags="addGlober")
	@RequestMapping(value = "/addGlober",method = RequestMethod.POST)
	public void addGlober(@RequestBody Glober glober) {
		globers.add(glober);
	}

	@ApiOperation(value = "Update Glober ",response = Glober.class,tags="updateGlober")
	@ApiResponse(code = 200, message = "Glober updated")
	@RequestMapping(value = "/updateGlober",method = RequestMethod.PUT)
	public void updateGlober(@RequestBody Glober globerRequest) {
		Glober glober = globers.stream().filter(g -> g.getName()
				.equals(globerRequest.getName()))
				.findFirst()
				.get();
		glober.setName(globerRequest.getName());
		glober.setCountry(globerRequest.getCountry());
		glober.setStudio(globerRequest.getStudio());
	}

	@ApiOperation(value = "Add new Glober ", tags="deleteGlober")
	@ApiResponse(code = 200, message = "Glober deleted")
	@RequestMapping(value = "/deleteGlober",method = RequestMethod.DELETE)
	public void deleteGlober(@RequestBody Glober glober) {
		globers.remove(glober);
	}

	@ApiOperation(value = "Add new Glober ",response = Glober.class,tags="patchGlober")
	@ApiResponse(code = 200, message = "Glober name updated")
	@RequestMapping(value = "/patchGlober",method = RequestMethod.PATCH)
	public void updateGloberName(@RequestBody Glober globerRequest) {
		Glober glober = globers.stream().filter(g -> g.getName()
				.equals(globerRequest.getName()))
				.findFirst()
				.get();
		glober.setName(globerRequest.getName());
	}
}
