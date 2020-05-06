package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.io.File;

public class ActionGarajeRegistroMasivo extends ActionViewLocal {

    private final Garaje garaje;

    public ActionGarajeRegistroMasivo(Garaje garaje) {
        super("Registro Masivo desde un archivo CSV ('marca, modelo')", "Registro Masivo");
        this.garaje = garaje;
    }

    @Override
    public void executeCustomAction() {
        String dir = prompt("Introduce la ruta del archivo: \n", String.class);
        File file = new File(dir);
        if (file.exists()) {
            int inserts = CocheDao.getInstance().insertarCoches(file, garaje);
            if (inserts > 0)
                this.actionSuccessful();
            else
                actionCanceled();
        } else {
            println("No se encuentra el archivo.");
            this.actionFailed();
        }
    }
}
