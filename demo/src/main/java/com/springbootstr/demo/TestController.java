package com.springbootstr.demo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RequestMapping("/employee")

@RestController  //send responce...accept request
public class TestController {
ArrayList<Employee> array=new ArrayList<>(100);

    @PostMapping
    public String addEmployee(@RequestBody  Employee emp)
    {
        array.add(new Employee(emp.getName(),emp.getId()));
        return "201 – CREATED\n" +
                "A new resource has been created\n";

    }
    @PostMapping("/eee")
    public Employee adddEmployee(@RequestBody  Employee emp)
    {
        array.add(new Employee(emp.getName(),emp.getId()));
        return emp;

    }

    @PostMapping("/e")
    public EntityModel<Employee> postMethodd(@RequestBody Employee emp) {
        array.add(new Employee(emp.getName(), emp.getId()));

        Employee savedEmp = array.get(array.size() - 1);
        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(TestController.class).getEmployeeById(emp.getId())).withSelfRel();
        Link collectionLink = WebMvcLinkBuilder.linkTo(TestController.class).withRel("employees");

        return EntityModel.of(savedEmp, selfLink, collectionLink);
    }

















    @GetMapping
    public ArrayList<Employee > getEmployee()
    {
        return array;
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@RequestParam int id)
    {
        for (int i=0;i<array.size();i++)
        {
            if (array.get(i).getId()==id)
            {
                return array.get(i);
            }

        }
        return null;
    }
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody  Employee employee)
    {
        for (int i=0;i<array.size();i++)
        {
            if (array.get(i).getId()==id)
            {
               array.get(i).setName(employee.getName());
               return "HTTP/1.1 200 OK";
            }

        }
        return "HTTP/1.1 404 Not Found\n";
    }
    @DeleteMapping ("/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        for (int i=0;i<array.size();i++)
        {
            if (array.get(i).getId()==id)
            {
                array.remove(i);
                return "HTTP/1.1 204 No Content";
            }

        }
        return "HTTP/1.1 404 Not Found";
    }
}
