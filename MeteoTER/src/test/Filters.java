package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class Filters extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MarvinImagePanel imagePanel;
	private MarvinImage image, backupImage;

	private JPanel panelBottom;

	private JButton buttonGray, buttonSepia, buttonInvert, buttonReset,
			buttonContrast;

	private MarvinImagePlugin imagePlugin;

	public Filters() {
		super("Filters Sample");

		// Create Graphical Interface
		ButtonHandler buttonHandler = new ButtonHandler();
		buttonGray = new JButton("Gray");
		buttonGray.addActionListener(buttonHandler);
		buttonSepia = new JButton("Sepia");
		buttonSepia.addActionListener(buttonHandler);
		buttonInvert = new JButton("Invert");
		buttonInvert.addActionListener(buttonHandler);
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(buttonHandler);
		buttonContrast = new JButton("Contrast");
		buttonContrast.addActionListener(buttonHandler);
		panelBottom = new JPanel();
		panelBottom.add(buttonGray);
		panelBottom.add(buttonSepia);
		panelBottom.add(buttonInvert);
		panelBottom.add(buttonReset);
		panelBottom.add(buttonContrast);

		// ImagePanel
		imagePanel = new MarvinImagePanel();

		Container l_c = getContentPane();
		l_c.setLayout(new BorderLayout());
		l_c.add(imagePanel, BorderLayout.NORTH);
		l_c.add(panelBottom, BorderLayout.SOUTH);

		// Load image
		loadImage();

		imagePanel.setImage(image);

		setSize(320, 600);
		setVisible(true);
	}

	private void loadImage() {
		image = MarvinImageIO.loadImage("./img/amitié.jpg");
		backupImage = image.clone();
	}

	public static void main(String args[]) {
		Filters t = new Filters();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent a_event) {
			image = backupImage.clone();
			if (a_event.getSource() == buttonGray) {
				imagePlugin = MarvinPluginLoader
						.loadImagePlugin("org.marvinproject.image.color.grayScale.jar");
				imagePlugin.process(image, image);
			} else if (a_event.getSource() == buttonSepia) {
				imagePlugin = MarvinPluginLoader
						.loadImagePlugin("org.marvinproject.image.color.sepia.jar");
				imagePlugin.setAttribute("hsIntensidade", 50);
				imagePlugin.process(image, image);
			} else if (a_event.getSource() == buttonInvert) {
				imagePlugin = MarvinPluginLoader
						.loadImagePlugin("org.marvinproject.image.color.invert.jar");
				imagePlugin.process(image, image);
			} else if (a_event.getSource() == buttonContrast) {
				double l_contrast = Math.pow((127 + 200) / 127, 2);
				double r, g, b;
				// Contrast
				for (int x = 0; x < image.getWidth(); x++) {
					for (int y = 0; y < image.getHeight(); y++) {
						r = image.getIntComponent0(x, y);
						g = image.getIntComponent1(x, y);
						b = image.getIntComponent2(x, y);

						r /= 255.0;
						r -= 0.5;
						r *= l_contrast;
						r += 0.5;
						r *= 255.0;

						g /= 255.0;
						g -= 0.5;
						g *= l_contrast;
						g += 0.5;
						g *= 255.0;

						b /= 255.0;
						b -= 0.5;
						b *= l_contrast;
						b += 0.5;
						b *= 255.0;

						if (r < 0)
							r = 0;
						if (r > 255)
							r = 255;
						if (g < 0)
							g = 0;
						if (g > 255)
							g = 255;
						if (b < 0)
							b = 0;
						if (b > 255)
							b = 255;

						image.setIntColor(x, y, (int) r, (int) g, (int) b);
					}
				}
			}
			image.update();
			imagePanel.setImage(image);
		}
	}
}