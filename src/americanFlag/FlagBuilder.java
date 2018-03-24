package americanFlag;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagBuilder extends Application
{

	public void start(Stage primaryStage)
	{
		Pane pane = new Pane();
		final double PANEWIDTH = 570;
		final double PANEHEIGHT = 310;

		for (int i = 0; i < 7; i++)
		{
			Rectangle r = new Rectangle();
			r.setX(10);
			r.widthProperty().bind(pane.widthProperty().subtract(20));
			r.yProperty().bind(pane.heightProperty().subtract(20).divide(13).multiply(2 * i).add(10));
			r.heightProperty().bind(pane.heightProperty().subtract(20).divide(13.0));
			r.setFill(Color.RED);
			pane.getChildren().addAll(r);
		}

		Rectangle b = new Rectangle();
		b.setX(10);
		b.widthProperty().bind(pane.widthProperty().multiply(.4).subtract(20));
		b.yProperty().bind(pane.heightProperty().subtract(20).divide(13).multiply(0).add(10));
		b.heightProperty().bind(pane.heightProperty().subtract(20).divide(13).multiply(7));
		b.setFill(Color.BLUE);
		pane.getChildren().addAll(b);

		String imagePath = "/flagstar.png";
		Image flagstar = new Image(imagePath);

		for (int j = 0; j < 5; j++)
		{
			for (int i = 0; i < 6; i++)
			{
				ImageView star = new ImageView(flagstar);
				star.fitWidthProperty().bind(pane.widthProperty().divide(30.84));
				star.fitHeightProperty().bind(pane.heightProperty().divide(16.23));
				star.xProperty().bind(pane.widthProperty().subtract(20).divide(30.84).multiply(2.1 * i).add(10));
				star.yProperty().bind(pane.heightProperty().subtract(20).divide(16.23).multiply(1.9 * j).add(10));
				pane.getChildren().addAll(star);
			}
		}
		for (int j = 0; j < 9; j++)
		{
			for (int i = 0; i < 11; i++)
			{
				ImageView star = new ImageView(flagstar);
				star.fitWidthProperty().bind(pane.widthProperty().divide(30.84));
				star.fitHeightProperty().bind(pane.heightProperty().divide(16.23));
				star.xProperty()
						.bind(pane.widthProperty().subtract(20).divide(30.84).multiply(.5).multiply(2.1 * i).add(10));
				star.yProperty()
						.bind(pane.heightProperty().subtract(20).divide(16.23).multiply(.5).multiply(1.9 * j).add(10));
				if (i % 2 == 1 && j % 2 == 1)
					pane.getChildren().addAll(star);
			}
		}

		Scene scene = new Scene(pane, PANEWIDTH, PANEHEIGHT);
		primaryStage.setTitle("American Flag");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}