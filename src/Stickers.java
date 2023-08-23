import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class Stickers {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        //leitura
        //InputStream inputStream = new FileInputStream(new File("entrada/teste.jpg"));
        //InputStream imagemOri = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs_2.jpg").openStream();

        BufferedImage imageOri = ImageIO.read(inputStream);

        //cria nova imagem em memoria com tranparencia e tamanho novo
        int largura = imageOri.getWidth();
        int altura = imageOri.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para novo imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOri,0,0 ,null);

        //fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        graphics.setColor(Color.cyan);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString( "eu te amo", 0, novaAltura - 100);
        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

}
