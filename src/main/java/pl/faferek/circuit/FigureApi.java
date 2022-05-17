package pl.faferek.circuit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureApi {

    @GetMapping("/calculate")
    public int calculateCircuit(@RequestParam String figure, @RequestParam int siteA,
                                   @RequestParam int siteB,
                                @RequestParam (required = false) Integer siteC ) {
        if (figure.equalsIgnoreCase("RECTANGLE")) {
            return 2 * siteA + 2 * siteB;
        } else if (figure.equalsIgnoreCase("TRIANGLE")) {
            return siteA + siteB + siteC;
        }
        return -1;
    }
}
