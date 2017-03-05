package reynoldstitko.gillian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //SpringBootApplication inits the beans, recognizes annotations, etc.
public class SpringbootdemoApplication {

	//Run the application open a browser to http://localhost:8080/students and the student info from the
	// GET call will be visible. The result is JSON - the conversion is done automatically using Jackson

	//We also defined an endpoint for the id, so to see the id when we run the application, type
	//http://localhost:8080/students/3 to get the student with the id value of 3

	//To delete, we can run Postman, go to the URL of interest (localhost:8080/students/2), select GET to get
	//a student. Then, select DELETE in postman and Send to delete
	public static void main(String[] args) {

		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
