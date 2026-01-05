package ActivitatsPackage;
import java.time.LocalDate;

import UsuarisPackage.LlistaUsuaris;
import UsuarisPackage.Usuaris;

public class LlistaInscripcio {
    private Inscripcions[] inscripcions;
    private int numElem;

    public LlistaInscripcio(int MAX) {
        inscripcions = new Inscripcions[MAX];
        numElem = 0;
    }

    private int posicioActivitat(Activitats a) {
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i].getActivitat() == a) return i;
        }
        return -1;
    }

    public void Afegir(Usuaris u, Activitats a) {
        int pos = posicioActivitat(a);

        if (pos != -1) {
            inscripcions[pos].afegirActivitat(u);
            return;
        }

        // no existeix inscripció per aquesta activitat
        inscripcions[numElem] = new Inscripcions(a, 100);
        inscripcions[numElem].afegirActivitat(u);
        numElem++;
    }

    public void eliminar(Usuaris u, Activitats a) {
        int pos = posicioActivitat(a);
        if (pos != -1) {
            inscripcions[pos].EliminaDeActivitat(u);
        }
    }

    public void Elimina(Inscripcions inscripcio) {
        int pos = -1;
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i] == inscripcio) { pos = i; break; }
        }
        if (pos == -1) return;

        for (int j = pos; j < numElem - 1; j++) {
            inscripcions[j] = inscripcions[j + 1];
        }
        inscripcions[numElem - 1] = null;
        numElem--;
    }

    public LlistaActivitats ActivitatsPertanyUsuari(Usuaris u) {
        LlistaActivitats activitats = new LlistaActivitats(numElem);

        for (int i = 0; i < numElem; i++) {
            LlistaUsuaris apuntats = inscripcions[i].getInscrits();
            boolean trobat = apuntats.BuscarUsuari(u);
            if (trobat) activitats.Afegir(inscripcions[i].getActivitat());
        }
        return activitats;
    }

    public void DonarDeBaixaActivitat(LocalDate dataAvui) {
        LocalDate avui = dataAvui;

        for (int i = numElem - 1; i >= 0; i--) {
            boolean acabada = avui.isAfter(inscripcions[i].getActivitat().getDataFi());
            if (!acabada) continue;

            boolean donarBaixa = false;

            if (!(inscripcions[i].getActivitat() instanceof ActivitatsOnline)) {
                double percentatge = (double) inscripcions[i].getNumInscrits() / inscripcions[i].getNumPlaces();
                if (percentatge < 0.10) donarBaixa = true;
            } else {
                if (inscripcions[i].getNumInscrits() < 20) donarBaixa = true;
            }

            if (donarBaixa) Elimina(inscripcions[i]);
        }
    }

    public boolean tePlaces(Activitats a) {
        // Online: sempre places segons enunciat
        if (a instanceof ActivitatsOnline) return true;

        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i] != null && inscripcions[i].getActivitat() == a) {
                return inscripcions[i].getNumInscrits() < inscripcions[i].getNumPlaces();
            }
        }

        // Si encara no hi ha "Inscripcions" creada per aquesta activitat,
        // vol dir que ningú s'hi ha inscrit: per tant hi ha places
        return true;
    }


    public void posarValoracio(Activitats act, Usuaris u, int valoracio) {
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i].getActivitat() == act) {
                inscripcions[i].setValoracioUsuari(u, valoracio);
                return;
            }
        }
    }

    public Integer getValoracioUsuariEnActivitat(Activitats act, Usuaris u) {
        for (int i = 0; i < numElem; i++) {
            if (inscripcions[i].getActivitat() == act) {
                return inscripcions[i].getValoracioUsuari(u);
            }
        }
        return null;
    }
}


