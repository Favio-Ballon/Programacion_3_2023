package obj.filtros;

import obj.ComandoFiltro;
import obj.Imagen;

public class Gris extends ComandoFiltro {


    public Gris(Imagen imagenBase) {
        super(imagenBase);
    }

    @Override
    public void ejecutar() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = (pixeles[i][j] >> 16) & 0x000000FF;
                int g = (pixeles[i][j] >> 8) & 0x000000FF;
                int b = pixeles[i][j] & 0x000000FF;
                int prom = (r+g+b)/3;

                pixeles[i][j] = prom + prom * 256 + prom * 256 * 256;
            }
        }
        imagenBase.cambiosImagen();
    }
}
