package dad.byr;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
			buscarLabel=new Label("Buscar:");
			
			mayMinCheckbox=new CheckBox("Mayúsculas y minúsculas");	
			erCheckbox=new CheckBox("Expresión regular");
			buscarAtrasCheckbox=new CheckBox("Buscar hacia atrás");
			resaltarResultadosCheckbox=new CheckBox("Resaltar Resultados");
			
			buscarButton=new Button("Buscar");
			reemplazarButton=new Button("Reemplazar");
			reemTodoButton=new Button("Reemplazar todo");
			cerrarButton=new Button("Cerrar");
			ayudaButton=new Button("Ayuda");
			
			
			VBox botonesBox= new VBox();
			botonesBox.setSpacing(10);
			botonesBox.getChildren().addAll(buscarButton, reemplazarButton, reemTodoButton, cerrarButton, ayudaButton);
			
			GridPane checkBoxPane= new GridPane();
			checkBoxPane.setPadding(new Insets(5));
			checkBoxPane.setHgap(5);
			checkBoxPane.setVgap(5);
			
			checkBoxPane.addRow(0, mayMinCheckbox, buscarAtrasCheckbox);
			checkBoxPane.addRow(1, erCheckbox, resaltarResultadosCheckbox);
			
			GridPane formPane = new GridPane();
			formPane.setPadding(new Insets(5));
			formPane.setHgap(5);
			formPane.setVgap(5);

			formPane.addRow(0, buscarLabel, buscarText);
			formPane.addRow(1, reemplazarLabel, reemplazarText);
			formPane.addRow(2,new Label(""), checkBoxPane );

			ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(),new ColumnConstraints() };
			formPane.getColumnConstraints().setAll(cols);

			RowConstraints [] rows= {
					new RowConstraints(),
	
			};
			formPane.getRowConstraints().setAll(rows);
			// restricciones de la columna 0 (1ª columna)
			cols[0].setHgrow(Priority.ALWAYS);

			// restricciones de la columna 1 (2ª columna)
			cols[1].setHgrow(Priority.ALWAYS);
			cols[2].setHgrow(Priority.ALWAYS);
			cols[2].setFillWidth(true);

			//restricciones de la fila 6(7ª fila)
			rows[0].setFillHeight(true);
			rows[0].setValignment(VPos.TOP);
			
			// restricciones especificas a nivel de celda
			GridPane.setColumnSpan(reemplazarText, 2);
			GridPane.setColumnSpan(buscarText, 2);
			GridPane.setHalignment(buscarLabel, HPos.LEFT);
			
			// panel inferior

			HBox root = new HBox();
			root.setPadding(new Insets(5));
			root.getChildren().addAll(formPane, botonesBox);
			
			

			Scene scene = new Scene(root, 640, 480);

			primaryStage.setTitle("GridPaneSample");
			primaryStage.setScene(scene);
			primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
