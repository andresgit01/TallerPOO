package estructuras;

import modelo.Admisiones.Matricula;

public class NodoMatricula {
    private Matricula matricula;
    private NodoMatricula siguiente;

    public NodoMatricula(Matricula matricula) {
        this.matricula = matricula;
        this.siguiente = null;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public NodoMatricula getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatricula siguiente) {
        this.siguiente = siguiente;
    }
}
