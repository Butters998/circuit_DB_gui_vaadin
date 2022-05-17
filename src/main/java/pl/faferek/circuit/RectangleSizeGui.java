package pl.faferek.circuit;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleSizeGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private TextField textFieldSize;
    private TextArea textAreaRectangle;
    private Button buttonBigger;
    private Button buttonSmaller;

    @Autowired
    public RectangleSizeGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;

        textFieldSize = new TextField("podaj rozmiar");
        textAreaRectangle = new TextArea("wynik");
        buttonBigger = new Button("większe");
        buttonSmaller = new Button("mniejsze");

        buttonBigger.addClickListener(clickEvent ->
                textAreaRectangle.setValue(rectangleRepo.getBigRectangle(Integer.parseInt(textFieldSize.getValue())).toString()));
        buttonSmaller.addClickListener(clickEvent ->
                textAreaRectangle.setValue(rectangleRepo.getSmallRectangle(Integer.parseInt(textFieldSize.getValue())).toString()));

        add(textFieldSize);
        add(buttonBigger);
        add(buttonSmaller);
        add(textAreaRectangle);
    }
}
