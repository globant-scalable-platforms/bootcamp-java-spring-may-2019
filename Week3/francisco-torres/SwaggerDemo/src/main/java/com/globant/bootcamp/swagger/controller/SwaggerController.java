package com.globant.bootcamp.swagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.globant.bootcamp.swagger.model.Glober;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Swagger2DemoController")
@RestController
public class SwaggerController {

    private List<Glober> globers = new ArrayList<>();
    {
        globers.add(new Glober("Alejo", "SP", "COL"));
        globers.add(new Glober("Lucho", "SP", "COL"));
        globers.add(new Glober("William", "BD", "USA"));
    }

    @ApiOperation(value = "Get list of Globers in the System ", response = Iterable.class, tags = "getGlobers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") })

    @RequestMapping(value = "/Globers", method = RequestMethod.GET)
    public List<Glober> getGlobers() {
        return globers;
    }

    @ApiOperation(value = "Get specific Glober in the System ", response = Glober.class, tags = "getGlober")
    @RequestMapping(value = "/Globers/{name}", method = RequestMethod.GET)
    public Glober getGlober(@PathVariable(value = "name") String name) {
        return globers.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Globers By Country in the System ", response = Glober.class, tags = "getGloberByCountry")
    @RequestMapping(value = "/GlobersByCountry/{country}", method = RequestMethod.GET)
    public List<Glober> getGloberByCountry(@PathVariable(value = "country") String country) {
        return globers.stream().filter(x -> x.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Get specific Globers By Studio in the System ",response = Glober.class,tags="getGloberByStudio")
    @RequestMapping(value = "/GlobersByStudio/{studio}", method = RequestMethod.GET)
    public List<Glober> getGloberByStudio(@PathVariable(value = "studio") String studio) {
        return globers.stream().filter(x -> x.getStudio().equalsIgnoreCase(studio)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Add new Glober ",response = Glober.class,tags="addGlober")
    @RequestMapping(value = "/Globers",method = RequestMethod.POST)
    public void addGlober(@RequestBody Glober glober) {
        globers.add(glober);
    }

    @ApiOperation(value = "Update a Glober by name in the system ",response = Glober.class,tags="updateGloberByName")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The glober with name {name} was updated"),
                            @ApiResponse(code = 404, message = "The glober named {name} does not exist") })

    @RequestMapping(value = "/Globers/{name}",method = RequestMethod.PUT)
    public ResponseEntity updateGlober(@ApiParam(value = "The glober name you want to update", required = true)
                                       @PathVariable(value = "name") String name,
                                       @ApiParam(value = "All glober information updated", required = true)
                                       @RequestBody Glober glober) {
        int index = IntStream.range(0, globers.size())
                .filter(i -> name.equals(globers.get(i).getName()))
                .findFirst().orElse(-1);

        if(index == -1) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        globers.set(index, glober);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Glober by name in the system ",response = Glober.class,tags="deleteGloberByName")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The glober with name {name} was deleted"),
                            @ApiResponse(code = 404, message = "The glober named {name} does not exist") })

    @RequestMapping(value = "/Globers/{name}",method = RequestMethod.DELETE)
    public ResponseEntity deleteGlober(@ApiParam(value = "The glober name you want to delete", required = true)
                                       @PathVariable(value = "name") String name) {
        int index = IntStream.range(0, globers.size())
                .filter(i -> name.equals(globers.get(i).getName()))
                .findFirst().orElse(-1);

        if(index == -1) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        globers.remove(index);
        return new ResponseEntity(HttpStatus.OK);
    }
}

