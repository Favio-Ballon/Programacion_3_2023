package obj.filtros;

import obj.ComandoFiltro;
import obj.Imagen;

public class Verde extends ComandoFiltro {


    public Verde(Imagen imagenBase) {
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
                pixeles[i][j] = prom * 256 ;
            }
        }
        imagenBase.cambiosImagen();

    }
}
