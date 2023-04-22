package obj.filtros;

import obj.ComandoFiltro;
import obj.Imagen;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ruido extends ComandoFiltro {
    private Random random;
    public Ruido(Imagen imagenBase) {
        super(imagenBase);
        random = new Random();
    }

    @Override
    public void ejecutar() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if(booleanAleatorio()) {
                    if (random.nextBoolean()){
                        pixeles[i][j]= 0xFFFFFF;
                    }else{
                        pixeles[i][j]= 0x0;
                    }
                }
            }
        }
        imagenBase.cambiosImagen();
    }

    public boolean booleanAleatorio(){
        int i =ThreadLocalRandom.current().nextInt(1, 100 + 1);
        if (i <=20){
            return true;
        }
        return false;
    }
}
