package junit;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import application.box;
import application.fileLoader;
import application.imadgeGenerator;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class boxTest {
	Image testImage;
	StackPane testPane; 
	ImageView testImageView;
	JFXPanel jfxPanel = new JFXPanel(); //<-- starts FX
	
	@Before
	public void setUp() throws Exception{
		fileLoader.selectedImage = new File("src/test.jpeg");
		fileLoader.loadedImage = new Image(fileLoader.selectedImage.toURI().toString());
		testPane = new StackPane();
		testImageView = new ImageView();
		testImageView.setImage(fileLoader.loadedImage);

	}
	@Test
	public void addBoxesLowTrig() {
		
		imadgeGenerator.blackWhiteGen(0.5);
		box.addBoxes(testPane, testImageView, 1, 500);
		assertEquals(990237336,box.matchTo.hashCode());
	}

}
