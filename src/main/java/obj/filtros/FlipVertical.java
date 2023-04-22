package obj.filtros;

import obj.ComandoFiltro;
import obj.Imagen;

public class FlipVertical extends ComandoFiltro {
    public FlipVertical(Imagen imagenBase) {
        super(imagenBase);
    }

    @Override
    public void ejecutar() {
        int[][] auxPixeles = new int[ancho][alto];

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                auxPixeles[i][j] = pixeles[i][alto-1-j];
            }
        }
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = auxPixeles[i][j];
            }
        }

        imagenBase.cambiosImagen();
    }
}
