package dev.ihm.options;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dev.exception.PlatException;
import org.springframework.stereotype.Controller;

@Order(30)
@Controller
public class OptionTerminer implements IOptionMenu {
    @Override
    public String getTitre() {
        return "Terminer";
    }

    @Override
    public void executer() {
        throw new PlatException("Aurevoir");
    }
}
