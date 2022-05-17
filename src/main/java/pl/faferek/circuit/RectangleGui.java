package pl.faferek.circuit;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleGui extends VerticalLayout {

    private final RectangleRepo rectangleRepo;

    private final TextField textFieldHeight;
    private final TextField textFieldWidth;
    private final Button button;

    @Autowired
    public RectangleGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textFieldHeight = new TextField("Podaj wysokość");
        textFieldWidth = new TextField("Podaj szerokość");
        button = new Button("Dodaj");

        add(textFieldHeight);
        add(textFieldWidth);
        add(button);

        button.addClickListener(clickEvent -> addRectangle());
    }

    public void addRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));

        rectangleRepo.save(rectangle);
    }
}
