package src.classes.stickers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stickers {
    public void create() throws IOException {

        // lendo a imagem:
        BufferedImage image = ImageIO.read(new File(""));

        // cria imagem em memória com transparência e com tamanho novo
        int largura = image.getWidth();
        int alturaOr = image.getHeight();
        int altura = alturaOr + 200;
        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem (em memória);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(image, 0, 0, null);
    }
}
