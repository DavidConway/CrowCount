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

public class TestCases {
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
	
	@Test
	public void addBoxesMidTrig() {
		
		imadgeGenerator.blackWhiteGen(0.5);
		box.addBoxes(testPane, testImageView, 500, 500);
		assertEquals(1024433236,box.matchTo.hashCode());
	}
	
	@Test
	public void addBoxesHighTrig() {
		
		imadgeGenerator.blackWhiteGen(0.5);
		box.addBoxes(testPane, testImageView, 999, 500);
		assertEquals(-93725008,box.matchTo.hashCode());
	}
	
	@Test
	public void addBoxesLowEndTrig() {
		
		imadgeGenerator.blackWhiteGen(0.5);
		box.addBoxes(testPane, testImageView, 500, 1);
		assertEquals(-2142350376,box.matchTo.hashCode());
	}
	
	
	@Test
	public void addBoxesHighEndTrig() {
		
		imadgeGenerator.blackWhiteGen(0.5);
		box.addBoxes(testPane, testImageView, 500, 999);
		assertEquals(-1838034000,box.matchTo.hashCode());
	}
	
	@Test
	public void blackWhiteGenLowSens() {
		imadgeGenerator.blackWhiteGen(0.1);
		assertEquals(-1470641087,imadgeGenerator.matchTo.hashCode());
	}
	
	@Test
	public void blackWhiteGenMidSens() {
		imadgeGenerator.blackWhiteGen(0.5);
		assertEquals(711149567,imadgeGenerator.matchTo.hashCode());
	}
	
	@Test
	public void blackWhiteGenHighSens() {
		imadgeGenerator.blackWhiteGen(0.9);
		assertEquals(-388362807,imadgeGenerator.matchTo.hashCode());
	}

}
