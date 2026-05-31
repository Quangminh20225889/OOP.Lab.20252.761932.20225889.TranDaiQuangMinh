package Lab04.AimsProject.SourceCode.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioButtonEraser;

    @FXML
    private RadioButton radioButtonPen;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        boolean erasing = radioButtonEraser.isSelected();
        double radius = erasing ? 8 : 4;
        Color color = erasing ? Color.WHITE : Color.BLACK;

        Circle newCircle = new Circle(event.getX(), event.getY(), radius, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
