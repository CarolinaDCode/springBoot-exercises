package academy.atl.bootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MainController {

    @GetMapping("/hacer-algo")
    public String primeraPrueba(){
        return "Hola mundo!";
    }

    @GetMapping("/generate-password")
    public String generatePassword(){
        String newPassword = getPassword();
        return newPassword;
    };

    private static String getPassword(){
        //Generate number random
        double numDecimal = Math.random() * 1000;
        long intRandom = Math.round(numDecimal);

        //Generate letters random
        String abcLower = "abcdefghijklmnopqrstuvwxyz";
        String abcUpper = "ABCDEFGHIJKLMNOPQRSTU";
        String abcAll = abcLower + abcUpper;

        Random mRandom = new Random();

        int abcLength = 4;
        String result = "";
        for (int i = 0; i < abcLength; i++) {
            int position  = mRandom.nextInt(abcAll.length());
            char caracter = abcAll.charAt(position);
            result += caracter;
        }
        return result + intRandom;
    }
}
