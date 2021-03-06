package draw;

import game.GameMain;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import share.RenderableHolder;
import window.SceneManager;

public class ScoreScreen extends Canvas{
	
	private AnimationTimer timer;

	public ScoreScreen() {
		super(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		GraphicsContext gc = this.getGraphicsContext2D();
		addEventHandler();
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				RenderableHolder.getInstance().playScoreBgm();
				drawScoreScreen(gc);
			}
		};
		timer.start();
	}
	
	public void drawScoreScreen(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		int score = RenderableHolder.getInstance().getScore();
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(80));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("GAME OVER"
				+ "", 400, 100);
		gc.setFont(Font.font(60));
		gc.fillText("Score : " + score, 400, 230);
		gc.setFont(Font.font(30));
		gc.fillText("press Enter to retry",400,350);
		gc.setFont(Font.font(20));
		gc.fillText("Exit: Esc", 750, 430);
	}
	
	public void addEventHandler() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					timer.stop();
					RenderableHolder.getInstance().stopScoreBgm();
					GameMain.newGame();
				}
				if (event.getCode() == KeyCode.ESCAPE) {
					timer.stop();
					RenderableHolder.getInstance().stopScoreBgm();
					Platform.exit();
				}
			}
			
		});
	}
	
}
