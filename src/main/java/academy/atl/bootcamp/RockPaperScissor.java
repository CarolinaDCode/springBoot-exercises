package academy.atl.bootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
@RestController
public class RockPaperScissor {

    @GetMapping("/yan-ken-po")
    public String yanKenPo() {
        //"Elige Piedra, Papel o Tijera: Piedra(1)-Papel(2)-Tijera(3)");
        Integer playerSymbol = 1;

        Integer pcSymbol = (int) Math.floor(Math.random() * 3 + 1);

        String infoPlayer = chooseSymbol(playerSymbol, "playerSymbol");
        String infoPc = chooseSymbol(pcSymbol, "pcSymbol");
        /**
        switch(playerSymbol) {
            case 1:
                System.out.println("Elegiste Piedra y");
                break;
            case 2:
                System.out.println("Elegiste Papel y");
                break;
            case 3:
                System.out.println("Elegiste Tijera y");
                break;
        }

        switch(pcSymbol) {
            case 1:
                System.out.println("PC eligió Piedra");
                break;
            case 2:
                System.out.println("PC eligió Papel");
                break;
            case 3:
                System.out.println("PC eligió Tijera");
                break;
        }*/

        String result = "";

        if (playerSymbol == pcSymbol) {
            result = "EMPATE!!!";
            System.exit(0);
        }

        if ((playerSymbol == 1 && pcSymbol == 3) ||
            (playerSymbol == 2 && pcSymbol == 1) ||
            (playerSymbol == 3 && pcSymbol == 2)) {
            result = "GANASTE!!!";
        }else{
            result = "PERDISTE!!!";
        }

        String legend = infoPlayer + infoPc + result;
        return legend;
    }

    private static String chooseSymbol(Integer chosenSymbol, String info){
        String descriptionSymbol = "";
        switch(chosenSymbol) {
            case 1:
                if(info == "playerSymbol"){
                    descriptionSymbol = "Elegiste Piedra y ";
                }
                if(info == "pcSymbol"){
                    descriptionSymbol = "PC eligió Piedra ";
                }
                break;
            case 2:
                if(info == "playerSymbol"){
                    descriptionSymbol = "Elegiste Papel y ";
                }
                if(info == "pcSymbol"){
                    descriptionSymbol = "PC eligió Papel ";
                }
                break;
            case 3:
                if(info == "playerSymbol"){
                    descriptionSymbol = "Elegiste Tijera y ";
                }
                if(info == "pcSymbol"){
                    descriptionSymbol = "PC eligió Tijera ";
                }
                break;
        }
        return descriptionSymbol;
    }
}
