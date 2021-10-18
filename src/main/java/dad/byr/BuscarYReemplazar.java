package dad.byr;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazar extends Application {
	private TextField reemplazarText;
	private TextField buscarText;
	private Label reemplazarLabel;
	private Label buscarLabel;
	private CheckBox mayMinCheckbox, erCheckbox, buscarAtrasCheckbox, resaltarResultadosCheckbox;
	private Button buscarButton, reemplazarButton, reemTodoButton, cerrarButton, ayudaButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		reemplazarText = new TextField();
		buscarText = new TextField();

		reemplazarLabel = new Label("Reemplazar con:");
		buscarLabel = new Label("Buscar:");

		mayMinCheckbox = new CheckBox("Mayúsculas y minúsculas");
		erCheckbox = new CheckBox("Expresión regular");
		buscarAtrasCheckbox = new CheckBox("Buscar hacia atrás");
		resaltarResultadosCheckbox = new CheckBox("Resaltar resultados");

		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemTodoButton = new Button("Reemplazar todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");

		buscarButton.setMinWidth(120);
		reemplazarButton.setMinWidth(120);
		reemTodoButton.setMinWidth(120);
		cerrarButton.setMinWidth(120);
		ayudaButton.setMinWidth(120);

		VBox botonesBox = new VBox();
		botonesBox.setSpacing(5);
		botonesBox.getChildren().addAll(reemTodoButton, cerrarButton, ayudaButton);

		GridPane checkBoxPane = new GridPane();
		checkBoxPane.setHgap(5);
		checkBoxPane.setVgap(5);

		checkBoxPane.addRow(0, mayMinCheckbox, buscarAtrasCheckbox);
		checkBoxPane.addRow(1, erCheckbox, resaltarResultadosCheckbox);

		GridPane formPane = new GridPane();
		formPane.setPadding(new Insets(5));
		formPane.setHgap(5);
		formPane.setVgap(5);

		formPane.addRow(0, buscarLabel, buscarText, buscarButton);
		formPane.addRow(1, reemplazarLabel, reemplazarText, reemplazarButton);
		formPane.add(checkBoxPane, 1, 2);
		formPane.add(botonesBox, 2, 2);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints() };
		formPane.getColumnConstraints().setAll(cols);

		RowConstraints[] rows = { new RowConstraints(), new RowConstraints(), new RowConstraints(),
				new RowConstraints() };
		formPane.getRowConstraints().setAll(rows);

		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		rows[0].setValignment(VPos.TOP);

		GridPane.setHalignment(buscarLabel, HPos.LEFT);

		Scene scene = new Scene(formPane, 550, 300);

		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
