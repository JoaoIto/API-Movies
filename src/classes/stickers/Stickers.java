package src.classes.stickers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Stickers {
    public void create(InputStream inputStream, String fileName) throws IOException {

        // lendo a imagem:
        BufferedImage image = ImageIO.read(new File(inputStream.toString()));

        // cria imagem em memória com transparência e com tamanho novo
        int width = image.getWidth();
        int oldHeight = image.getHeight();
        int height = oldHeight + 200;
        BufferedImage novaImagem = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem (em memória);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 100, height - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(fileName));
    }
}
