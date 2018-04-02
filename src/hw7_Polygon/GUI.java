package hw7_Polygon;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

public class GUI extends Application
{
	private MyPolygon polygon = new MyPolygon();

	public void start(Stage primaryStage)
	{
		BorderPane borderpane = layout();
		Scene scene = new Scene(borderpane, 500, 500);
		primaryStage.setTitle("Polygon");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public BorderPane layout()
	{
		Button btplus = new Button("+");
		btplus.setOnAction(new PlusSideHandler());
		Button btminus = new Button("-");
		btminus.setOnAction(new MinusSideHandler());

		HBox hpane = new HBox(15);
		hpane.setAlignment(Pos.CENTER);
		hpane.getChildren().addAll(btminus, btplus);

		BorderPane borderpane = new BorderPane();
		borderpane.setCenter(polygon);
		borderpane.setBottom(hpane);
		BorderPane.setAlignment(hpane, Pos.TOP_CENTER);

		return borderpane;

	}

	class PlusSideHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			polygon.setSides(polygon.getSides() + 1);
		}
	}

	class MinusSideHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			polygon.setSides(polygon.getSides() - 1);
		}
	}

	class MyPolygon extends Pane
	{
		private int sides = 6;

		private void paint()
		{
			Polygon polygon = new Polygon();
			polygon.setFill(Color.WHITE);
			polygon.setStroke(Color.BLACK);
			ObservableList<Double> list = polygon.getPoints();

			double centerX = getWidth() / 2, centerY = getHeight() / 2;
			double radius = Math.min(getWidth() * .4, getHeight() * .4);

			for (int i = 0; i < sides; i++)
			{
				list.add(centerX + radius * Math.cos(2 * i * Math.PI / sides));
				list.add(centerY - radius * Math.sin(2 * i * Math.PI / sides));
			}
			getChildren().clear();
			getChildren().add(polygon);
		}

		public void setWidth(double width)
		{
			super.setWidth(width);
			paint();
		}

		public void setHeight(double height)
		{
			super.setHeight(height);
			paint();
		}

		public void setSides(int side)
		{
			if (side > 2)
				sides = side;
			paint();
		}

		public int getSides()
		{
			return this.sides;
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
